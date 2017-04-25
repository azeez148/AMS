<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<%
	String section = request.getAttribute("section").toString();
	//  out.print(section);
%>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="../resources/css/jsDatePick_ltr.min.css">
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />

	





<script type="text/javascript"
	src="../resources/js/jquery-ui-1.11.1.min.js"></script>


 <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="../resources/js/jsDatePick.min.1.3.js"></script>
<script type="text/javascript"
	src="../resources/js/applicationScript/depreciation.js"></script>
<title>AMS-Transfer</title> -->

<script type="text/javascript">

function showtab() {
// 	alert("Hi")
	$('#myTab a[href="#modify"]').tab('show');
}
function gethrefassetid()
{
	
	
var id=$('#assethid').val();	
alert(id);
	 $('#hrefastid').val(id);
	
	 
	 
	 
}

</script>
<script type="text/javascript">document.getElementById('AssetTransfer').className = 'active';</script>



</head>
<body>
<div class="h80">
<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">
<c:set var="Emp" value="class=active" />
				<c:set var="mngEmp" value="class=act" />
				<c:set var="modifyClass" value="" />
				<c:set var="listClass" value="active" />
				<c:if test="${section == 'Modify Depreciation'}">
			
<c:set var="Emp" value="class=act"/>
<c:set var="mngEmp" value="class=active"/>
<c:set var="modifyClass" value="active"/>
<c:set var="listClass" value=""/>
</c:if>

				<div class="exp_container">
		
					<h4><img src="../resources/images/Asset TransferH.png" style="width:25px; height:auto; margin-right:5px"/>Asset Transfer</h4>
					<ul class="nav nav-tabs" id="myTab">
						<li ${Emp} ><a data-toggle="tab"  href="#list">List
								Assets</a></li>
						<li ${mngEmp} ><a data-toggle="tab"  href="#modify">Asset Transfer</a></li>

					</ul>

					<div class="tab-content servicetab">
						<div id="list" class="tab-pane fade in ${listClass} ">
							

								 <form:form class="form-inline"  role="form" action="searchTransferAsset" commandName="assetTransfer">
									  <div class="exp_search">
									   <div class="form-group">
										<label>Asset No.</label>
										<form:input path="searchText" type="text" class="form-control" id="search" name="assetNumber" placeholder="Search"/>&nbsp;
										<button type="submit" class="btn btn-info pBtn">Search</button>
									   </div>
									  </div>
									</form:form>
                   <form role="form" >
<!-- 								<table class="table"> -->
<!-- 									<thead> -->
<!-- 										<tr> -->
<%-- 											<th><spring:message code="co.asset.label.assetno" /></th> --%>
<%-- 											<th><spring:message code="co.asset.label.model" /></th> --%>
<%-- 											<th><spring:message code="co.asset.label.department" /></th> --%>
<%-- 											<th><spring:message code="co.asset.label.project" /></th> --%>
<%-- 											<th><spring:message code="co.asset.label.custodian" /></th> --%>
<!-- 											<th></th> -->
<!-- 										</tr> -->
<!-- 									</thead> -->
<!--                             <tbody> -->
<%--                             	<c:forEach var="al" items="${assetList}"> --%>
<!-- 									<tr class="info"> -->
<%-- 										<td>${al.assetNumber}</td> --%>
<%-- 										<td>${al.assetModel}</td> --%>
<%-- 										<td>${al.assetDeptCode.comValue}</td> --%>
<%-- 										<td>${al.assetProjectCode.comValue}</td> --%>
<%-- 										<td>${al.assetCustodianCode.empName}</td> --%>
<%-- 										<td><a href="transferasset/${al.assetId}"   data-toggle="tooltip" --%>
<!-- 											data-placement="top" title="Clik Here">Transfer Asset</a> -->
											
