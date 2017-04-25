	<%@ include file="/views/common/taglibs.jsp"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%
	 response.setDateHeader("Expires", 0);  
	 response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
	 response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
	 response.setHeader("Pragma", "no-cache");  
	%>
<link rel="stylesheet" href="${contextPath}resources/css/style.css" type="text/css" />
<div id="header">
		<div class="container exp">
			<!-- Logo -->
			<div class="row">
				<div class="col-md-2 experion_logo">
					<img src="../resources/images/experionIco.png" style="width:80%"/>
				</div>
				<div class="col-md-2 experion_asm_logo"></div>
				<div class="col-md-8 experion_head">
					<img class="ams_ico"
						src="../resources/images/asset-managementIco.png" />
					<div class="style_asset">Asset Management System</div>
				</div>
			</div>
		</div>

		<!-- menu --> <!-- 	<nav class="navbar navbar-inverse experion_navbar">
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

		<%-- 	<table>
			<c:forEach var="Asset_Status" items="${AssetStatus}">
				<tr>
					<td>${Asset_Status.key}</td>
					<td><input TYPE="text" NAME="${Asset_Status.key}"
						VALUE="${Asset_Status.value}" SIZE="45"></td>
				</tr>
			</c:forEach>
		</table> --%>
</div>
	
