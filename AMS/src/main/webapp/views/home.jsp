<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="/WEB-INF/tld/c-1_0-rt.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<!-- <title>Asset Management System</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/css/bootstrap.min.css" />
<script type="text/javascript" src="../resources/js/canvasjs.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
</script> -->

</head>
<body>
	<div class="h80">
		<div class="row ams_row">
			<div class="col-md-12 exp_chart">
				<div class="col-md-12 pmzero" style="top: 10px">
					<div class="col-md-6 mzero">
						<div class="chart1">
							<div class="chartHead">Asset</div>
							<div class="Chart" id="AssetChartContainer"
								style="height: 210px; width: 98%;"></div>
						</div>

						<div class="chart2">
							<div class="chartHead">Asset-Group wise</div>
							<div class="Chart" id="AssetGroupChartContainer"
								style="height: 210px; width: 98%;"></div>
						</div>
					</div>
					<div class="col-md-6 mzero">
						<div class="evt">
							<div class="evt_head">Events</div>
							<!-- <div id="arrow"></div> -->
							<div class="evt_body" style="height: 210px">
								<marquee direction="up" scrolldelay="300">
									<ul class="pmzero">
										<c:forEach var="Service_Remainder" items="${ServiceRemainder}">
											<li>The service date for the asset :
												${Service_Remainder.key} is on ${Service_Remainder.value}.</li>
										</c:forEach>
									</ul>
								</marquee>
							</div>
							<!-- <div class="evt_head"></div> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- Pie chart -->
<script type="text/javascript">
		window.onload = function() {
			//Asset chart
			var assetChart = new CanvasJS.Chart("AssetChartContainer", {
				theme : "theme3",
				title : {
				/* text: "Asset" */
				},
				legend: {
					maxWidth: 450,
					itemWidth: 80
				},
				data : [ {
					type : "pie",
					showInLegend : true,
					toolTipContent : "{y} - #percent %",
					yValueFormatString : "#,#00. ",
					legendText : "{indexLabel}",
					dataPoints : [ 
					<c:forEach var="Asset_Status" items="${AssetStatus}">
					{
						y : parseInt('<c:out value="${Asset_Status.value}"/>'),
						indexLabel : "<c:out value="${Asset_Status.key}"/>"
				
					},</c:forEach>
					]
				} ]
			});
			assetChart.render();
		
			//Asset Group Chart
			var assetGroupChart = new CanvasJS.Chart(
					"AssetGroupChartContainer", {
						theme : "theme3",
						title : {
						/* text: "Asset" */
						},
						legend: {
							maxWidth: 450,
							itemWidth: 80
						},
						data : [ {
							type : "pie",
							showInLegend : true,
							toolTipContent : "{y} - #percent %",
							yValueFormatString : "#,#00. ",
							legendText : "{indexLabel}",
							dataPoints : [ 
							<c:forEach var="Available_Asset" items="${AvailableAsset}">
							{
								y : parseInt('<c:out value="${Available_Asset.value}"/>'),
								indexLabel : "<c:out value="${Available_Asset.key}"/>"
						
							},</c:forEach>]
						} ]
					});
			assetGroupChart.render();
			document.getElementById('Home').className = 'active';
		}
		
		
	</script>
</html>













