<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>Main Company Process</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	</head>
	<body>
		<section > <!-- top container -->
				<div class="row">
					<div class="topContainer">
						<div class="pull-right btn">
							<form action="<c:url value="/register" />" method="GET">
	    						<input type="submit" name="action" value="Sign up" />
							</form>
						</div>
						<div class="pull-right btn">
							<form action="<c:url value="/login" />" method="GET">
	    						<input type="submit" name="action" value="Log In" />
							</form>
						</div>
					</div>
				</div>
		</section>
		<section>
			<div class="jumbotron text-center">Jakis randomowy tekst dla pedziów</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-4 col-md-6">
						<p>Przyjacielski tekst</p>
						<p>Ale nie dla pedałow</p>
					</div>
					<div class="col-sm-4 col-md-6">
						<p>Przyjacielski tekst</p>
						<p>Ale nie dla pedałow</p>
					</div>
					<div class="col-sm-4 col-md-6">
						<p>Przyjacielski tekst</p>
						<p>Ale nie dla pedałow</p>
					</div>
					<div class="col-sm-4 col-md-6">
						<p>Przyjacielski tekst</p>
						<p>Ale nie dla pedałow</p>
					</div>
				</div>
			</div>
		</section>
		<section>
			<div>
				<h1>Testing</h1>
			</div>
			<div>
				<h3>Sympozjum</h3>
				<c:forEach var="com" items="${company}" > 
					<p>Nazwa Firmy: ${com.companyName}</p>
					<p>Opis Firmy: ${com.companyDescription}</p><br/>
				</c:forEach>
			</div>
		</section>
	</body>
</html>