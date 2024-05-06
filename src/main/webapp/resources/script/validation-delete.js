$(document).ready(() => {


	$('#password').focusout(e => {
		if ($('#password').val() === "") {
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
		}
	});

	$('form').submit(e => {
		e.preventDefault();

		const password = $('#password').val();

		// 유효성 검사 
		let isValid = true;


		if (password === "") {
			isValid = false;
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		}

		if (isValid) {
			e.target.submit();
		}
	});
});