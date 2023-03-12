
//const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

async function fetchAddNewUser(userInfo){
	const url = `${URL_API_ROOT}/user`;
	const rawResponse = await fetch(url, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userInfo)
    });
    let respone = await rawResponse.json();
    return respone;
}

async function fetchGetErrorMessage({language,errorCode,msg}){
	const url = `${URL_API_ROOT}/error-message?errorCode=${errorCode}&language=${language}&msg=${msg}`;
	const rawResponse = await fetch(url, {
		method:"GET"
	});
	 let respone = await rawResponse.json();
    return respone;
}


async function handleEventSubmit(){
	$("#btn_Submit").click(async function(event){
		event.preventDefault();
		let url = `${URL_API_ROOT}/user`;
		const urlParams = new URLSearchParams(window.location.search);
		let language = urlParams.get("lan") == null ? "en" : urlParams.get("lan");
		
		$("#form_data").attr("action",url);
		
		let userInfo = {};
		const formData = $("#form_data").serializeArray();
		for(let data of formData){
			userInfo[data["name"]] = data["value"];
		}
		
		let {statusCode, message, errorCode} = await fetchAddNewUser(userInfo);
		console.log(formData);
		console.log(userInfo);
		console.log({statusCode, message, errorCode});
		
		if(errorCode == 0 && message == "Success" && statusCode == 200){
			window.location.href = ".././adminuser";
		}else{
			let error_info = await fetchGetErrorMessage({language,errorCode,msg:message})
			$(".error_message").each(function(index,el){
				$(el).css({"display":"none"});
			})
			let err_lists = ["","#error_name","#error_email","#error_email","#error_email","#error_pwd","#error_status"];
			$(err_lists[errorCode]).text(error_info.message);
			$(err_lists[errorCode]).css({"display":"block"});
		}
	})
}





// Main
$(document).ready(async function() {
	await handleEventSubmit();
})