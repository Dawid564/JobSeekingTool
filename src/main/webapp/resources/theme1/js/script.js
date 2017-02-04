document.addEventListener("DOMContentLoaded", function(event) {
	//do nothing
});
function checkCheckBox(c){
	if(c == "true"){
		document.getElementById("sendResume").checked = true;
	}else{
		document.getElementById("sendResume").checked = false;
	}
}
function checkCheckBoxRightClothing(c){
	if(c == "true"){
		document.getElementById("rightClothing").checked = true;
	}else{
		document.getElementById("rightClothing").checked = false;
	}
}
function checkCheckBoxRemindResume(c){
	if(c == "true"){
		document.getElementById("remindResume").checked = true;
	}else{
		document.getElementById("remindResume").checked = false;
	}
}
function checkCheckBoxImportantDocs(c){
	if(c == "true"){
		document.getElementById("importantDocs").checked = true;
	}else{
		document.getElementById("importantDocs").checked = false;
	}
}

function submitDocument(){
	document.getElementById("logOut").submit();	
}
function checkAddProcessName(){
	var data = document.getElementById('processName').value;
	if(data == ""){
		document.getElementById('alert').innerHTML = "This gap can't be empty";
	}else{
		document.getElementById('alert').innerHTML = "";
		document.getElementById('processNameForm').submit();
	}
}
function delButton(asd){
	document.getElementById('hiddenButton').value=asd;
	document.getElementById('delButton').submit();
}
function sendFirstMileStone(){
	//exception
	//document.getElementById('wholeSeekingProcess').submit();
	
	var responseDateVal = document.getElementById("responseDate").value;
	var dateReg = /^\d{4}([./-])\d{2}\1\d{2}$/;
	
	if(dateReg.test(responseDateVal) || responseDateVal == "YYYY-MM-DD"){
		document.getElementById('wholeSeekingProcess').submit();
	}else{
		document.getElementById("responseDateError").innerHTML = "Date must looks like 2001-12-31 (YYYY-MM-DD)";
	}
}
function setProcessOnFront(processId){
	document.getElementById('getProcessHidden').value=processId;
	document.getElementById('getProcessId').submit();
}
function checkTextarea(txt){
	document.getElementById("companyDescription").value = txt;
}
function checkTextareaWQuestions(txt){
	document.getElementById("questionsPhoneCall").value = txt;
}
function checkTextareaNotes(txt){
	document.getElementById("notesPhoneCall").value = txt;
}
function checkTextareaStrengths(txt){
	document.getElementById("strengths").value = txt;
}
function checkTextareaWeakness(txt){
	document.getElementById("weakness").value = txt;
}
function responseDate(responseDate){
	if(responseDate != ""){
		document.getElementById("responseDate").value = responseDate.substring(0, 10);
	}else{
		document.getElementById("responseDate").value = "YYYY-MM-DD";
	}
}
function interviewTime(responseDate){
//	if(responseDate != ""){
//		document.getElementById("responseDate").value = responseDate.substring(0, 10);
//	}else{
//		document.getElementById("responseDate").value = "YYYY-MM-DD";
//	}
}
