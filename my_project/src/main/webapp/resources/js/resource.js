$(document).ready(function(){
	
	$('#request-link').click(function(e){
		e.preventDefault();
		var ctx = location.protocol + '//' + location.host + "/my-project";
		$.post(ctx + "/resource/request", $("form").serialize(), function(data){
			alert(data);
		});
		return false;
	});
});