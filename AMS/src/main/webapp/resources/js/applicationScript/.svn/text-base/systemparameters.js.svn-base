/**
 * 
 */



           
 





//document.getElementById('Master').className = 'active';
	function ValidateLocationform() {

		if (document.getElementById("comValueLC").value == "") {
			document.getElementById("lvaluediv").innerHTML = "Enter Value";
			document.getElementById("lvaluediv").focus();
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
	function ValidateDepartmentform() {

		if (document.getElementById("comValueDPT").value == "") {
			document.getElementById("dvaluediv").innerHTML = "Enter Value";
			document.getElementById("dvaluediv").focus();
			return false;
		} else {
			document.getElementById("dvaluediv").innerHTML = "";
		}
		if (document.getElementById("comDescriptionDPT").value == "") {
			document.getElementById("ddescriptiondiv").innerHTML = "Enter Description";
			document.getElementById("ddescriptiondiv").focus();
			return false;
		} else {
			document.getElementById("ddescriptiondiv").innerHTML = "";
		}
		if (document.getElementById("comRemarksDPT").value == "") {
			document.getElementById("dremarkdiv").innerHTML = "Enter Remarks";
			document.getElementById("dremarkdiv").focus();
			return false;
		} else {
			document.getElementById("dremarkdiv").innerHTML = "";
		}

	}

	function ValidateServiceProform() {

		if (document.getElementById("comValueSP").value == "") {
			document.getElementById("svaluediv").innerHTML = "Enter Value";
			document.getElementById("svaluediv").focus();
			return false;
		} else {
			document.getElementById("svaluediv").innerHTML = "";
		}
		if (document.getElementById("comDescriptionSP").value == "") {
			document.getElementById("sdescriptiondiv").innerHTML = "Enter Description";
			document.getElementById("sdescriptiondiv").focus();
			return false;
		} else {
			document.getElementById("sdescriptiondiv").value.innerHTML = "";
		}
		if (document.getElementById("comRemarksSP").value == "") {
			document.getElementById("sremarkdiv").innerHTML = "Enter Remarks";
			document.getElementById("sremarkdiv").focus();
			return false;
		} else {
			document.getElementById("sremarkdiv").innerHTML = "";
		}

	}

	function ValidateProjectsform() {

		if (document.getElementById("comValuePRJ").value == "") {
			document.getElementById("pvaluediv").innerHTML = "Enter Value";
			document.getElementById("pvaluediv").focus();
			return false;
		} else {
			document.getElementById("pvaluediv").innerHTML = "";
		}
		if (document.getElementById("comDescriptionPRJ").value == "") {
			document.getElementById("pdescriptiondiv").innerHTML = "Enter Description";
			document.getElementById("pdescriptiondiv").focus();
			return false;
		} else {
			document.getElementById("pdescriptiondiv").value.innerHTML = "";
		}
		if (document.getElementById("comRemarksPRJ").value == "") {
			document.getElementById("premarkdiv").innerHTML = "Enter Remarks";
			document.getElementById("premarkdiv").focus();
			return false;
		} else {
			document.getElementById("premarkdiv").innerHTML = "";
		}

	}

	function ValidateVendorsform() {

		if (document.getElementById("comValueVNDR").value == "") {
			document.getElementById("vvaluediv").innerHTML = "Enter Value";
			document.getElementById("vvaluediv").focus();
			return false;
		} else {
			document.getElementById("vvaluediv").innerHTML = "";
		}
		if (document.getElementById("comDescriptionVNDR").value == "") {
			document.getElementById("vdescriptiondiv").innerHTML = "Enter Description";
			document.getElementById("vdescriptiondiv").focus();
			return false;
		} else {
			document.getElementById("vdescriptiondiv").value.innerHTML = "";
		}
		if (document.getElementById("comRemarksVNDR").value == "") {
			document.getElementById("vremarkdiv").innerHTML = "Enter Remarks";
			document.getElementById("vremarkdiv").focus();
			return false;
		} else {
			document.getElementById("vremarkdiv").innerHTML = "";
		}

	}

	function ValidateMakeform() {

		if (document.getElementById("comValueMK").value == "") {
			document.getElementById("mvaluediv").innerHTML = "Enter Value";
			document.getElementById("mvaluediv").focus();
			return false;
		} else {
			document.getElementById("mvaluediv").innerHTML = "";
		}
		if (document.getElementById("comDescriptionMK").value == "") {
			document.getElementById("mdescriptiondiv").innerHTML = "Enter Description";
			document.getElementById("mdescriptiondiv").focus();
			return false;
		} else {
			document.getElementById("mdescriptiondiv").innerHTML = "";
		}
		if (document.getElementById("comRemarksMK").value == "") {
			document.getElementById("mremarkdiv").innerHTML = "Enter Remarks";
			document.getElementById("mremarkdiv").focus();
			return false;
		} else {
			document.getElementById("mremarkdiv").innerHTML = "";
		}

	}

	function showForm(x) {

		if (x == "Location") {
			$("#frmLocation").css("display", "inline");
			$("#frmDepartment").css("display", "none");
			$("#frmservpro").css("display", "none");
			$("#frmproject").css("display", "none");
			$("#frmvendors").css("display", "none");

			$("#frmmake").css("display", "none");
		} else if (x == "Department") {

			$("#frmDepartment").css("display", "inline");
			$("#frmLocation").css("display", "none");
			$("#frmservpro").css("display", "none");
			$("#frmproject").css("display", "none");
			$("#frmvendors").css("display", "none");

			$("#frmmake").css("display", "none");
		}

		else if (x == "Service Provider") {
			$("#frmservpro").css("display", "inline");
			$("#frmLocation").css("display", "none");
			$("#frmDepartment").css("display", "none");
			$("#frmproject").css("display", "none");
			$("#frmvendors").css("display", "none");

			$("#frmmake").css("display", "none");

		} else if (x == "Projects") {
			$("#frmproject").css("display", "inline");
			$("#frmservpro").css("display", "none");
			$("#frmLocation").css("display", "none");
			$("#frmDepartment").css("display", "none");
			$("#frmvendors").css("display", "none");

			$("#frmmake").css("display", "none");

		} else if (x == "Vendors") {

			$("#frmvendors").css("display", "inline");
			$("#frmservpro").css("display", "none");
			$("#frmLocation").css("display", "none");
			$("#frmDepartment").css("display", "none");
			$("#frmproject").css("display", "none");

			$("#frmmake").css("display", "none");
		}

		else if (x == "Make") {

			$("#frmmake").css("display", "inline");

			$("#frmvendors").css("display", "none");
			$("#frmservpro").css("display", "none");
			$("#frmLocation").css("display", "none");
			$("#frmDepartment").css("display", "none");
			$("#frmproject").css("display", "none");
		}

	}

	function getEdit(id, type) {

		if ($('#checkdisabilty' + type).val() != 1) {
			$('#btnsubmitLC').css("display", "none");
			$('#btnupdateLC').css("display", "inline");
			$('#btnsubmitDPT').css("display", "none");
			$('#btnupdateDPT').css("display", "inline");
			$('#btnsubmitSP').css("display", "none");
			$('#btnupdateSP').css("display", "inline");
			$('#btnsubmitPRJ').css("display", "none");
			$('#btnupdatePRJ').css("display", "inline");
			$('#btnsubmitVNDR').css("display", "none");
			$('#btnupdateVNDR').css("display", "inline");
			$('#btnsubmitMK').css("display", "none");
			$('#btnupdateMK').css("display", "inline");
			$("#comValue" + type).prop('disabled', true);
			$("#comValue" + type).prop('readonly', true);
			$("#comDescription" + type).prop('disabled', true);
			$("#comDescription" + type).prop('readonly', true);
			$("#comRemarks" + type).prop('disabled', true);
			$("#comRemarks" + type).prop('readonly', true);
			$("#comType" + type).prop('disabled', true);
			$("#comId" + type).prop('disabled', true);

			$("#" + id + "lcomValue").prop('disabled', false);
			$("#" + id + "lcomValue").prop('readonly', false);

			$("#" + id + "lcomDescription").prop('disabled', false);
			$("#" + id + "lcomDescription").prop('readonly', false);

			$("#" + id + "lcomRemarks").prop('disabled', false);
			$("#" + id + "lcomRemarks").prop('readonly', false);
			$("#" + id + "lcomType").prop('disabled', false);
			$("#" + id + "lcomType").prop('readonly', false);

			$("#" + id + "lcomId").prop('disabled', false);
			$("#" + id + "lcomId").prop('readonly', false);
			$('#checkdisabilty' + type).val(1);
		}

	}

	function cancelEdit(id, type) {

		if ($('#checkdisabilty' + type).val() == 1) {

			$('#btnsubmitLC').css("display", "inline");
			$('#btnupdateLC').css("display", "none");
			$('#btnsubmitDPT').css("display", "inline");
			$('#btnupdateDPT').css("display", "none");
			$('#btnsubmitSP').css("display", "inline");
			$('#btnupdateSP').css("display", "none");
			$('#btnsubmitPRJ').css("display", "inline");
			$('#btnupdatePRJ').css("display", "none");
			$('#btnsubmitVNDR').css("display", "inline");
			$('#btnupdateVNDR').css("display", "none");
			$('#btnsubmitMK').css("display", "inline");
			$('#btnupdateMK').css("display", "none");

			$("#comValue" + type).prop('disabled', false);
			$("#comValue" + type).prop('readonly', false);
			$("#comDescription" + type).prop('disabled', false);
			$("#comDescription" + type).prop('readonly', false);
			$("#comRemarks" + type).prop('disabled', false);
			$("#comRemarks" + type).prop('readonly', false);
			$("#comType" + type).prop('disabled', false);
			$("#comId" + type).prop('disabled', false);

			$("#" + id + "lcomValue").prop('disabled', true);
			$("#" + id + "lcomValue").prop('readonly', true);

			$("#" + id + "lcomDescription").prop('disabled', true);
			$("#" + id + "lcomDescription").prop('readonly', true);

			$("#" + id + "lcomRemarks").prop('disabled', true);
			$("#" + id + "lcomRemarks").prop('readonly', true);
			$("#" + id + "lcomType").prop('disabled', true);
			$("#" + id + "lcomType").prop('readonly', true);

			$("#" + id + "lcomId").prop('disabled', true);
			$("#" + id + "lcomId").prop('readonly', true);
			$('#checkdisabilty' + type).val("");

		}

	}