<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link href='<c:url value="/resources/css/style.css"/>' rel="stylesheet"  type="text/css"/>
<link href='<c:url value="/resources/css/Navbar.css"/>' rel="stylesheet"  type="text/css"/>
</head>
<body>
	
	<!-- Navbar -->
	<%@include file="Navbar.jsp"%>


	<h2 class="txt_red">Home Page</h2>
	
	
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
	
	<!-- Navbar Reirect Page -->
	<script type="text/javascript" src="<c:url value="/resources/js/navbarRedirectPage.js"/>"></script>
	
	<!-- Fetch laguage -->
	<script type="text/javascript" src="<c:url value="/resources/js/fetchLanguage.js"/>"></script>
	
</body>
</html>