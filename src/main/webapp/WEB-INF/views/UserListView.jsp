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
	
		<!-- Navber -->
		<%@include file="Navbar.jsp"%>
		
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
             
             <div id="pageInfo" class="text-center mt-3 mb-3 font-weight-bold">Page <span id="c_page">0</span> / <span id="t_page">0</span> Pages</div>
 
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
		
		<!-- Authentication -->
		<script type="text/javascript" src="<c:url value="/resources/js/Authetication.js"/>"></script>
		
		<!-- Fetch user data -->
		<script type="text/javascript" src="<c:url value="/resources/js/fetchUserData.js"/>"></script>
	
		<!-- Fetch laguage -->
		<script type="text/javascript" src="<c:url value="/resources/js/fetchLanguage.js"/>"></script>
		
		<!-- Navbar Reirect Page -->
		<script type="text/javascript" src="<c:url value="/resources/js/navbarRedirectPage.js"/>"></script>
		
	</body>
</html>