<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Main Company Process</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/script.js" />"></script>

</head>
<body>
	<!-- Start Top container -->
	<section>
		<div>
			<div class="topContainer col-md-12 col-sm-12 col-xs-12">
				<div
					class="logo col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-1 col-sm-1 col-xs-1">Logo</div>
				<div>
					<sec:authorize access="isAuthenticated()">
						<sec:authorize access="hasRole('ROLE_USER')" var="isUser">
							<form id="logOut"
								action=<c:url value="/j_spring_security_logout"/> method="POST">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
							<div
								class="col-md-offset-9 col-sm-offset-9  col-xs-offset-9 logOutBtn">
								<button class="btn btn-default" onclick="submitDocument()">LogOut</button>
							</div>
						</sec:authorize>
					</sec:authorize>
				</div>
				<div
					class="col-md-offset-5 col-sm-offset-2 col-xs-offset-0 col-md-2 col-sm-4 col-xs-6">
					<sec:authorize access="isAnonymous()">
						<div class="btn singBtn">
							<form action="<c:url value="/register" />" method="GET">
								<input class="btn btn-default" type="submit" name="action"
									value="Sing Up" />
							</form>
						</div>
						<div class="btn singBtn">
							<form action="<c:url value="/login" />" method="GET">
								<input class="btn btn-default" type="submit" name="action"
									value="Log In" />
							</form>
						</div>
					</sec:authorize>
				</div>
			</div>
		</div>
	</section>
	<!-- End of top Container -->
	<!-- Menu -->
	<section class="topMenu ">
		<ul
			class="topMenuList list-group col-md-offset-2 col-sm-offset-1 col-xs-offset-0 col-md-8 col-sm-10 col-xs-12">
			<li class="topMenuListElement"><a href="/webwork"
				class="btn btn-default col-md-3 col-sm-6 col-xs-12"><spring:message
						code="menu.tab.first" /></a></li>
			<li class="topMenuListElement"><a href="content"
				class="btn btn-default col-md-3 col-sm-6 col-xs-12"><spring:message
						code="menu.tab.second" /></a></li>
			<li class="topMenuListElement"><a href="payment"
				class="btn btn-default col-md-3 col-sm-6 col-xs-12"><spring:message
						code="menu.tab.third" /></a></li>
			<li class="topMenuListElement"><a href="settings"
				class="btn btn-default col-md-3 col-sm-6 col-xs-12"><spring:message
						code="menu.tab.fourth" /></a></li>
		</ul>
	</section>
	<%--End menu Container --%>
	<!-- Main Part Starts -->
	<div class="col-md-12 col-sm-12 col-xs-12">
		<section class="mainFirstContainer">
			<div
				class="col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-10 col-sm-10 col-xs-12">
				<!-- Description -->
				<h1>The best Solution for You</h1>
			</div>
		</section>
		<section class="mainSecondContainer ">
			<div
				class="col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-8 col-sm-9 col-xs-12">
				<!-- About Us -->
				<h1>About Us</h1>
			</div>
		</section>
	</div>

</body>
</html>