<!-- 											</td> -->
<!-- 									</tr> -->
<%-- 									</c:forEach> --%>
<!-- 									</tbody> -->
<!-- 								</table> -->
										<div onmouseover="addRowHandlers('displayMaster', 'rowMouseOver', 'availableAssetDetails', 'assetId', 0, 1)">
											<display:table pagesize="8" defaultsort="1"
												name="availableAssetDetails" uid="displayMaster"
												export="false" requestURI="" sort="external" cellpadding="5"
												cellspacing="5">
												<display:column class="hiddenDisplayColumn"
													headerClass="hiddenDisplayColumn" property="assetId"
													title=""></display:column>

												<display:column title="Asset No" property="assetNumber"
													class="tableRow"></display:column>
												<display:column title="Model" property="assetModel"
													class="tableRow"></display:column>
												<display:column title="Dept"
													property="assetDeptCode.comValue" class="tableRow"></display:column>
												<display:column title="Projects"
													property="assetProjectCode.comValue" class="tableRow"></display:column>
												<display:column title="Custodian"
													property="assetCustodianCode.empName" class="tableRow"></display:column>
												<display:column title="" class="tableRow">
													<a href=# >Transfer Asset</a>
												</display:column>

											</display:table>
										</div>
								
<!-- 								<div align="left"> -->
<!-- 							 <input type="submit" class="btn btn-info" value="pre" name="pre" /> -->
<!-- 							<input type="submit" class="btn btn-info" value="next" name="next" /> -->
                           
<!-- 						    <input type="text" name="pageNum" value="1" /> -->
<!-- 						      <input type="submit" class="btn btn-info" value="first" name="first"/> -->
<!--                            <input type="submit" class="btn btn-info" value="last" name="last" /> -->
                         
<!--                             <input type="hidden" value="0" name="pagecountHidden"/> -->
<!-- 								</div> -->
								
                          </form>
						
						</div>



					<div id="modify" class="tab-pane fade in ${modifyClass}" >
							<form:form commandName="assetTransfer" class="form-horizontal exp_align formassetTransfer" role="form"  method="POST">
								<form:hidden path="assetId"/>
									<div class="row1 col-sm-12 topblue">
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label asstlabel col-sm-3">Asset No</label>
												<form:input readonly="true" path="assetNo"  class="form-control common col-sm-6" type="text"
													 />
											</div>
											<div class="form-group">
												<label class="control-label asstlabel col-sm-3">Model</label>
												<form:input readonly="true"  path="model"  class="form-control common col-sm-6" type="text" />
											</div>
											<div class="form-group">
												<label class="control-label asstlabel col-sm-3">Description</label>
												<form:textarea readonly="true"  path="desc" class="form-control textarea col-sm-6"></form:textarea>
											</div>

										</div>


										<div class="col-sm-6">
						
											<div class="form-group">
												<label class="control-label asstlabel col-sm-3">Capital Date</label>
												<form:input readonly="true"  path="capitalDate" id="capDate" class="form-control common col-sm-6" />
											</div>
											<div class="form-group">
												<label class="control-label asstlabel col-sm-3">Transfer Date</label>
												<form:input readonly="true" path="transferDate"  id="transDate"  class="form-control common col-sm-6" />
											</div>
											<div class="form-group">
												<label class="control-label asstlabel col-sm-3">Transfer
													Type</label>

											<form:select path="transferType" id="transType"
												class="form-control common col-sm-6">
												<option>Transfer Asset</option>
												<option>Write Off Asset</option>
												<option>Re-Value of Asset</option>
											</form:select>
										</div>
										</div>
									</div>
									<!-- row1 div closed here-->

									<div class="row2 col-md-12 ">

										<div id="transAsset" class="transborder">
											<h4 class="assetTransferHead" align="center">Transfer
												Asset</h4>
											<div class="col-sm-6 transAsset1">
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Location
														From</label>
														<form:input path="locationFrom" class="form-control common col-sm-6" readonly="true"/>		
