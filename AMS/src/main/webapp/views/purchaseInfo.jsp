<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>
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
<script type="text/javascript"
	src="../resources/js/jsDatePick.min.1.3.js"></script>
<script type="text/javascript"
	src="../resources/js/applicationScript/purchaseinfo.js"></script>-->
<script type="text/javascript"> 

document.getElementById('PurchaseInfo').className = 'active';

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
					document.forms[0].action = "purchaseInfo";
					document.forms[0].submit();
				};

			}
		}
	}

	function showModifyTab(selectedAsset) {

		// 			document.getElementById("roleName").value = roleName;
		$.ajax({
			type : "GET",
			url : "setPurchaseAssetIdToSession",
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

	<%
		int i = 0;
		pageContext.setAttribute("i", i);
	%>
	<div class="h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">
				<c:set var="Emp" value="class=active" />
				<c:set var="mngEmp" value="class=act" />
				<c:set var="modifyClass" value="" />
				<c:set var="listClass" value="active" />
				<c:if test="${section == 'Purchase Info'}">
					<script type="text/javascript">
						
					</script>
					<c:set var="Emp" value="class=act" />
					<c:set var="mngEmp" value="class=active" />
					<c:set var="modifyClass" value="active" />
					<c:set var="listClass" value="" />

				</c:if>

				<div class="exp_container">
					<h4><img src="../resources/images/Purchase InfoH.png" style="width:25px; height:auto; margin-right:5px"/>Purchase Info</h4>
					<ul class="nav nav-tabs" id="tabs">
						<li ${Emp}><a id="listTab" data-toggle="tab" href="#list">Purchase List<a
								class="subA" href="PurchaseInfo">Purchase List</a></a></li>
						<li ${mngEmp}><a id="modifyTab" data-toggle="tab" href="/">Purchase
								Info</a></li>
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


								<div id="Details">

									<div>
										<display:table pagesize="8" defaultsort="1"
											name="assetgroup" uid="displayMaster"
											export="false" requestURI="" sort="external" cellpadding="5"
											cellspacing="5">
											<display:column class="hiddenDisplayColumn"
												headerClass="hiddenDisplayColumn" property="assetId"
												title=""></display:column>

											<display:column title="Asset No" property="assetNumber"
												class="tableRow"></display:column>
											<display:column title="Model" property="assetModel"
												class="tableRow"></display:column>
											<display:column title="Make"
												property="assetMake.comValue" class="tableRow"></display:column>
											
											<display:column title="Custodian"
												property="assetCustodianCode.empName" class="tableRow"></display:column>
												<display:column title="Group"
												property="assetGroupCode.groupName" class="tableRow"></display:column>
											<display:column title="" class="tableRow">
												<div
													onmouseover="addRowHandlers('displayMaster', 'rowMouseOver', 'assetgroup', 'assetId', 0, 1)">
													<a href=# onclick="showTab()">Purchase Info</a>
												</div>
											</display:column>

										</display:table>
									</div>
								</div>
							</form:form>

						</div>
						<div id="modify" class="tab-pane fade ${modifyClass} in"
							style="${disp2}">
							<form name="command" class="form-horizontal" role="form"
								method="post" action="addPurchaseInfo">
								<div class="col-md-6" id="purchase">
									<div class="borderLine">
										<fieldset>
											<legend class="assetHead"> Purchase Information </legend>
											<div class="form-group">

												<label class="control-label col-sm-5" for="email"><spring:message
														code="co.label.assetNo" /></label>
												<div class="col-sm-6">
													<input type="text" name="assetNumber"
														class="form-control common" id="aNo"
														placeholder="Enter AssetNumber"
														value="${assetPurchaseNo}" readonly="readonly"></input>
													<div id="ano" style="color: red"></div>
													<input type="hidden" name="assetId" id="assetId"
														value="${aid}"></input>

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="co.label.vendor" /></label>
												<div class="col-sm-6">

													<select class="form-control common" name="piVender.comId"

														id="vendor">
														<c:forEach var="vndr" items="${vendor}">

															<option value="${vndr.comId}">${vndr.comValue}</option>

														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Invoce
													Number</label>
												<div class="col-sm-6">
													<input type="text" name="piInviceNo"
														class="form-control common" id="pNo"
														placeholder="Enter Invoice Number"
														value="${info.piInviceNo}"></input>
													<div id="in" style="color: red"></div>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Invoice
													Date</label>
												<div class="col-sm-6">

													<input type="text" class="form-control name=" invoiceDate
														common" id="idate" placeholder="Select Invoice Date"
														value="${info.invoiceDate}"></input>
													<div id="ind" style="color: red"></div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">P.O.Number</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="pnum"
														name="piPoNumber" placeholder="Enter Purchase Cost"
														value="${info.piPoNumber}"></input>
													<div id="inp" style="color: red"></div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">P.O.Date</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="lsdate"
														name="pipoDate" placeholder="Select PO Date"
														value="${info.pipoDate}"></input>
													<div id="pipodate" style="color: red"></div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Delivery
													Date</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="dsdate"
														name="deliveryDate" placeholder="Select Delivery Date"
														value="${info.piDeliveryDate}"></input>
													<div id="pideldate" style="color: red"></div>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Capitilization
													Date</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="nsdate"
														name="piCaptialDate"
														placeholder="Select Capitilization Date"
														value="${info.piCaptialDate}"></input>
													<div id="picap" style="color: red"></div>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Purchase
													Cost</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="pcost"
														name="piPurchasecost" placeholder="Enter Purchase Cost"
														value="${info.piPurchasecost}"></input>
													<div id="inpc" style="color: red"></div>


												</div>
											</div>
										</fieldset>
									</div>
								</div>

								<div class="col-md-6" id="purchase">
									<div class="borderLine">
										<fieldset>

											<legend class="assetHead"> Depreciation Information
											</legend>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Depreciation
													Method</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common"
														id="warranty" name="deprType"
														placeholder="Enter Warranty Period"
														value="${depriciation.deprecateType}" readonly="readonly"></input>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Value</label>
												<div class="col-sm-6">
													<input type="text" name="deprValue"
														class="form-control common" id="value"
														placeholder="Enter Value"
														value="${depriciation.depriciateValue}"
														readonly="readonly"></input>
												</div>
											</div>
											<div class="form-group dpbutton" align="center">
												<button type="button" class="btn btn-info"
													data-toggle="modal" data-target="#depreciation"
													style="float: right; margin-right: 20px;">Depreciation
													Details</button>
											</div>
										</fieldset>
									</div>
								</div>
								<div class="col-md-12 mb20" align="right">

									<div class="butt">
										<button type="submit" class="btn btn-info"
											onclick="return Validateform()">Submit</button>
										<button type="reset" class="btn btn-info">Cancel</button>
									</div>
								</div>

							</form>
							<div class="modal fade" id="depreciation" role="dialog">
								<div class="modal-dialog" style="width: 60%;">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Depreciation Details</h4>
										</div>
										<div class="modal-body">

											<table class="table" style="margin-top: 20px;">
												<thead>
													<tr>
														<th scope="col">Date</th>
														<th scope="col">Aged</th>
														<th scope="col">depreciation tilldate</th>
														<th scope="col">Depreciation Amount</th>
														<th scope="col">Accumulated Depreciation</th>

													</tr>

												</thead>
												<tbody>
													<c:forEach items="${deprlist}" var="depr">
														<%-- 								<c:forEach items="${asset1.asset}" var="assets" >  --%>
														<tr>


															<td>${depr.depreciationTo}</td>
															<td>${depr.depreciationDaysAged}</td>
															<td>${depr.depreciationBookValue}</td>
															<td>${depr.depreciationAmount}</td>
															<td>${depr.depreciationAccumulatedAmount}</td>

															<%
																pageContext.setAttribute("i", ++i);
															%>

														</tr>
													</c:forEach>
												</tbody>

											</table>




										</div>
									</div>
								</div>
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

						document.forms[0].action = "searchAsset";
						document.forms[0].submit();

					}
	
		window.onload = function() {
			

			new JsDatePick({
				useMode : 2,
				target : "idate",
				dateFormat : "%Y-%M-%d"
			});

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

			new JsDatePick({
				useMode : 2,
				target : "dsdate",
				dateFormat : "%Y-%M-%d"
			});

		};

		function showtab() {

			$('#tabs a[href="#modify"]').tab('show');
	
		}
	</script>

</body>

</html>








