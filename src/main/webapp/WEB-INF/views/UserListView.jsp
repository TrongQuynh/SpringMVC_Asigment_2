<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>User List</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<style type="text/css">
			.container{
				max-width: 85rem;
			}
			/*Table Style*/
			#tbl_Header{
				background: #28344b99;
				
			}
			
			.tbl_HeaderName{
				cursor: pointer;
			}
			
			.tbl_HeaderName:hover{
				color: var(--purple);
			}
			
			#tbl_body tr{
				cursor: pointer;
			}
			
			#tbl_body tr:hover{
				background: var(--secondary);
			}
			
			.userName{
				width: 18rem;
				max-width: 18rem;
				overflow-wrap: break-word;
			}
			
			.userEmail{
				width: 15rem;
				max-width: 15rem;
				overflow-wrap: break-word;
			}
			
			.userNotes {
				width: 18rem;
				max-width: 18rem;
				overflow-wrap: break-word;
			}
			
			.userInactive {
				pointer-events: none;
				text-decoration: line-through;
				color: #b6b6b6;
			}
			
			.btn_Edit{
				padding: 0.5rem 0.8rem;
			}
		</style>
		<style type="text/css">
			.disabled{
				pointer-events: none;
			}
			
			#img_loading{
				max-width: 10rem;
				max-height: 10rem;
			}
		</style>
		<!-- Navbar -->
	    <style type="text/css">
	    	#img_laguage{
	    		width: 2rem;
	    		height: 2rem;
	    	}
	    	#btn_Language{
	    		padding-top: 1.2px;
	    		padding-bottom: 1.2px;
	    	}
	    	
	    </style>
	</head>
	<body>
	
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	        <!-- Brand -->
	        <a id="nav_logo" class="navbar-brand" href="">Logo</a>
	        <!-- Links -->
	        <ul class="navbar-nav">
	          <li class="nav-item">
	            <a class="nav-link" id="nav_userList" href="adminuser">User List</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" id="nav_newUser" href="adminuser/new">New User</a>
	          </li>
	        </ul>
	        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
	        	<a id="btn_Language" data-language="vi" class="btn btn-primary mr-2">
	        		<img alt="" src="../resources/image/viIcons.png" id="img_laguage">
	        		<span>VI</span>
	        	</a>
	        	<a id="btn_LogOut" class="btn btn-danger">Log Out</a>
        	</div>
      	</nav>
		
		<div class="container">
            <h2 id="titlePage">User List</h2>
            <table id="tbl_users" data-sort="asc" class="table table-dark table-striped table-hover">
                <thead id="tbl_Header">
                  <tr>
                    <th class="tbl_HeaderName disabled">ID</th>
                    <th data-col="Name" class="tbl_HeaderName header_name">Name</th>
                    <th data-col="Email" class="tbl_HeaderName header_email">Email</th>
                    <th data-col="Status" class="tbl_HeaderName header_status">Status</th>
                    <th data-col="Notes" class="tbl_HeaderName header_notes">Notes</th>
                    <th data-col="CreatedAt" class="tbl_HeaderName header_createdAt">CreatedAt</th>
                    <th data-col="UpdatedAt" class="tbl_HeaderName header_updatedAt">UpdatedAt</th>
                    <th class="tbl_HeaderName"></th>
                  </tr>
                </thead>
                <tbody id="tbl_body">
                  <tr>
                  	<td class="text-center" colspan="8">
                  		<img alt="" src="https://thumbs.gfycat.com/ImpressiveGenuineHen-size_restricted.gif" id="img_loading">
                  	</td>
                  </tr>
                </tbody>
              </table>
 
            <ul class="pagination justify-content-center" id="pagination">
               <!-- Insert Data here --> 
            </ul>
              
        </div>
	
		<!-- jQuery library -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
		<!-- Popper JS -->
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<!-- Jquery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		
		<!-- Variable Config -->
		<script type="text/javascript" src="<c:url value="/resources/js/config.js"/>"></script>
		
		<!-- Fetch user data -->
		<script type="text/javascript" src="<c:url value="/resources/js/fetchUserData.js"/>"></script>
	
		<!-- Fetch laguage -->
		<script type="text/javascript" src="<c:url value="/resources/js/fetchLanguage.js"/>"></script>
		
		<!-- Navbar Reirect Page -->
		<script type="text/javascript" src="<c:url value="/resources/js/navbarRedirectPage.js"/>"></script>
		
	</body>
</html>