<%-- 												 <form:select id="location" path="locationFrom" class="form-control common col-sm-6"> --%>
												 
												 	
<%-- 												 <c:forEach items="${location }" var="location"> --%>
<%-- 													 		<form:option value="${location.comId }">${location.comValue }</form:option> --%>
<%-- 										    	 	</c:forEach>  --%>
<!-- 													<option>Trivandrum</option> -->
<!-- 													<option>Cochin</option> -->
<%-- 												</form:select> --%>
											</div>
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Department
														From</label>
														<form:input path="deptFrom" class="form-control common col-sm-6" readonly="true"/>
<%-- 												 <form:select id="deptFrom" path="deptFrom" class="form-control common col-sm-6"> --%>
												 
<%-- 											    	 <c:forEach items="${department }" var="department"> --%>
<%-- 													 		<form:option value="${department.comId }">${department.comValue }</form:option> --%>
<%-- 										    	 	</c:forEach> --%>
<%-- 													</form:select> --%>
												</div>

												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Custodian
														From</label>
														
														<form:input path="custFrom" class="form-control common col-sm-6" readonly="true"/>
														
<%-- 													 <form:select path="custFrom" class="form-control common col-sm-6"> --%>
<%-- 													 	<c:forEach items="${custodian }" var="custodian"> --%>
<%-- 													 		<form:option value="${custodian.empId }">${custodian.empName }</form:option> --%>
<%-- 													 	</c:forEach> --%>
<%-- 													 <form:option value=""></form:option> --%>
<!-- 														<option>Aneesh</option> -->
<!-- 														<option>Mathew</option> -->
<!-- 														<option>Justin</option> -->
<%-- 													</form:select> --%>
												</div>
											</div>

											<div class="col-sm-6 transAsset2">
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Location
														To</label> 
													<form:select path="locationTo" class="form-control common col-sm-6">
														 <c:forEach items="${location }" var="location">
														 		<form:option value="${location.comId }">${location.comValue }</form:option>
											    	 	</c:forEach> 
													</form:select>
												</div>
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Department To</label>

												<form:select path="deptTo" class="form-control common col-sm-6">
													<c:forEach items="${department }" var="department">
													 		<form:option value="${department.comId }">${department.comValue }</form:option>
										    	 	</c:forEach>
												</form:select>
											</div>
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Custodian
														To</label>
													<form:select id="custTo" path="custTo"  class="form-control common col-sm-6">
														<c:forEach items="${custodian }" var="custodian">
													 		<form:option value="${custodian.empId }">${custodian.empName }</form:option>
													 	</c:forEach>
													</form:select>
												</div>
											</div>
										</div>
										<!-- transAsset closed herer -->

										<div id="writeOff" class="col-md-12 transborder">
											<h4 class="assetTransferHead1" align="center">Write Off
												Asset</h4>
											<div class="col-sm-6 transAsset1">
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Written
														Down Value</label>
														 <form:input path="writtenDownVal" class="form-control common col-sm-6"
														type="text"/>
												</div>
											</div>

											<div class="col-sm-6 transAsset2">

												<div class="form-group"></div>
											</div>
										</div>
										<!-- write Off closed here-->
										<div id="re-value" class="col-md-12 transborder">
											<h4 class="assetTransferHead1" align="center">Re-Value
												of Asset</h4>
											<div class="col-sm-6 transAsset1">
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Book
														Value</label>
														 <form:input path="bookValue" class="form-control common col-sm-6"
														type="text" />
												</div>
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Book
														Value After Re-valuation</label>
														 <form:input path="bookValueAfter"
														class="form-control common col-sm-6" type="text" />
												</div>

											</div>

											<div class="col-sm-6 transAsset2">
												<div class="form-group">
													<label class="control-label asstlabel col-sm-4">Purchase
														Cost</label> <form:input path="purchaseCost"  class="form-control common col-sm-6"
														type="text" />
												</div>


											</div>
										</div>


									</div>

									<div align="right">
										<button onclick="submitForm()" id="transferSubmit" name="transferSubmit" type="submit" class="btn btn-info submitButton">Cancel</button>
										<button onclick="submitForm()" id="transferCancel" name="transferCancel" type="submit" class="btn btn-info submitButton">Submit</button>
										
										<button onclick="submitForm()" id="writeOffSubmit" name="writeOffSubmit" type="submit" class="btn btn-info submitButton">Cancel</button>
										<button onclick="submitForm()" id="writeOffCancel" name="writeOffCancel" type="submit" class="btn btn-info submitButton">Submit</button>
										
										<button onclick="submitForm()" id="reValSubmit" name="reValSubmit" type="submit" class="btn btn-info submitButton">Cancel</button>
										<button onclick="submitForm()" id="reValCancel" name = "reValCancel" type="submit" class="btn btn-info submitButton">Submit</button>
										<header style="text-align: left; color: red;">${errorMessage}</header>
									</div>
									<!-- row2 div closed here-->
								</form:form>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	
