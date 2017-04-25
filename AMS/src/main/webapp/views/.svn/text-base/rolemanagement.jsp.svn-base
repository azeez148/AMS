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
%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
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
<script type="text/javascript" src="../resources/js/jquery-picklist.js"></script> -->

<script type="text/javascript">
	/**
	 * script validaion
	 */
	function roleExist(roleName) {

		// 		alert("hii");
		$
				.ajax({

					type : "POST",

					url : "checkRole",

					data : "name=" + roleName,

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
											roleName
													+ "     <spring:message code="ams.error.unique" />");

							addRole.name.focus();
							return false;
						}
					},

				});

	}
</script>




<script type="text/javascript">
document.getElementById('Role').className = 'active';

	$(function() {
		$("#basic").pickList();

	});

</script>
<script type="text/javascript">
function search(){
	
		document.forms[0].action = "searchResultForRole";
		document.forms[0].submit();
		
}

function changeTab() {
	

	$("#modifyTab").attr("aria-expanded", "true");
	$("#modifyTab").parent().addClass("active");
	//             $("#financeDashboard").removeClass();
	$("#listTab").attr("aria-expanded", "false");
	$("#listTab").parent().removeClass("active");
	$("#list").removeClass();
	$("#list").addClass("tab-pane fade in");
	$("#modify").addClass("tab-pane fade in active");

}

	var selectedRoleId;
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
					selectedRoleId = paramValue;
					showModifyTab(selectedRoleId);

					document.forms[0].action = "editRoleDetails";
					document.forms[0].submit();
				};

				
			}
		}
	}

	/* 	function editRole()
	 document.getElementById("selectedItem").value = selectedRoleId;
	 {
	 if(selectedRoleId == null)
	 {
	 alert('nothing selected')		}
	 else
	 {
	 document.forms[0].action = "editemployeedetails";
	 document.forms[0].submit();
	 }
	 } */

	function showModifyTab(selectedItem) {

		// 			document.getElementById("roleName").value = roleName;
		$.ajax({
			type : "GET",
			url : "setRoleName",
			data : "selectedItem=" + selectedItem,

			success : function(response) {
				// 				alert(response);

				if (response == "true") {

					// 					showEditDetails();

					// 					changeTab();
				} else {
					alert('error');
				}

				
			}
		});
		
	}

	function searchRole() {
// 		alert('hai');

		{
			var roleName = $("#rolename").val();
			$.ajax({
				type : "GET",
				url : "searchResultForRole",
				data : "roleName=" + roleName,
				success : function(response) {
					// 							$("#Details").html(response);
				},
				error : function(responseObject, ioArgs) {
					if (responseObject.status == 601) {
						// reload entire page - this leads to login page
						window.location.reload();
					} else {
						alert("Error" + e);
					}
				}
			});
		}
	}

	function showEditDetails() {
		document.forms[0].action = "editRoleDetails";
		document.forms[0].submit();
	}

	
</script>

<title>Role</title>


</head>
<body>

	<div class="h80">
		<div class="row ams_row">

			<div class="col-md-12 exp_serviceInfo">
				<script>
					// 			 <c:if test="${section == 'Role List'}"/>

					<c:set var="Role" value="class=active" />
					<c:set var="mngRole" value="class=act" />
					<c:set var="modifyClass" value="" />
					<c:set var="listClass" value="active" />
				</script>
				<script>
					<c:if test="${section == 'Manage Role'}">
					// 			    alert('hi');
					<c:set var="Role" value="class=act"/>
					<c:set var="mngRole" value="class=active"/>
					<c:set var="modifyClass" value="active"/>
					<c:set var="listClass" value=""/></c:if>
				</script>

				<div class="exp_container">
					<h4><img src="../resources/images/RoleH.png" style="width:25px; height:auto; margin-right:5px"/>Role</h4>
					<ul class="nav nav-tabs" id="myTab">
						<li ${Role}><a id="listTab" data-toggle="tab" href="#list"><spring:message
									code="ams.tabname.listrole" /> <a class="subA" href="role">
									<spring:message code="ams.tabname.listrole" /></a></a></li>
						<li ${mngRole}><a id="modifyTab" data-toggle="tab"
							href="#modify"><spring:message code="ams.tabname.managerole" /></a></li>

																	<div id="exists"></div>
											
											<c:if test="${not empty succes}">
												<div id="success">${succes}</div></c:if>
											<c:if test="${not empty error}">
												<div id="error">${error}</div></c:if>


					</ul>

					<div class="tab-content servicetab col-md-12">
						<div id="list" class="tab-pane fade in ${listClass}"
							style="${disp}">
							<div class="">
								<form:form commandName="roleForm" class="form-inline"
									role="form">

									<div class="exp_search">
										<div class="form-group">
											<spring:message code="ams.label.roleName" />
											<form:input path="name" class="form-control widform"
												type="text" id="rolename" />
											&nbsp; <input type="button" class="btn btn-info pBtn"
												value="<spring:message code="ams.label.searchcriteria" />"
												onclick="search()" />
										</div>
									</div>


									<div id="Details">
									
												<div onmouseover="addRowHandlers('displayMaster', 'rowMouseOver', 'availableRoleDetails', 'roleId', 0, 1)"><display:table
														pagesize="5" defaultsort="1" name="availableRoleDetails"
														uid="displayMaster" export="false" requestURI=""
														sort="external" cellpadding="5" cellspacing="5">
														<display:column class="hiddenDisplayColumn"
															headerClass="hiddenDisplayColumn" property="id" title=""></display:column>

														<display:column title="Role Name" property="roleName"
															class="tableRow"></display:column>
														<display:column title="Description" property="description"
															class="tableRow"></display:column>
														<display:column title="Status" property="status"
															class="tableRow"></display:column>
														<display:column title="more" class="tableRow">
															<a href=# onclick="showTab()">more info</a>
														</display:column>

													</display:table></div>
									</div>
								</form:form>

							</div>
						</div>


