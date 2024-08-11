/**
 * 
 */
$(function() {
	const header = $('.app-header');
	const sidebar = $('.left-sidebar');
	const container = $('.body-wrapper');
	const toggleThemeInput = $('.toggle-theme');
	
	toggleThemeInput.change(function() {
		if ($(this).is(':checked')) {
			sidebar.addClass('dark');
			header.addClass('dark');
			container.addClass('dark');
		} else {
			sidebar.removeClass('dark');
			header.removeClass('dark');
			container.removeClass('dark');
		}
	});
});