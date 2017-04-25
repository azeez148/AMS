<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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
	src="../resources/js/jsDatePick.min.1.3.js"></script> -->
<script type="text/javascript">document.getElementById('Phys.Verification').className = 'active';</script>
	

<title>AMS-System Parameter</title>


       

<script type="text/javascript">
function showfield(assetnumber) {
	
	



       

	var params="physicalverificationAsset.assetNumber=" + assetnumber;

	$.ajax({

		type : "POST",
		url : "getAssetVerification",

		data : params,

		success : function(response) {

	               var responceAssetVeriList = $.parseJSON(response);
	               alert(responceAssetVeriList.model);
	                 $("#fm").val(responceAssetVeriList.model);
	                 $('#fd').val(responceAssetVeriList.department);
	                 $('#fp').val(responceAssetVeriList.project);
	                 $('#fc').val(responceAssetVeriList.custodian);
	                 $('#flv').val(responceAssetVeriList.lastveridate);
	                 $('#fdv').val(responceAssetVeriList.verificationdate);
	                 $('#fh').val(responceAssetVeriList.assetId);
	                 
			

		},

		error : function(e) {

			alert('Error: ' + e);

		}

	});


	
	
	
	
	
	

	$("#ftxt").css("display", "inline");
	$("#save").css("display", "inline");
	$("#cancel").css("display", "inline");




}
	
</script>


</head>
<body>






	<!-- Header -->


	<div class=" h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">

				<div class="exp_container">
					<h4><img src="../resources/images/Phys. VerificationH.png" style="width:25px; height:auto; margin-right:5px"/>Physical Verification</h4>

					<div class="exp_box col-md-12">
                        <form:form  action="searchResultForAssetVerification"
								class="form-inline col-sm-12 topblue mb20 exp_align" role="form">
								<div class="col-sm-12 pBottom">
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetno" /></label>
										<form:input path="assetNumber" class="form-control widform"
											type="text" id="assetnum" value=""
											placeholder="Enter AssetNumber" />
									</div>


<!-- 									<div class="form-group col-sm-3">  -->
<%-- 									<label for="email"><spring:message --%>
<%-- 												code="ams.label.assetgroup" /></label>  --%>

<%--   										<form:select class="form-control widform"  --%>
<%--  											path="assetGroupCode.groupId" id="group">  --%>
<%--  											<option value="0"><spring:message   --%>
<%--  													code="ams.select.selectvalue" /></option>  --%>

<%--   											<c:forEach var="allGroups" items="${allGroupDetails}">  --%>
<%--  												<option value="${allGroups.groupId}">  --%>
<%--   													<c:out value="${allGroups.groupName}" />  --%>
<!--  												</option>   -->
<%--   											</c:forEach>  --%>
<%-- 										</form:select>   --%>
<!--  									</div>   -->

<!-- 									<div class="form-group col-sm-3"> -->
<%--  										<label for="email"><spring:message --%>
<%--  												code="ams.label.assetdept" /></label> --%>
<%--  										<form:select class="form-control widform" --%>
<%--  											path="assetDeptCode.comId" id="dept">  --%>
<%-- 											<option value="0"><spring:message  --%>
<%--  													code="ams.select.selectvalue" /></option>  --%>

<%-- 											<c:forEach var="allDepartments" items="${allDepartmentList}"> --%>
<%-- 												<option value="${allDepartments.comId}"> --%>
<%-- 													<c:out value="${allDepartments.comValue}" /> --%>
<!-- 												</option> -->
<%-- 											</c:forEach> --%>
<%-- 										</form:select> --%>
<!-- 									</div> -->
<!-- 									<div class="form-group col-sm-3"> -->
<%-- 										<label for="email"><spring:message --%>
<%--  												code="ams.label.assetloc" /></label> --%>
<%--  										<form:select class="form-control widform"  --%>
<%--  											path="assetLocationCode.comId" id="location">  --%>
<%-- 											<option value="0"><spring:message  --%>
<%--  													code="ams.select.selectvalue" /></option>  --%>

<%--  											<c:forEach var="allLocations" items="${allLocationList}">  --%>
<%-- 												<option value="${allLocations.comId}">  --%>
<%--  													<c:out value="${allLocations.comValue}" />  --%>
<!--  												</option>  -->
<%--  											</c:forEach>  --%>
<%--  										</form:select>  --%>
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 								<div class="col-sm-12 pBottom"> -->
<!-- 									<div class="form-group col-sm-3"> -->
<%-- 										<label for="email"><spring:message --%>
<%--  												code="ams.label.assetproj" /></label> --%>
<%--  												<form:select class="form-control widform" 											 --%>
<%--  												path="assetProjectCode.comId" id="project"> --%>
<%--  											<option value="0"><spring:message --%>
<%-- 													code="ams.select.selectvalue" /></option> --%>

