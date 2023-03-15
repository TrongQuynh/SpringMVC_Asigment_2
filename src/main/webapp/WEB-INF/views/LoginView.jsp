
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link href='<c:url value="/resources/css/Login.css"/>' rel="stylesheet"  type="text/css"/>
<style type="text/css">
	#nav_logo{
		cursor: pointer;
	}
</style>
</head>
<body>
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<!-- Brand -->
		<a id="nav_logo" class="navbar-brand" href="./">TQ</a>
	
	</nav>
	
	<div id="container-box" class="container text-center mt-5">
		<h2 class="font-weight-bold">Login</h2>
		
		<c:url var="loginUrl" value="/login" />
		<form action="${loginUrl}" method="POST" class="text-left rounded border border-dark p-3 mt-3">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<c:if test="${param.accessDenied != null}">
				<div class="alert alert-danger">
					<p>Access Denied: You are not authorised!</p>
				</div>
			</c:if>
		
		  <div class="form-group">
		    <label class="font-weight-bold" for="username">User Name</label>
		    <input type="text" class="form-control" id="username" name="username" placeholder="Enter User Name" required>
		  </div>
		  <div class="form-group">
		    <label class="font-weight-bold" for="password">Password</label>
		    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
		  </div>
		  <div class="form-group text-center">
		  	<button type="submit" class="btn btn-outline-primary font-weight-bold w-100">Submit</button>
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
	
	
	
</body>
</html>