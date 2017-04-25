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
<!-- <link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/css/bootstrap.min.js"></script>
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="../resources/css/jsDatePick_ltr.min.css">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link type="text/css" href="../resources/css/jquery-picklist.css"
	rel="stylesheet" />

<script src="../resources/js/jquery.min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jquery-ui-1.8.16.custom.min.js"></script>

<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript"
	src="../resources/js/jsDatePick.min.1.3.js"></script>
<script type="text/javascript" src="../resources/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="../resources/js/jquery-picklist.js"></script> -->

<script type="text/javascript">

	document.getElementById('TransferHistory').className = 'active';
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
					document.forms[0].action = "listAssetTransferHistory";
					document.forms[0].submit();
				};

			}
		}
	}

	function showModifyTab(selectedAsset) {

		// 			document.getElementById("roleName").value = roleName;
		$.ajax({
			type : "GET",
			url : "setAssetIdToSession",
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
<title>Transfer History</title>
</head>
<body>

	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_serviceInfo">

				<c:set var="list" value="class=active" />
				<c:set var="tranHist" value="class=act" />
				<c:set var="modifyClass" value="" />
				<c:set var="listClass" value="active" />

				<c:if test="${section == 'Transfer History'}">
					<c:set var="list" value="class=act" />
					<c:set var="tranHist" value="class=active" />
					<c:set var="modifyClass" value="active" />
					<c:set var="listClass" value="" />
				</c:if>

				<div class="exp_container">
					<h4><img src="../resources/images/Transfer HistoryH.png" style="width:25px; height:auto; margin-right:5px"/>Transfer History</h4>
					<ul class="nav nav-tabs" id="myTab">
						<li ${list}><a data-toggle="tab" href="#list">List Assets<a
								class="subA" href="transferHistory">List Assets</a></a></li>
						<li ${tranHist}><a data-toggle="tab" href="/">Transfer
								History </a></li>

					</ul>

					<div class="tab-content servicetab">
						<div id="list" class="tab-pane fade in ${listClass} ">
							<div class="">
								<form:form commandName="roleForm" class="form-inline"
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


									<div id="Details">

										<div>
											<display:table pagesize="8" defaultsort="1"
												name="availableAssetDetails" uid="displayMaster"
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
													property="workflowAssetCode.assetDeptCode.comValue" class="tableRow"></display:column>
												<display:column title="Projects"
													property="workflowAssetCode.assetProjectCode.comValue" class="tableRow"></display:column>
												<display:column title="Custodian"
													property="workflowAssetCode.assetCustodianCode.empName" class="tableRow"></display:column>
												<display:column title="" class="tableRow">
													<div onmouseover="addRowHandlers('displayMaster', 'rowMouseOver', 'availableAssetDetails', 'workflowAssetCode.assetId', 0, 1)"><a href=#>View History</a></div>
												</display:column>

											</display:table>
										</div>
									</div>
								</form:form>
							</div>
						</div>

						<div id="modify" class="tab-pane fade in ${modifyClass}">
							<div class="">
								<form class="form-inline col-sm-12 topblue exp_align mb20"
									role="form" style="margin-bottom: 10px">
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="co.asset.label.assetno" /></label><input
											class="form-control widform"
											value="${tranHistAssets[0].transferAssetCode.assetNumber}"
											name="assetNumber" readonly="readonly" />

									</div>
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="co.asset.label.model" /></label> <input
											class="form-control widform"
											value="${tranHistAssets[0].transferAssetCode.assetModel}"
											name="assetModel" readonly="readonly">
									</div>
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="co.label.assetDescription" /></label> <input
											name="assetDescription" class="form-control widform"
											type="text"
											value="${tranHistAssets[0].transferAssetCode.assetDescription}"
											readonly>
									</div>

									<div class="form-group col-sm-3">

										<label for="email"><spring:message
												code="co.label.capitalDate" /></label> <input
											name="assetCapitalizationDate" class="form-control widform"
											value="${capitalDate}" readonly>
									</div>

									<br>

								</form>
								<br>

								<display:table pagesize="10" defaultsort="1"
									name="tranHistAssets" uid="displayMaster" export="false"
									requestURI="" sort="external" cellpadding="5" cellspacing="5">
									<display:column title="Department"
										property="transferDeptCode.comValue" class="tableRow"></display:column>
									<display:column title="Project"
										property="transferProjectCode.comValue" class="tableRow"></display:column>
									<display:column title="Custodian"
										property="transferCustodianCode.empName" class="tableRow"></display:column>
									<display:column title="Transferred On"
										property="transferTransferredOn" class="tableRow"></display:column>
									<display:column title="Transferred Upto"
										property="transferTransferredUpto" class="tableRow"></display:column>
								</display:table>

							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		function search() {

			document.forms[0].action = "searchAssetInTransfer";
			document.forms[0].submit();

		}
		window.onload = function() {

			new JsDatePick({
				useMode : 2,
				target : "purdate",
				dateFormat : "%Y-%M-%d"
			});

			new JsDatePick({
				useMode : 2,
				target : "purtilldate",
				dateFormat : "%Y-%M-%d"
			});
			new JsDatePick({
				useMode : 2,
				target : "depdate",
				dateFormat : "%Y-%M-%d"
			});

		};
		function showtab() {
			$('#myTab a[href="#modify"]').tab('show');
		}
	</script>
</body>
</html>












