$(document).ready(function() {
	/*
	$('.navbar-nav li a').click(function(e) {

		$('.navbar-nav li.active').removeClass('active');

		var $parent = $(this).parent();
		$parent.addClass('active');
		e.preventDefault();
	});
	*/
	
	$(document).on('click', '.nav-item a', function (e) {
        $(this).parent().addClass('active').siblings().removeClass('active');
    });
	
});