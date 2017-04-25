<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">document.getElementById('ServiceInfo').className = 'active';</script>
<title>AMS-Service Info</title>

</head>
<body>
	<!-- Header
	<header>
		<div class="container exp">-->
			<!-- Logo -->
		<!--	<div class="row">
				<div class="col-md-2 experion_logo">
					<img src="img/experionIco.png" />
				</div>
				<div class="col-md-2 experion_asm_logo"></div>
				<div class="col-md-8 experion_head">
					<img class="ams_ico" src="img/asset-managementIco.png" />
					<div class="style_asset">Asset Management System</div>
				</div>
			</div>
		</div> -->

		<!-- menu -->
		<!-- 	<nav class="navbar navbar-inverse experion_navbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">WebSiteName</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active exp_menu_li"><a href="#">Home</a></li>
						<li class="dropdown exp_menu_li"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Menu 1-1</a></li>
								<li><a href="#">Menu 1-2</a></li>
								<li><a href="#">Menu 1-3</a></li>
							</ul></li>
						<li class="exp_menu_li"><a href="#">Menu 2</a></li>
						<li class="exp_menu_li"><a href="#">Menu 3</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a>
						</li>
						<li>
							<a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Login</a>
						</li>
					</ul>
				</div>
			</div>
		</nav> </header>-->
	

	<div class="h80">
		<div class="row ams_row">
			<!--<div class="col-md-2 exp_sideMenu">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="index.html">Home</a></li>
					<li><a href="AMS_ManageEmployee.html">Manage Employee</a></li>
					<li><a href="AMS_Role.html">Role</a></li>
					<li><a href="AMS_ManagerInbox.html">Manager Inbox</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown">Master <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="AMS_SystemParameter.html">System Parameter</a></li>
								<li><a href="AMS_Group.html">Group</a></li>
							</ul>
					</li>
						<li><a href="AMS_AddAssetNew.html">Assets</a></li>
					<li><a href="AMS_AssetTransfer.html">Asset Transfer</a></li>
					<li><a href="AMS_AssetDep.html">Asset Depreciation</a></li>
					<li><a href="AMS_PhysicalVerification.html">Physical Verification</a></li>
					<li class="active"><a href="AMS_ServiceInfo.html">Service Info</a></li>
					<li><a href="AMS_PurchaseInfo.html">Purchase Info</a></li>

					<li><a href="AMS_Replication.html">Replication</a></li>
					<li><a href="AMS_TransferHistory.html">Transfer History</a></li>
                  		 	 <li><a href="AMS_ServiceHistoryInfo.html">Service Info History </a></li>
				</ul>
			</div>-->
			<div class="col-md-12 exp_serviceInfo">

				<div class="exp_container">
					<h4><img src="../resources/images/Service InfoH.png" style="width:25px; height:auto; margin-right:5px"/>Service Info</h4>
					<ul class="nav nav-tabs" id="tabs">
						<li class="active"><a data-toggle="tab" href="#home">
								List Assets</a></li>
						<li><a data-toggle="tab" href="#menu1" class="Service_Info">Service Info</a></li>
					</ul>

					<div class="tab-content servicetab">
						<div id="home" class="tab-pane fade in active">
							<div class="">
							<form:form class="form-inline" role="form" action="searchAssetNumber" commandName="serviceInfoForm" method="post">
								  <div class="exp_search">
								   <div class="form-group">
									<label>Asset No.</label>
									<form:input path="assetNo" type="text" name="assetNo" class="form-control" id="search" placeholder="Search"/>&nbsp;
									<button type="submit" class="btn btn-info pBtn">Search</button>
								   </div>
								  </div>
								</form:form>

							</div>
							<table id="service_info" class="table">
								<thead>
									<tr>
										<th>Asset No</th>
										<th>Model</th>
										<th>Dept</th>
										<th>Projects</th>
										<th>Custodian</th>
										<th></th>
									</tr>
								</thead>
								<tbody> 
								<c:forEach var="asset" items="${assetData}" >

										<tr class="info">
										
										<td>${asset.assetNumber}</td>
										<td>${asset.assetModel }${asset.assetModelNumber }</td>
										<td>${asset.assetDeptCode.comValue}</td>
										<td>${asset.assetProjectCode.comValue}</td>
										<td>${asset.assetCustodianCode.empName}</td>
										<td><a id="${asset.assetId}" href="#" onClick="showtab(this.id)" class="Service_Info">Service Info</a></td>

									</tr>
											 						
 	 								</c:forEach> 	

								
								</tbody>
							</table>
								<span id="#success_message" style="color:green">${successmessage}</span>
								<span id="#failure_message" style="color:red">${failuremessage}</span>
						</div>
						<div id="menu1" class="tab-pane fade">
							<form:form class="form-horizontal exp_search" role="form" name="form2"
								method="post" action="saveServiceInfo" commandName="serviceInfoForm">

								<div class="form-group">
									<label class="control-label col-sm-2" for="ndate">Service
										Provider</label>
									<div class="col-sm-2">
										<form:select path="siServiceProviderCode" name="siComValue" id="siComValue" class="form-control common" size="auto">
												<!-- <option value ="" disabled selected> -- select service provider -- </option>  -->
												<c:forEach items="${codemaster}" var="var">
													<form:option value="${var.comId}">${var.comValue}</form:option>
												</c:forEach>
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-2" for="noyear">Service
										Contract</label>
									<div class="col-sm-10">
										<form:input path="siContractNumber" type="text" name="contractNo" class="form-control common"
											id="contractNo" value=""/>
										<form:errors path='siContractNumber' />
										<form:input  path="siId" type="hidden" name="serviceId" class="form-control common"
											id="serviceId" value=""/>
										<form:errors path="siId" />
									</div>
									
								</div>
								
								<div class="form-group">
									<label class="control-label col-sm-2" for="noyear">No
										of Services/Year</label>
									<div class="col-sm-10">
										<form:input path="siNoServicesYear" type="text" class="form-control common" name="noyear"
											id="noyear" value=""/>
										<form:errors path="siNoServicesYear" />
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-2" for="ldate">Last
										Service Date</label>
									<div class="col-sm-10">
										<form:input path="siLastServiceDate" type="text" class="form-control common" id="lsdate"
											name="ldate" value=""/>
										<form:errors path="siLastServiceDate" />
									</div>
								</div>


								<div class="form-group">
									<label class="control-label col-sm-2" for="ndate">Next
										Service Date</label>
									<div class="col-sm-10">
										<form:input path="siNextServiceDate" type="text" class="form-control common" id="nsdate"
											name="ndate" value=""/><span id="service_msg">Your next service date must be after last service date.</span>
										<form:errors path="siNextServiceDate" />
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-4 col-sm-3">
										<input type="submit" id="btn_save" class="btn btn-info saveBtn" value="Save">

										<input type="button" class="btn btn-info cancelBtn" value="Cancel">
									</div>
									
								</div>
							

							</form:form>
								
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Date picker -->
	<script type="text/javascript">
		$('#service_msg').hide();
		$('#btn_save').click(function(){
		 var d1 = new Date($('#lsdate').val());
		    var d2 = new Date($('#nsdate').val());
		    if(d1 > d2) {
		        $('#service_msg').show();	
		    return false;
		    }
		    else{
		    	return true;
		    }
		    	
		    
		});
		window.onload = function() {

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

		};
		var assetid;
		function showtab(id) {
			
		assetid=id;
			$('#tabs a[href="#menu1"]').tab('show');
			$('#siComValue').load();
			
		}
	
		
		 $("#siComValue").load(function(){
			 
			   $.ajax({
	               type: "GET",
	               url: "fetchServiceData",
	               data:"assetid="+assetid,
	               success: function(response){
	            	  var serviceInfo = $.parseJSON(response);
	            	  
	            	  $("#serviceId").val(serviceInfo.siId);
	            	 if(serviceInfo.siServiceProviderCode>1){
 	            	  $("#siComValue").val(serviceInfo.siServiceProviderCode);
	            	  }
	            	  $("#contractNo").val(serviceInfo.siContractNumber);
	            	  $("#noyear").val(serviceInfo.siNoServicesYear);
	            	  $("#lsdate").val(serviceInfo.siLastServiceDate);
	            	  $("#nsdate").val(serviceInfo.siNextServiceDate);
	            	  }
	               
	               });

			 });
	</script>
	<!--<footer class="container-fluid" style="padding:0px;">
		<div align="center" style="">
			<p>© 2015 Experion Technologies, All rights reserved.</p>
		</div>
	</footer>-->
</body>
</html>













