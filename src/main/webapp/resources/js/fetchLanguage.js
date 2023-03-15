
//const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

async function fetchNavBarLabel(language){
	const url = `${URL_API_ROOT}/lan/nav-bar?lan=${language}`;
	const rawResponse = await fetch(url, {
		method:"GET"
	});
	 let respone = await rawResponse.json();
    return respone;
}

async function fetch_language_Page(url){
	
	console.log(url)
	const rawResponse = await fetch(url, {
		method:"GET"
	});
	 let respone = await rawResponse.json();
    return respone;
}

// setNavbar language
async function setNavBarlanguage(language){
	/** 
	 *  Import from Authentication.js
	*/
	let data = await fetchNavBarLabel(language);
	console.log(data);
	//$("#nav_userList").text(data.userList);
	//$("#nav_newUser").text(data.newUser);
	for(let key of Object.keys(data)){
		$(`#${key}`).text(data[key]);
	}
	if(! await isAuthentication()){
		// If NOT Login
		$(`#btn_LogOut`).text(data["btn_LogIn"]);
		$(`#btn_LogOut`).removeClass();
		$(`#btn_LogOut`).attr("class","btn btn-outline-success")
	}
}

async function setPageLanguare(language){
	
	let current_url = window.location.pathname;
	console.log("curent url: " + current_url)
	
	let pages = ["user-list-view","new-update-view"];
	let data = {};
	if(current_url.includes("adminuser/new")){
		
		let url = `${URL_API_ROOT}/lan/${pages[1]}?lan=${language}`;
		data = await fetch_language_Page(url);
		
		$("#titlePage").text(data.header_new);
		
		$("#btn_Submit").text(data["btn_Submit"]);
	}
	else if(current_url.includes("/adminuser/edit")){
		let url = `${URL_API_ROOT}/lan/${pages[1]}?lan=${language}`;
		data = await fetch_language_Page(url);
		$("#titlePage").text(data.header_update);
		
		$("#btn_Update").text(data["btn_Delete"]);
		$("#btn_Cancel").text(data["btn_Delete"]);
		$("#btn_Delete").text(data["btn_Delete"]);
	}
	else if((window.location.pathname).endsWith("/adminuser")){
		// User List Page
		
		let url = `${URL_API_ROOT}/lan/${pages[0]}?lan=${language}`;
		data = await fetch_language_Page(url);
		$("#titlePage").text(data.header);
		for(let key of Object.keys(data)){
			console.log(key);
			$(`#tbl_Header`).find(`.${key}`).text(data[key]);
		}
		return;
	}else{
		// Home Page
	}
	
	// New - Edit Page
	for(let key of Object.keys(data)){
		console.log(key);
		$(`#form_data`).find(`#${key}`).text(data[key]);
		$(`#form_data`).find(`#${key}`).parent().find("input").attr("placeholder", `${language == 'en' ? 'Enter' : 'Nhập'} ${data[key]}`);
	}
}

// Handle Event
function handleEventChangeLanguage(){
	$("#btn_Language").click(function(){
		const urlParams = new URLSearchParams(window.location.search);
		let language = $(this).attr("data-language");
		urlParams.set("lan", language);
		console.log(`${window.location.pathname}?${urlParams.toString()}`);
		
		window.location.href = `${window.location.pathname}?${urlParams.toString()}`;
	})
}

async function handleEventChangeLanguageInPage(language){
	await setNavBarlanguage(language);
	
	await setPageLanguare(language);
}

// Main
$(document).ready(async function() {
	
	// Get current lan on URl
	const urlParams = new URLSearchParams(window.location.search);
	let language = urlParams.get("lan") == null ? "en" : urlParams.get("lan");
	
	//Set language
	await handleEventChangeLanguageInPage(language);
	
	handleEventChangeLanguage();
	
	
	
	//
})