<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String section = request.getAttribute("section").toString();
	//  out.print(section);
	Date todayDate = new Date();
	String projectId = request.getAttribute("inProjectId").toString();
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <title>Asset Management System</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
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
<script type="text/javascript" src="../resources/js/jquery-1.9.2.ui.js"></script> -->

<script type="text/javascript">
	/**
	 * script validaion
	 */
	function assetExist(assetNumber) {

		// 		alert("hii");
		$
				.ajax({

					type : "POST",

					url : "checkAsset",

					data : "assetNumber=" + assetNumber,

					success : function(response) {

						// we have the response

						if (response == "true") {
							$('#exists').html("");

										//alert("valid mail id");
							return true;
						} else {
							// 					alert(response);

											//alert(" email already exist");
							//
							$('#exists')
									.html(
											assetNumber
													+ "     <spring:message code="ams.error.unique" />");

 						addAsset.assetNum.focus();
							return false;
						}
					},

				});

	}
</script>

<script type="text/javascript">


function isNumberKey(evt)
{
  var charCode = (evt.which) ? evt.which : event.keyCode;
 console.log(charCode);
    if (charCode != 46 && charCode != 45 && charCode > 31
    && (charCode < 48 || charCode > 57))
     return false;

  return true;
}
</script>
<script type="text/javascript">

</script>

<script>

	window.onload = function() {
		
		

		
		 new JsDatePick({
			useMode : 2,
			target : "wdate",
			dateFormat : "%Y-%M-%d"
		});
		new JsDatePick({
			useMode : 2,
			target : "indate",
			dateFormat : "%Y-%M-%d"
		}); 

		var myParam = location.search.split('myParam=')[1]
		$(".reason").hide();
		if (myParam == 2) {
			$('#tabs a[href="#manage"]').tab('show');
			$(".butt").show();
			$(".reason").hide();

		} else {
			$(".list").show();
			$(".approve").hide();

		}

		$(function() {
		    $('#assetNum').on('keypress', function(e) {
		        if (e.which == 32)
		            return false;
		    });
		});
		
		function getHash(url) {
			var hashPos = url.lastIndexOf('#');
			//alert(hashPos)
			//			      return url.substring( hashPos + 1 );
		}
		/* new JsDatePick({
			useMode : 2,
			target : "cdate",
			dateFormat : "%Y-%M-%d"
		}); */

		/* new JsDatePick({
			useMode : 2,
			target : "idate",
			dateFormat : "%Y-%M-%d"
		}); */
		/* 	new JsDatePick({
		 useMode : 2,
		 target : "pdate",
		 dateFormat : "%Y-%M-%d"
		 }); */
		/* new JsDatePick({
			useMode : 2,
			target : "podate",
			dateFormat : "%Y-%M-%d"
		}); */
		/* new JsDatePick({
			useMode : 2,
			target : "wdate",
			dateFormat : "%Y-%M-%d"
		}); */
		/* new JsDatePick({
			useMode : 2,
			target : "indate",
			dateFormat : "%Y-%M-%d"
		}); */

	};
	$(document).ready(function() {
		
		var e = document.getElementById("stock");
		var selected = e.options[e.selectedIndex].text;
		//alert(e);
		//alert(strUser);
		if(selected != "In-Project"){
			
			
			$('.groupinfo').hide();

		}
		else{
			$('.groupinfo').show();

		}
		
		
		
		
		
// 		$(".groupinfo").hide();
		$('#stock').change(function() {

			/* if ($('#stock option:selected').text() == "In-Project") {
				alert('hai');

				$('.groupinfo').show();
			} else {
				alert('else');

				$('.groupinfo').hide();
			} */
		});
		$('#associated').change(function() {
// 			if ($('#associated option:selected').text() == "E440") {

// 				$('#purchase :input').attr('readonly', 'readonly');

// 			} else {
// 				$('#purchase :input').attr('readonly', false);

// 			}
		});

	});
	function optionCheck(value) {
		var val = value;
		 var projectId='<%=projectId%>';

		$('.groupinfo').hide();

		//currentlyAt.comid=26 dats y..
		if (val == projectId) {

			$('.groupinfo').show();
		} else {

			$('.groupinfo').hide();
		}
	}

	
	
	function search() {
		alert(hi);
		document.forms[0].action = "searchResultForAsset";
		document.forms[0].submit();
	}
	function getResaon() {
		$(".reason").show();

	}
	function hideReason() {
		$(".reason").hide();

	}
	function redirect() {

		window.location.href = 'AMS_ManagerInbox.html';

	}
	$(function() {
	    $( "#datepicker" ).datepicker();
	  });
