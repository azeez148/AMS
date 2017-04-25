	$(document).ready(function() {	
		
		$( "#selectAssetNumber" ).change(function() {
			var assetId = $(this).find('option:selected').val();
			var assetNumber = $(this).find('option:selected').text();
			
			  $.ajax({ 
				  type : "GET", 
				  url : "SelectReplicationAsset",
				  data:"assetNumber="+assetNumber, 
				  success : function(response) {
			  $("assetNumber").val(""); var responseAsset =$.parseJSON(response); 
			  //var responseAsset =JSON.stringify(response);
			  $("#maid").val(responseAsset.assetMake.comValue);
			  $("#desc").val(responseAsset.assetDescription);
			  $("#maid_hidden_id").val(assetId);
			  $("#maid_hidden_num").val(assetNumber);}, 
			  error : function(){
			  alert("Error in Asset Number Format"); } });
			 
			
		});
		
		$("#ok").click(function(){
			
			var assetNumber = $("#maid_hidden_num").val();
			if(($("#maid").val()=='')||($("#selectAssetNumber").val()=='')){
				window.location="../login/AMS_Replication"
			}
			$.ajax({
				
	            url : "AMS_ReplicationOK",
	            data:"assetNumber="+assetNumber,
	            success : function(response) {
	              
	                var responseAssetSave = $.parseJSON(response);
	                $("#assetNumber").val(responseAssetSave.assetNumber);
	                $("#assetModel").val(responseAssetSave.assetDescription);
	            	$("#startNo").val(responseAssetSave.startNo);
	            	$('.errors').hide();
	
	            }
	        });
		});
		$("#popupReplication").click(function(){
			var assetId = $("#maid_hidden_id").val();
			var assetNumber = $("#maid_hidden_num").val();
			$.ajax({
				
	            url : '../login/AMS_FetchData',
	            
	            success : function(response) {
	                var responseAssetList = $.parseJSON(response);
	                var optionsAsString = "<option value=''>Select</option>";
	                for(var i = 0; i < responseAssetList.length; i++) {
	                    optionsAsString += "<option value='" + responseAssetList[i].assetId + "'>" + responseAssetList[i].assetNumber + "</option>";
	                }
	                $( 'select[name="assetNumber"]' ).find('option').remove().end().append( optionsAsString );
	            	
	            },
	            error : function(){
	  			  alert("error"); } 
	        });
		});
		$("#cancel-main").click(function(){
			window.location="../login/AMS_Replication"
        	
		});
		$("#cancel").click(function(){
			window.location="../login/AMS_Replication"
		});
					
	});