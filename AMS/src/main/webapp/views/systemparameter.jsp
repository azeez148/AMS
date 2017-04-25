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
	src="../resources/js/jsDatePick.min.1.3.js"></script>
<script type="text/javascript" src="../resources/js/applicationScript/systemparameters.js"></script> -->
	
<script type="text/javascript">document.getElementById('Master').className = 'active';</script>
<title>AMS-System Parameter</title>


       

<script type="text/javascript">
$(document).ready(function(){
    document.getElementById("comValue").value = localStorage.getItem("Name");
    showForm(document.getElementById("comValue").value);
   
});


$(window).on('beforeunload', function() {
    localStorage.setItem("Name",document.getElementById("comValue").value);
  
    
});

	
</script>


</head>
<body>






	<!-- Header -->


	<div class=" h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">

				<div class="exp_container">
					<h4><img src="../resources/images/System ParameterH.png" style="width:25px; height:auto; margin-right:5px"/>System Parameter</h4>

					<div class="exp_box">
						<form class="form-inline topblue" role="form" name="frmmaster" method="post">
							<div class="form-group">

								<label class="dropdown">Master Type</label> <select
									class="form-control common" id="comValue" name="comValue"
									onChange="showForm(this.value)">
									<c:forEach var="systemvalues" items="${masterlist}">
										<option value="${systemvalues.comValue}">${systemvalues.comValue}</option>
									</c:forEach>
								</select>





							</div>
						</form>





						<form role="form" id="frmLocation" action="addLocation"
							name="frmlocation" method="post">

							<table id="tableLC" class="table">
								<div align="right"></div>
								<thead>
									<tr>
										<th><spring:message code="co.label.name" /></th>
										<th><spring:message code="co.label.description" /></th>
										<th><spring:message code="co.label.remark" /></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>

<tbody>
								
								<c:forEach var="ll" items="${locationlist}">
									<tr class="info">
										<td><input name="comValue" class="form-control common"
											type="text" value="${ll.comValue}" id="${ll.comId}lcomValue"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comDescription"
											class="form-control common" type="text"
											value="${ll.comDescription}" id="${ll.comId}lcomDescription"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comRemarks" id="${ll.comId}lcomRemarks"
											class="form-control common" type="text"
											value="${ll.comRemarks}" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comType" id="${ll.comId}lcomType"
											class="form-control common" type="hidden"
											value="${ll.comType}" readonly="readonly" disabled="disabled">

											<input name="checkdisabiltyLC" type="hidden"
											id="checkdisabiltyLC" value="" /></td>
										<td><input name="comId" class="form-control common"
											type="hidden" value="${ll.comId}" id="${ll.comId}lcomId"
											readonly="readonly" disabled="disabled"></td>
										<td style="text-align:center"><a href="#"
											onclick="getEdit('${ll.comId}','${ll.comType}')" style="margin:5px" class="newPencil"><span
												class="glyphicon glyphicon-pencil" id=""></span></a> <span style="margin:5px"
												 id=""><input type="reset" onclick="cancelEdit('${ll.comId}','${ll.comType}')" class="btn btn-reset glyphicon glyphicon-minus"/></span></td>
									</tr>
								</c:forEach>
								<tr class="info">
									<td><input name="comValue" class="form-control common"
										type="text" value="" id="comValueLC">
									<div id="lvaluediv" style="color: red"></div></td>
									<td><input name="comDescription"
										class="form-control common" type="text" value=""
										id="comDescriptionLC">
									<div id="ldescriptiondiv" style="color: red"></div></td>
									<td><input name="comRemarks" class="form-control common"
										type="text" value="" id="comRemarksLC">
									<div id="lremarkdiv" style="color: red"></div></td>
									<td><input name="comType" class="form-control common"
										type="hidden" value="LC" id="comTypeLC"></td>
									<td><input name="comId" class="form-control common"
										type="hidden" value="" id="comIdLC"></td>
									<td></td>
								</tr>
								
								</tbody>
							</table>


							<div align="right">
								<button type="submit" name="locationSubmit" onclick="return ValidateLocationform()"
									class="btn btn-info" id="btnsubmitLC">Submit</button>
								<button type="submit" class="btn btn-info" name="locationUpdate" id="btnupdateLC"
									style="display: none">Submit</button>
								<button type="reset" class="btn btn-info">cancel</button>
								
								
							</div>
							<div align="left">
							 <input type="submit" class="btn btn-info" value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" name="next" />
                           
						    <input type="text" name="pageNum" value="1" />
