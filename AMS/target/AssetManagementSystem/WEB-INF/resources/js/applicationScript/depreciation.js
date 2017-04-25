/**
 * 
 */

//document.getElementById('AssetDepreciation').className = 'active';


function getDepreciationDetails(curdate) {


         $('#depdate').val(curdate);

	var params="date=" + curdate+"&assetId="+$('#assethid').val();

	$.ajax({

		type : "POST",
		url : "getdepreciationCalculation",

		data : params,

		success : function(response) {

	                 var responceAssetList = $.parseJSON(response);
	               
	                 $('#depreciationDaysAged').val(responceAssetList.days);
	                 $('#depreciationAmount').val(responceAssetList.depramount);
	                 $('#depreciationAccumulatedAmount').val(responceAssetList.accumulated);
	                 $('#depreciationBookValue').val(responceAssetList.bookvalue);
	                 $('#assetDbHIdden').val(responceAssetList.assetid);
	                 $('#deprfromdate').val(responceAssetList.fromdate);
	                 
			

		},

		error : function(e) {

			alert('Error: ' + e);

		}

	});

}




window.onload = function() {

	g_globalObject=new JsDatePick({
		useMode : 2,
		target : "depdate",
		dateFormat : "%Y-%M-%d",
	
		
	
	});

	g_globalObject.setOnSelectedDelegate(function(){
		var obj = g_globalObject.getSelectedDay();
		
	
		getDepreciationDetails(obj.year + "-" + obj.month + "-" + obj.day);
		
		
	});
	

};






function showtab() {
	$('#myTab a[href="#modify"]').tab('show');
}


	

	function ValidateDeprForm() {

		if (document.getElementById("depdate").value == "") {
			document.getElementById("todatediv").innerHTML = "Empty value not valid";
			document.getElementById("depdate").focus();
			return false;
		} else {
			document.getElementById("todatediv").innerHTML = "";
		}
		if (document.getElementById("depreciationDaysAged").value == "") {
			document.getElementById("agediv").innerHTML = "Empty value not valid";
			document.getElementById("depreciationDaysAged").focus();
			return false;
		} else {
			document.getElementById("agediv").innerHTML = "";
		}
		if (document.getElementById("depreciationBookValue").value == "") {
			document.getElementById("bookvaluediv").innerHTML = "Empty value not valid";
			document.getElementById("depreciationBookValue").focus();
			return false;
		} else {
			document.getElementById("bookvaluediv").innerHTML = "";
		}
		
		
		if (document.getElementById("depreciationAmount").value == "") {
			document.getElementById("depramountdiv").innerHTML = "Empty value not valid";
			document.getElementById("depreciationAmount").focus();
			return false;
		} else {
			document.getElementById("depramountdiv").innerHTML = "";
		}
		
		if (document.getElementById("depreciationAccumulatedAmount").value == "") {
			document.getElementById("accmaountdiv").innerHTML = "Empty value not valid";
			document.getElementById("depreciationAccumulatedAmount").focus();
			return false;
		} else {
			document.getElementById("accmaountdiv").innerHTML = "";
		}

	}

	
	
	

	

	
	