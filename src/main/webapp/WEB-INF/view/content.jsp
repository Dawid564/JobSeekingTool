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
	<script>
		function formSubmit(){
			document.getElementById("logoutForm").submit();
		}
	</script>
		<h1>${welcome}</h1>
		<h1>${friend}</h1>
		<h1>if you can read this you are a hackerman</h1>
		<form id="logOut" action=<c:url value="/j_spring_security_logout"/> method="POST">
			<input name="btn"  type="submit"  value="logOut"/>
		</form> 
		 	<!-- this not working 
		<form id="logoutForm" action="/j_spring_security_logout" method="POST">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
 		
 		
 		<c:if test="${pageContext.request.userPrincipal.name != null}">
 			<h2>
 				Welcome: ${pageContext.request.userPrincipal.name} <a href="javascript:formSubmit()">Logout</a>
 			</h2>
 		</c:if>
 		 -->
	</body>
</html>