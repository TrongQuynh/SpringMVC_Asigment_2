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
			
			.userEmail{
				width: 15rem;
				max-width: 15rem;
				overflow-wrap: break-word;
			}
			
			.userNotes {
				width: 25rem;
				max-width: 25rem;
				overflow-wrap: break-word;
			}
			
			.userInactive {
				pointer-events: none;
				text-decoration: line-through;
				color: #b6b6b6;
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
	</head>
	<body>
	
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	        <!-- Brand -->
	        <a class="navbar-brand" href="./">Logo</a>
	        <!-- Links -->
	        <ul class="navbar-nav">
	          <li class="nav-item">
	            <a class="nav-link" href="adminuser">User List</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="adminuser/new">New User</a>
	          </li>
	        </ul>
      	</nav>
		
		<div class="container">
            <h2>User List</h2>
            <table id="tbl_users" data-sort="asc" class="table table-dark table-striped table-hover">
                <thead id="tbl_Header">
                  <tr>
                    <th class="tbl_HeaderName disabled">ID</th>
                    <th class="tbl_HeaderName">Name</th>
                    <th class="tbl_HeaderName">Email</th>
                    <th class="tbl_HeaderName">Status</th>
                    <th class="tbl_HeaderName">Notes</th>
                    <th class="tbl_HeaderName">CreatedAt</th>
                    <th class="tbl_HeaderName">UpdatedAt</th>
                  </tr>
                </thead>
                <tbody id="tbl_body">
                  <tr>
                  	<td class="text-center" colspan="7">
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
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"/>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		
		<!-- Fetch user data -->
		<script type="text/javascript" src="<c:url value="/resources/js/fetchUserData.js"/>"></script>

	</body>
</html>