</script>
<script type="text/javascript">
var assetId;
var previousClass;
var preEl;
function addRowHandlers(tableId, rowClassName, url, paramName, columnIndex) {
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
					var paramValue = cell.innerHTML;
					assetId = paramValue;
					showModifyTab(assetId);
					// 				alert(assetId);
					document.forms[0].action = "editAssetDetails";
					document.forms[0].submit();
				};

			}
		}
	}
	function showModifyTab(assetID) {
		// alert(assetId);
		// 			document.getElementById("roleName").value = roleName;
		$.ajax({
			type : "GET",
			url : "setAssetId",
			data : "assetID=" + assetID,

			success : function(response) {
				// 							alert(response);

				if (response == "true") {

					// 					showEditDetails();

					// 					changeTab();
				} else {
					alert('error');
				}

			}
		});

	}

	function uploadFile() {
		// alert(assetId);
		// 			document.getElementById("roleName").value = roleName;
		$.ajax({
			type : "GET",
			url : "uploadFile",
			data : "assetID=" + assetID,

			success : function(response) {
				// 							alert(response);

				if (response == "true") {

					// 					showEditDetails();

					// 					changeTab();
				} else {
					alert('error');
				}

			}
		});

	}

	/* $(function() {
		var currentDate = new Date();
		$('#datepicker').datepicker({
			inline : true,
			showOtherMonths : true,
			dayNamesMin : [ 'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat' ],
			dateFormat : 'yyyy-MM-dd'
		});
		$("#datepicker").datepicker("setDate", currentDate);
	}); */
