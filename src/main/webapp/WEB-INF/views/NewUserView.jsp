<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>New User</title>
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
        #btn_Submit{
            width: 100%;
        }
    </style>
</head>

<body>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <!-- Brand -->
        <a class="navbar-brand" href=".././">TQ</a>
        <!-- Links -->
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link" href=".././adminuser">User List</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href=".././adminuser/new">New User</a>
          </li>
        </ul>
      </nav>

    <div class="container">
        <h2>New User</h2>

        <form id="form_data" method="POST">
            <div class="form-group">
                <label for="name" class="font-weight-bold">Username <span class="text-danger">*</span> :</label>
                <input type="text" class="form-control" id="name" placeholder="Enter username" name="name" required>
                <div class="error_message mt-2 alert alert-danger" id="error_name" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label for="email" class="font-weight-bold">Email <span class="text-danger">*</span> : </label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
                <div class="error_message mt-2 alert alert-danger" id="error_email" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label for="password" class="font-weight-bold">Password: </label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                
            </div>
            <div class="form-group">
                <label for="password" class="font-weight-bold">Confirm Password: </label>
                <input type="password" class="form-control" id="confirm_password" placeholder="Enter confirm password" name="confirm_password">
                <div class="error_message mt-2 alert alert-danger" id="error_pwd" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label for="agentID" class="font-weight-bold">Agent ID:</label>
                <input type="text" class="form-control" id="agentID" placeholder="Enter Agent ID" name="agentID">
            </div>
            <div class="form-group">
                <label for="statusCD" class="font-weight-bold">Device Type <span class="text-danger">*</span> :</label>
                <select class="custom-select" id="statusCD" name="statusCD" required>
                    <option value="">Select</option>
                    
                </select>
                <div class="error_message mt-2 alert alert-danger" id="error_status" role="alert">Please fill out this field</div>
            </div>
            <div class="form-group">
                <label for="note"><b>Notes</b></label>
                <input type="text" class="form-control" name="notes" id="note" placeholder="Enter notes" />
            </div>

            <div class="form-group text-center">
                <button type="submit" id="btn_Submit" class="btn btn-primary">Submit</button>
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
    
    <!-- Send user data -->
	<script type="text/javascript" src="<c:url value="/resources/js/sendNewUser.js"/>"></script>
	
	<!-- Fetch Status Selection -->
	<script type="text/javascript" src="<c:url value="/resources/js/fetchStatusData.js"/>"></script>
</body>

</html>