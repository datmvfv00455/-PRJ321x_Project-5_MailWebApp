$(document).ready(function() {
	$('.login-form').submit(function(e) {
		e.preventDefault();
		var values = $(this).serialize();

		$.ajax({
			url : $(this).attr('action'),
			type : "post",
			data : values,
			success : function(response) {

				console.log(response);

				$.each(response, function(key, value) {
					if (key == "error") {
						insertErrorMsg(value);
					} else {
						window.location.assign(value);
					}
				});
			}
		});
	});
});

function insertErrorMsg(msg) {

	if (!$(".alert-message").is(":visible")) {
		var html = $("<div>").addClass(
				"alert alert-block alert-danger alert-message").append(
				$("<button>").addClass("close").attr("type", "button").attr(
						"data-dismiss", "alert").append(
						$("<i>").addClass("ace-icon fa fa-times"))

		).append(msg);

		$(html).insertBefore($(".login-form"));
	}

}