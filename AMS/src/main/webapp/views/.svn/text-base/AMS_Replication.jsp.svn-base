<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	document.getElementById('Replication').className = 'active';
</script>
<title>AMS-Replication</title>
</head>
<body>

	<div class="h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo" style="overflow-x: hidden;">

				<div class="exp_container">
					<h4><img src="../resources/images/ReplicationH.png" style="width:25px; height:auto; margin-right:5px"/>Replication</h4>
					<form:form commandName="replicationForm"
						class="form-horizontal exp_box" role="form" name="form2"
						method="post" action="../login/AMS_Replication">
						<!-- 		edit form action	 action-/Asset_Management_System/login/AMS_Replication-->
						<div class="exp_search">
							<div class="form-group formmargin">
								<label class="control-label col-sm-2" for="ndate">Asset
									No</label>
								<div class="col-sm-3">
									<form:input path="assetNumber" class="form-control common"
										readonly="true" />
									<form:errors path="assetNumber" cssClass="error" />
								</div>
								<div id="popupReplication" class="col-sm-2 plStyle"
									style="margin-left: 1.1cm;">
									<a onclick="refreshPage()" data-toggle="modal"
										data-target="#myModal" style="cursor: pointer; float: left"><img
										src="../resources/images/popIco.png" width="15%"></a>
								</div>
							</div>



							<div class="form-group">
								<label class="control-label col-sm-2" for="Tag No">Model
								</label>
								<div class="col-sm-10">

									<form:input path="assetModel" class="form-control common"
										readonly="true" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="Tag No">Start
									No</label>
								<div class="col-sm-10">
									<form:input path="startNo" class="form-control common"
										readonly="true" />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-2" for="ldate">No of
									Repetition</label>
								<div class="col-sm-10">
									<form:input path="assetRepeat" class="form-control common" />
									<h6 Class="error">${message}</h6>
									<form:errors path="assetRepeat" cssClass="error" />
								</div>
							</div>





							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-10">
									<input type="submit" class="btn btn-info" value="Save">

									<input type="button" class="btn btn-info" value="Cancel"
										id="cancel-main">
								</div>
								
							</div>
							<div style="text-align: center; font-size:12px">${successMsg}</div>
						</div>
					</form:form>
					

				</div>

				<!-- Modal -->
				<form:form commandName="replicationForm" role="form"
					class="form-inline" id="list_form">
					<div class="modal fade" id="myModal" role="dialog">
						<!-- 						    <div class="modal-dialog modal-sm"> -->
						<div class="popup">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Replication</h4>
								</div>
								<div class="modal-body">
									<div class="form-group"
										style="text-align: center; margin-bottom: 10px;">
										<label>Asset No</label>
										<form:select path="assetNumber" class="ReplicationForm"
											id="selectAssetNumber">
										</form:select>
										<p></p>
										<div class="col-md-6">
											<div class="form-group">


												<label>Make</label> <input id="maid"
													class="form-control widform" value="" type="text" readonly />
												<input id="maid_hidden_id" class="form-control widform"
													value="" type="hidden" /> <input id="maid_hidden_num"
													class="form-control widform" value="" type="hidden" />

											</div>
										</div>
										<div class="col-md-6">

											<div class="form-group">
												<label>Description</label>
												<textarea id="desc" class="form-control textarea"
													style="width: 50%" readonly></textarea>
											</div>
										</div>

										<div class="modal-footer">

											<button type="button" id="ok" class="btn btn-info btnfooter"
												data-dismiss="modal">Ok</button>
											<button id="cancel" type="button"
												class="btn btn-info btnfooter" data-dismiss="modal">Cancel</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>

			</div>
		</div>
	</div>

</body>
</html>













