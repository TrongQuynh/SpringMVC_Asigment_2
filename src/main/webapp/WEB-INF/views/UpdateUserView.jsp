<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Update User</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <style>
        .container{
            max-width: 40%;
        }
        .form-group {
		    margin-bottom: 0.8rem;
		}
		.error_message{
			color: var(--danger);
			display: none;
		}
        button.btn{
            width: 32%;
            margin: 0 1px;
        }
        .disabled{
			pointer-events: none;
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
        <a id="nav_logo" class="navbar-brand" href=".././">TQ</a>
        <!-- Links -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" id="nav_userList" href=".././adminuser">User List</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" id="nav_newUser" href=".././adminuser/new">New User</a>
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

    <div class="container mb-5 mt-3">
        <h2 id="titlePage">Update User</h2>
        
		<%@include file="ModalConfirm.html"%>
		
        <form id="form_data" method="POST">
            <div class="form-group">
                <label for="name" class="font-weight-bold"><span id="lbl_name">User Name</span> <span class="text-danger">*</span> :</label>
                <input type="text" class="form-control" id="name" placeholder="Enter username" name="name" required>
                <div class="error_message mt-2 alert alert-danger" id="error_name" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label for="email" class="font-weight-bold"><span id="lbl_email">Email</span> <span class="text-danger">*</span> : </label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" disabled>
                <!-- <div class="error_message mt-2 alert alert-danger" id="error_email" role="alert">Please fill out this field</div>  -->
            </div>
            <div class="form-group">
                <label for="password" id="lbl_pwd" class="font-weight-bold">Password: </label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                <input type="hidden" class="form-control" id="password_hiden" name="password_hiden">
            </div>
            <div class="form-group">
                <label for="password" id="lbl_cdm_pwd" class="font-weight-bold">Confirm Password: </label>
                <input type="password" class="form-control" id="confirm_password" placeholder="Enter confirm password" name="confirm_password">
                <div class="error_message mt-2 alert alert-danger" id="error_pwd" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label for="agentID" id="lbl_agentID" class="font-weight-bold">Agent ID:</label>
                <input type="text" class="form-control" id="agentID" placeholder="Enter Agent ID" name="agentID">
            </div>
            <div class="form-group">
                <label for="statusCD" class="font-weight-bold"><span id="lbl_status">Status</span> <span class="text-danger">*</span> :</label>
                <select class="custom-select" id="statusCD" name="statusCD" required>
                    <option value="">Select</option>
                    
                </select>
                <div class="error_message mt-2 alert alert-danger" id="error_status" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label id="lbl_notes" class="font-weight-bold" for="note"><b>Notes</b></label>
                <input type="text" class="form-control" name="notes" id="notes" placeholder="Enter notes" />
            </div>
            
            <div class="form-group row">
            	<div class="col">
            		<label id="lbl_createdAt" class="font-weight-bold" for="createdAt"><b>Created At</b></label>
                	<input type="datetime" value="2022-09-05 00:00:00.0" class="form-control" name="createdAt" id="createdAt" disabled/>
            	</div>
            	
            	<div class="col">
            		<label id="lbl_updatedAt" class="font-weight-bold" for="updatedAt"><b>Updated At</b></label>
                	<input type="datetime" value="2022-09-05 00:00:00.0" class="form-control" name="updatedAt" id="updatedAt" disabled />
            	</div>
            </div>
            
             
            <div class="form-group text-center mt-3">
            	<button type="button" id="btn_Cancel" class="btn btn-secondary font-weight-bold">Cancel</button>
                <button type="button" id="btn_Update" class="btn btn-warning font-weight-bold">Update</button>
                <button type="button" id="btn_Delete" class="btn btn-danger font-weight-bold">Delete</button>
            </div>
            
        </form>

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
	
	
	<!-- Fetch Status Selection -->
	<script type="text/javascript" src="<c:url value="/resources/js/fetchStatusData.js"/>"></script>
	
	<!-- Update user data -->
	<script type="text/javascript" src="<c:url value="/resources/js/sendUpdateUser.js"/>"></script>
	
	<!-- Fetch laguage -->
	<script type="text/javascript" src="<c:url value="/resources/js/fetchLanguage.js"/>"></script>
	
	<!-- Navbar Reirect Page -->
	<script type="text/javascript" src="<c:url value="/resources/js/navbarRedirectPage.js"/>"></script>
</body>

</html>