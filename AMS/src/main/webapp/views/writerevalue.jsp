<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/css/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="all"
	href="../resources/css/jsDatePick_ltr.min.css">
<script type="text/javascript"
	src="../resources/js/jsDatePick.min.1.3.js"></script> -->
	
<!-- DAte picker -->
<script type="text/javascript">
	window.onload = function() {

		new JsDatePick({
			useMode : 2,
			target : "cDate",
			dateFormat : "%Y-%M-%d"
		});

		new JsDatePick({
			useMode : 2,
			target : "tDate",
			dateFormat : "%Y-%M-%d"
		});

	};
</script>
</head>
<body>

	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_serviceInfo">

				<div class="exp_container">
					<h4><img src="../resources/images/Asset TransferH.png" style="width:25px; height:auto; margin-right:5px"/>Asset Transfer</h4>
					<div class="col-md-12 exp_box pmZero">
						<div id="menu1" class="tab-pane fade in active">
							<form class="form-horizontal" role="form" method="post">
								<div class="row1 col-sm-12 topblue">
									<div class="col-sm-6">
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.assetNo" /></label> <input
												class="form-control common col-sm-6" type="text"
												value="${WrAsset[0].assetNumber}" name="assetNumber" /> <input
												value="${WrAsset[0].assetId}" name="assetId" type="hidden" />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.assetModel" /></label> <input
												class="form-control common col-sm-6" type="text"
												value="${WrAsset[0].assetModel}" name="assetModel" />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.assetDescription" /></label>
											<textarea class="form-control textarea col-sm-6"
												name="assetDescription">${WrAsset[0].assetDescription}</textarea>
										</div>

									</div>


									<div class="col-sm-6 writerevalueform">

										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.capitalDate" /></label>		
													<input id="cDate"
												class="form-control common col-sm-6" type="date" name="date"
												value="${capitalDate}" />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.transferDate" /></label> <input
												class="form-control common col-sm-6" value="${transferDate}"
												readonly="readonly" />
										</div>
										<div class="form-group">
											<label class="control-label asstlabel col-sm-3"><spring:message
													code="co.label.transferType" /></label> <input id="transType"
												class="form-control common col-sm-6" readonly="readonly" />

										</div>
									</div>
								</div>
								<!-- row1 div closed here-->

								<div class="row2 col-md-12 ">

									<div id="transAsset" class="transborder"></div>
									<!-- transAsset closed herer -->

									<div id="writeOff" class="col-md-12 transborder">
										<h4 class="assetTransferHead1" align="center">Write Off
											Asset</h4>
										<div class="col-sm-6 transAsset1">
											<div class="form-group">
												<label class="control-label asstlabel col-sm-4"><spring:message
														code="co.label.WrittenDownValue" /></label></label> <input
													class="form-control common col-sm-6" type="text"
													name="assetDispWriteOffAmount"
													value="${WrAsset[0].assetDisposal.assetDispWriteOffAmount}" />
											</div>
										</div>

										<div class="col-sm-6 transAsset2">

											<div class="form-group"></div>
										</div>
									</div>
									<!-- write Off closed here-->
									<div id="re-value" class="col-md-12 transborder">
										<h4 class="assetTransferHead1" align="center">Re-Value of
											Asset</h4>
										<div class="col-sm-6 transAsset1">
											<div class="form-group">
												<label class="control-label asstlabel col-sm-4"><spring:message
														code="co.label.bookValue" /></label> <input
													class="form-control common col-sm-6" type="text"
													value="37500" />
											</div>
											<div class="form-group">
												<label class="control-label asstlabel col-sm-4"><spring:message
														code="co.label.bookValueAfterRevaluation" /></label> <input
													class="form-control common col-sm-6" type="text"
													name="revRevalueAmount"
													value="${WrAsset[0].assetRevalue.revRevalueAmount}" />
											</div>

										</div>

										<div class="col-sm-6 transAsset2">
											<div class="form-group">
												<label class="control-label asstlabel col-sm-4"><spring:message
														code="co.label.purchaseCost" /></label> <input
													class="form-control common col-sm-6" type="text"
													value="40000" />
											</div>


										</div>
									</div>


								</div>

								<div align="right">
									<button id="reject" data-toggle="modal" data-target="#myModal"
										type="button" class="btn btn-info submitButton">
										<spring:message code="co.button.reject" />
									</button>
									<button type="submit" class="btn btn-info submitButton"
										onclick="approveAsset()">
										<spring:message code="co.button.approve" />
									</button>
								</div>
								<input id="rejectReason" name="workflowManagerRejectReason"
									value="" type="hidden" />
								<!-- row2 div closed here-->
							</form>


						</div>

					</div>


					<!-- Modal -->
					<form role="form" class="form-inline" method="post">
						<div class="modal fade" id="myModal" role="dialog">
							<!--     <div class="modal-dialog modal-sm"> -->
							<div class="popup" style="width: 450px;">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 id="rejecthead" class="modal-title"></h4>
									</div>
									<div class="modal-body" style="text-align: center">
										<input value="${WrAsset[0].assetId}" name="assetId"
											type="hidden" />
										<div class="form-group">
											<label><spring:message code="co.label.rejectReason" /></label>
											<textarea id="rejectReasonDummy"
												class="form-control textarea" style="width: 50%"
												name="reason"></textarea>
										</div>


										<div class="modal-footer">
											<button type="submit" id="ok" onclick="rejectAsset()"
												class="btn btn-info btnfooter" data-dismiss="modal">
												<spring:message code="co.button.submit" />
											</button>
											<button id="cancel" type="button"
												class="btn btn-info btnfooter" data-dismiss="modal">
												<spring:message code="co.button.cancel" />
											</button>

										</div>


									</div>
								</div>
							</div>
						</div>
					</form>
				</div>

			</div>

		</div>
		<!-- exp_Container -->
	</div>




	<script type="text/javascript">
		var myParam;
		$(document).ready(
				function() {
					$("#transAsset").hide();
					// 					$("#writeOff").hide();
					// 					$("#re-value").hide();
					myParam=location.search.split(
												'myParam=')[1];
					myParam = decodeURIComponent(myParam);
					// 					myParam = myParam.replace("%20"," ");
					// 					myParam = myParam.replace("%20"," ");
					$("#transType").val(myParam);
					if (myParam === "Write Off Asset") {
						$("#writeOff").show();
						$("#re-value").hide();
					} else {
						$("#re-value").show();
						$("#writeOff").hide();
					}
					$('#reject').click(
							function() {
								$('#rejecthead').text("Reject Reason of " + $("#transType").val());
							});

				});
		function
												showtab() {
			$('#myTab a[href="#menu1"]').tab('show');
		}

		function
												approveAsset() {
			document.forms[0].action="approveAsset"
												;
			document.forms[0].submit();
		}
		function
												rejectAsset() {
			var reason=$(
												'#rejectReasonDummy').val();
			$('#rejectReason').val(reason);
			document.forms[0].action="rejectAsset"
												;
			document.forms[0].submit();
		}
		document.getElementById('AssetTransfer').className='active';
	
												</script>

</body>
</html>












