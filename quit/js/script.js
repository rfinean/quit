$(document).ready(function(){

	$('a').click(function(e){
		e.preventDefault();
	
		// You'll have to something like $('form').submit();
	
		$(this).addClass('done');
		
		$('form').addClass('done');
	
	});

});// End of Ready.




