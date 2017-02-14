<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Main</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/script.js" />"></script>
<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="assets/css/main.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- Start Top container -->
	<section>
		<div>
			<div class="topContainer col-md-12 col-sm-12 col-xs-12">
				<div
					class="logo col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-1 col-sm-1 col-xs-1">
					<img class="col-md-12 col-sm-12 col-xs-12"
						src='<c:url value="resource/logo.png"/>' />
				</div>
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
					class="col-md-offset-4 col-sm-offset-2 col-xs-offset-0 col-md-3 col-sm-4 col-xs-6">
					<sec:authorize access="isAnonymous()">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="btn singBtn col-md-4 col-sm-4 col-xs-4">
								<form action="<c:url value="/register" />" method="GET">
									<input class="btn btn-default" type="submit" name="action"
										value="Sing Up" />
								</form>
							</div>
							<div class="btn singBtn col-md-4 col-sm-4 col-xs-4">
								<form action="<c:url value="/login" />" method="GET">
									<input class="btn btn-default" type="submit" name="action"
										value="Log In" />
								</form>
							</div>
						</div>
					</sec:authorize>
				</div>
			</div>
		</div>
	</section>
	<!-- End of top Container -->
	<!-- Menu -->
	<div
		class="col-md-offset-2 col-sm-offset-1 col-xs-offset-0 col-md-8 col-sm-10 col-xs-12 ">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/webwork"><spring:message
							code="siteBrand"></spring:message></a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/webwork"><spring:message
									code="menu.tab.first" /><span class="sr-only">(current)</span></a></li>
						<li><a href="content"><spring:message
									code="menu.tab.second" /></a></li>
						<li><a href="payment"><spring:message
									code="menu.tab.third" /></a></li>
						<li><a href="settings"><spring:message
									code="menu.tab.fourth" /></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<%--End menu Container --%>
	<!-- Main Part Starts -->
	<div class="col-md-12 col-sm-12 col-xs-12">

		<div class="mainFirstContainer col-md-12 col-sm-12 col-xs-12">
			<div
				class="col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-10 col-sm-10 col-xs-12">
				<!-- Description -->
					<div class="alertLabel">${alertMessage}</div>
				<h1>The best solution for you</h1>
				<div class="col-md-8 col-sm-8 col-xs-12">
					<div class="col-md-6 col-sm-6 col-xs-12"><spring:message code="main.top.best.solution"/></div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<a
							href="http://www.freepik.com/free-vector/jobs-background-design_1024506.htm"><img
							class="logo2 col-md-12 col-sm-12 col-xs-12"
							src='<c:url value="resource/webjob.png"/>' /></a>
					</div>
				</div>
			</div>
		</div>
		<div class="mainSecondContainer col-md-12 col-sm-12 col-xs-12">
			<div
				class="col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-10 col-sm-10 col-xs-12">
				<!-- About Us -->
				<h1>About Us</h1>
				<div class="col-md-8 col-sm-8 col-xs-12">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<spring:message code="about.us" />
					</div>
					<div class="im col-md-6 col-sm-6 col-xs-12">
						<a
							href="http://www.freepik.com/free-vector/business-banners-set_957343.htm"><img
							class="logo2 col-md-12 col-sm-12 col-xs-12"
							src='<c:url value="resource/carrierLog.png"/>' /></a>
					</div>
				</div>
			</div> 
		</div>
		<div class="mainThirdContainer col-md-12 col-sm-12 col-xs-12">
			<div
				class="col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-10 col-sm-10 col-xs-12">
				<!-- Description -->
				<h1>What you'll get</h1>
				<div class="thirdContent col-md-8 col-sm-8 col-xs-12">
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/Application.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Powerful application</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/ChartAreaUp.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Grow
							your effectiveness</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/Web.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Access
							anywhere</div>
					</div>
					<div class="col-md-3 col-sm-3 col-xs-6">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/Webcam.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Control your progress</div>
					</div>
				</div>
			</div>
		</div>
		<div class="mainfourthContainer col-md-12 col-sm-12 col-xs-12">
			<div
				class="col-md-offset-2 col-sm-offset-2 col-xs-offset-0 col-md-10 col-sm-10 col-xs-12">
				<!-- About Us -->
				<h1>How it works</h1>
				<div class="fourthContent col-md-8 col-sm-8 col-xs-12">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/CreditCards.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Buy
							for 1$/30 days access</div>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/Application.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Use
							application</div>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<img class="col-md-12 col-sm-12 col-xs-12"
								src='<c:url value="resource/Briefcase.png"/>' />
						</div>
						<div class="text-center col-md-12 col-sm-12 col-xs-12">Get
							the job</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>