<%-- 											<c:forEach var="allProjects" items="${allProjectList}"> --%>
<%-- 												<option value="${allProjects.comId}">  --%>
<%-- 													<c:out value="${allProjects.comValue}" /> --%>
<!-- 												</option> -->
<%--  											</c:forEach>  --%>
<%--  										</form:select>  --%>
<!-- 									</div> -->
<!-- 									<div class="form-group col-sm-3"> -->
<%-- 										<label for="email"><spring:message --%>
<%-- 												code="ams.label.assetcusto" /></label>  --%>
<%-- 										<form:select class="form-control widform" --%>
<%--  											path="assetCustodianCode.empId" id="custody">  --%>
<%--  											<option value="0"><spring:message  --%>
<%--  													code="ams.select.selectvalue" /></option>  --%>

<%--  											<c:forEach var="allEmployees" items="${allCustodianDetails}"> --%>
<%-- 												<option value="${allEmployees.empId}">  --%>
<%-- 													<c:out value="${allEmployees.empName}" />  --%>
<!--  												</option>  -->
<%-- 											</c:forEach>  --%>

<%-- 										</form:select>  --%>
<!-- 									</div> -->
									<div class="form-group col-sm-3" style="text-align: right">
										<input name="search" type="submit"
											value="<spring:message code="co.button.search" />"
											class="btn btn-info"> <input name="search"
											type="button"
											value="<spring:message code="co.button.clear" />"
											class="btn btn-info" />
									</div>
									
								</div>
							</form:form>

           <form role="form" action="addAssetVerification" method="post">

								<table class="table col-md-12">
									<thead>
										<tr>
											<th>Asset No</th>
											<th>Model</th>
											<th>Department</th>
										    <th>Project</th>
											<th>Custodian</th>
                                            <th>Last Verification</th>
                                            <th>Verification Date</th>
                                            <th>Remarks</th>
										
											<th></th>
                                            <th></th>
										</tr>
									</thead>
									<tbody>
                                     <tr>
										<td><input type="text"
												value="" class="form-control"  onblur="showfield(this.value)"></td>
                                              
											<td><input type="text"
												value="" class="form-control" name="" id="fm" readonly /></td>
											<td><input type="text"
												value="" class="form-control" id="fd" name="" readonly ></td>
											
											<td><input type="text"
												value="" class="form-control" id="fp" name="" readonly ></td>
											<td><input type="text"
												value="" class="form-control" id="fc" name="" readonly ></td>
                                            <td><input type="text"
												value="" class="form-control" id="flv" name="lastdatetrans" readonly ></td>
                                            <td><input type="text"
												value="" class="form-control" id="fdv" name="verifiedtrans" readonly ></td>
												
                                            <td><textarea class="form-control" id="ftxt" name="remarks" style="display:none"></textarea></td>
                                             <td><input name="save" id="save" type="submit" value="Save"
												class="btn btn-info" style="display:none"/></td>
                                                <td> <input name="cancel" type="button"
												value="Cancel" id="cancel" class="btn btn-info" style="display:none"/>
												
												<input type="hidden" name="physicalverificationAsset.assetId"
												value="" id="fh" />
												</td>
                                    
                                     
										</tr>
                                   
								     <c:forEach var="gv" items="${getverification}">
									<tr class="">
										<td>${gv.physicalverificationAsset.assetNumber}</td>
										<td>${gv.physicalverificationAsset.assetModel}</td>
										<td>${gv.physicalverificationAsset.assetDeptCode.comValue}</td>
										<td>${gv.physicalverificationAsset.assetProjectCode.comValue}</td>
										<td>${gv.physicalverificationAsset.assetCustodianCode.empName}</td>
										<td>${gv.lastDate}</td>
									   <td>${gv.verifiedDate}</td>
										<td>${gv.remarks}</td>
										<td></td><td></td>
										
									</tr>
									</c:forEach>
										
									</tbody>
								</table>
</form>
								<!-- <div align="right">

      <input name="Manage" type="button" value="Modify" class="btn btn-info" style="background-color:#09C"/>
      </div>-->
							</div>

				</div>
			</div>
		</div>
	</div>



	
	

</body>
</html>


