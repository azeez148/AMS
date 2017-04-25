<%@ include file="/views/common/taglibs.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:url var="contextPath" value="/">
</c:url>
<div class="left">
	<div class="col-md-2 exp_sideMenu">
			<div id="links">
				<ul class="nav nav-pills nav-stacked">
				<li id="Home"><a href="<spring:message code="ams.url.Home"/>"><img src="../resources/images/home.png" style="width:15px; height:auto; margin-right:5px"/>Home</a></li>
				<c:set  var="screenMap" value="${AuthScreens[0].getEmpRoleMapping()[0].getRoleCode().getRoleScreenMap()}"/>
				<c:if test="${!empty screenMap}">
				<c:set var="ScreenNum" scope="session" value="${screenMap.size()}"/>
				<c:forEach var="i" begin="0" end="${ScreenNum-1}">
				<c:set var="ScreenName" scope="session" value="${screenMap.get(i).getScreen().getScreenName()}"/>
				<c:set var="ScreenUrl" value="${fn:replace(ScreenName,' ', '')}" />
				<c:set var="Master" scope="session" value="Master"/>
				<c:if test="${ScreenName == Master}">
				<li id="Master" class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown"><img src="../resources/images/Master.png" style="width:15px; height:auto; margin-right:5px"/>Master <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<spring:message code="ams.url.SystemParameter"/>"><img src="../resources/images/System Parameter.png" style="width:15px; height:auto; margin-right:5px"/>System Parameter</a></li>
							<li><a href="<spring:message code="ams.url.Group"/>"><img src="../resources/images/Group.png" style="width:15px; height:auto; margin-right:5px"/>Group</a></li>
						</ul>
				</li>
				</c:if>
				<c:if test="${ScreenName != Master}">
				<li id="${ScreenUrl}"><a href="<spring:message code="ams.url.${ScreenUrl}"/>"><img src="../resources/images/${ScreenName}.png" style="width:15px; height:auto; margin-right:5px"/>${ScreenName}</a></li>
				</c:if>
				 </c:forEach> 
				 </c:if>
				 
				 <li id="Logout"><a style="" href="<spring:message code="ams.url.Logout"/>"><img src="../resources/images/logout.png" style="width:15px; height:auto; margin-right:5px"/>Logout</a></li>
				 <%-- </c:forEach> --%>
				<!-- 	<li class="active"><a href="../login/home">Home</a></li>
					<li><a href="AMS_ManageEmployee.html">Manage Employee</a></li>
					<li><a href="AMS_Role.html">Role</a></li>
					 <li><a href="AMS_ManagerInbox.html">Manager Inbox</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown">Master <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="AMS_SystemParameter.html">System Parameter</a></li>
							<li><a href="AMS_Group.html">Group</a></li>
						</ul></li>
					<li><a href="AMS_AddAssetNew.html">Assets</a></li>
					<li><a href="AMS_AssetTransfer.html">Asset Transfer</a></li>
					<li><a href="AMS_AssetDep.html">Asset Depreciation</a></li>
					<li><a href="AMS_PhysicalVerification.html">Physical
							Verification</a></li>
					<li><a href="AMS_ServiceInfo.html">Service Info</a></li>
					<li><a href="AMS_PurchaseInfo.html">Purchase Info</a></li>

					<li><a href="AMS_Replication.html">Replication</a></li>
					<li><a href="AMS_TransferHistory.html">Transfer History</a></li>
					<li><a href="AMS_ServiceHistoryInfo.html">Service Info
							History </a></li>  -->
				</ul>
			</div>
	</div>
</div>
