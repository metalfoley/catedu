$(document).ready(function() {
	
	// Toggle password visibilty when checkbox is checked
	$("#login").on('change', "#showPass", function() {
		if($("#showPass").is(":checked")){
			$("#password").prop('type', 'text');
		} 
        else{
			$("#password").prop('type', 'password');
		}
	});
	
	//Tabs on main dashboard
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
	
});
