$(document).ready(function() {
	
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
	
	$("#showPass").change(function() {
		if(checked=true){
			$("#password").prop('type', 'text');
		} 
        else if(checked=false){
			$("#password").prop('type', 'password');
		}
	})
});
