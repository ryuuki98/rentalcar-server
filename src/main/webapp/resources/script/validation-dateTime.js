

$(document).ready(() => {

	var startDateTimeInput = document.getElementById('start-datetime');

	var endDateTimeInput = document.getElementById('end-datetime');

	startDateTimeInput.addEventListener('change', function() {
		startDateTimeInput.value = startDateTimeInput.value.substring(0, 14) + "00:00";
	});

	endDateTimeInput.addEventListener('change', function() {
		endDateTimeInput.value = endDateTimeInput.value.substring(0, 14) + "00:00";
	});

	$('form').submit(e => {
		e.preventDefault();

		const id = $('#start-datetime').val();
		const password = $('#end-datetime').val();

		// 유효성 검사 
		let isValid = true;


		if (id === "") {
			isValid = false;
			alert("대여 일자를 입력하세요.");
		}

		if (password === "") {
			isValid = false;
			alert("반납 일자를 입력하세요.");
		}

		if (isValid) {
			e.target.submit();
		}
	});
});

