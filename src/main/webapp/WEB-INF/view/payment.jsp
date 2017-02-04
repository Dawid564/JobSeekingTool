<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h1>HELLO PAYMENT</h1>
	<form action="https://www.paypal.com/cgi-bin/webscr" method="post"
		target="_top">
		<input type="hidden" name="cmd" value="_s-xclick"> <input
			type="hidden" name="hosted_button_id" value="4NVFD4P8RXUZL">
		<input type="image"
			src="https://www.paypalobjects.com/en_US/PL/i/btn/btn_buynowCC_LG.gif"
			border="0" name="submit"
			alt="PayPal - The safer, easier way to pay online!"> <img
			alt="" border="0"
			src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1"
			height="1">
	</form>



</body>
</html>