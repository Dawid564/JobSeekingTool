<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Payment</title>
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
					<a class="navbar-brand" href="/"><spring:message
							code="siteBrand"></spring:message></a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-2">
					<ul class="nav navbar-nav">
						<li><a href="/"><spring:message code="menu.tab.first" /></a></li>
						<li><a href="content"><spring:message
									code="menu.tab.second" /></a></li>
						<li class="active"><a href="payment"><spring:message
									code="menu.tab.third" /><span class="sr-only">(current)</span></a></li>
						<li><a href="settings"><spring:message
									code="menu.tab.fourth" /></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<%--End menu Container --%>
	<%--Content container starts --%>
	<div class="">
		<div
			class="col-md-offset-3 col-sm-offset-1 col-xs-offset-0 col-md-6 col-sm-10 col-xs-12">
			<%--left panel --%>
			<div class="col-md-3 col-sm-3 col-xs-12 paymentControl">
				<div class="row">
					<div class="">
						<p
							class="text-center paymentSubscriptionPanel col-md-12 col-sm-12 col-xs-12">Premium</p>
					</div>
				</div>
				<div>
					<a href="/webwork"><img
						class="logo3 col-md-12 col-sm-12 col-xs-12"
						src='<c:url value="resource/logo.png"/>' /></a>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<h4 class="text-center">Benefits</h4>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<p>- Powerful application</p>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<p>- Grow your effectiveness</p>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<p>- Access anywhere</p>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<p>- Control your progress</p>
					</div>
				</div>
				<div class="bot">
					<div class="row">
						<p
							class="text-center paymentSubscriptionPanel col-md-12 col-sm-12 col-xs-12">1$
							/ 30 Days</p>
					</div>
				</div>
			</div>
			<%--end left panel--%>
			<div class="col-md-9 col-sm-9 col-xs-12">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<%--account status --%>
					<div class="row">
						<div>
							<h2 class="col-md-8 col-sm-8 col-xs-8">Account Status:</h2>
							<h2 class="col-md-4 col-sm-4 col-xs-4">${result}</h2>
						</div>
					</div>
					<div class="row">
						<div class="paymentControl">
							<div
								class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-7 col-sm-6 col-xs-5">
								<h4>PREMIUM STATUS</h4>
							</div>
							<div class="col-md-4 col-sm-5 col-xs-6">
								<h4>${timeRemaining}</h4>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12">
					<%--payment information --%>
					<div class="row">
						<h2>Payment Information:</h2>
					</div>
					<div class="row">
						<div class="paymentControl">
							<div
								class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-10 col-sm-10 col-xs-10 paymentDesc">
								<div>
									<p>
										Purchase a subscription is fast, simple and secure with
										PayPal. If you need help just contact with us through this <a
											href="settings">link</a> .
									</p>
								</div>
							</div>
							<div
								class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-10 col-sm-10 col-xs-10">
								<div>
									<p>For 1$ you'll get 30 days access to tool which support
										process of job seeking</p>
								</div>
							</div>
							<div
								class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-10 col-sm-10 col-xs-10">
								<div>
									<p>If your want to cancel premium just do not pay any more.</p>
								</div>
							</div>
							<div
								class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-10 col-sm-10 col-xs-10">
								<div>
									<p>If your account expired, you can't use our tool, but we
										doesn't erase your data. When you'll buy premium again you
										retrieve all data.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%--paypal --%>
				<div class="">
					<h2>Payment:</h2>
				</div>
				<div class="">
					<div class="paymentControl">
						<div
							class="col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-10 col-sm-10 col-xs-10">
						</div>
					</div>

					<div class="">
						<div
							class="payPalForm col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-md-10 col-sm-10 col-xs-10">
							<form action="https://www.paypal.com/cgi-bin/webscr"
								method="post" target="_top">
								<input type="hidden" name="cmd" value="_s-xclick"> <input
									type="hidden" name="hosted_button_id" value="4NVFD4P8RXUZL">
								<input type="image"
									src="https://www.paypalobjects.com/en_US/PL/i/btn/btn_buynowCC_LG.gif"
									border="0" name="submit"
									alt="PayPal - The safer, easier way to pay online!"> <img
									alt="" border="0"
									src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif"
									width="1" height="1">
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>