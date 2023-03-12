
// Fetch data from Server : http://localhost:8080/Assignment_2/api/users

//const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

async function getUsers(url) {
	const respone = await fetch(url);
	return await respone.json();
}


async function getTotalUser() {
	const respone = await fetch(`${URL_API_ROOT}/total-users`,{
		method:"GET"
	});
	
	return await respone.json();
}


function formatDateTime(datetime){
	const date = new Date(parseInt(datetime));
	
	const year = date.getFullYear(); // get the 4-digit year
	const month = ("0" + (date.getMonth() + 1)).slice(-2); 
	const day = ("0" + date.getDate()).slice(-2); 
	const hours = ("0" + date.getHours()).slice(-2);
	const minutes = ("0" + date.getMinutes()).slice(-2);
	const seconds = ("0" + date.getSeconds()).slice(-2);

	return `${year}:${month}:${day} ${hours}:${minutes}:${seconds}`; 
     
}

function createRowTableHTML(user,language) {
	return `
		<tr>
	        <td class="align-middle text-align ${ user.statusCode == 4 ? 'userInactive' : ''}">${user.id}</td>
	        <td class="userName align-middle ${ user.statusCode == 4 ? 'userInactive' : ''}">${user.name}</td>
	        <td class="userEmail align-middle ${ user.statusCode == 4 ? 'userInactive' : ''} ${ user.statusCode == 4 ? 'userInactive' : ''}">${user.email}</td>
	        <td class="align-middle ${user.statusColor} ${ user.statusCode == 4 ? 'userInactive' : ''}">${user.status}</td>
	        <td class="userNotes align-middle ${ user.statusCode == 4 ? 'userInactive' : ''}">${user.notes}</td>
	        <td class="align-middle ${ user.statusCode == 4 ? 'userInactive' : ''}">${formatDateTime(user.createdAt)}</td>
	        <td class="align-middle ${ user.statusCode == 4 ? 'userInactive' : ''}">${formatDateTime(user.updatedAt)}</td>
	        <td class="align-middle text-align"><a href="adminuser/edit?id=${user.id}${language}" class="badge badge-warning btn_Edit">Edit</a></td>
	     </tr>
	`;
}

function createPagination(currentPage,totalPage){
	
	const urlParams = new URLSearchParams(window.location.search);
	let language = urlParams.get("lan") == null ? "" : `&lan=${urlParams.get("lan")}`;
	
	let startPage = currentPage > 3 ? currentPage - 2 : 1;
	let endPage = currentPage + 2 <= totalPage ? currentPage + 2 : totalPage;
	let pageList = "";
	for(let page = startPage; page <= endPage;page++){
		pageList += `<li class="page-item ${currentPage == page ? "active" : ""}"><a class="page-link" href="adminuser?page=${page}${language}">${page}</a></li>`;
	}
	
	return `
		<li class="page-item ${currentPage == 1 ? "disabled" : ""}">
            <a class="page-link" href="adminuser?page=1${language}">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <li class="page-item ${currentPage == 1 ? "disabled" : ""}"><a class="page-link" href="adminuser?page=${currentPage <= 1 ? 1 : currentPage - 1}${language}">Previous</a></li>
        `
        +
        	pageList
        +
        `
        <li class="page-item ${currentPage == totalPage ? "disabled" : ""}"><a class="page-link" href="adminuser?page=${currentPage >= totalPage ? totalPage : currentPage + 1}${language}">Next</a></li>
        <li class="page-item ${currentPage == totalPage ? "disabled" : ""}">
            <a class="page-link" href="adminuser?page=${totalPage}${language}">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
	`;
}

async function initPagination(currentPage,totalPage){
	$("#pagination").empty();
	$("#pagination").append(createPagination(currentPage,totalPage));
}


function initRowData(users) {
	const urlParams = new URLSearchParams(window.location.search);
	let language = urlParams.get("lan") == null ? "" : `&lan=${urlParams.get("lan")}`;
	let result = "";
	for (let user of users) {
		//$("#tbl_body").append(createRowTableHTML(user));
		result += createRowTableHTML(user,language);
	}
	$("#tbl_body").empty();
	$("#tbl_body").append(result);
}

function initCurrentSortType(sortType){
	$("#tbl_users").attr("data-sort",sortType);
}

async function handleEventSort(){
	$("#tbl_Header .tbl_HeaderName").each(function(index, header){
		$(header).click(async function(event){
			//event.preventDefault()
			const urlParams = new URLSearchParams(window.location.search);
			const column = ($(this).attr("data-col")).toLowerCase();
			const sortType = $("#tbl_users").attr("data-sort");
			let new_url = (window.location.href);
			new_url = new_url.includes("?") ? new_url.slice(0,new_url.indexOf("?")) : new_url;
			console.log(new_url);
			
			urlParams.set("col",column);
			urlParams.set("sort",sortType);
			
			console.log(`${new_url}?${urlParams.toString()}`);
			window.location.href = `${new_url}?${urlParams.toString()}`;
			
		})
	})
}


// Main
$(document).ready(async function() {
	
	const urlParams = new URLSearchParams(window.location.search);
	
	console.log(urlParams.toString());
	let url_api_users = `${URL_API_ROOT}/users?${urlParams.toString()}` ;
	
	const {totalPage, currentPage, userList,sortType} = await getUsers(url_api_users);
	console.log({totalPage, currentPage, userList})
	initRowData(userList);
	initPagination(currentPage,totalPage);
	initCurrentSortType(sortType);
	
	await handleEventSort();
})