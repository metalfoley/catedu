$(document).ready(function() {
	
	/*****************************************************
	 * 
	 * Show and hide password on login screen based on checkbox change
	 * 
	 ******************************************************/
	$("#login").on('change', "#showPass", function() {
		if($("#showPass").is(":checked")){
			$("#password").prop('type', 'text');
		} 
        else{
			$("#password").prop('type', 'password');
		}
	});
	
	/*****************************************************
	 * 
	 * Enable or disable selectbox on addstudentwiz5
	 * 
	 ******************************************************/
	
	$("#addstudent5").on('change', "#ellCheck", function() {
		if($("#ellCheck").is(":checked")){
			$("#langselect").prop('disabled', false);
		} 
        else{
			$("#langselect").prop('disabled', true);
		}
	});
	
	/*****************************************************
	 * 
	 * Tabs on main dashboard
	 * 
	 ******************************************************/
	$('#myTab a[href="#home"]').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	$('#myTab a[href="#profile"]').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	$('#myTab a[href="#messages"]').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	$('#myTab a[href="#settings"]').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	
	/*****************************************************
	 * 
	 * Lesson Wizard 4
	 * 
	 ******************************************************/
	$('#coreClass').change(function() {
		var value = $("#coreClass option:selected").val();
		var divString = "#" + value;
		var divShow = $(divString);
		
		divShow.removeClass("hidden");
		divShow.siblings().not('.noHide').addClass("hidden");
	});
	
});
