/**
 * 
 */
	
function ValidateLocationform() {
	

		if (document.getElementById("assetNumber").value == "") {
			document.getElementById("lvaluediv").innerHTML = "Enter Asset No";
			document.getElementById("lvaluediv").focus();
			return false;
		} else {
			document.getElementById("lvaluediv").innerHTML = "";
		}
		
		if (document.getElementById("aNo").value == "") {
			document.getElementById("ano").innerHTML = "Enter Asset No";
			document.getElementById("ano").focus();
			return false;
		} else {
			document.getElementById("lvaluediv").innerHTML = "";
		}
		if (document.getElementById("comDescriptionLC").value == "") {
			document.getElementById("ldescriptiondiv").innerHTML = "Enter Description";
			document.getElementById("ldescriptiondiv").focus();
			return false;
		} else {
			document.getElementById("ldescriptiondiv").innerHTML = "";
		}
		if (document.getElementById("comRemarksLC").value == "") {
			document.getElementById("lremarkdiv").innerHTML = "Enter Remarks";
			document.getElementById("lremarkdiv").focus();
			return false;
		} else {
			document.getElementById("lremarkdiv").innerHTML = "";
		}

	}
	
	
	
	function Validateform() {
		
		if (document.getElementById("aNo").value == "") {
			document.getElementById("ano").innerHTML = "Enter Value";
			document.getElementById("ano").focus();
			return false;
		} else {
			document.getElementById("ano").innerHTML = "";
		}
		if (document.getElementById("pNo").value == "") {
			document.getElementById("in").innerHTML = "Enter Invoice Number";
			document.getElementById("in").focus();
			return false;
		} else {
			document.getElementById("in").innerHTML = "";
		}
		if (document.getElementById("pnum").value == "") {
			document.getElementById("inp").innerHTML = "Enter PO Number";
			document.getElementById("inp").focus();
			return false;
		} else {
			document.getElementById("inp").innerHTML = "";
		}
		
		 
		if (document.getElementById("idate").value == "") {
			document.getElementById("ind").innerHTML = "Enter invoice date";
			document.getElementById("ind").focus();
			return false;
		} else {
			document.getElementById("ind").innerHTML = "";
		}
		
//		      var pattern =/^\d{4}([./-])\d{2}\1\d{2}$/;
//		   // var re = /^\d{4}-(0[1-9]|1[0-2])-([0-2]\d|3[01]) (0\d|1[01]):[0-5]\d:[0-5]\d$/;
//		      var re = /^\d{4}-(0[1-9]|1[0-2])-([0-2]\d|3[01]) (0\d|1[01]):[0-5]\d:[0-5]\d$/;
//			  var idate = document.getElementById("idate").value;
//		if (document.getElementById("idate").value != "" && !idate.match(re)) {
//			alert("hai");
//			document.getElementById("ind").innerHTML = "Invalid date";
//			document.getElementById("ind").focus();
//			return false;
//		} else {
//			document.getElementById("ind").innerHTML = "";
//		}
		
		
		if (document.getElementById("lsdate").value == "") {
			document.getElementById("pipodate").innerHTML = "Enter PO date";
			document.getElementById("pipodate").focus();
			return false;
		} else {
			document.getElementById("pipodate").innerHTML = "";
		}
		
//		var pattern =/^\d{4}([./-])\d{2}\1\d{2}$/
//		var idate1 = document.getElementById("lsdate").value;
//		if (document.getElementById("lsdate").value != "" && !idate1.match(pattern)) {
//			alert("hai");
//			document.getElementById("pipodate").innerHTML = "Invalid date";
//			document.getElementById("pipodate").focus();
//			return false;
//		} else {
//			document.getElementById("pipodate").innerHTML = "";
//		}
		
		
		if (document.getElementById("dsdate").value == "") {
			document.getElementById("pideldate").innerHTML = "Enter Delivery date";
			document.getElementById("pideldate").focus();
			return false;
		} else {
			document.getElementById("pideldate").innerHTML = "";
		}
		

		if (document.getElementById("nsdate").value == "") {
			document.getElementById("picap").innerHTML = "Enter Captilization date";
			document.getElementById("picap").focus();
			return false;
		} else {
			document.getElementById("picap").innerHTML = "";
		}

		var x =document.getElementById("pcost").value;
		if (document.getElementById("pcost").value == ""||isNaN(x)) {
			document.getElementById("inpc").innerHTML = "Enter a valid puchase cost";
			document.getElementById("inpc").focus();
			return false;
		} else {
			document.getElementById("inpc").innerHTML = "";
		}
		
		
		
		
	  
	   var pattern =/^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/;

		
		
	}