<c:choose>
								<c:when test="${not empty role}">
									<c:set var="action" value="editRoleAction" />

								</c:when>

								<c:otherwise>

									<c:set var="action" value="save" />

								</c:otherwise>
							</c:choose>

						<div id="modify" class="tab-pane fade ${modifyClass} in">
							<div class="modify">
								<form:form action="${action}" method="post"
									commandName="roleForm" name="addRole"
									class="form-inline col-sm-12 topblue exp_align mb20"
									style="margin-bottom: 10px;" role="form">
									<%-- 									<c:set value="${role}" var="roleDetails"> --%>
									<c:forEach items="${role}" var="roleDetails">
										<c:set var="roleName" value="${roleDetails.roleName }"></c:set>

										<c:set var="description" value="${roleDetails.description }"></c:set>
										<c:set var="status" value="${roleDetails.status }">



										</c:set>
									</c:forEach>
									
									<div class="form-group col-sm-3">


										<spring:message code="ams.label.roleName" />
										<form:input path="name" class="form-control widform"
											type="text" id="name" value="${roleName}"  onblur="return roleExist(this.value)"/>
										<spring:hasBindErrors name="RoleForm">
										<form:errors path="name" class="error"></form:errors>
						</spring:hasBindErrors>


									</div>
									<div class="form-group col-sm-3">
										<spring:message code="ams.label.description" />
										<form:input path="description" class="form-control widform"
											id="description" type="text" value="${description }" />
										<form:errors path="description" class="error"></form:errors>

									</div>
									<div class="form-group col-sm-3">
										<spring:message code="ams.label.status" />
										<form:select class="form-control" path="status" id="status">
										
										
<c:choose>
								<c:when test="${status == 'yes'}">
	<option selected><spring:message code="ams.label.active" /></option>
													<option><spring:message code="ams.label.inactive" /></option>
	
								</c:when>

								<c:otherwise>

<option selected><spring:message code="ams.label.inactive" /></option>
												<option><spring:message code="ams.label.active" /></option>
											
								</c:otherwise>
							</c:choose>
										
										
										
										
											<%-- <c:if test="${status == 'yes'}">
											
											</c:if>
											<c:if test="${status != 'yes'}">
												<option selected><spring:message
														code="ams.label.inactive" /></option>
												<option><spring:message code="ams.label.inactive" /></option>
											</c:if> --%>
										</form:select>
										<form:errors path="status" class="error"></form:errors>

									</div>


									<br>
									<div class="form-group col-sm-12">
										<div class="form-group col-sm-3"
											style="margin-left: -14px; width: 115px;">
											<spring:message code="ams.label.privileges" />
										</div>

										<select id="basic" name="previliages" multiple="multiple">



											<c:forEach var="avail" items="${leftscreen}">
												<option value='${avail}'>${avail}</option>
											</c:forEach>
											<c:forEach var="screens" items="${screenlist}">

												<option value='${screens.screen.screenName}'
													selected="selected">${screens.screen.screenName}</option>
											</c:forEach>
											<c:if test="${empty leftscreen}">
												<c:forEach var="screen" items="${availableScreens}">
													<option value='${screen.screenName}'>${screen.screenName}</option>
												</c:forEach>
											</c:if>
										</select>


										<form:errors path="previliages" class="error"></form:errors>

									</div>
									<%-- <div class="form-group col-sm-6 " align="right">
										<input type="submit" class="btn btn-info pBtn"
											value="<spring:message code="co.button.save" />"></input>

									</div> --%>
									
									<div class="col-md-12 mb20" align="right">

									<div class="butt">
										<button type="submit" class="btn btn-info">
											<spring:message code="co.button.save" />
										</button>
										
										<button type="reset" class="btn btn-info">
											<spring:message code="co.button.cancel" />
										</button>
									</div>
								</div>


								</form:form>
								<br>




							</div>
						</div>














					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- 
