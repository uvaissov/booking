<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<header>
		<div id="controls">
					<sec:authorize access="hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')">
						<%@include file="authheader.jsp" %>
						<a href="<c:url value="/manager/list" />">Users</a>
					</sec:authorize>	
					<sec:authorize access="isAnonymous()">
					 	<div class="well">
					 		<a href="<c:url value='/login' />">Личный кабинет</a>
					 	</div>
				 	</sec:authorize>
	   	</div>
		<div>a;kljsda</div>
		
	</header>
	<div id="contentBody">
	
	</div>
	<footer></footer>

</body>
</html>