<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<link rel="stylesheet" type="text/css" media="all"
	href="../resources/css/jsDatePick_ltr.min.css">
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/css/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jsDatePick.min.1.3.js"></script>
	<script type="text/javascript"
	src="../resources/js/applicationScript/purchaseinfo.js"></script> -->
<script type="text/javascript">



document.getElementById('ServiceInfoHistory').className = 'active';

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
				//alert(assetId);
				document.forms[0].action = "historyInfo";
				document.forms[0].submit();
			};

		}
	}
}

function showModifyTab(selectedAsset) {

	// 			document.getElementById("roleName").value = roleName;
	$.ajax({
		type : "GET",
		url : "setServiceInfAssetIdToSession",
		data : "assetId=" + selectedAsset,

		success : function(response) {
			// 				alert(response);

			if (response == "true") {
				alert(response);
				// 					showEditDetails();

				// 					changeTab();
			} else {
				alert('error');
			}

		}
	});
}

</script>

</head>
<body>

	<%int i=0;pageContext.setAttribute("i", i); %>
	<div class="h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">
				<c:set var="Emp" value="class=active" />
				<c:set var="mngEmp" value="class=act" />
				<c:set var="modifyClass" value="" />
				<c:set var="listClass" value="active" />
				<c:if test="${section == 'History'}">
					<script type="text/javascript">
				
				</script>
					<c:set var="Emp" value="class=act" />
					<c:set var="mngEmp" value="class=active" />
					<c:set var="modifyClass" value="active" />
					<c:set var="listClass" value="" />

				</c:if>

				<div class="exp_container">
					<h4><img src="../resources/images/Service Info HistoryH.png" style="width:25px; height:auto; margin-right:5px"/>Service Info History</h4>
					<ul class="nav nav-tabs" id="tabs">
						<li ${Emp}><a id="listTab" data-toggle="tab" href="#list">List Assets<a
								class="subA" href="serviceInfoHistory">List Assets</a></a></li>
						<li ${mngEmp}><a id="modifyTab" data-toggle="tab" href="/">History</a></li>
					</ul>
					<div class="tab-content servicetab col-md-12">

						<div id="list" class="tab-pane fade ${listClass} in"
							style="${disp}">


							<form:form  class="form-inline"
									role="form">
									<div class="exp_search">
										<div class="form-group">
											<label><spring:message code="co.label.assetNo" /></label>
											<form:input path="assetNumber" class="form-control widform"
												type="text" id="assetNumber" placeholder="Search" />
											&nbsp; <input type="button" class="btn btn-info pBtn"
												value="<spring:message code="ams.label.searchcriteria" />"
												onclick="search()" />
										</div>
									</div>




<!-- 								<table class="table"> -->
<!-- 									<thead> -->
<!-- 										<tr> -->
<!-- 											<th>Asset No</th> -->
<!-- 											<th>Model</th> -->
<!-- 											<th>Dept</th> -->
<!-- 											<th>Projects</th> -->
<!-- 											<th>Custodian</th> -->
<!-- 											<th></th> -->
<!-- 										</tr> -->
<!-- 									</thead> -->
<!-- 									<tbody> -->
<%-- 										<c:forEach items="${assetlist}" var="al"> --%>

<!-- 											<tr> -->


<%-- 												<td>${al.assetNumber}<input type="hidden" --%>
<%-- 													name="assetId" value="${al.assetId}"></td> --%>
<%-- 												<td>${al.assetModel}</td> --%>

<%-- 												<td>${al.assetDeptCode.comValue}</td> --%>

<%-- 												<td>${al.assetProjectCode.comValue}</td> --%>
<%-- 												<td>${al.assetCustodianCode.empName}</td> --%>
<%-- 												<td><a href="historyInfo?assetId=${al.assetId}" --%>
<!-- 													onclick="showtab()">View History</a></td> -->

<%-- 												<%pageContext.setAttribute("i", ++i); %> --%>

<!-- 											</tr> -->
<%-- 										</c:forEach> --%>


<!-- 									</tbody> -->
<!-- 								</table> -->

