
// Fetch data from Server : http://localhost:8080/Assignment_2/api/users

//const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

async function fetchUserRole(){
	const url = `${URL_API_ROOT}/acc/curr-role`;
	const responeRaw = await fetch(url,{
		method:"GET"
	})
	return await responeRaw.json();
}

async function isAuthentication(){
	/**
	 * Return true if user is login
	 */
	const ROLE = await fetchUserRole();
	return String(ROLE).includes("ROLE_ANONYMOUS") ? false : true;
}

// Main
$(document).ready(async function() {
	/**
	 * Check is user login or not 
	 */
	if(!await isAuthentication()){
		$("#btn_LogOut").attr("href",`${WEB_ROOT}/login`);
	}
})