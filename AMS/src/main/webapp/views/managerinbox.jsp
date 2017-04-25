<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<!--
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
 <script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/css/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<title>Manager Inbox</title>
</head>
<body>

	<div class="h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">

				<div class="exp_container">
					<h4><img src="../resources/images/Manager InboxH.png" style="width:25px; height:auto; margin-right:5px"/>Manager Inbox</h4>
					<div class="exp_box col-md-12">

						<div id="home" class="tab-pane fade in active">
							<!-- <h5>Inbox</h5> -->
							<form class="form-inline" role="form" action="searchManagerInbox"
								method="post">
								<div class="searchpanel">
									<div class="exp_search">

										<div class="form-group">
											Asset No <input type="text" class="form-control search"
												id="search assetNo" placeholder="Search" name="assetNo"
												value="">&nbsp;
										</div>
										<div class="form-group">
											Status <select class="form-control search"
												id="search assetStatus" name="assetStatus">
												<option>Pending Approval</option>
												<option>Write-off Request</option>
												<option>Re-Value Request</option>
											</select>&nbsp;
											<button type="submit" id="searchBtn"
												class="btn btn-info pBtn">Search</button>
										</div>
									</div>
								</div>
								<div class="mngrinbx">
									<div class="panel panel-default">

										<table class="table">
											<thead>
												<tr>
													<th><spring:message code="co.label.asset" /></th>
													<th><spring:message code="co.label.model" /></th>
													<th><spring:message code="co.label.make" /></th>
													<th><spring:message code="co.label.purchaseDate" /></th>
													<th><spring:message code="co.label.cost" /></th>
													<th><spring:message code="co.label.custodian" /></th>
													<th><spring:message code="co.label.approvalType" /></th>

												</tr>
											</thead>
											<tbody>
												<c:forEach items="${assetDetails}" var="assetDetails">
													<tr>
														<td>${assetDetails.workflowAssetCode.assetNumber}<input
															type="hidden" name="assetId" id="assetId"
															value="${assetDetails.workflowAssetCode.assetId}"></td>
														<td>${assetDetails.workflowAssetCode.assetModel}</td>
														<td>${assetDetails.workflowAssetCode.assetMake.comValue}</td>
														<td>${assetDetails.workflowAssetCode.assetPurchaseReqDate}</td>
														<td>${assetDetails.workflowAssetCode.purchaseinfo.piPurchasecost}</td>
														<td>${assetDetails.workflowAssetCode.assetCustodianCode.empName}</td>
														<td><a style="cursor:pointer;"class="assetType ${assetDetails.workflowAssetCode.assetId}" id="${assetDetails.workflowAssetType}">${assetDetails.workflowAssetType}</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</form>
						</div>



					</div>
				</div>
			</div>

		</div>
	</div>




	<script type="text/javascript">
	
	$(document).ready(function() {
	    $(".assetType").click(function(event) {
	    	var assetId = event.target.classList[1];
	        if(event.target.id == "Asset Approve"){
	        	window.location.href = "../login/asssetApprove?assetId="+assetId;	
	        }
	        else{
	        	window.location.href = "../login/writeRevalue?assetId="+assetId+"&myParam="+ event.target.id;
	        }
	    });
	});
		
		function showtab() {
			alert();
			$('AMS_AddAsset.html#tabs a[href="#manage"]').tab('show');
		}
		function checktick() {

			var x = document.getElementById("check").checked;
			if (x == true) {
				var date = new Date();
				var curdate = date.getFullYear() + "-" + date.getMonth() + "-"
						+ date.getDate();
				document.getElementById("vt").value = curdate;
			} else {
				document.getElementById("vt").value = "";
			}

		}
		/* function showDetails(anchor) {
			var flag = $(anchor).text();
			alert("hai");
			if (flag == "Asset Approve")
				window.location.href = "AMS_AddAssetNew.html?myParam=2";
			else
				window.location.href = "AMS_AssetTransferDetails.html?myParam="
						+ flag; 
		} */

		document.getElementById('ManagerInbox').className = 'active';
	</script>

	<!-- to retain field values -->
	<script>
		/* 	$("#searchBtn")
					.click(
							function() {
								document.getElementById("search assetNo").value = localStorage
										.getItem("number");
								document.getElementById("search assetStatus").value = localStorage
										.getItem("status");
							}); */
		$(document)
				.ready(
						function() {
							document.getElementById("search assetNo").value = localStorage
									.getItem("number");
							document.getElementById("search assetStatus").value = localStorage
									.getItem("status");
						});
	</script>
	<script>
		$(window).on(
				'beforeunload',
				function() {
					localStorage.setItem("number", document
							.getElementById("search assetNo").value);
					localStorage.setItem("status", document
							.getElementById("search assetStatus").value);
				});
	</script>
</body>
</html>











