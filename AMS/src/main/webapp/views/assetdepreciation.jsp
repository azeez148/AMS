<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
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
<script type="text/javascript" src="../resources/js/applicationScript/depreciation.js"></script> -->
<script type="text/javascript">document.getElementById('AssetDepreciation').className = 'active';</script>
<title>AMS-Depreciation</title>

<script type="text/javascript">

function gethrefassetid()
{
	
	
var id=$('#assethid').val();	
alert(id);
	 $('#hrefastid').val(id);
	
	 
	 
	 
}

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
				<c:if test="${section == 'Modify Depreciation'}">
			
<c:set var="Emp" value="class=act"/>
<c:set var="mngEmp" value="class=active"/>
<c:set var="modifyClass" value="active"/>
<c:set var="listClass" value=""/>
</c:if>

				<div class="exp_container">
		
					<h4><img src="../resources/images/Asset DepreciationH.png" style="width:25px; height:auto; margin-right:5px"/>Asset Depreciation</h4>
					<ul class="nav nav-tabs" id="myTab">
						<li ${Emp}><a data-toggle="tab" href="#list">List
								Assets</a></li>
						<li ${mngEmp}><a data-toggle="tab" href="#modify">Modify
								Depreciation</a></li>

					</ul>

					<div class="tab-content servicetab">
						<div id="list" class="tab-pane fade in ${listClass} ">
							

								 <form class="form-inline"  role="form" action="searchAssetDep">
									  <div class="exp_search">
									   <div class="form-group">
										<label>Asset No.</label>
										<input type="text" class="form-control" id="search" name="assetNumber" placeholder="Search">&nbsp;
										<button type="submit" class="btn btn-info pBtn">Search</button>
									   </div>
									  </div>
									</form>
                   <form role="form" action="assetpagination">
								<table class="table">
									<thead>
										<tr>
											<th><spring:message code="co.asset.label.assetno" /></th>
											<th><spring:message code="co.asset.label.model" /></th>
											<th><spring:message code="co.asset.label.department" /></th>
											<th><spring:message code="co.asset.label.project" /></th>
											<th><spring:message code="co.asset.label.custodian" /></th>
											<th></th>
										</tr>
									</thead>
                            <tbody>
                            	<c:forEach var="al" items="${assetList}">
									<tr class="info">
										<td>${al.workflowAssetCode.assetNumber}</td>
										<td>${al.workflowAssetCode.assetModel}</td>
										<td>${al.workflowAssetCode.assetDeptCode.comValue}</td>
										<td>${al.workflowAssetCode.assetProjectCode.comValue}</td>
										<td>${al.workflowAssetCode.assetCustodianCode.empName}</td>
										<td><a href="getdepreciation?asset.assetId=${al.workflowAssetCode.assetId}"  onClick="showtab()" data-toggle="tooltip"
											data-placement="top" title="Clik Here">Depreciation</a>
											
											</td>
									</tr>
									</c:forEach>
									</tbody>
								</table>
								
								<div align="left">
							 <input type="submit" class="btn btn-info" value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" name="next" />
                           
						    <input type="text" name="pageNum" value="1" />
						      <input type="submit" class="btn btn-info" value="first" name="first"/>
                           <input type="submit" class="btn btn-info" value="last" name="last" />
                         
                            <input type="hidden" value="0" name="pagecountHidden"/>
								</div>
								
                          </form>
						
						</div>

						<div id="modify" class="tab-pane fade in ${modifyClass}">
							<c:choose>
                                     <c:when test="${not empty ifemptyassetdeprDetail}">
                                     
                                     <form class="form-inline col-sm-12 topblue exp_align" role="form">
									<div class="form-group col-sm-3">
										<label for="email">Depr. Method</label>

										<input
											name="depmethod" value="${ifemptyassetdeprDetail.assetGroupCode.groupDepreciation.deprecateType}" class="form-control widform" type="text"
											value="normal" readonly/>

									</div>
									<div class="form-group col-sm-3">
										<label for="email">Depr.Value</label> <input
											name="deppercentage" value="${ifemptyassetdeprDetail.assetGroupCode.groupDepreciation.depriciateValue}" class="form-control widform" type="text"
											value="5%" readonly/>
									</div>
									<div class="form-group col-sm-3">
										<label for="email"> Delivery date</label> <input
											name="puchasedate" value="${deliverydate}" class="form-control widform"
											type="text"  readonly>
									</div>
                                <div class="form-group col-sm-3">

										<label for="email">Depr. till date</label> <input
											name="deprectilldate" id=""
											class="form-control widform" value="${ifemptyassetdeprDetail.purchaseinfo.piPurchasecost }" readonly type="text" value="37500">
									</div>
									
									<div class="form-group col-sm-3">

										<label for="email">Purchase Cost</label> <input name="cost"
											class="form-control widform" type="text" value="${ifemptyassetdeprDetail.purchaseinfo.piPurchasecost}" readonly>
									
									<input type="hidden" id="assethid" value="${ifemptyassetdeprDetail.assetId}">
									</div>
									<br>

								</form>
                                     
                                     
                                     </c:when>
                                   
                                     
                                     <c:otherwise>
                                     <form class="form-inline col-sm-12 topblue exp_align" role="form" style="margin-bottom: 10px;">
									<div class="form-group col-sm-3">
										<label for="email">Depr. Method</label>

										<input
											name="depmethod" value="${assetdeprDetail.asset.assetGroupCode.groupDepreciation.deprecateType}" class="form-control widform" type="text"
											value="normal" readonly/>

									</div>
									<div class="form-group col-sm-3">
										<label for="email">Depr.Value</label> <input
											name="deppercentage" value="${assetdeprDetail.asset.assetGroupCode.groupDepreciation.depriciateValue}" class="form-control widform" type="text"
											value="5%" readonly/>
									</div>
									<div class="form-group col-sm-3">
										<label for="email"> Delivery date</label> <input
											name="puchasedate" value="${deliverydate}" class="form-control widform"
											type="text"  readonly>
									</div>
									
									

									<div class="form-group col-sm-3">

										<label for="email">Depr. till date</label> <input
											name="deprectilldate" id=""
											class="form-control widform" value="${assetdeprDetail.depreciationBookValue }" readonly type="text" value="37500">
									</div>
									<div class="form-group col-sm-3">

										<label for="email">Purchase Cost</label> <input name="cost"
											class="form-control widform" type="text" value="${assetdeprDetail.asset.purchaseinfo.piPurchasecost }" readonly>
									<input type="hidden" id="assethid" value="${assetdeprDetail.asset.assetId}">
									
									</div>
									<br>

								</form>
                                     
                                      </c:otherwise>
                                        </c:choose>
								

								<form action="addDepreciation" method="get" name="depreciation">
									<table class="table col-md-12">
										<thead>
											<tr>

												<th scope="col">Date</th>
												<th scope="col">Aged</th>
												<th scope="col">Book Value</th>
												<th scope="col">Depreciation Amount</th>
												<th scope="col">Accumulated Depreciation</th>

											</tr>
										</thead>

										<tbody>
											<c:forEach var="adl" items="${assetdeprList}">
											<tr class="info">
											
											
											
											
												<td>${adl.fromdate}</td>
												<td>${adl.depreciationDaysAged}</td>
												<td>${adl.depreciationBookValue}</td>
												<td>${adl.depreciationAmount}</td>
												<td>${adl.depreciationAccumulatedAmount}
												
												</td>
											</tr>
											</c:forEach>
											
											<tr class="info">
												<td><input name="todate" class="form-control"
													id="depdate" type="text" readonly="readonly"><div id="todatediv" style="color: red"></div></td> 
												<td><input name="depreciationDaysAged" id="depreciationDaysAged" readonly="true"  class="form-control"
													type="text"><div id="agediv" style="color: red"></div></td>
												<td><input name="depreciationBookValue" id="depreciationBookValue" readonly="true"  class="form-control"
													type="text"><div id="bookvaluediv" style="color: red"></div></td>
												<td><input name="depreciationAmount" id="depreciationAmount" class="form-control"
													type="text"><div id="depramountdiv" style="color: red"></div></td>
											<td><input name="depreciationAccumulatedAmount" id="depreciationAccumulatedAmount" readonly="true"  class="form-control"
													type="text">
													<div id="accmaountdiv" style="color: red"></div>
													<input type="hidden" id="assetDbHIdden" name="asset.assetId" value="">
													<input type="hidden" id="deprfromdate" name="fromdate" value="">
													</td>
											</tr>

										</tbody>

									</table>

									<div align="right">
										<button type="submit"  name="Submit" class="btn btn-info" onclick="return ValidateDeprForm()">Submit</button>
										<button type="reset" class="btn btn-info">cancel</button>
									</div>
									<div align="left">
							 <input type="submit" class="btn btn-info" onclick="gethrefassetid()"  value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" onclick="gethrefassetid()" name="next" />
                           
						    <input type="text" name="pageNum" value="1"/>
						    
						      <input type="submit" class="btn btn-info" onclick="gethrefassetid()"  value="first" name="first"/>
                           <input type="submit" class="btn btn-info" onclick="gethrefassetid()"  value="last" name="last" />
                         
                            <input type="hidden" value="" id="hrefastid" name="assetpagnId"/>
                            <input type="hidden" value="0" name="pagecountHidden"/>
                         
								</div>
								</form>
							
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


	
</div>
</body>
</html>













