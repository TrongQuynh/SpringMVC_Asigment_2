
//const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

async function fetchDeleteUser(id) {
  const url = `${URL_API_ROOT}/user/${id}`;
  
  const responeRaw = await fetch(url, {
    method: 'DELETE',
  });
  return await responeRaw.json();
   
};

async function fetchUpdateData(userData){
	const url = `${URL_API_ROOT}/user/${userData.id}`;
	console.log(userData)
	console.log(url);
	const rawResponse = await fetch(url, {
        method: 'PATCH',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    });
    let respone = await rawResponse.json();
    return respone;
}


async function fetchGetUserData(userID){
	try	{
		const url = `${URL_API_ROOT}/user?id=${Number(userID)}`;
	  
		const responeRaw = await fetch(url, {
		    method: 'GET',
		});
		return await responeRaw.json();
	}catch(err){
		return null;
	}
}

async function fetchGetErrorMessage({language,errorCode,msg}){
	const url = `${URL_API_ROOT}/error-message?errorCode=${errorCode}&language=${language}&msg=${msg}`;
	const rawResponse = await fetch(url, {
		method:"GET"
	});
	 let respone = await rawResponse.json();
    return respone;
}

// Helper
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

// Init data into form
function initDataIntoForm(userInfo){
	console.log(userInfo);
	if(userInfo){
		$("#name").val(userInfo.name);
		$("#email").val(userInfo.email);
		$("#password_hiden").val(userInfo.password);
		$("#agentID").val(userInfo.agentID);
		$("#statusCD").val(userInfo.statusCD);
		$("#notes").val(userInfo.notes);
		$("#createdAt").val(formatDateTime(userInfo.createdAt));
		$("#updatedAt").val(formatDateTime(userInfo.updatedAt));
	}
}

function getFormData(){	
	return {
		name: $("#name").val(),
		password: $("#password").val() === "" && $("#confirm_password").val() === "" ? $("#password_hiden").val() : $("#password").val(),
		confirm_password: $("#password").val() === "" && $("#confirm_password").val() === "" ? $("#password_hiden").val() : $("#confirm_password").val(),
		agentID: $("#agentID").val(),
		statusCD:Number($("#statusCD").val()),
		notes:$("#notes").val(),
	}
}


// Handle Evnet
function handleEventCancel(){
	$("#btn_Cancel").click(function(){
		window.location.href = ".././adminuser";
	})
}

function handleEventDeleteUser(id){
	$("#btn_Delete").click(async function(event){
		event.preventDefault();
		
		console.log("Call request delete")
		$("#confirmModal_body").empty();
		
		$("#confirmModal_Title").text("Delete User");
		$("#confirmModal_body").append("Are you sure wanna <strong class='text-danger'>DELETE</strong> this user?");
		$("#btn_modal_submit").removeAttr('class');
		$("#btn_modal_submit").attr('class',"btn btn-danger");
		$("#btn_modal_submit").text("Delete"); 
		
		$("#confirmModal").modal('show');
		$("#btn_modal_submit").click(async function(){
			console.log(await fetchDeleteUser(id));
			
			window.location.href = ".././adminuser";
		})
		
	})
}

function handleEventUpdateUser(userInfo){
	$("#btn_Update").click(async function(){
		$("#confirmModal_body").empty();
		
		$("#confirmModal_Title").text("Update User");
		$("#confirmModal_body").append("Are you sure wanna <strong class='text-warning'>Update</strong> this user?");
		$("#btn_modal_submit").removeAttr('class');
		$("#btn_modal_submit").attr('class',"btn btn-warning");
		$("#btn_modal_submit").text("Submit"); 
		
		// Get current Language
		const urlParams = new URLSearchParams(window.location.search);
		let language = urlParams.get("lan") == null ? "en" : urlParams.get("lan");
		
		$("#confirmModal").modal('show');
		console.log(userInfo);
		$("#btn_modal_submit").click(async function(){
			let data = getFormData();
			console.log({...userInfo,...data})
			
			
			let {statusCode, message, errorCode} = await fetchUpdateData({...userInfo,...data});
			console.log({statusCode, message, errorCode});
			
			if(errorCode == 0 && message == "Success" && statusCode == 200){
				window.location.href = ".././adminuser";
			}else{
				$("#confirmModal").modal('hide');
				let error_info = await fetchGetErrorMessage({language,errorCode,msg:message})
				$(".error_message").each(function(index,el){
					$(el).css({"display":"none"});
				})
				let err_lists = ["","#error_name","","","","#error_pwd","#error_status"];
				$(err_lists[errorCode]).text(error_info.message);
				$(err_lists[errorCode]).css({"display":"block"});
			}
			
		})
	})
}


// Main
$(document).ready(async function() {
	
	const urlParams = new URLSearchParams(window.location.search);
	
	let userInfo = await fetchGetUserData(Number(urlParams.get("id")));
	
	initDataIntoForm(userInfo);
	
	handleEventCancel();
	
	handleEventDeleteUser(urlParams.get("id"));
	
	handleEventUpdateUser(userInfo);
})