<div id="Details">

										<div>
											<display:table pagesize="8" defaultsort="1"
												name="assetlist" uid="displayMaster"
												export="false" requestURI="" sort="external" cellpadding="5"
												cellspacing="5">
												<display:column class="hiddenDisplayColumn"
													headerClass="hiddenDisplayColumn" property="workflowAssetCode.assetId"
													title=""></display:column>

												<display:column title="Asset No" property="workflowAssetCode.assetNumber"
													class="tableRow"></display:column>
												<display:column title="Model" property="workflowAssetCode.assetModel"
													class="tableRow"></display:column>
												<display:column title="Dept"
													property="workflowAssetCode.assetDeptCode.comDescription" class="tableRow"></display:column>
												<display:column title="Projects"
													property="workflowAssetCode.assetProjectCode.comDescription" class="tableRow"></display:column>
												<display:column title="Custodian"
													property="workflowAssetCode.assetCustodianCode.empName" class="tableRow"></display:column>
												<display:column title="" class="tableRow">
													<div onmouseover="addRowHandlers('displayMaster', 'rowMouseOver', 'assetlist', 'workflowAssetCode.assetId', 0, 1)"><a href=# onclick="showTab()">View History</a></div>
												</display:column>

											</display:table>
										</div>
									</div>
						
				
							</form:form>

						</div>
						<div id="modify" class="tab-pane fade ${modifyClass} in"
							style="${disp2}">
							
									<form class="form-inline col-sm-12 topblue exp1_align mb20"
										role="form">
<!-- 										<div class="col-md-6" id="purchase"> -->
<!-- 								<div class="borderLine"> -->
										<div class="form-group col-sm-3">
											<label for="email">Asset No</label> <input name="assetNumber"
												class="form-control widform" type="text"
												value="${asset.assetNumber}" readonly="readonly">

										</div>
										<div class="form-group col-sm-3">
											<label for="email">Model</label> <input name="assetModel"
												class="form-control widform" type="text"
												value="${asset.assetModel}" readonly="readonly">
										</div>
										<div class="form-group col-sm-3">
											<label for="email"> Description</label> <input
												name="assetDescription" class="form-control widform" type="text"
												value="${asset.assetDescription}" readonly>
										</div>

										<div class="form-group col-sm-3">

											<label for="email">Capital.date</label> <input
												name="assetCapitalizationDate" class="form-control widform"
												value="${asset.assetCapitalizationDate}" readonly>
										</div>

										<br>

									</form>
									<br>
<!-- 									<table class="table"> -->
<!-- 										<thead> -->
<!-- 											<tr> -->

<!-- 												<th scope="col">Service Provider</th> -->
<!-- 												<th scope="col">Department</th> -->
<!-- 												<th scope="col">Project</th> -->
<!-- 												<th scope="col">Custodian</th> -->
<!-- 												<th scope="col">No Of Service/Year</th> -->
<!-- 												<th scope="col">Serviced Date</th> -->
<!-- 												<th scope="col">Next Service</th> -->

<!-- 											</tr> -->
<!-- 										</thead> -->

<%-- 										<c:forEach items="${history}" var="history"> --%>

<!-- 											<tr> -->


<%-- 												<td>${history.siServiceProviderCode.comValue}</td> --%>
<%-- 												<td>${history.siAssetCode.assetDeptCode.comValue}</td> --%>

<%-- 												<td>${history.siAssetCode.assetProjectCode.comValue}</td> --%>

<%-- 												<td>${history.siAssetCode.assetCustodianCode.empName}</td> --%>
<%-- 												<td>${history.siNoServicesYear}</td> --%>
<%-- 												<td>${history.siLastServiceDate}</td> --%>
<%-- 												<td>${history.siNextServiceDate}</td> --%>

<%-- 												<%pageContext.setAttribute("i", ++i); %> --%>

<!-- 											</tr> -->
<%-- 										</c:forEach> --%>


<!-- 									</tbody> -->


<!-- 									</table> -->
<div>
											<display:table class="col-md-12" pagesize="5" defaultsort="1"
												name="history" uid="displayMaster"
												export="false" requestURI="" sort="external" cellpadding="5"
												cellspacing="5">

												<display:column title="Service Provider" property="siServiceProviderCode.comValue"
													class="tableRow"></display:column>
												<display:column title="Department" property="siAssetCode.assetDeptCode.comValue"
													class="tableRow"></display:column>
												 <display:column title="Projects"
													property="siAssetCode.assetProjectCode.comValue" class="tableRow"></display:column>
												<display:column title="Custodian"
													property="siAssetCode.assetCustodianCode.empName" class="tableRow"></display:column>
												<display:column title="No Of Service/Year"
													property="siNoServicesYear" class="tableRow"></display:column>
												<display:column title="Serviced Date"
													property="siLastServiceDate" class="tableRow"></display:column>
												<display:column title="Next Service"
													property="siNextServiceDate" class="tableRow"></display:column>
												
													
												</display:table>
										</div>

								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		
	


	<!-- DAte picker -->
	<script type="text/javascript">
	function search() {

		document.forms[0].action = "searchHistoryAsset";
		document.forms[0].submit();

	}

		function showtab() {
		
			$('#tabs a[href="#modify"]').tab('show');
		}
	</script>

</body>

</html>