<%-- 						    <form:input path="pageNum" value="1"/> --%>
						      <input type="submit" class="btn btn-info" value="first" name="first"/>
                           <input type="submit" class="btn btn-info" value="last" name="last" />
                         
                            <input type="hidden" value="0" name="pagecountHidden"/>
								</div>
							
							 
						</form>


						<!-- ------------------------>
						<form role="form" id="frmDepartment" style="display: none"
							action="addDepartment" name="frmdepartment" method="post">
							<table class="table">
								<div align="right"></div>
								<thead>
									<tr>
										<th><spring:message code="co.label.name" /></th>
										<th><spring:message code="co.label.description" /></th>
										<th><spring:message code="co.label.remark" /></th>
										<th></th>
										<th></th>
										<th></th>

									</tr>
								</thead>


								
								<c:forEach var="dl" items="${departmentlist}">
									<tr class="info">
										<td><input name="comValue" class="form-control common"
											type="text" value="${dl.comValue}" id="${dl.comId}lcomValue"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comDescription"
											class="form-control common" type="text"
											value="${dl.comDescription}" id="${dl.comId}lcomDescription"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comRemarks" id="${dl.comId}lcomRemarks"
											class="form-control common" type="text"
											value="${dl.comRemarks}" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comType" id="${dl.comId}lcomType"
											class="form-control common" type="hidden"
											value="${dl.comType}" readonly="readonly" disabled="disabled">

											<input name="checkdisabiltyDPT" type="hidden"
											id="checkdisabiltyDPT" value="" /></td>
										<td><input name="comId" class="form-control common"
											type="hidden" value="${dl.comId}" id="${dl.comId}lcomId"
											readonly="readonly" disabled="disabled"></td>
										<td><a href="#"
											onclick="getEdit('${dl.comId}','${dl.comType}')"><span
												class="glyphicon glyphicon-pencil" id=""></span></a><span
												 id=""><input type="reset" onclick="cancelEdit('${dl.comId}','${dl.comType}')" class="glyphicon glyphicon-minus"/></span></td>
									</tr>
								</c:forEach>
								<tr class="info">
									<td><input name="comValue" class="form-control common"
										type="text" value="" id="comValueDPT">
									<div id="dvaluediv" style="color: red"></div></td>
									<td><input name="comDescription"
										class="form-control common" type="text" value=""
										id="comDescriptionDPT">
									<div id="ddescriptiondiv" style="color: red"></div></td>
									<td><input name="comRemarks" class="form-control common"
										type="text" value="" id="comRemarksDPT">
									<div id="dremarkdiv" style="color: red"></div></td>
									<td><input name="comType" class="form-control common"
										type="hidden" value="DPT" id="comTypeDPT"></td>
									<td><input name="comId" class="form-control common"
										type="hidden" value="" id="comIdDPT"></td>
									<td></td>
								</tr>
							</table>

							<div align="right">
								<button type="submit" name="locationSubmit" onclick="return ValidateDepartmentform()"
									class="btn btn-info" id="btnsubmitDPT">Submit</button>
								<button type="submit" name="locationUpdate" class="btn btn-info" id="btnupdateDPT"
									style="display: none">Submit</button>
								<button type="reset" class="btn btn-info">cancel</button>
								
								
								
							
							</div>
							<div align="left">
							<input type="submit" class="btn btn-info" value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" name="next" />
                            
						    <input type="text" name="pageNum" value="1" />
						    <input type="submit" class="btn btn-info" value="first" name="first"/>
                           <input type="submit" class="btn btn-info" value="last" name="last" />
                           
                            <input type="hidden" value="0" name="pagecountHidden"/>
								</div>
							
							
						</form>

						<form role="form" id="frmservpro" style="display: none"
							action="addServicePro" name="frmservicepro" method="post">
							<table class="table">
								<div align="right"></div>
								<thead>
									<tr>
										<th><spring:message code="co.label.name" /></th>
										<th><spring:message code="co.label.description" /></th>
										<th><spring:message code="co.label.remark" /></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>


								
								<c:forEach var="sl" items="${serviceprolist}">
									<tr class="info">
										<td><input name="comValue" class="form-control common"
											type="text" value="${sl.comValue}" id="${sl.comId}lcomValue"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comDescription"
											class="form-control common" type="text"
											value="${sl.comDescription}" id="${sl.comId}lcomDescription"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comRemarks" class="form-control common"
											type="text" value="${sl.comRemarks}"
											id="${sl.comId}lcomRemarks" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comType" class="form-control common"
											type="hidden" value="${sl.comType}" id="${sl.comId}lcomType"
											readonly="readonly" disabled="disabled"> <input
											name="checkdisabiltySP" type="hidden" id="checkdisabiltySP"
											value="" /></td>
										<td><input name="comId" class="form-control common"
											type="hidden" value="${sl.comId}" id="${sl.comId}lcomId"
											readonly="readonly" disabled="disabled"></td>
										<td><a href="#"
											onclick="getEdit('${sl.comId}','${sl.comType}')"><span
												class="glyphicon glyphicon-pencil" id=""></span></a> <span
												 id=""><input type="reset" onclick="cancelEdit('${sl.comId}','${sl.comType}')" class="glyphicon glyphicon-minus"/></span></td>
									</tr>
								</c:forEach>
								<tr class="info">
									<td><input name="comValue" class="form-control common"
										type="text" value="" id="comValueSP">
									<div id="svaluediv" style="color: red"></div></td>
									<td><input name="comDescription"
										class="form-control common" type="text" value=""
										id="comDescriptionSP">
										<div id="sdescriptiondiv" style="color: red"></div></td>
									<td><input name="comRemarks" class="form-control common"
										type="text" value="" id="comRemarksSP"/>
										<div id="sremarkdiv" style="color: red"></div></td>
									<td><input name="comType" class="form-control common"
										type="hidden" value="SP" id="comTypeSP"/></td>
									<td><input name="comId" class="form-control common"
										type="hidden" value="" id="comIdSP"/></td>
									<td></td>
								</tr>
							</table>
							<div align="right">
								<button type="submit" name="locationSubmit" onclick="return ValidateServiceProform()"
									class="btn btn-info" id="btnsubmitSP">Submit</button>
								<button type="submit" name="locationUpdate" class="btn btn-info" id="btnupdateSP"
									style="display: none">Submit</button>
								<button type="reset" class="btn btn-info">cancel</button>
						
							</div>
							<div align="left">
							 <input type="submit" class="btn btn-info" value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" name="next" />
                           
						    <input type="text" name="pageNum" value="1" />
						    <input type="submit" class="btn btn-info" value="first" name="first"/>
                           <input type="submit" class="btn btn-info" value="last" name="last" />
                           
                            <input type="hidden" value="0" name="pagecountHidden"/>
								</div>
							
						</form>

						<!-- ------------------------>
						<form role="form" id="frmproject" style="display: none"
							action="addProject" method="post">
							<table class="table">
								<div align="right"></div>
								<thead>
									<tr>
										<th><spring:message code="co.label.name" /></th>
										<th><spring:message code="co.label.description" /></th>
										<th><spring:message code="co.label.remark" /></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>


								
								<c:forEach var="pl" items="${projectlist}">
									<tr class="info">
										<td><input name="comValue" class="form-control common"
											type="text" value="${pl.comValue}" id="${pl.comId}lcomValue"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comDescription"
											class="form-control common" type="text"
											value="${pl.comDescription}" id="${pl.comId}lcomDescription"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comRemarks" class="form-control common"
											type="text" value="${pl.comRemarks}"
											id="${pl.comId}lcomRemarks" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comType" class="form-control common"
											type="hidden" value="${pl.comType}" id="${pl.comId}lcomType"
											readonly="readonly" disabled="disabled"> <input
											name="checkdisabiltyPRJ" type="hidden" id="checkdisabiltyPRJ"
											value="" /></td>
										<td><input name="comId" class="form-control common"
											type="hidden" value="${pl.comId}" id="${pl.comId}lcomId"
											readonly="readonly" disabled="disabled"></td>
										<td><a href="#"
											onclick="getEdit('${pl.comId}','${pl.comType}')"><span
												class="glyphicon glyphicon-pencil" id=""></span></a> <span
												 id=""><input type="reset" onclick="cancelEdit('${pl.comId}','${pl.comType}')" class="glyphicon glyphicon-minus"/></span></td></td>
									</tr>
								</c:forEach>
								<tr class="info">
									<td><input name="comValue" class="form-control common"
										type="text" value="" id="comValuePRJ">
									<div id="pvaluediv" style="color: red"></div></td>
									<td><input name="comDescription"
										class="form-control common" type="text" value=""
										id="comDescriptionPRJ">
									<div id="pdescriptiondiv" style="color: red"></div></td>
									<td><input name="comRemarks" class="form-control common"
										type="text" value="" id="comRemarksPRJ">
									<div id="premarkdiv" style="color: red"></div></td>
									<td><input name="comType" class="form-control common"
										type="hidden" value="PRJ" id="comTypePRJ"></td>
									<td><input name="comId" class="form-control common"
										type="hidden" value="" id="comIdPRJ"></td>
									<td></td>
								</tr>
							</table>

							<div align="right">
								<button type="submit" name="locationSubmit" onclick="return ValidateProjectsform()"
									class="btn btn-info" id="btnsubmitPRJ">Submit</button>
								<button type="submit" name="locationUpdate" class="btn btn-info" id="btnupdatePRJ"
									style="display: none">Submit</button>
								<button type="reset" class="btn btn-info">cancel</button>
								
								
							</div>
							
							
							<div align="left">
							<input type="submit" class="btn btn-info" value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" name="next" />
                            
						    <input type="text" name="pageNum" value="1" />
						     <input type="submit" class="btn btn-info" value="first" name="first"/>
                           <input type="submit" class="btn btn-info" value="last" name="last" />
                          
                            <input type="hidden" value="0" name="pagecountHidden"/>
								</div>
						</form>

						<!-- ------------------------>
						<form role="form" id="frmvendors" style="display: none"
							action="addVendors" method="post">
							<table class="table">
								<div align="right"></div>
								<thead>
									<tr>
										<th><spring:message code="co.label.name" /></th>
										<th><spring:message code="co.label.description" /></th>
										<th><spring:message code="co.label.remark" /></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>


								
								<c:forEach var="vl" items="${vendorslist}">
									<tr class="info">
										<td><input name="comValue" id="${vl.comId}lcomValue"
											class="form-control common" type="text"
											value="${vl.comValue}" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comDescription"
											id="${vl.comId}lcomDescription" class="form-control common"
											type="text" value="${vl.comDescription}" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comRemarks" id="${vl.comId}lcomRemarks"
											class="form-control common" type="text"
											value="${vl.comRemarks}" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comType" id="${vl.comId}lcomType"
											class="form-control common" type="hidden"
											value="${vl.comType}" readonly="readonly" disabled="disabled">
											<input name="checkdisabiltyVNDR" type="hidden"
											id="checkdisabiltyVNDR" value="" /></td>
										<td><input name="comId" class="form-control common"
											type="hidden" value="${vl.comId}" id="${vl.comId}lcomId"
											readonly="readonly" disabled="disabled"></td>
										<td><a href="#"
											onclick="getEdit('${vl.comId}','${vl.comType}')"><span
												class="glyphicon glyphicon-pencil" id=""></span></a> <span
												 id=""><input type="reset" onclick="cancelEdit('${vl.comId}','${vl.comType}')" class="glyphicon glyphicon-minus"/></span></td></td>
									</tr>
								</c:forEach>
								<tr class="info">
									<td><input name="comValue" class="form-control common"
										type="text" value="" id="comValueVNDR">
									<div id="vvaluediv" style="color: red"></div></td>
									<td><input name="comDescription"
										class="form-control common" type="text" value=""
										id="comDescriptionVNDR">
									<div id="vdescriptiondiv" style="color: red"></div></td>
									<td><input name="comRemarks" class="form-control common"
										type="text" value="" id="comRemarksVNDR">
									<div id="vremarkdiv" style="color: red"></div></td>
									<td><input name="comType" class="form-control common"
										type="hidden" value="VNDR" id="comTypeVNDR"></td>
									<td><input name="comId" class="form-control common"
										type="hidden" value="" id="comIdVNDR"></td>
									<td></td>
								</tr>
							</table>

							<div align="right">
								<button type="submit" name="locationSubmit" onclick="return ValidateVendorsform()"
									class="btn btn-info" id="btnsubmitVNDR">Submit</button>
								<button type="submit" name="locationUpdate" class="btn btn-info" id="btnupdateVNDR"
									style="display: none">Submit</button>
								<button type="reset" class="btn btn-info">cancel</button>
								
								
								
							</div>
							<div align="left">
							<input type="submit" class="btn btn-info" value="pre" name="pre" />
							<input type="submit" class="btn btn-info" value="next" name="next" />
                            
						    <input type="text" name="pageNum" value="1" />
						     <input type="submit" class="btn btn-info" value="first" name="first"/>
                           <input type="submit" class="btn btn-info" value="last" name="last" />
                          
                            <input type="hidden" value="0" name="pagecountHidden"/>
								</div>
						</form>
						<!---------------------------------------------------------------->

						<!-------------------------------------------------------------------->
						<form role="form" id="frmmake" style="display: none"
							action="addMake" method="post">
							<table class="table">
								<div align="right"></div>
								<thead>
									<tr>
										<th><spring:message code="co.label.name" /></th>
										<th><spring:message code="co.label.description" /></th>
										<th><spring:message code="co.label.remark" /></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>


								
								<c:forEach var="ml" items="${makelist}">
									<tr class="info">
										<td><input name="comValue" class="form-control common"
											type="text" value="${ml.comValue}" id="${ml.comId}lcomValue"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comDescription"
											class="form-control common" type="text"
											value="${ml.comDescription}" id="${ml.comId}lcomDescription"
											readonly="readonly" disabled="disabled"></td>
										<td><input name="comRemarks" class="form-control common"
											type="text" value="${ml.comRemarks}"
											id="${ml.comId}lcomRemarks" readonly="readonly"
											disabled="disabled"></td>
										<td><input name="comType" class="form-control common"
											type="hidden" value="${ml.comType}" id="${ml.comId}lcomType"
											readonly="readonly" disabled="disabled"> <input
											name="checkdisabiltyMK" type="hidden" id="checkdisabiltyMK"
											value="" /></td>
										<td><input name="comId" class="form-control common"
											type="hidden" value="${ml.comId}" id="${ml.comId}lcomId"
											readonly="readonly" disabled="disabled"></td>
										<td><a href="#"
											onclick="getEdit('${ml.comId}','${ml.comType}')"><span
												class="glyphicon glyphicon-pencil" id=""></span></a> <span
												 id="" ><input type="reset" onclick="cancelEdit('${ml.comId}','${ml.comType}')" class="glyphicon glyphicon-minus"/></span></td>
									</tr>
								</c:forEach>
								<tr class="info">
									<td><input name="comValue" class="form-control common"
										type="text" value="" id="comValueMK">
									<div id="mvaluediv" style="color: red"></div></td>
									<td><input name="comDescription"
										class="form-control common" type="text" value=""
										id="comDescriptionMK">
									<div id="mdescriptiondiv" style="color: red"></div></td>
									<td><input name="comRemarks" class="form-control common"
										type="text" value="" id="comRemarksMK">
									<div id="mremarkdiv" style="color: red"></div></td>
									<td><input name="comType" class="form-control common"
										type="hidden" value="MK" id="comTypeMK"></td>
									<td><input name="comId" class="form-control common"
										type="hidden" value="" id="comIdMK"></td>
									<td></td>
								</tr>
							</table>

							<div align="right">
								<button type="submit" name="locationSubmit" onclick="return ValidateMakeform()"
									class="btn btn-info" id="btnsubmitMK">Submit</button>
								<button type="submit" name="locationUpdate" class="btn btn-info" id="btnupdateMK"
									style="display: none">Submit</button>
								<button type="reset" class="btn btn-info">cancel</button>
								
								
								
							</div>
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

				</div>
			</div>
		</div>
	</div>




</body>
</html>












