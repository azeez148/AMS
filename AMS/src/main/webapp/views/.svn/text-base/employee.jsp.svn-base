<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String section = request.getAttribute("section").toString();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <title>Asset Management System</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/css/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->
<script type="text/javascript"> 
function showEmployee()
{
	{
		var employeeName = $("#empName").val();

		var obj=document.getElementById("empDesignation");
		var employeeDesignation = obj.options[obj.selectedIndex].value;
		var obj1 =  document.getElementById("empRole");
		var employeeRole = obj1.options[obj1.selectedIndex].value;
		$.ajax({
			type: "GET",
			url: "searchresultforaddemployee",
			data: "employeeName="+employeeName+"&employeeDesignation="+employeeDesignation+"&employeeRole="+employeeRole,
			success: function(response){
				$("#Details").html(response);
			},
			error: function(responseObject, ioArgs){
				if (responseObject.status == 601) {
		            // reload entire page - this leads to login page
		            window.location.reload();
		         } else {
		        	 alert("Error"+e);	
		         }
			}
		});
	}
}

function addEmployee()
{
	
	document.forms[0].action = "addemployee";
	document.forms[0].submit();
}
function restEmployee(){
	document.forms[0].action = "showEmployees";
	document.forms[0].submit();
	
}

document.getElementById('ManageEmployee').className = 'active';
</script>

</head>
<body>


	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_serviceInfo">
				<c:set var="Emp" value="class=active" />
				<c:set var="mngEmp" value="class=act" />
				<c:set var="modifyClass" value="" />
				<c:set var="listClass" value="active" />
				<c:if test="${section == 'Manage Employee'}">
					<script>
	/* $('#tabs a[href="#modify"]').tab('show'); */
