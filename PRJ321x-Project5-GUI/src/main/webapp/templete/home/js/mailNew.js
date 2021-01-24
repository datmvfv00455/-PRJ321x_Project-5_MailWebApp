CKEDITOR.replace('editor', configCkEditor());

function configCkEditor() {
	config = {};

	// Toolbar configuration generated automatically by the editor based on
	// config.toolbarGroups.
	config.toolbar = [
			{
				name : 'document',
				groups : [ 'mode', 'document', 'doctools' ],
				items : [ 'Source', '-', 'Save', 'NewPage', 'Preview', 'Print',
						'-', 'Templates' ]
			},
			{
				name : 'clipboard',
				groups : [ 'clipboard', 'undo' ],
				items : [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord',
						'-', 'Undo', 'Redo' ]
			},
			{
				name : 'editing',
				groups : [ 'find', 'selection', 'spellchecker' ],
				items : [ 'Find', 'Replace', '-', 'SelectAll', '-', 'Scayt' ]
			},
			{
				name : 'forms',
				items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea',
						'Select', 'Button', 'ImageButton', 'HiddenField' ]
			},
			'/',
			{
				name : 'basicstyles',
				groups : [ 'basicstyles', 'cleanup' ],
				items : [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript',
						'Superscript', '-', 'CopyFormatting', 'RemoveFormat' ]
			},
			{
				name : 'paragraph',
				groups : [ 'list', 'indent', 'blocks', 'align', 'bidi' ],
				items : [ 'NumberedList', 'BulletedList', '-', 'Outdent',
						'Indent', '-', 'Blockquote', 'CreateDiv', '-',
						'JustifyLeft', 'JustifyCenter', 'JustifyRight',
						'JustifyBlock', '-', 'BidiLtr', 'BidiRtl', 'Language' ]
			},
			{
				name : 'links',
				items : [ 'Link', 'Unlink', 'Anchor' ]
			},
			{
				name : 'insert',
				items : [ 'Image', 'Flash', 'Table', 'HorizontalRule',
						'Smiley', 'SpecialChar', 'PageBreak', 'Iframe' ]
			}, '/', {
				name : 'styles',
				items : [ 'Styles', 'Format', 'Font', 'FontSize' ]
			}, {
				name : 'colors',
				items : [ 'TextColor', 'BGColor' ]
			}, {
				name : 'tools',
				items : [ 'Maximize', 'ShowBlocks' ]
			}, {
				name : 'others',
				items : [ '-' ]
			}, {
				name : 'about',
				items : [ 'About' ]
			} ];

	// Toolbar groups configuration.
	config.toolbarGroups = [ {
		name : 'document',
		groups : [ 'mode', 'document', 'doctools' ]
	}, {
		name : 'clipboard',
		groups : [ 'clipboard', 'undo' ]
	}, {
		name : 'editing',
		groups : [ 'find', 'selection', 'spellchecker' ]
	}, {
		name : 'forms'
	}, '/', {
		name : 'basicstyles',
		groups : [ 'basicstyles', 'cleanup' ]
	}, {
		name : 'paragraph',
		groups : [ 'list', 'indent', 'blocks', 'align', 'bidi' ]
	}, {
		name : 'links'
	}, {
		name : 'insert'
	}, '/', {
		name : 'styles'
	}, {
		name : 'colors'
	}, {
		name : 'tools'
	}, {
		name : 'others'
	}, {
		name : 'about'
	} ];

	config.entities = false;
	config.entities_latin = false;
	config.height = 500;

	return config;
}

$(document).ready(function() {

	$('#message-form').submit(function(e) {
		e.preventDefault();

		var values = $(this).serializeArray();

		values.push({
			name : "bean.emailMessage",
			value : CKEDITOR.instances.editor.getData()
		});

		console.log(values);

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
						insertOKMsg(value);
					}
				});
			}

		});
	});
});

function insertOKMsg(msg) {
	console.log("adsdc" + msg);
	
	var html = $("<div>").addClass(
	"alert alert-block alert-success alert-message").append(
	$("<button>").addClass("close").attr("type", "button").attr(
			"data-dismiss", "alert").append(
			$("<i>").addClass("ace-icon fa fa-times"))

			).append(msg);

	if (!$(".alert-message").is(":visible")) {
		$(html).insertAfter($("#message-form"));
	} else {
		$(".alert-message").replaceWith(html);
	}

}

function insertErrorMsg(msg) {

	var html = $("<div>").addClass(
			"alert alert-block alert-danger alert-message").append(
			$("<button>").addClass("close").attr("type", "button").attr(
					"data-dismiss", "alert").append(
					$("<i>").addClass("ace-icon fa fa-times"))

	).append(msg);

	if (!$(".alert-message").is(":visible")) {

		$(html).insertAfter($("#message-form"));
	} else {
		$(".alert-message").replaceWith(html);

	}

}
