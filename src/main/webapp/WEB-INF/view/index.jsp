<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Jakis tytul</title>
	</head>
	<body>
		<div>
			<h1>${pedaly}</h1>
		</div>
			<h1>jestes prawdziwym hakerem</h1>
			
		<sec:authorize access="hasRole('ROLE_USER')" var="isUser">
		<c:if test="${isUser}">
			<h1>ONLY FOR REAL USER using IF!!!</h1>
		</c:if>
			<c:choose>
				<c:when test="${isUser}">
					<h1>MASS EFFECT</h1>
					<h1>hello user haker man</h1>
				</c:when>
			</c:choose>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin">
			<c:choose>
				<c:when test="${isAdmin}">
					<h1>Hello HAKERMAN ADMIN</h1>
				</c:when>
			</c:choose>
		</sec:authorize>
	</body>
</html>