<c:set var="Emp" value="class=act"/>
<c:set var="mngEmp" value="class=active"/>
<c:set var="modifyClass" value="active"/>
<c:set var="listClass" value=""/>
	</script>
				</c:if>
		<div class="exp_container">
					<h4><img src="../resources/images/Manage EmployeeH.png" style="width:25px; height:auto; margin-right:5px"/>Manage Employee</h4>
					<ul class="nav nav-tabs" id="tabs">
						<li ${Emp}><a id="listTab" data-toggle="tab" href="#list">
						Employee List
							<!-- <a class="subA" href="showEmployees">Employee List</a> -->
							</a></li>
						<li ${mngEmp}><a id="modifyTab" data-toggle="tab"
							href="/">Manage Employee</a></li>
					</ul>

					<div class="tab-content servicetab col-md-12">
						<div id="list" class="tab-pane fade ${listClass} in"
							style="${disp}">
							<form action="searchresultforaddemployee" class="form-inline"
								role="form" method="post">

								<div class="searchpanel">
									<div class="exp_search">

										<div class="form-group">
											<spring:message code="co.label.employeeName" />
											<input type="text" class="form-control search" name="empName"
												id="empName">&nbsp;
											<%-- 											<input type="hidden" name="id" value="${getRole.id}"> --%>

										<!-- </div>
										<div class="form-group"> -->
											<spring:message code="co.label.designation" />
											<select class="form-control search" id="empDesignation"
												name="empDesignation">
												<option>Admin</option>
												<option>Developer</option>
												<option>Software Engineer</option>

											</select>&nbsp;
											<spring:message code="co.label.role" />
											<select class="form-control common" id="search"
												name="description">
												<option></option>
												<c:forEach var="role" items="${getRole}">
													<option value="${role.description}">${role.description}</option>
												</c:forEach>
											</select>&nbsp;
											<button type="submit" class="btn btn-info pBtn"
												onclick="searchResults()">
												<spring:message code="co.button.search" />
											</button>
											&nbsp;
											<button type="reset" class="btn btn-info pBtn">
												<spring:message code="co.button.clear" />
											</button>
										</div>
									</div>
								</div>
								<div class="mngrinbx">
									<div class="panel panel-default">

										<%
											int i = 0;
											pageContext.setAttribute("i", i);
										%>
										<table class="table">

											<thead>
												<tr>
													<th><spring:message code="co.label.code" /></th>
													<th><spring:message code="co.label.name" /></th>
													<th><spring:message code="co.label.email" /></th>
													<th><spring:message code="co.label.designation" /></th>
													<th><spring:message code="co.label.contact" /></th>
													<th><spring:message code="co.label.role" /></th>
													<th><spring:message code="co.label.joinDate" /></th>
													<th><spring:message code="co.label.gender" /></th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${employeeDetails}" var="empDetails">
													<tr>
														
														<td>${empDetails.empCode}<input type="hidden" name="empId"
															value="${employee.empId}"></td>
														<td>${empDetails.empName}</td>
														<td>${empDetails.empEmail}</td>
														<td>${empDetails.empDesignation}</td>
														<td>${empDetails.empContact}</td>
														<td>${empDetails.getEmpRoleMapping()[0].getRoleCode().getDescription()}</td>
														<%-- <td>${empDetails.getEmpRoleMapping()[0].getRoleCode().getRoleName()}</td> --%>
														<td>${empDetails.joiningDate}</td>
														<td>${empDetails.empGender}</td>
														<td><a href="editemployee?empId=${empDetails.empId}"
															onclick="showtab()">Edit</a></td>


													</tr>
												</c:forEach>
												<!-- 												<tr> -->
												<!-- 													<td>1001</td> -->
												<!-- 													<td>Aneesh</td> -->
												<!-- 													<td>aneesh@experionglobal.com</td> -->
												<!-- 													<td>Software Engineer</td> -->
												<!-- 													<td>9560785689</td> -->
												<!-- 													<td>Employee</td> -->
												<!-- 													<td>10-Mar-2013</td> -->
												<!-- 													<td>M</td> -->
												<!-- 													<td><a href="#" onclick="showtab()">Edit</a></td> -->

												<!-- 												</tr> -->
											</tbody>
										</table>

									</div>
								</div>
							</form>

						</div>
						<div id="modify" class="tab-pane fade ${modifyClass} in"
							style="${disp2}">
							<form action="addemployee" class="form-horizontal col-sm-12 pzero" role="form" method="POST">



								<div class="row1 col-sm-12 exp_search pzero pbottom10">
									<div class="col-sm-6">
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.employeeCode" /></label><input
												class="form-control common col-sm-6" type="text"
												name="empCode" value="${employee.empCode}" readonly /> <input
												type="hidden" name="empId" value="${employee.empId}">
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.employeeEmail" /></label><input
												class="form-control common col-sm-6" type="text"
												name="empEmail" value="${employee.empEmail}" readonly />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.employeeContact" /></label> <input
												class="form-control common col-sm-6" type="text"
												name="empContact" value="${employee.empContact}" readonly />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.joinDate" /></label> <input
												class="form-control common col-sm-6" type="text"
												name="joiningDate" value="${employee.joiningDate}" readonly />
										</div>

									</div>


									<div class="col-sm-6">
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.employeeDesignation" /></label> <input
												class="form-control common col-sm-6" type="text"
												name="empDesignation" value="${employee.empDesignation}"
												readonly />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.employeeName" /></label> <input
												class="form-control common col-sm-6" type="text"
												name="empName" value="${employee.empName}" readonly />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.employeeGender" /></label> <input
												class="form-control common col-sm-6" type="text"
												name="empName" value="${employee.empGender}" readonly />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.role" /></label> <select class="form-control common"
												id="search" name="description">
												<c:forEach var="role" items="${getRole}">
													<option value="${role.description}">${role.description}</option>
												</c:forEach>
											</select>
										</div>
										<div align="right">
											<button type="submit" class="btn btn-info submitButton">
												<spring:message code="co.button.save" />
											</button>
											<button type="reset" class="btn btn-info submitButton"
												onclick="restEmployee()">
												<spring:message code="co.button.cancel" />
											</button>
										</div>
									</div>

								</div>

							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- DAte picker -->
	<script type="text/javascript">
