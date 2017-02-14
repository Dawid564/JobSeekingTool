<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Tool Seeking</title>
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
								class="col-md-offset-9 col-sm-offset-9 col-xs-offset-9 logOutBtn">
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
						<li><a href="/webwork"><spring:message
									code="menu.tab.first" /></a></li>
						<li class="active"><a href="content"><spring:message
									code="menu.tab.second" /><span class="sr-only">(current)</span></a></li>
						<li><a href="payment"><spring:message
									code="menu.tab.third" /></a></li>
						<li><a href="settings"><spring:message
									code="menu.tab.fourth" /></a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- End Menu -->
	<div
		class="col-md-offset-2 col-sm-offset-1 col-xs-offset-0 col-md-8 col-sm-10 col-xs-12 ">${failValid}</div>
	<div id="seekingToolAccess">
		<%--<sec:authorize access="hasRole('ROLE_PREMIUM')"> --%>
		<div class="container-fluid">
			<!-- left side table -->

			<div
				class="leftTabelPanel col-md-offset-2 col-sm-offset-0 col-xs-offset-0 col-md-2 col-sm-12 col-xs-12">
				<div class="row leftTabelTopBtn ">
					<div>
						<p class="col-md-8 col-sm-8 col-xs-8">
							<spring:message code="process.container.description" />
						</p>
						<p class="col-md-4 col-sm-4 col-xs-4">${numberOfProcesses}/20</p>
					</div>
				</div>
				<div>
					<c:forEach items="${listOfProcess}" var="process">
						<div class="">
							<form action="/webwork/content/look/" method="get"
								id="getProcessId">
								<input type="hidden" name="getProcess" id="getProcessHidden" />
								<input
									class="leftPanelListElement btn btn-default col-md-8 col-sm-8 col-xs-8"
									type="button" value="${process.processName}"
									onclick="setProcessOnFront('${process.processName}')"></input>
								<!-- <p>${process.processName}</p>  -->
							</form>
							<form action="/webwork/content/del/" method="get" id="delButton">
								<input type="hidden" name="processTitle" id="hiddenButton" /> <input
									class="btn btn-danger col-md-4 col-sm-4 col-xs-4" type="button"
									onclick="delButton('${process.processName}')"
									value="<spring:message
						code="left.panel.option.del"/>" />
							</form>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- end of left side table -->
			<!-- Top add process panel -->
			<div class="topAddPanel container col-md-6 col-sm-12 col-xs-12"
				id="seekingToolProcess">
				<form:form modelAttribute="createNewProcess" id="processNameForm"
					action="/webwork/content">
					<!-- type="submit"  -->
					<input class="btn btn-primary col-md-12 col-sm-12 col-xs-12"
						type="button" onclick="checkAddProcessName()"
						value="<spring:message
						code="top.panel.button"/>" />
					<form:input class="form-control" id="processName"
						path="processName" type="text" placeHolder="Name of process" />
					<p id="alert" class="alertLabel"></p>
				</form:form>
				<div id="seekingToolProcessContentForm">
					<div class="mainContentPanel col-md-12 col-sm-12 col-xs-12">
						<form:form modelAttribute="createNewProcess"
							id="wholeSeekingProcess" action="/webwork/content/update">
							<div>
								<form:input path="processName" name="processName"
									id="processName" type="hidden" value="${nameOfCurrentProcess}" />
							</div>
							<div class="topFormElement">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="company.name" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:input class="form-control" path="companyName"
										id="companyName" type="text" value="${companyName}" />
								</div>
							</div>
							<div class="correctTextArea">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="company.description" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:textarea class="form-control" path="companyDescription"
										id="companyDescription" type="text" rows="5"
										value="${companyDescription}"
										placeHolder="How big is this company? How many employees? etc. " />
									<script>
										checkTextarea("${companyDescription}");
									</script>
								</div>
							</div>
							<div class="topFormElement">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="await.salary" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:input class="form-control" path="awaitSalary"
										id="awaitSalary" type="text" value="${awaitSalary}" />
								</div>
							</div>
							<div class="topFormElement">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="contactEmail" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:input class="form-control" path="contactEmail"
										id="contactEmail" type="text" value="${contactEmail}" />
								</div>
							</div>
							<div class="topFormElement">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="contactPhone" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:input class="form-control" path="contactPhone"
										id="contactPhone" type="text" value="${contactPhone}" />
								</div>
							</div>
							<div class="holdImage col-md-12 col-sm-12 col-xs-12">
								<p>Download Free Resume Sample</p>
								<div class="col-md-4 col-sm-4 col-xs-6">
									<img class="col-md-12 col-sm-12 col-xs-12"
										src='<c:url value="resource/resume1.png"/>' /> <input
										class="btn btn-primary firstMilestone col-md-12 col-sm-12 col-xs-12"
										type="button" value="<spring:message code="download"/>"
										onclick="window.location='/webwork/content/download/resume1.rar';" />
									<%--http://www.freepik.com/free-vector/simple-resume_1014731.htm --%>
								</div>
								<div class="col-md-4 col-sm-4 col-xs-6">
									<img class="col-md-12 col-sm-12 col-xs-12"
										src='<c:url value="resource/resume2.png"/>' /> <input
										class="btn btn-primary firstMilestone col-md-12 col-sm-12 col-xs-12"
										type="button" value="<spring:message code="download"/>"
										onclick="window.location='/webwork/content/download/resume2.rar';" />
									<%--http://www.freepik.com/free-vector/professional-resume-template_837838.htm --%>
								</div>
								<div class="col-md-4 col-sm-4 col-xs-6">
									<img class="col-md-12 col-sm-12 col-xs-12"
										src='<c:url value="resource/resume3.png"/>' /> <input
										class="btn btn-primary firstMilestone col-md-12 col-sm-12 col-xs-12"
										type="button" value="<spring:message code="download"/>"
										onclick="window.location='/webwork/content/download/resume3.rar';" />
									<%--http://www.freepik.com/free-vector/simple-and-useful-resume-template_1025270.htm --%>
								</div>
							</div>
							<div class="midFormElement">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="resume.send" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:input class="form-control" path="dataResumeSend"
										placeHolder="YYYY-MM-DD HH:MM:SS" id="dataResumeSend" type="text"
										value="${dataResumeSend}" />
								</div>
							</div>

							<%-- place for date --%>

							<div class="midFormElement">
								<p class="col-md-4 col-sm-4 col-xs-4">
									<spring:message code="expectedAnswer" />
								</p>
								<div class="col-md-8 col-sm-8 col-xs-8">
									<form:input class="datePicker form-control" id="responseDate"
										type="text" name="responseDate" path="responseDate"
										placeHolder="YYYY-MM-DD HH:MM:SS" value="${responseDate}" />
								</div>
								<p id="responseDateError"
									class="alertLabel col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-8 col-sm-8 col-xs-8"></p>
								<script>
									responseDate("${responseDate}");
								</script>
							</div>
							<div class="midFormElement">
								<div id="">
									<p class="col-md-4 col-sm-4 col-xs-4">TO DO List</p>
									<div class="col-md-8 col-sm-8 col-xs-8">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-1 col-sm-1 col-xs-1">
												<form:checkbox class="correctCheckbox form-control" path="sendResume"
													value="send" id="sendResume" />
											</div>
											<div></div>
											<div class="col-md-11 col-sm-11 col-xs-11">
												<p>
													<spring:message code="sendResume" />
												</p>
											</div>
											<script>
												checkCheckBox("${checkBoxVal}");
											</script>
										</div>
									</div>
								</div>
							</div>
							<div class="firstMilestone col-md-12 col-sm-12 col-xs-12">
								<input class="btn btn-primary col-md-12 col-sm-12 col-xs-12"
									value="<spring:message code="first.mile.stone"/>"
									id="firstMileStone" type="button"
									onclick="sendFirstMileStone()" />
							</div>
							<div id="secondPart"
								class="col-md-12 col-sm-12 col-xs-12 secondPart">
								<p class="col-md-12 col-sm-12 col-xs-12">Prepare to phone answer</p>
								<div class="correctTextArea1">
									<p class="col-md-4 col-sm-4 col-xs-4">
										<spring:message code="questions.Phone.Call" />
									</p>
									<div class="col-md-8 col-sm-8 col-xs-8">
										<form:textarea class="form-control" path="questionsPhoneCall"
											id="questionsPhoneCall" type="text" rows="5"
											value="${questionsPhoneCall}" />
										<script>
											checkTextareaWQuestions("${questionsPhoneCall}");
										</script>
									</div>
								</div>
								<div class="correctTextArea">
									<p class="col-md-4 col-sm-4 col-xs-4">
										<spring:message code="notes.Phone.Call" />
									</p>
									<div class="col-md-8 col-sm-8 col-xs-8">
										<form:textarea class="form-control" path="notesPhoneCall"
											id="notesPhoneCall" type="text" rows="5"
											value="${notesPhoneCall}" />
										<script>
											checkTextareaNotes("${notesPhoneCall}");
										</script>
									</div>
								</div>
								<section class="col-md-12 col-sm-12 col-xs-12">
									<div class="correctTextAreaStrength col-md-6 col-sm-6 col-xs-6">
										<p class="col-md-12 col-sm-12 col-xs-12">
											<spring:message code="strengths" />
										</p>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<form:textarea class="form-control" path="strengths"
												id="strengths" type="text" rows="15" value="${strengths}" />
											<script>
												checkTextareaStrengths("${strengths}");
											</script>
										</div>
									</div>
									<div class="correctTextAreaStrength col-md-6 col-sm-6 col-xs-6">
										<p class="col-md-12 col-sm-12 col-xs-12">
											<spring:message code="weakness" />
										</p>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<form:textarea class="form-control" path="weakness"
												id="weakness" type="text" rows="15" value="${weakness}" />
											<script>
												checkTextareaWeakness("${weakness}");
											</script>
										</div>
									</div>
								</section>
							</div>
							<div class="firstMilestone col-md-12 col-sm-12 col-xs-12">
								<input class="btn btn-primary col-md-12 col-sm-12 col-xs-12"
									value="<spring:message code="second.mile.stone"/>"
									id="firstMileStone" type="button"
									onclick="sendFirstMileStone()" />
							</div>

							<div id="thirdPart">
								<p class="col-md-12 col-sm-12 col-xs-12">Prepare To
									Interview</p>
								<div id="todo">
									<p class="col-md-4 col-sm-4 col-xs-4">TO DO List</p>
									<div class="col-md-8 col-sm-8 col-xs-8">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-1 col-sm-1 col-xs-1">
												<form:checkbox path="rightClothing" id="rightClothing" />
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10">
												<p>
													<spring:message code="rightClothing" />
												</p>
											</div>
											<script>
												checkCheckBoxRightClothing("${rightClothing}")
											</script>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-1 col-sm-1 col-xs-1">
												<form:checkbox path="remindResume" id="remindResume" />
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10">
												<p>
													<spring:message code="remindResume" />
												</p>
											</div>
											<script>
												checkCheckBoxRemindResume("${remindResume}")
											</script>
										</div>
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="col-md-1 col-sm-1 col-xs-1">
												<form:checkbox path="importantDocs" id="importantDocs" />
											</div>
											<div class="col-md-10 col-sm-10 col-xs-10">
												<p>
													<spring:message code="importantDocs" />
												</p>
											</div>
											<script>
												checkCheckBoxImportantDocs("${importantDocs}")
											</script>
										</div>
									</div>
								</div>
								<div>
									<div class="topFormElement1">
										<p class="col-md-4 col-sm-4 col-xs-4">
											<spring:message code="interviewPlace" />
										</p>
										<div class="col-md-8 col-sm-8 col-xs-8">
											<form:input class="form-control" path="interviewPlace"
												id="interviewPlace" type="text" value="${interviewPlace}" />
										</div>
									</div>
								</div>
								<div class="topFormElement1">
									<p class="col-md-4 col-sm-4 col-xs-4">
										<spring:message code="interviewDate" />
									</p>
									<div class="col-md-8 col-sm-8 col-xs-8">
										<form:input class="datePicker form-control" id="interviewTime"
											type="text" name="interviewTime" path="interviewTime" placeHolder="YYYY-MM-DD HH:MM:SS"
											value="${interviewTime}" />
									</div>
									<p id="responseDateError"
										class="alertLabel col-md-offset-4 col-sm-offset-4 col-xs-offset-4 col-md-8 col-sm-8 col-xs-8"></p>
									<script>
										interviewTime("${interviewTime}");
									</script>
								</div>
							</div>
							<div class="firstMilestone col-md-12 col-sm-12 col-xs-12">
								<input class="btn btn-primary col-md-12 col-sm-12 col-xs-12"
									value="<spring:message code="third.mile.stone"/>"
									id="firstMileStone" type="button"
									onclick="sendFirstMileStone()" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<%--</sec:authorize> --%>
	</div>
	<script>
		access('${premiumStatus}')
	</script>
	<script>
		mainContentVisibleSettings('${halo}')
	</script>

</body>
</html>