</div>
<script type="text/javascript">
		$(document).ready(
				function() {
					$("#transAsset").show();
					$("#transferSubmit").show();
					$("#transferCancel").show();
					$("#writeOffSubmit").hide();
					$("#writeOffCancel").hide();
					$("#reValSubmit").hide();
					$("#reValCancel").hide();
					$("#writeOff").hide();
					$("#re-value").hide();
										
					new JsDatePick({
						useMode : 2,
						target : "transDate",
						dateFormat : "%d-%M-%Y"
					});

					$("#transType").change(function() {
						var transValue = this.value;
						if (transValue === "Transfer Asset") {
							$("#transAsset").fadeIn(100);
							$("#writeOff").hide();
							$("#re-value").hide();
						} else if (transValue === "Write Off Asset") {
							$("#transAsset").hide();
							$("#writeOff").fadeIn(100);
							$("#re-value").hide();

						} else {
							$("#transAsset").hide();
							$("#writeOff").hide();
							$("#re-value").fadeIn(100);
						}

					});
					$("tr").dblclick(function() {
						if ($("tr").index(this) !== 0)
							showtab();
					});
					$("tr").click(
							function() {
								if ($("tr").index(this) !== 0)
									$(this).addClass("selected").siblings()
											.removeClass("selected");
							});
					/*	$('#edit').click( function() {
							alert("hi");
						$("#manage").addClass("active").siblings().removeClass("active");
						$("#menu1").addClass("tab-pane fade  in active")

						return false; } );
					function editAsset(){
						alert("Hi");

					}*/

				});
		$("#custTo").change(function(){
// 				alert($("#custTo").val())
		});
// 		function showtab() {
// 			$('#myTab a[href="#menu1"]').tab('show');
// 		}

		function submitForm(){
// 				var $val = $("#transDate").val();
// 				alert($val)
				document.forms[2].action="saveTransfer";
	   			document.forms[2].submit();
		}
		
		var selectedRoleId;
		var previousClass;
		var preEl;
		function addRowHandlers(tableId, rowClassName, url, assetId, columnIndex) {
			var section = '<%=section%>';

			$('span.pagelinks>a').click(function() {
				// 			selectedRoleName = 0;
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
						var assetId = cell.innerHTML;
						/* selectedRoleId = paramValue; */
						
						showModifyTab(assetId);
						
						document.forms[0].action = "getAsset";
						document.forms[0].submit();
					};

				}
			}
		}

		function showModifyTab(selectedAsset) {
			$.ajax({
				type : "GET",
				url : "setAssetIdToSession",
				data : "assetId=" + selectedAsset,

				success : function(response) {
					// 				alert(response);

					if (response == "true") {
// 						alert(response);
						// 					showEditDetails();

						// 					changeTab();
					} else {
						alert('error');
					}

				}
			});

		}

	</script>
</body>
</html>