<%-- 	function addRowHandlers(tableId, rowClassName, url, paramName, columnIndex) {
		var section = '<%=section%>';
		if(section == 'Manage Employee')
		{
			document.getElementById("main").style.display = "none";
			document.getElementById("firstlink").style.zIndex = "0";
			document.getElementById("secondlink").style.zIndex = "2";
			document.getElementById("addList").style.zIndex = "1";
			document.getElementById("firstlink").style.marginTop = "2px";
			document.getElementById("secondlink").style.marginTop = "0px";
		}
		else
		{
			document.getElementById("addList").style.display = "none";
			document.getElementById("firstlink").style.zIndex = "2";
			document.getElementById("secondlink").style.zIndex = "0";
			document.getElementById("main").style.zIndex = "1";	
			document.getElementById("secondlink").style.marginTop = "2px";
			document.getElementById("firstlink").style.marginTop = "0px";
		} 
		$('span.pagelinks>a').click(function()
		{
			selectedEmpCode = 0;
			document.getElementById("error").innerHTML = "";
		});
		if (document.getElementById(tableId) != null) {
			var table = document.getElementById(tableId);
			var rows = table.getElementsByTagName("tr");
			for (i = 1; i < rows.length; i++) {
				rows[i].onclick = function() {
					if (typeof (preEl) != 'undefined'
							&& typeof (previousClass) != 'undefined') {
						preEl.className = previousClass;
					}
					previousClass = this.className;
					this.className = rowClassName;
					preEl = this;
					var cell = this.getElementsByTagName("td")[columnIndex];
					var paramValue = cell.innerHTML;
					selectedEmpCode = paramValue;
				};
				
			}
		}
	} --%>
	
		window.onload = function() {
			new JsDatePick({
				useMode : 2,
				target : "lsdate",
				dateFormat : "%Y-%M-%d"
			});

			new JsDatePick({
				useMode : 2,
				target : "nsdate",
				dateFormat : "%Y-%M-%d"
			});

		};
		function showEmp() {
			document.forms[0].action = "showEmployees";
			document.forms[0].submit();	
		}
		function searchResults{
			document.forms[0].action = "searchresultforaddemployee";
			document.forms[0].submit();
			
		}
		function saveEmployee() {
			document.forms[0].action = "addemployee";
			document.forms[0].submit();
			
		}
		function showtab() {
			$('#tabs a[href="#modify"]').tab('show');
		//$('#tabs a[href="#menu1"]').tab('show');
//		 	$('#listTab').parents().tabs({ de : 0});

			// 		$('#modifyTab').parents().tabs({ active: 0});
/* if(document.getElementById("hdnDisplayDiv").value="ManageEmployee") {
	
} */
	/* 		$("#modifyTab").attr("aria-expanded", "true");
			$("#modifyTab").parent().addClass("active");
			//             $("#financeDashboard").removeClass();
			$("#listTab").attr("aria-expanded", "false");
			$("#listTab").parent().removeClass("active");
			$("#list").removeClass();
			$("#list").addClass("tab-pane fade in");
			$("#modify").addClass("tab-pane fade in active"); */
		}
		
	</script>
	<!-- to retain field values -->
	     <script>
            $(document).ready(function(){
                document.getElementById("empName").value = localStorage.getItem("Name");
                document.getElementById("empDesignation").value = localStorage.getItem("Designation");
                document.getElementById("search").value = localStorage.getItem("Role");
            });
        </script>
        <script>
            $(window).on('beforeunload', function() {
                localStorage.setItem("Name",document.getElementById("empName").value);
                localStorage.setItem("Designation",document.getElementById("empDesignation").value);
                localStorage.setItem("Role",document.getElementById("search").value);
                
            });

        </script>
	
</body>
</html>













