document.addEventListener("DOMContentLoaded", function(event) {

});
function checkCheckBox(c) {
	if (c == "true") {
		document.getElementById("sendResume").checked = true;
	} else {
		document.getElementById("sendResume").checked = false;
	}
}
function checkCheckBoxRightClothing(c) {
	if (c == "true") {
		document.getElementById("rightClothing").checked = true;
	} else {
		document.getElementById("rightClothing").checked = false;
	}
}
function checkCheckBoxRemindResume(c) {
	if (c == "true") {
		document.getElementById("remindResume").checked = true;
	} else {
		document.getElementById("remindResume").checked = false;
	}
}
function checkCheckBoxImportantDocs(c) {
	if (c == "true") {
		document.getElementById("importantDocs").checked = true;
	} else {
		document.getElementById("importantDocs").checked = false;
	}
}

function submitDocument() {
	document.getElementById("logOut").submit();
}
function checkAddProcessName() {
	var data = document.getElementById('processName').value;
	if (data == "") {
		document.getElementById('alert').innerHTML = "This gap can't be empty";
	} else {
		document.getElementById('alert').innerHTML = "";
		document.getElementById('processNameForm').submit();
	}
}
function delButton(asd) {
	document.getElementById('hiddenButton').value = asd;
	document.getElementById('delButton').submit();
}
function sendFirstMileStone() {
	// exception
	// document.getElementById('wholeSeekingProcess').submit();

	var responseDateVal = document.getElementById("responseDate").value;
	var dateReg = /^\d{4}([./-])\d{2}\1\d{2}$/;

	if (dateReg.test(responseDateVal) || responseDateVal == "YYYY-MM-DD") {
		document.getElementById('wholeSeekingProcess').submit();
	} else {
		document.getElementById("responseDateError").innerHTML = "Date must looks like 2001-12-31 (YYYY-MM-DD)";
	}
}
function setProcessOnFront(processId) {
	document.getElementById('getProcessHidden').value = processId;
	document.getElementById('getProcessId').submit();
	
	//show main tool
	//document.getElementById("seekingToolProcessContentForm").style.visibility = "visible";
	
}
function checkTextarea(txt) {
	document.getElementById("companyDescription").value = txt;
}
function checkTextareaWQuestions(txt) {
	document.getElementById("questionsPhoneCall").value = txt;
}
function checkTextareaNotes(txt) {
	document.getElementById("notesPhoneCall").value = txt;
}
function checkTextareaStrengths(txt) {
	document.getElementById("strengths").value = txt;
}
function checkTextareaWeakness(txt) {
	document.getElementById("weakness").value = txt;
}
function responseDate(responseDate) {
	if (responseDate != "") {
		document.getElementById("responseDate").value = responseDate.substring(
				0, 10);
	} else {
		document.getElementById("responseDate").value = "YYYY-MM-DD";
	}
}
function interviewTime(responseDate) {
	// if(responseDate != ""){
	// document.getElementById("responseDate").value = responseDate.substring(0,
	// 10);
	// }else{
	// document.getElementById("responseDate").value = "YYYY-MM-DD";
	// }
}
function checkPass() {
	//check if password is the same
	var counter = 0;
	
	var pass1 = document.getElementById("pass1").value;
	var pass2 = document.getElementById("pass2").value;
	if (pass1 == pass2) {
		counter = counter + 1;
	} else {
		document.getElementById("registerPassValidation").innerHTML = "passwords are not the same";
	}
	
	if(pass1.length < 5){
		document.getElementById("registerPassValidation").innerHTML = "password must have at least 6 characters";
	}else{
		counter = counter + 1;
	}
	
	//check email
	var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var email = document.getElementById("registerFormEmail").value;
	if(emailRegex.test(email)){
		counter = counter + 1;
	}else{
		document.getElementById("registerEmailValidation").innerHTML = "email is not correct";
	}
	
	//check user login
	var fisrtNameForm = document.getElementById("registerUserForm");
	console.log(fisrtNameForm.value.length);
	var nameLength = fisrtNameForm.value.length;
	if(nameLength < 5){
		document.getElementById("registerUserValidation").innerHTML = "login must have at least 6 characters";
	}else{
		counter = counter + 1;
	}
		
	if(counter==4){
		setForm();
	}
}

function setForm() {
	document.getElementById("registerForm").submit();
}
function passwordFormScript(){
	alert("Wlecome Sir!!!");
	document.getElementById('settingsPasswordForm').submit();
}
function access(access){
	var doc = document.getElementById("seekingToolAccess").style.visibility = access;
}

function mainContentVisibleSettings(vis){
	//hidden main tool
	if(vis == ""){
		document.getElementById("seekingToolProcessContentForm").style.visibility = "hidden";
	}else{
		document.getElementById("seekingToolProcessContentForm").style.visibility = "visible";
	}
}