</script>
</head>
<body>

	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_serviceInfo">

				<c:set var="Asset" value="class=active" />
				<c:set var="mngAsset" value="class=act" />
				<c:set var="modifyClass" value="" />
				<c:set var="listClass" value="active" />

				<c:if test="${section == 'Manage Asset'}">
					<c:set var="Asset" value="class=act" />
					<c:set var="mngAsset" value="class=active" />
					<c:set var="modifyClass" value="active" />
					<c:set var="listClass" value="" />
				</c:if>

				<div class="exp_container">

					<h4><img src="../resources/images/AssetH.png" style="width:25px; height:auto; margin-right:5px"/>Assets</h4>
					<ul class="nav nav-tabs" id="tabs">
						<li ${Asset}><a data-toggle="tab" href="#list"> <spring:message
									code="ams.tabname.listasset" /><a class="subA" href="asset">
									<spring:message code="ams.tabname.listasset" />
							</a></a></li>
						<li ${mngAsset}><a data-toggle="tab" href="#manage"> <spring:message
									code="ams.tabname.manageasset" />
						</a></li>

						<div id="exists"></div>
						<c:if test="${not empty succes}">
							<div id="success">${succes}</div>
						</c:if>
						<c:if test="${not empty error}">
							<div id="error">${error}</div>
						</c:if>
					</ul>


					<div class="tab-content servicetab col-md-12 pmZero">
						<div id="list" class="tab-pane fade in ${listClass} tabStyle"
							style="${disp}">


							<form:form commandName="assetForm" action="searchResultForAsset"
								class="form-inline col-sm-12 topblue mb20 exp_align" role="form">
								<div class="col-sm-12 pBottom">
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetno" /></label>
										<form:input path="assetNumber" class="form-control widform"
											type="text" id="assetnum" value=""
											placeholder="Enter AssetNumber" />
									</div>


									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetgroup" /></label>

										<form:select class="form-control widform"
											path="assetGroupCode.groupId" id="group">
											<option value="0"><spring:message
													code="ams.select.selectvalue" /></option>

											<c:forEach var="allGroups" items="${allGroupDetails}">
												<option value="${allGroups.groupId}">
													<c:out value="${allGroups.groupName}" />
												</option>
											</c:forEach>
										</form:select>
									</div>

									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetdept" /></label>
										<form:select class="form-control widform"
											path="assetDeptCode.comId" id="dept">
											<option value="0"><spring:message
													code="ams.select.selectvalue" /></option>

											<c:forEach var="allDepartments" items="${allDepartmentList}">
												<option value="${allDepartments.comId}">
													<c:out value="${allDepartments.comValue}" />
												</option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetloc" /></label>
										<form:select class="form-control widform"
											path="assetLocationCode.comId" id="location">
											<option value="0"><spring:message
													code="ams.select.selectvalue" /></option>

											<c:forEach var="allLocations" items="${allLocationList}">
												<option value="${allLocations.comId}">
													<c:out value="${allLocations.comValue}" />
												</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="col-sm-12 pBottom">
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetproj" /></label>
										<form:select class="form-control widform"
											path="assetProjectCode.comId" id="project">
											<option value="0"><spring:message
													code="ams.select.selectvalue" /></option>

											<c:forEach var="allProjects" items="${allProjectList}">
												<option value="${allProjects.comId}">
													<c:out value="${allProjects.comValue}" />
												</option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group col-sm-3">
										<label for="email"><spring:message
												code="ams.label.assetcusto" /></label>
										<form:select class="form-control widform"
											path="assetCustodianCode.empId" id="custody">
											<option value="0"><spring:message
													code="ams.select.selectvalue" /></option>

											<c:forEach var="allEmployees" items="${allCustodianDetails}">
												<option value="${allEmployees.empId}">
													<c:out value="${allEmployees.empName}" />
												</option>
											</c:forEach>

										</form:select>
									</div>
									<!-- <div class="form-group col-sm-3">
										<label for="email">Purchase Cost</label> <input type="text"
											value=">5000" class="form-control widform" id="amount">
									</div> -->
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




							<div id="Details">

								<div
									onmouseover="addRowHandlers('displayMaster', 'rowMouseOver', 'availableAssetDetails', 'assetId', 0, 1)">
									<display:table pagesize="5" defaultsort="1" class="col-md-12"
										name="availableAssetDetails" uid="displayMaster"
										export="false" requestURI="" sort="external" cellpadding="5"
										cellspacing="5">
										<display:column class="hiddenDisplayColumn"
											headerClass="hiddenDisplayColumn" property="assetId" title=""></display:column>

										<display:column title="Asset Number" property="assetNumber"
											class="tableRow"></display:column>
										<display:column title="Model" property="assetModel"
											class="tableRow"></display:column>
										<display:column title="Group"
											property="assetGroupCode.groupName" class="tableRow"></display:column>

										<display:column title="Location"
											property="assetLocationCode.comValue" class="tableRow"></display:column>
										<display:column title="Project"
											property="assetProjectCode.comValue" class="tableRow"></display:column>
										<display:column title="Custodian"
											property="assetCustodianCode.empName" class="tableRow"></display:column>
										<display:column title="Department"
											property="assetDeptCode.comValue" class="tableRow"></display:column>
										<display:column title="More" class="tableRow">
											<a href=# onclick="showTab()"><spring:message
													code="ams.label.moreinfo" /></a>
										</display:column>

									</display:table>
								</div>
							</div>

							<!-- <div align="right">

      <input name="Manage" type="button" value="Modify" class="btn btn-info" style="background-color:#09C"/>
      </div>-->
						</div>

						<div id="manage" class="tab-pane fade ${modifyClass} in">
							<%-- 							<form class="form-horizontal" role="form" action="#">
 --%>

							<%--  		<c:if test="${empty assetList}"> --%>
							<%--  									<c:set var="action" value="save"/> --%>
							<%--  		</c:if> --%>
							<c:choose>
								<c:when test="${not empty assetList}">
									<c:set var="action" value="editAsset" />

								</c:when>

								<c:otherwise>

									<c:set var="action" value="saveAsset" />

								</c:otherwise>
							</c:choose>



							<form:form action="${action}" enctype="multipart/form-data"
								method="post" commandName="assetForm" name="addAsset"
								class="form-horizontal" role="form">
								<div class="col-md-12 pmzero">
									<div class="borderLine ">



										<fieldset>


											<legend class="assetHead" align="left">
												<spring:message code="ams.label.assetInfo" />
											</legend>

											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label col-sm-5" for="make"><spring:message
															code="ams.label.assetmake" /> </label>
													<div class="col-sm-6">

														<form:select class="form-control common"
															path="assetMake.comId" id="make" name="assetMake">

															<option value=""><spring:message
																	code="ams.select.selectvalue" /></option>
															<c:forEach var="allMakes" items="${allMakeList}">

																<c:choose>
																	<c:when
																		test="${assetList.assetMake.comId==allMakes.comId}">
																		<form:option selected="selected"
																			value="${assetList.assetMake.comId}">
																			<c:out value="${assetList.assetMake.comValue}" />
																		</form:option>
																	</c:when>

																	<c:otherwise>



																		<option value="${allMakes.comId}">
																			<c:out value="${allMakes.comValue}" /></option>

																	</c:otherwise>
																</c:choose>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.assetno" /></label>
													<div class="col-sm-6">
														<form:input path="assetNumber" class="form-control common"
															type="text" id="assetNum"
															value="${assetList.assetNumber}"
															placeholder="Enter AssetNumber"
															onblur="return assetExist(this.value)" />

													</div>
												</div>


												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.associated" /></label>
													<div class="col-sm-6">
														<form:select class="form-control common"
															path="associatedAssetId" id="associated">


															<option value=""><spring:message
																	code="ams.select.selectvalue" /></option>

															<c:forEach var="allAssets"
																items="${availableAssetDetails}">

																<c:choose>
																	<c:when
																		test="${assetList.associatedAssetId==allAssets.assetId}">
																		<form:option selected="selected"
																			value="${assetList.associatedAssetId}">
																			<c:out value="${assetList.assetNumber}" />
																		</form:option>
																	</c:when>

																	<c:otherwise>
																		<option value="${allAssets.assetId}">
																			<c:out value="${allAssets.assetNumber}" />
																		</option>
																	</c:otherwise>
																</c:choose>

															</c:forEach>

														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.assetgroup" /></label>
													<div class="col-sm-6">
														<form:select class="form-control common"
															path="assetGroupCode.groupId" id="group">
															<option value=""><spring:message
																	code="ams.select.selectvalue" /></option>

															<c:forEach var="allGroups" items="${allGroupDetails}">

																<c:choose>
																	<c:when
																		test="${assetList.assetGroupCode.groupId==allGroups.groupId}">
																		<form:option selected="selected"
																			value="${assetList.assetGroupCode.groupId}">
																			<c:out value="${assetList.assetGroupCode.groupName}" />
																		</form:option>
																	</c:when>

																	<c:otherwise>
																		<option value="${allGroups.groupId}">
																			<c:out value="${allGroups.groupName}" />
																		</option>
																	</c:otherwise>
																</c:choose>

															</c:forEach>


														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="pwd"><spring:message
															code="ams.label.description" /></label>
													<div class="col-sm-6">

														<textarea class="form-control textarea" id="desc"
															placeholder="Enter Description" name="assetDescription">${assetList.assetDescription}</textarea>

														<%-- 
														 <form:textarea path="assetDescription" id="desc"
															placeholder="Enter Description"></form:textarea> --%>

													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.model" /></label>
													<div class="col-sm-6">

														<form:input path="assetModel" class="form-control common"
															type="text" id="model" placeholder="Enter model"
															value="${assetList.assetModel}" />
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.modelnum" /></label>
													<div class="col-sm-6">
														<form:input path="assetModelNumber"
															class="form-control common" type="text" id="modelnum"
															placeholder="Enter Model Number"
															value="${assetList.assetModelNumber}" />
													</div>
												</div>

												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.serialno" /></label>
													<div class="col-sm-6">

														<form:input path="assetSerialNumber"
															class="form-control common" type="text" id="serialnum"
															placeholder="Enter Serial Number"
															value="${assetList.assetSerialNumber}" />

													</div>
												</div>

												<div class="form-group">
													<label class="control-label col-sm-5" for="pwd"><spring:message
															code="ams.label.notes" /></label>
													<div class="col-sm-6">

														<textarea class="form-control textarea" id="note"
															placeholder="Enter Notes" name="assetNotes">${assetList.assetNotes}</textarea>


														<%-- <form:textarea path="assetNotes" id="note"
															placeholder="Enter Notes" value="${assetList.assetNotes}" />
 --%>
													</div>
												</div>

												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.status" /></label>
													<div class="col-sm-6">
														<form:select class="form-control common"
															path="assetStatus" id="status">
															${status}
															<c:choose>
																<c:when test="${assetList.assetStatus == 'Active'}">
																	<option selected><spring:message
																			code="ams.label.active" /></option>
																	<option><spring:message
																			code="ams.label.inactive" /></option>

																</c:when>

																<c:otherwise>

																	<option selected><spring:message
																			code="ams.label.inactive" /></option>
																	<option><spring:message
																			code="ams.label.active" /></option>

																</c:otherwise>
															</c:choose>


														</form:select>
													</div>
												</div>


											</div>
											<div class="col-md-6">

												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.warranty" /></label>
													<div class="col-sm-6">


														<form:input path="assetWarrantyPeriod"
															class="form-control common" type="text" id="wperiod"
															placeholder="Enter Warranty Period"
															value="${assetList.assetWarrantyPeriod}"
															onkeypress="return isNumberKey(event);" />



													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.warrantyend" /></label>
													<div class="col-sm-6">

														<c:if test="${not empty assetList}">
															<c:set var="warrantyEndDate"
																value="${assetList.assetWarrantyEndDate}" />
														</c:if>
														<c:if test="${empty assetList}">
															<c:set var="warrantyEndDate" value="${todayDate}" />
														</c:if>


														<form:input id="wdate" path="assetWarrantyEndDate"
															class="form-control common" type="text"
															value="${warrantyEndDate}" />

													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.assettype" /></label>
													<div class="col-sm-6">
														<form:select class="form-control common"
															path="assetType.comId" id="assetType">

															<option value=""><spring:message
																	code="ams.select.selectvalue" /></option>

															<c:forEach var="allTypes" items="${allAssetTypeList}">


																<c:choose>
																	<c:when
																		test="${assetList.assetType.comId==allTypes.comId}">
																		<form:option selected="selected"
																			value="${assetList.assetType.comId}">
																			<c:out value="${assetList.assetType.comValue}" />
																		</form:option>
																	</c:when>

																	<c:otherwise>
																		<option value="${allTypes.comId}">
																			<c:out value="${allTypes.comValue}" />
																		</option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>

														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.condition" /></label>
													<div class="col-sm-6">
														<form:select class="form-control common"
															path="assetCondition.comId" id="condition">
															<option value=""><spring:message
																	code="ams.select.selectvalue" /></option>

															<c:forEach var="allConditions"
																items="${allConditionList}">
																<c:choose>
																	<c:when
																		test="${assetList.assetCondition.comId==allConditions.comId}">
																		<form:option selected="selected"
																			value="${assetList.assetCondition.comId}">
																			<c:out value="${assetList.assetCondition.comValue}" />
																		</form:option>
																	</c:when>

																	<c:otherwise>
																		<option value="${allConditions.comId}">
																			<c:out value="${allConditions.comValue}" />
																		</option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>






														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.image" /></label>
													<div class="col-sm-6">
														<input type="file" name="file"></input>${assetList.fileName }
													</div>
												</div>







												<div class="form-group">
													<label class="control-label col-sm-5" for="email"><spring:message
															code="ams.label.currently" /></label>
													<div class="col-sm-6">
														<form:select class="form-control common"
															path="assetCurrentlyAt.comId" id="stock"
															onchange="optionCheck(this.value)">

															<option value=""><spring:message
																	code="ams.select.selectvalue" /></option>

															<c:forEach var="allCurrentlyAt"
																items="${allCurrentlyAtList}">
																<c:choose>
																	<c:when
																		test="${assetList.assetCurrentlyAt.comId==allCurrentlyAt.comId}">


																		<form:option selected="selected"
																			value="${assetList.assetCurrentlyAt.comId}">
																			<c:out value="${assetList.assetCurrentlyAt.comValue}" />
																		</form:option>
																	</c:when>

																	<c:otherwise>
																		<option value="${allCurrentlyAt.comId}">
																			<c:out value="${allCurrentlyAt.comValue}" />
																		</option>
																	</c:otherwise>
																</c:choose>
															</c:forEach>



														</form:select>
													</div>
												</div>

												<c:choose>


													<c:when test="${not empty flag}">
														<c:set var="readonly" value="true" />

													</c:when>

													<c:otherwise>

														<c:set var="readonly" value="false" />

													</c:otherwise>
												</c:choose>

												<div class="groupinfo">
													<div class="borderLine">
														<fieldset>
															<legend class="assetHead">
																<spring:message code="ams.label.custoinfo" />
															</legend>

															<div class="form-group">
																<label class="control-label col-sm-5" for="email"><spring:message
																		code="ams.label.assetloc" /></label>
																<div class="col-sm-6">
																	<form:select class="form-control common"
																		path="assetLocationCode.comId" id="location"
																		readonly="${readonly}">
																		<option value=""><spring:message
																				code="ams.select.selectvalue" /></option>

																		<c:forEach var="allLocations"
																			items="${allLocationList}">
																			<c:choose>
																				<c:when
																					test="${assetList.assetLocationCode.comId==allLocations.comId}">
																					<form:option selected="selected"
																						value="${assetList.assetLocationCode.comId}">
																						<c:out
																							value="${assetList.assetLocationCode.comValue}" />
																					</form:option>
																				</c:when>

																				<c:otherwise>
																					<option value="${allLocations.comId}">
																						<c:out value="${allLocations.comValue}" />
																					</option>
																				</c:otherwise>
																			</c:choose>


																		</c:forEach>



																	</form:select>
																</div>
															</div>


															<div class="form-group">
																<label class="control-label col-sm-5" for="email"><spring:message
																		code="ams.label.assetdept" /></label>
																<div class="col-sm-6">
																	<form:select class="form-control common"
																		path="assetDeptCode.comId" id="dept"
																		readonly="${readonly}">
																		<option value=""><spring:message
																				code="ams.select.selectvalue" /></option>


																		<c:forEach var="allDepartments"
																			items="${allDepartmentList}">
																			<c:choose>
																				<c:when
																					test="${assetList.assetDeptCode.comId==allDepartments.comId}">
																					<form:option selected="selected"
																						value="${assetList.assetDeptCode.comId}">
																						<c:out value="${assetList.assetDeptCode.comValue}" />
																					</form:option>
																				</c:when>

																				<c:otherwise>
																					<option value="${allDepartments.comId}">
																						<c:out value="${allDepartments.comValue}" />
																					</option>
																				</c:otherwise>
																			</c:choose>


																		</c:forEach>



																	</form:select>
																</div>
															</div>
															<div class="form-group">
																<label class="control-label col-sm-5" for="email"><spring:message
																		code="ams.label.assetcusto" /></label>
																<div class="col-sm-6">

																	<form:select class="form-control common"
																		path="assetCustodianCode.empId" id="custody"
																		readonly="${readonly}">

																		<option value=""><spring:message
																				code="ams.select.selectvalue" /></option>


																		<c:forEach var="allEmployees"
																			items="${allCustodianDetails}">

																			<c:choose>
																				<c:when
																					test="${assetList.assetCustodianCode.empId==allEmployees.empId}">
																					<form:option selected="selected"
																						value="${assetList.assetCustodianCode.empId}">
																						<c:out
																							value="${assetList.assetCustodianCode.empName}" />
																					</form:option>
																				</c:when>

																				<c:otherwise>
																					<option value="${allEmployees.empId}">
																						<c:out value="${allEmployees.empName}" />
																					</option>
																				</c:otherwise>
																			</c:choose>





																		</c:forEach>

																	</form:select>
																</div>
															</div>
															<div class="form-group">
																<label class="control-label col-sm-5" for="email"><spring:message
																		code="ams.label.assetproj" /></label>
																<div class="col-sm-6">
																	<form:select class="form-control common"
																		path="assetProjectCode.comId" id="project"
																		readonly="${readonly}">



																		<option value=""><spring:message
																				code="ams.select.selectvalue" /></option>

																		<c:forEach var="allProjects" items="${allProjectList}">



																			<c:choose>
																				<c:when
																					test="${assetList.assetProjectCode.comId==allProjects.comId}">
																					<form:option selected="selected"
																						value="${assetList.assetProjectCode.comId}">
																						<c:out
																							value="${assetList.assetProjectCode.comValue}" />
																					</form:option>
																				</c:when>

																				<c:otherwise>
																					<option value="${allProjects.comId}">
																						<c:out value="${allProjects.comValue}" />
																					</option>
																				</c:otherwise>
																			</c:choose>








																		</c:forEach>
																	</form:select>
																</div>
															</div>
														</fieldset>
													</div>
												</div>
											</div>
										</fieldset>
									</div>



								</div>



								<div class="col-md-6 pmzero" id="purchase">
									<div class="borderLine">

										<fieldset>
											<legend class="assetHead">
												<spring:message code="ams.label.purchaseorder" />
											</legend>

											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.purchasename" /> </label>
												<div class="col-sm-6">
													<form:input path="assetPurchaseReqName"
														class="form-control common" type="text" id="pname"
														value="${assetList.assetPurchaseReqName}"
														placeholder="Enter name" />

												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"><spring:message
														code="ams.label.purchaseno" /></label>
												<div class="col-sm-6">

													<form:input path="assetPurchaseReqNumber"
														class="form-control common" type="text" id="value"
														value="${assetList.assetPurchaseReqNumber}"
														placeholder="Enter Value" />


												</div>
											</div>
											<div class="form-group">
												<label class="control-label col-sm-5" for="email"> <spring:message
														code="ams.label.purchaseDate" /></label>
												<div class="col-sm-6">

													<c:if test="${not empty assetList}">
														<c:set var="purchaseReqDate"
															value="${assetList.assetPurchaseReqDate}" />
													</c:if>
													<c:if test="${empty assetList}">
														<c:set var="purchaseReqDate" value="${todayDate}" />
													</c:if>

													<form:input path="assetPurchaseReqDate"
														class="form-control common" type="text" id="indate"
														value="${purchaseReqDate}" />
												</div>
											</div>
										</fieldset>
									</div>

								</div>


								<div class="col-md-12 mb20" align="right">

									<div class="butt">
										<button type="submit" class="btn btn-info">
											<spring:message code="co.button.save" />
										</button>
										<button type="reset" class="btn btn-info">
											<spring:message code="co.button.addnew" />
										</button>
										<button type="reset" class="btn btn-info">
											<spring:message code="co.button.cancel" />
										</button>
									</div>
								</div>
							</form:form>



						</div>

					</div>

				</div>
				<!-- exp_container -->
			</div>
		</div>
	</div>
</body>
<script>
	document.getElementById('Asset').className = 'active';
</script>
<script>

</script>
</html>













