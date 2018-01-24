<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en" ng-app="BookingApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/app.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
    var navigationList = [
    	<c:forEach var="navigationItem" items="${navigationList}"  varStatus="loop">'<c:out value="${navigationItem}" />'<c:if test="${!loop.last}">,</c:if></c:forEach>
    ];
    
    
    </script>
</head>
<body>


<div class="container" ng-controller="MainCtrl as main" >
	<div class="container-header" style="min-height: 10px;">
    	<form id="logoutForm" method="POST" action="${contextPath}/logout" style="float: right;">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="button" class="btn btn-link btn-sm" onclick="document.forms['logoutForm'].submit()">Logout</button>
        </form>
	</div>
	<div class="row profile">
	<div class="col-md-3">
		<div class="profile-sidebar">
			<!-- SIDEBAR USERPIC -->
		<div class="profile-userpic">
			<img src="http://keenthemes.com/preview/metronic/theme/assets/admin/pages/media/profile/profile_user.jpg" class="img-responsive" alt="">
		</div>
		<!-- END SIDEBAR USERPIC -->
		<!-- SIDEBAR USER TITLE -->
		<div class="profile-usertitle">
			<div class="profile-usertitle-name">
				${pageContext.request.userPrincipal.name}
			</div>
			<div class="profile-usertitle-job">
				{{main.title}}
			</div>
		</div>
		<!-- END SIDEBAR USER TITLE -->
		<!-- SIDEBAR BUTTONS -->
		<div class="profile-userbuttons">
			<button type="button" class="btn btn-success btn-sm" >Follow</button>
			<button type="button" class="btn btn-danger btn-sm" >Message</button>
			
		</div>
		<!-- END SIDEBAR BUTTONS -->
		<!-- SIDEBAR MENU -->
		<div class="profile-usermenu">
			<ul class="nav">
			    		<li ng-class="{'active':nav.active}" ng-repeat="nav in main.navigationList">
							<a ng-click="main.changeContent(nav)">
							<i class="glyphicon glyphicon-home"></i>
							{{nav.name}} </a>
						</li>
			</ul>
		</div>
		<!-- END MENU -->
			</div>
		</div>
		<div class="col-md-9">
	           <div class="profile-content">
			  CONTENT
	           </div>
		</div>
	</div>
	
	
    

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>


<script src="${contextPath}/resources/js/angular.min.js"></script>
<script src="${contextPath}/resources/project/app/app.js"></script>
<script src="${contextPath}/resources/project/controller/MainCtrl.js"></script>
</body>
</html>