<!-- 		<script type="text/javascript"> -->
			
// 			window.onload = function() {

// 				new JsDatePick({
// 					useMode : 2,
// 					target : "purdate",
// 					dateFormat : "%Y-%M-%d"
// 				});

// 				new JsDatePick({
// 					useMode : 2,
// 					target : "purtilldate",
// 					dateFormat : "%Y-%M-%d"
// 				});
// 				new JsDatePick({
// 					useMode : 2,
// 					target : "depdate",
// 					dateFormat : "%Y-%M-%d"
// 				});

// 			};
// 			// 			function showtab() {
// 			// 				alert('hai');
// 			// 				$('#myTab a[href="#modify"]').tab('show');
// 			// 			}
<!-- 		</script> -->
<!-- 		<script type="text/javascript"> -->
// 			function changeLinks() {
// 				done = true;
// 				var linkData, queryArr, action, qryStr;
// 				selector = 'span.pagelinks>a';
// 				changeUsingSelector(selector);
// 				selector = 'table#dispTable>thead>tr>th>a';
// 				changeUsingSelector(selector);
// 			}
// 			function changeUsingSelector(selector) {
// 				$(selector)
// 						.each(
// 								function() {
// 									linkData = $(this).attr("href");
// 									queryArr = linkData.split("?");
// 									action = queryArr[0];
// 									qryStr = queryArr[1];
// 									newStr = "JavaScript:doAjax('" + action
// 											+ "','" + qryStr + "','ajxDspId');";
// 									$(this).attr("href", newStr);
// 									$(this)
// 											.attr("onMouseOver",
// 													"window.status='Pagination Links have been Ajaxified!!';return false;");
// 									$(this).attr("onMouseOut",
// 											"window.status='';return false;");
// 								});

// 			}

// 			jQuery(function($) {
// 				changeLinks();
// 			});

// 			function doAjax(url, data, eleId) {
// 				document.getElementById("resetPanel").innerHTML = "<br>";
// 				//if you need additional params to be passed - add to the data variable
// 				$.ajax({
// 					url : url,
// 					data : data,
// 					async : false,
// 					success : function(resp) {
// 						var d = $(resp);
// 						htmlStr = "";
// 						for (i = 0; i < d.length; i++) {
// 							var node = d[i];
// 							if (node.id == eleId) {
// 								htmlStr = $(node).html();
// 								break;
// 							}
// 						}
// 						$('#' + eleId).html(htmlStr);
// 						changeLinks();
// 					}

// 				});
// 			}
// 			var previousClass;
// 			var preEl;
// 			function addRowHandlers(tableId, rowClassName, url, paramName,
// 					columnIndex0, columnIndex1) {
// 				if (document.getElementById(tableId) != null) {
// 					var table = document.getElementById(tableId);
// 					var rows = table.getElementsByTagName("tr");
// 					for (i = 1; i < rows.length; i++) {
// 						rows[i].onclick = function() {
// 							if (typeof (preEl) != 'undefined'
// 									&& typeof (previousClass) != 'undefined') {
// 								preEl.className = previousClass;
// 							}
// 							previousClass = this.className;
// 							this.className = rowClassName;
// 							preEl = this;
// 							var cell = this.getElementsByTagName("td")[columnIndex];
// 							var paramValue = cell.innerHTML;
// 							selectedRoleName = roleName;
// 							showModifyTab(selectedRoleName);
// 						};
// 					}
// 				}
// 			}

<!-- 			function showModifyTab(selectedRoleName) { -->
<!--  				alert("modify function called") -->
<!--  				document.getElementById("roleName").value = roleName; -->
<!--  				$.ajax({ -->
<!--  					type : "GET", -->
<!--  					url : "showEditTabDetails", -->
<!--  					data : "roleName=" + roleName, -->
<!--  					success : function(response) { -->
<!--  						$("#resetPanel").html(response); -->
<!--  					}, -->
<!--  					error : function(responseObject, ioArgs) { -->
<!--  						if (responseObject.status == 601) { -->
<!--  							// reload entire page - this leads to login page -->
<!--  							window.location.reload(); -->
<!--  						} else { -->
<!--  							alert("Error" + e); -->
<!--  						} -->
<!--  					} -->
<!--  				}); -->
<!--  				$("#resetPanel").hide(); -->
<!--  				$("#resetPanel").slideDown(300); -->
<!--  				 			} -->
<!-- 		</script> -->--%>

</body>
</html>













