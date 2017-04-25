<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<script type="text/javascript" src="../resources/js/jquery-picklist.js"></script>
<script type="text/javascript"
	src="../resources/js/jsDatePick.min.1.3.js"></script> -->
<%
	Date todayDate = new Date();
	String projectId = request.getAttribute("inProjectId").toString();
%>
</head>
<body>
	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_serviceInfo mbottom50">

				<div class="exp_container">
					<h4><img src="../resources/images/AssetH.png" style="width:25px; height:auto; margin-right:5px"/>Assets</h4>
					<ul class="nav nav-tabs" id="tabs">

						<li class="active"><a data-toggle="tab" href="#manage">Manage
								Asset</a></li>

					</ul>
					
					<div class="tab-content servicetab col-md-12 pmZero">
					<!-- Display status of updation -->
					<span style="float: right">${MsgStatus}</span>
						<div id="manage" class="tab-pane fade in active tabStyle">
							<form class="form-horizontal exp_form" role="form" method="post"
								action="updateApproveAsset">
								<div class="col-md-6">
									<div class="borderLine">
										<!-- Asset Information Started -->
										<fieldset>


											<legend class="assetHead" align="left">
												<spring:message code="ams.label.assetInfo" />
											</legend>
											<%-- <div id="error">${error}</div> --%>
											<div class="form-group">
												<label class="control-label col-sm-5" for="make"><spring:message
														code="ams.label.assetmake" /> </label>
												<div class="col-sm-6">

													<select class="form-control common" name="assetMake.comId"
														id="make" name="assetMake">

														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>
														<c:forEach var="allMakes" items="${allMakeList}">

															<c:choose>
																<c:when
																	test="${assetList[0].assetMake.comId==allMakes.comId}">
																	<option selected="selected"
																		value="${assetList[0].assetMake.comId}">
																		<c:out value="${assetList[0].assetMake.comValue}" />
																	</option>
																</c:when>

																<c:otherwise>



																	<option value="${allMakes.comId}">
																		<c:out value="${allMakes.comValue}" /></option>

																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.assetno" /></label>
												<div class="col-sm-6">
													<input name="assetNumber" class="form-control common"
														type="text" id="assetnum"
														value="${assetList[0].assetNumber}" readonly="readonly"
														placeholder="Enter AssetNumber" />

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.associated" /></label>
												<div class="col-sm-6">
													<select class="form-control common"
														name="associatedAssetId" id="associated">


														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>

														<c:forEach var="allAssets"
															items="${availableAssetDetails}">

															<c:choose>
																<c:when
																	test="${assetList[0].associatedAssetId==allAssets.assetId}">
																	<option selected="selected"
																		value="${assetList[0].assetId}">
																		<c:out value="${allAssets.assetNumber}" />
																	</option>
																</c:when>

																<c:otherwise>
																	<option value="${allAssets.assetId}">
																		<c:out value="${allAssets.assetNumber}" />
																	</option>
																</c:otherwise>
															</c:choose>

														</c:forEach>

													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.assetgroup" /></label>
												<div class="col-sm-6">

													<select class="form-control common"
														name="assetGroupCode.groupId" name="assetGroupCode"
														id="group">
														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>

														<c:forEach var="allGroups" items="${allGroupDetails}">

															<c:choose>

																<c:when
																	test="${assetList[0].assetGroupCode.groupId==allGroups.groupId}">
																	<option selected="selected"
																		value="${assetList[0].assetGroupCode.groupId}">
																		<c:out
																			value="${assetList[0].assetGroupCode.groupName}" />
																	<option>
																</c:when>

																<c:otherwise>
																	<option value="${allGroups.groupId}">
																		<c:out value="${allGroups.groupName}" />
																	</option>
																</c:otherwise>
															</c:choose>

														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="pwd"><spring:message
														code="ams.label.description" /></label>
												<div class="col-sm-6">
													<textarea name="assetDescription" id="desc"
														placeholder="Enter Description">${assetList[0].assetDescription}</textarea>

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.model" /></label>
												<div class="col-sm-6">

													<input name="assetModel" class="form-control common"
														type="text" id="model" placeholder="Enter model"
														value="${assetList[0].assetModel}" />
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.modelnum" /></label>
												<div class="col-sm-6">
													<input name="assetModelNumber" class="form-control common"
														type="text" id="modelnum" placeholder="Enter Model Number"
														value="${assetList[0].assetModelNumber}" />
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.serialno" /></label>
												<div class="col-sm-6">

													<input name="assetSerialNumber" class="form-control common"
														type="text" id="serialnum"
														placeholder="Enter Serial Number"
														value="${assetList[0].assetSerialNumber}" />

												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="pwd"><spring:message
														code="ams.label.notes" /></label>
												<div class="col-sm-6">

													<textarea name="assetNotes" id="note"
														placeholder="Enter Notes">${assetList[0].assetNotes}</textarea>

												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.warranty" /></label>
												<div class="col-sm-6">


													<input name="assetWarrantyPeriod"
														class="form-control common" type="text" id="wperiod"
														placeholder="Enter Warranty Period"
														value="${assetList[0].assetWarrantyPeriod}" />



												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="wdate"><spring:message
														code="ams.label.warrantyend" /></label>
												<div class="col-sm-6">

													<c:if test="${not empty assetList}">
														<c:set var="warrantyEndDate" value="${assetList[0].assetWarrantyEndDate}" />
													</c:if>
													<c:if test="${empty assetList}">
														<c:set var="warrantyEndDate" value="${todayDate}" />
													</c:if>


													<input id="wdate" name="datewar"
														class="form-control common" type="date"
														value="${warrantyEndDate}" />

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.assettype" /></label>
												<div class="col-sm-6">
													<select class="form-control common" name="assetType.comId"
														id="assetType">

														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>

														<c:forEach var="allTypes" items="${allAssetTypeList}">


															<c:choose>
																<c:when
																	test="${assetList[0].assetType.comId==allTypes.comId}">
																	<option selected="selected"
																		value="${assetList[0].assetType.comId}">
																		<c:out value="${assetList[0].assetType.comValue}" />
																	</option>
																</c:when>

																<c:otherwise>
																	<option value="${allTypes.comId}">
																		<c:out value="${allTypes.comValue}" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>

													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.condition" /></label>
												<div class="col-sm-6">
													<select class="form-control common"
														name="assetCondition.comId" id="condition">
														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>

														<c:forEach var="allConditions" items="${allConditionList}">
															<c:choose>
																<c:when
																	test="${assetList[0].assetCondition.comId==allConditions.comId}">
																	<option selected="selected"
																		value="${assetList[0].assetCondition.comId}">
																		<c:out value="${assetList[0].assetCondition.comValue}" />
																	</option>
																</c:when>

																<c:otherwise>
																	<option value="${allConditions.comId}">
																		<c:out value="${allConditions.comValue}" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.image" /></label>
												<div class="col-sm-6">
													<input type="file" name="fileName"></input>${assetList[0].fileName }
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.currently" /></label>
												<div class="col-sm-6">
													<select class="form-control common"
														name="assetCurrentlyAt.comId" id="stock"
														onchange="optionCheck(this.value)">

														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>

														<c:forEach var="allCurrentlyAt"
															items="${allCurrentlyAtList}">
															<c:choose>
																<c:when
																	test="${assetList[0].assetCurrentlyAt.comId==allCurrentlyAt.comId}">
																	<option selected="selected"
																		value="${assetList[0].assetCurrentlyAt.comId}">
																		<c:out
																			value="${assetList[0].assetCurrentlyAt.comValue}" />
																	</option>
																</c:when>

																<c:otherwise>
																	<option value="${allCurrentlyAt.comId}">
																		<c:out value="${allCurrentlyAt.comValue}" />
																	</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>
										</fieldset>
										<!-- Asset Information End -->
									</div>
								</div>

								<div class="col-md-6" id="purchase">

									<!-- Purchase Information Start-->
									<div class="borderLine">
										<fieldset>
											<legend class="assetHead"> Purchase Information </legend>
											<div class="form-group">

												<label class="control-label col-sm-5" for="email"><spring:message
														code="co.label.assetNo" /></label>
												<div class="col-sm-6">
													<input type="text" name="assetNumber" id="assetNumber"
														class="form-control common" id="assetNumber"
														placeholder="Enter AssetNumber" readonly="readonly"
														value="${info.asset.assetNumber}"></input> <input
														type="hidden" name="assetId" id="assetId" value="${aid}"></input>

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="co.label.vendor" /></label>
												<div class="col-sm-6">




													<select class="form-control common" name="piVender.comId"
														name="piVender" id="vendor">

														<option value=""><spring:message
																code="ams.select.selectvalue" /></option>
														<c:forEach var="vndr" items="${vendor}">

															<c:choose>
																<c:when
																	test="${assetList[0].purchaseinfo.piVender.comId==vndr.comId}">
																	<option selected="selected"
																		value="${assetList[0].purchaseinfo.piVender.comId}">
																		<c:out
																			value="${assetList[0].purchaseinfo.piVender.comValue}" />
																	</option>
																</c:when>

																<c:otherwise>



																	<option value="${vndr.comId}">
																		<c:out value="${vndr.comValue}" /></option>

																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Invoce
													Number</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="invNum"
														name="piInviceNo" placeholder="Enter Invoice Number"
														value="${info.piInviceNo}"></input>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Invoice
													Date</label>
												<div class="col-sm-6 purchaseDate">
													<input type="text" class="form-control common"
														name="invoiceDate" id="idate"
														placeholder="Select Invoice Date"
														value="${info.invoiceDate}"></input>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">P.O.Number</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="pnum"
														name="piPoNumber" placeholder="Enter Purchase Cost"
														value="${info.piPoNumber}"></input>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">P.O.Date</label>
												<div class="col-sm-6 purchaseDate">
													<input type="text" class="form-control common"
														name="pipoDate" id="lsdate"
														placeholder="Select Capitilization Date"
														value="${info.pipoDate}"></input>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Delivery
													Date</label>
												<div class="col-sm-6 purchaseDate">
													<input type="text" class="form-control common" id="dsdate"
														name="deliveryDate" placeholder="Select Delivery Date"
														value="${info.piDeliveryDate}"></input>
												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Capitilization
													Date</label>
												<div class="col-sm-6 purchaseDate">
													<input type="text" class="form-control common" id="nsdate"
														name="piCaptialDate"
														placeholder="Select Capitilization Date"
														value="${info.piCaptialDate}"></input>
												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email">Purchase
													Cost</label>
												<div class="col-sm-6">
													<input type="text" class="form-control common" id="pcost"
														name="piPurchasecost" placeholder="Enter Purchase Cost"
														value="${info.piPurchasecost}"></input>
												</div>
											</div>
										</fieldset>
									</div>
									<!-- Purchase Information End -->

									<!-- Purchase Request Order Start -->
									<div class="borderLine">
										<fieldset>
											<legend class="assetHead">
												<spring:message code="ams.label.purchaseorder" />
											</legend>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.purchasename" /> </label>
												<div class="col-sm-6">
													<input type="text" class="form-control common"
														name="assetPurchaseReqName" id="pname"
														placeholder="Enter Name"
														value="${assetList[0].assetPurchaseReqName}"></input>
													<%-- <form:input path="assetPurchaseReqName"
														class="form-control common" type="text" id="pname"
														value="${assetList}"
														placeholder="Enter name" /> --%>

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.purchaseno" /></label>
												<div class="col-sm-6">

													<input type="text" class="form-control common"
														name="assetPurchaseReqNumber" id="value"
														placeholder="Enter Value"
														value="${assetList[0].assetPurchaseReqNumber}"></input>
													<%-- <form:input path="assetPurchaseReqNumber"
														class="form-control common" type="text" id="value"
														value="${assetList}"
														placeholder="Enter Value" />
 --%>

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="indate"> <spring:message
														code="ams.label.purchaseDate" /></label>
												<div class="col-sm-6">

													 <c:if test="${not empty assetList[0]}">
														<c:set var="purchaseReqDate" value="${assetList[0].assetPurchaseReqDate}" />
													</c:if>
													<c:if test="${empty assetList[0]}">
														<c:set var="purchaseReqDate" value="${todayDate}" />
													</c:if> 
													<input type="text" class="form-control common"
														name="datepur" id="indate" placeholder="Enter Value"
														value="${purchaseReqDate}"></input>
													<%-- <form:input path="assetPurchaseReqDate"
														class="form-control common" type="text" id="indate"
														value="${purchaseReqDate}" /> --%>
												</div>
											</div>
										</fieldset>
									</div>
									<!-- Purchase Request Order End -->

									<!-- Depreciation Information start -->
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
									<!-- Depreciation Information End -->

								</div>


								<div class="col-md-12 mBottom" align="right">

									<div class="butt">
										<button type="submit" class="btn btn-info">Save</button>

										<button type="reset" class="btn btn-info">Cancel</button>
									</div>
								</div>

							</form>

							<div class="col-sm-12 approve">
								<form class="form-horizontal exp_form" role="form" method="post">
									<fieldset>
										<div class="borderLine"
											style="margin: 0 auto 20px; width: 50%;">
											<div class="assetHead1">Status</div>
											<div class="form-group">
												<label class="control-label col-sm-5">Approve</label>
												<div class="col-sm-6">
													<input type="radio" name="inlineRadioOptions"
														id="approveRadio" value="Approved" onclick="hideReason()"
														checked="checked" />

												</div>
											</div>

											<div class="form-group">
												<label class="control-label col-sm-5">Reject</label>
												<div class="col-sm-6">
													<input type="radio" name="inlineRadioOptions"
														id="rejectRadio" value="Rejected" onclick="getResaon()" />
												</div>
											</div>

											<div class="form-group reason">
												<label class="control-label col-sm-5">Reason</label>
												<div class="col-sm-6">
													<textarea class="form-control textarea"
														placeholder="Enter Reason"
														name="workflowManagerRejectReason"></textarea>
													<input type="hidden" name="workflowAssetStatus"
														id="appReject" /> <input type="hidden" name="assetId"
														value="${ApprovedAsset[0].assetId}">
												</div>
											</div>

											<div class="form-group dpbutton" align="center">
												<button type="submit" name="appRejectBtn"
													class="btn btn-info">Submit</button>
											</div>
										</div>
									</fieldset>
								</form>
							</div>



							<div class="modal fade" id="myModal" role="dialog">
								<div class="modal-dialog" style="width: 70%;">

									<!-- Modal content-->
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">&times;</button>
											<h4 class="modal-title">Component Details</h4>
										</div>
										<div class="modal-body">

											<form class="form-horizontal" role="form">
												<fieldset>

													<div class="col-md-6" style="">


														<div class="form-group">
															<label class="control-label col-sm-5" for="model">Model
															</label>
															<div class="col-sm-6">
																<input type="text" class="form-control common"
																	id="model" value="Mouse"></input>
															</div>
														</div>

														<div class="form-group">
															<label class="control-label col-sm-5" for="make">Make
															</label>
															<div class="col-sm-6">
																<input type="text" class="form-control common" id="make"
																	value="Lenovo"></input>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-sm-5" for="condition">Condition
															</label>
															<div class="col-sm-6">
																<select class="form-control common" id="vendor">
																	<option>Working</option>
																	<option>Not Working</option>

																</select>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-sm-5" for="description">Description</label>
															<div class="col-sm-6">
																<textarea class="form-control textarea" id="desc"
																	placeholder="Enter Description">USB Mouse</textarea>
															</div>
														</div>




													</div>

													<div class="col-md-6">


														<div class="form-group">
															<label class="control-label col-sm-5" for="model_number">Model
																Number</label>
															<div class="col-sm-6">
																<input type="text" class="form-control common"
																	id="model_number" value="MU-0001"></input>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-sm-5" for="serial_number">Serial
																Number</label>
															<div class="col-sm-6">
																<input type="text" class="form-control common"
																	id="serial" value="MI848190488"></input>
															</div>
														</div>
													</div>

													<div class="col-md-12" align="right">

														<button type="submit" class="btn btn-info">Save</button>
														<button type="reset" class="btn btn-info">Cancel</button>


													</div>
												</fieldset>
											</form>

										</div>
										<div class="modal-footer">
											<!-- <button type="button" class="btn btn-info"
												data-dismiss="modal">Close</button> -->
										</div>
									</div>

								</div>
							</div>
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

															<%-- 	<%pageContext.setAttribute("i", ++i); %> --%>

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
				<!-- exp_container -->
			</div>
		</div>
	</div>


	<script>
		document.getElementById('Asset').className = 'active';
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

			new JsDatePick({
				useMode : 2,
				target : "indate",
				dateFormat : "%Y-%M-%d"
			});

			new JsDatePick({
				useMode : 2,
				target : "wdate",
				dateFormat : "%Y-%M-%d"
			});

			$(".reason").hide();
			//for filling form
			document.getElementById('make').value = document
					.getElementById('makeOption').value;

			function getHash(url) {
				var hashPos = url.lastIndexOf('#');
				//alert(hashPos)
				//			      return url.substring( hashPos + 1 );
			}

		};
		$(document).ready(function() {
			$('[name="appRejectBtn"]').click(appReject);
			$(".groupinfo").hide();
			$('#stock').change(function() {
				if ($('#stock option:selected').text() == "In-Project") {
					$('.groupinfo').show();
				} else {
					$('.groupinfo').hide();
				}
			});
			$('#associated').change(function() {
				if ($('#associated option:selected').text() == "E440") {

					$('#purchase :input').attr('readonly', 'readonly');

				} else {
					$('#purchase :input').attr('readonly', false);

				}
			});

		});

		function showtab() {
			$('#tabs a[href="#manage"]').tab('show');
		}
		function getResaon() {
			$(".reason").show();

		}
		function hideReason() {
			$(".reason").hide();

		}
		function appReject() {
			var status = $('input[name=inlineRadioOptions]:checked').val();
			$('#appReject').val(status);
			document.forms[1].action = "appReject";
			document.forms[1].submit();
		}
	</script>

</body>
</html>












