<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
		<title>Registration</title>
		<script>
			function checkPass(){
				var pass1 = document.getElementById("pass1").value;
				console.log("pass1 " + pass1);
				var pass2 = document.getElementById("pass2").value;
				console.log("pass2 " + pass2);
				if(pass1 == pass2){
					alert("passwords is the same");
					setForm();
				}else{
					alert("passwords is diffrent");
				}
			}

			function setForm(){
				console.log("how often i see this");
				document.getElementById("registerForm").submit();
			}
		</script>
	</head>
	<body>
		<!-- Register FORM -->
		<h1>REGISTRATION</h1>
		<section>
			<div id="registerContainer" class="from-horizontal">
				<form:form id="registerForm" modelAttribute="newUser" method="post">
					<div>
						<label>First Name</label>
						<form:input path="firstName" type="text"></form:input>	
					</div>
					<div>
						<label>Last Name</label>
						<form:input path="lastName" type="text"></form:input>	
					</div>
					<div>
						<label>Password</label>
						<form:input id="pass1" path="password" type="password"></form:input>
					</div>
					<div>
						<label>Re-type Password</label>
						<input id="pass2" type="password"></input>
					</div>
					<div>
						<label>Email</label>
						<form:input path="email" type="text"></form:input>
					</div>
				</form:form>
				<div>
					<button onClick="checkPass()">REGISTER</button>
				</div>
			</div>
		</section>
	</body>
</html>