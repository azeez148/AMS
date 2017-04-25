<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <title>Asset Management System</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script> -->
<script type="text/javascript">
	function validateForm() {
		document.forms[0].action = "login";
		document.forms[0].submit();
	}
	function reset() {
		document.getElementById("EmployeeCode").focus();
	}
	function processLogin(event) {
		if (event.keyCode == '13') {
			document.forms[0].action = "login";
			document.forms[0].submit();
		}
	}
</script>
</head>
<body style="align: center">
	<form:form method="POST" commandName="loginForm" action="../login/home"
		modelAttribute="logForm">
		<div class="loginPanel">
			<br /> <br />
			<div class="topblue exp_login_box">
				<table class="exp_login_table" style="font-size: 14px;"
					cellpadding="0px">
					<tr>
						<td><spring:message code="ams.button.username" /></td>

						<td><form:input path="employeeCode" id="employeeCode"
								cssClass="textBox" maxlength="22" /> <br>
						<span class="loginBlankError"><form:errors
									path="employeeCode" /></span></td>

					</tr>

					<tr>
						<td><spring:message code="ams.button.password" /></td>

						<td><form:password path="password" id="password"
								cssClass="textBox" maxlength="22" /> <br>
						<span class="loginBlankError"><form:errors path="password" /></span>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="right"><input class="btn btn-info"
							type="submit"
							style="margin-top: 5px; padding: 4px 5px 8px; height: 26px;"
							value="<spring:message code="ams.button.login"/>" /></td>
					</tr>

				</table>
				<div class="errMSg"
					style="color: red; text-align: center; margin-top: 15px;">${ErrMsg}</div>
					
			</div>
		</div>
	</form:form>
</body>
</html>