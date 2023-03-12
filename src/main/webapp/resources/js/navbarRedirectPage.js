
/*
	Handle redirect page when user click on navbar

*/

//const URL_API_ROOT = "http://localhost:8080/Assignment_2/api";

//const WEB_ROOT = "http://localhost:8080/Assignment_2";

function updateURLforNavbar(){
	$("#btn_Language").click(function(){
		setURLNavbar();
	})
}

function setURLNavbar(){
	// Get current Language
	const urlParams = new URLSearchParams(window.location.search);
	let language = urlParams.get("lan");
	
	let queryString = "";
	
	if(language != null){
		urlParams.set("lan",language);
		queryString = `?${urlParams.toString()}`;
	}
	
	// Home Page
	$("#nav_logo").attr("href",`${WEB_ROOT}${queryString}`);
	
	// User List Page
	$("#nav_userList").attr("href",`${WEB_ROOT}/adminuser${queryString}`);
	
	// New User Page
	$("#nav_newUser").attr("href",`${WEB_ROOT}/adminuser/new${queryString}`);
	
	// Update Next language for button laguage
	language = language == null ? "en" : urlParams.get("lan");
	let newLanguage = language == "en" ? "vi" : "en";
	$("#btn_Language").attr("data-language",newLanguage);
	$("#btn_Language > span").text(newLanguage.toUpperCase());
	if(window.location.pathname.includes("new") || window.location.pathname.includes("edit")){
		$("#btn_Language > img").attr("src",`${WEB_ROOT}/resources/image/${newLanguage}Icons.png`);
	}else{
		$("#btn_Language > img").attr("src",`${WEB_ROOT}/resources/image/${newLanguage}Icons.png`);
	}
}

// Main
$(document).ready(async function() {
	
	setURLNavbar();
	
	updateURLforNavbar();
		
})