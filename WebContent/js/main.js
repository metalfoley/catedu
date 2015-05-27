$(document).ready(function() {
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
