<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
#appHeader,#reportingAgent {
    background-color: #F0F8FF;
    width: 400px;
    border: 1px solid black;
    padding: 5px;
    height: 320px;

}


#submission {
  text-align: center;
  }
</style>
<script >
function validateForm() {
    var x = document.getElementById("fileSize").value;
    
	var y = document.getElementById("transactionSize").value;
	var z = document.getElementById("invalidRecordSize").value;
	
    if (x < 0) {
        alert("No: of files should not be blank");
        return false;
    }
	
	
}

</script>
<body style="padding:20px; ">
<img style="float:left;height:50px;" alt="" src="/img/images.jpg">
<form name="xmlForm" style="width:100%"  action="submit" method="post"  >


<h2 style="text-align:center">Welcome to EBOR XML Utility Generator</h2>


<br/>
<div id="agentId" style="width:420px;"> No: of files to be created*:
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id ="reportAgentId" type="number" name="fileSize" value="0" min="1" /></div><br/>

<div id="totalRecords" style="width:420px;">Enter no of transactions*: 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="number" id ="transactionSize" name="transactions" value ="0" min="1" max="50000" /></div><br/>


<div id="invalidRecord" style="width:420px;"> Enter no of invalid transactions:
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="number" id="invalidRecordSize" name="inValidRecords" value ="0" max="100" /><div style="font-size: 11px;color: red;">(Value should be in % e.g.(10) don't put % symbol)</div> </div><br />


<div id="lastDay"style="width:420px;"> Enter no of Last day transactions: 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="number" id = "lastDayTransactionSize" name="lastDayTransactions" value="0" max ="100" /><div style="font-size: 11px;color: red">(Value should be in % e.g.(10) don't put % symbol)</div> </div> <br/>

<div style="width:420px;"> Created By: 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<input type="text" id = "createdBy" name="createdBy" value="user"/> </div> <br/>

<div style="width:420px;"> Label Info: 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name="labelInfo" required style="width:160px;">
  <option value="L1">L1</option>
  <option value="L2">L2</option>
  <option value="L3">L3</option>
  <option value="Filter1">Filter1</option>
  <option value="Filter2">Filter2</option>
</select> </div> <br/>

<p id="submission"><input type="submit" value="Click to Create XML"></p>

</form> 
</body>
</html>