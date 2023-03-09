
async function getStatus(){
	const respone = await fetch("http://localhost:8080/Assignment_2/api/status");
	return await respone.json();
}

function initStatusSelection(statusList){
	$("#statusCD").empty();
	$("#statusCD").append(`<option value="">Select</option>`);
	for (let status of statusList) {
		$("#statusCD").append(`<option value="${status.codeValue}">${status.codeName}</option>`);
	}
}

// Main
$(document).ready(async function() {
	const statusList = await getStatus();
	initStatusSelection(statusList);
})