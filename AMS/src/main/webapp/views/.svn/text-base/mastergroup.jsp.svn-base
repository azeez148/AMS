<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <title>Asset Management System</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script> -->


<!-- <link href="http://www.jqueryscript.net/css/jquerysctipttop.css" -->
<!-- 	rel="stylesheet" type="text/css"> -->
<!-- <script -->
<!-- 	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> -->
<!-- <script src="../resources/js/jquery.tabledit.js"></script>
<script src="../resources/js/customTable.js"></script> -->
<script type="text/javascript">
	document.getElementById('Master').className = 'active';
</script>

</head>
<body>
	<!-- Header -->
	<!-- 	<header> -->

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
		</nav> -->
	<!-- 	</header> -->
	<%
		int i = 0;
		pageContext.setAttribute("i", i);
	%>
	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_serviceInfo">

				<div class="exp_container">
					<h4><img src="../resources/images/GroupH.png" style="width:25px; height:auto; margin-right:5px"/>Group</h4>

					<div class="exp_box">
						<%-- 						<form:form class="form-inline topblue" role="form" commandName="groupMasterForm"> --%>
						<!-- 							<div class="form-group"> -->
						<!-- 								<label class="dropdown">Group Type</label> -->
						<%-- 								 <form:select id="groupList" path="groupName" class="form-control dropdown" name="master" size="auto" onChange="showForm(this.value)"> --%>
						<%-- 								   <c:forEach var="groupList" items="${groupList}"> --%>
						<%-- 									<form:option value="${groupList.groupId}"> --%>
						<%-- 										<c:out value="${groupList.groupName}" /> --%>
						<%-- 									</form:option> --%>
						<%-- 								</c:forEach> --%>
						<%--      						   </form:select> --%>
						<!-- 							</div> -->
						<%-- 						</form:form> --%>
						<%-- 						<c:if test="${empty groupList}"></c:if> --%>
						<c:choose>
							<c:when test="${empty groupList}">
								<form role="form">
									<table class="table table-striped table-bordered" id="example">

										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Depr.Type</th>
												<th>Depr.Percentage</th>
												<th>Active</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td id="id">0</td>
												<td id="name"></td>
												<td id="type"></td>
												<td id="percentage"></td>
												<td id="active"></td>
											</tr>
										</tbody>
									</table>
								</form>
							</c:when>
							<c:otherwise>

								<form:form role="form" commandName="groupMasterForm"
									action="group" method="POST">
									<form:hidden path="count" />
									<c:set var="page" value="${fn:length(groupList)/10}"></c:set>
									<fmt:formatNumber value="${page}" type="number" pattern="#"
										var="pageCount" />

									<%-- 								<c:out value="${pageCount }"></c:out> --%>

									<table class="table table-striped table-bordered" id="example">

										<thead>
											<tr>
												<th><spring:message code="ams.group.id" /></th>
												<th><spring:message code="ams.group.name" /></th>
												<th><spring:message code="ams.group.type" /></th>
												<th><spring:message code="ams.group.percentage" /></th>
												<th><spring:message code="ams.group.active" /></th>
											</tr>
										</thead>
										<tbody>
											<%--   <c:forEach var="groupList" items="${groupList}"> --%>
											<c:forEach items="${groupList}" var="groupList"
												varStatus="status" begin="${i }" end="9" step="1">
												<tr>
													<td id="id">${groupList.groupId}</td>
													<td id="name">${groupList.groupName}</td>
													<td id="type">${groupList.groupDepreciation.deprecateType}</td>
													<td id="percentage">${groupList.groupDepreciation.depriciateValue}</td>
													<td id="active">${groupList.groupStatus}</td>

												</tr>
											</c:forEach>

											<tr>
												<td id="id">0</td>
												<td id="name"></td>
												<td id="type"></td>
												<td id="percentage"></td>
												<td id="active"></td>
											</tr>

										</tbody>

									</table>
								<div>	<span id="successGroup" style="color: green;"></span>
									<span id="failGroup" style="color: red;"></span></div>
									
									<%-- 								<c:forEach items="${groupList}" var="groupList" --%>
									<%-- 												varStatus="status" begin="${i+1 }" end="${pageCount }" step="1"> --%>
									<input type="submit" class="btn btn-info" value="first"
										name="first" style="" />
									<input type="submit" class="btn btn-info" value="pre"
										name="pre" style="margin-right: 5px;" />
										<form:input path="pageNo" />
									<input type="submit" class="btn btn-info" value="next"
										name="next" style="" />

									<input type="submit" class="btn btn-info" value="last"
										name="last" style="margin-right: 5px;" />


									<!-- <button type="submit" class="transp" name="next" style="float: right;"><span class="glyphicon glyphicon-step-backward"></span></button> -->
									<%-- 								</c:forEach> --%>
								</form:form>


							</c:otherwise>
						</c:choose>

						<script>
							
						</script>
						<script type="text/javascript">
							
						</script>





						<!-- ------------------------>
						<%-- 						<form role="form" id="frmFurniture" style="display: none"> --%>
						<!-- 							<table class="table"> -->
						<!-- 								<div align="right"> -->
						<!-- 									<span class="glyphicon glyphicon-plus"></span> <span -->
						<!-- 										class="glyphicon glyphicon-minus"></span> -->
						<!-- 								</div> -->

						<!-- 								<thead> -->
						<!-- 									<tr> -->
						<!-- 										<th>Name</th> -->
						<!-- 										<th>Depr.Type</th> -->
						<!-- 										<th>Depr.Percentage</th> -->
						<!-- 										<th>Active</th> -->
						<!-- 									</tr> -->
						<!-- 								</thead> -->

						<!-- 								<tr class="info"> -->
						<!-- 									<td>Furniture</td> -->
						<!-- 									<td>Written-Down Method</td> -->
						<!-- 									<td>15%</td> -->
						<!-- 									<td>yes</td> -->
						<!-- 								</tr> -->
						<!-- 								<tr class="info"> -->
						<!-- 									<td><input name="name" class="form-control common" -->
						<!-- 										type="text" value=""></td> -->
						<!-- 									<td><input name="type" class="form-control common" -->
						<!-- 										type="text" value=""></td> -->
						<!-- 									<td><input name="type" class="form-control common" -->
						<!-- 										type="text" value=""></td> -->
						<!-- 									<td><select class="form-control dropdown" name="status" -->
						<!-- 										size="auto"> -->

						<!-- 											<option>yes</option> -->
						<!-- 											<option>no</option> -->

						<!-- 									</select></td> -->
						<!-- 								</tr> -->



						<!-- 							</table> -->

						<!-- 							<div align="right"> -->
						<!-- 								<button type="submit" class="btn btn-info">Submit</button> -->
						<!-- 								<button type="reset" class="btn btn-info">cancel</button> -->
						<!-- 							</div> -->
						<%-- 						</form> --%>

					</div>

				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript">
		var j = 0;
		var ids;
		$('#groupList').change(function() {
			displayBlock();
		});
		function showItem() {
			$("#example").Tabledit(
					{
						columns : {
							identifier : [ 0, 'id' ],
							editable : [
									[ 1, 'Name' ],
									[ 2, 'First' ],
									[ 3, 'Last' ],
									[ 4, 'Nickname',
											'{"1": "Yes ", "2": "No "}' ] ]
						}
					});

		}
		$("#example")
				.Tabledit(
						{
							columns : {
								identifier : [ 0, 'id' ],
								editable : [
										[ 1, 'Name' ],
										[ 2, 'First' ],
										[ 3, 'Last' ],
										[ 4, 'Nickname',
												'{"1": "Yes ", "2": "No "}' ] ]
							}
						});

		$('#example').ready(function() {

			$('.tabledit-edit-button').each(function(i) {

				$(this).attr('id', 'btn' + i);
				// You can also add more code here if you wish to manipulate each IMG element further
			});
			var lastIndex = $('#example').find('tr:last').index();
			// 			$('#example tr').slice(1).remove();
			$('#btn' + lastIndex).click();

			// 			var opts = document.getElementById('groupList').options;
			// 			for(var i=0;i<opts.length;i++){			
			// 				j=parseFloat(opts[i].value);
			// 				$("#example").Tabledit({
			// 	 			    columns: {
			// 	 	    		    identifier: [0, 'id'],
			// 	 	        	editable: [[1,'Name'],[2, 'First'],[3, 'Last'],[4, 'Nickname', '{"1": "Yes ", "2": "No "}']]
			// 	 	    	}
			// 				});
			// 				var $tr =$("#example-"+j+" tr:last")
			// 				 var rowId = $tr.attr('id');
			// 				var rowIndex =$("#"+rowId).index();

			// 	                	$('#editButton:nth-child(1)').click();

			// 			}

			// 			displayBlock();
		});

		// 		function displayBlock() {
		// 			var opts = document.getElementById('groupList').options;
		// 			var x = jQuery("#groupList option:selected").val();
		// 			var length = $('#groupList').children('option').length;
		// 			for (var i = 0; i < opts.length; i++) {
		// 				if (x === opts[i].value) {
		// 					j = parseInt(opts[i].value);
		// 					$("#" + j).css("display", "inline");
		// 				} else {
		// 					j = parseInt(opts[i].value);
		// 					$("#" + j).css("display", "none");
		// 				}
		// 			}

		// 		}
	</script>
</body>
</html>
