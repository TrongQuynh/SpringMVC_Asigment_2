
const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

async function fetchDeleteUser(id) {
  const url = `${URL_API_ROOT}/user/${id}`;
  
  const responeRaw = await fetch(url, {
    method: 'DELETE',
  });
  return await responeRaw.json();
   
};


async function fetchGetUserData(userID){
	try	{
		const url = `${URL_API_ROOT}/user?id=${userID}`;
	  
		const responeRaw = await fetch(url, {
		    method: 'GET',
		});
		return await responeRaw.json();
	}catch(err){
		return null;
	}
}



// Handle Evnet
function handleEventCancel(){
	$("#btn_Cancel").click(function(){
		window.location.href = ".././";
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

function handleEventUpdateUser(){
	$("#btn_Update").click(async function(){
		window.location.href = ".././";
	})
}


// Main
$(document).ready(async function() {
	console.log(await fetchGetUserData(200));
	const urlParams = new URLSearchParams(window.location.search);
	
	handleEventCancel();
	
	handleEventDeleteUser(urlParams.get("id"));
	
	handleEventUpdateUser();
})