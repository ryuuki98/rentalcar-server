$(document).ready(() => {
    var startDateTimeInput = document.getElementById('start-datetime');
    var endDateTimeInput = document.getElementById('end-datetime');

    startDateTimeInput.addEventListener('change', function () {
        startDateTimeInput.value = startDateTimeInput.value.substring(0, 14) + "00:00";
    });

    endDateTimeInput.addEventListener('change', function () {
        endDateTimeInput.value = endDateTimeInput.value.substring(0, 14) + "00:00";
    });

    $('form').submit(e => {
        e.preventDefault();
        
        var startDateTime = $('#start-datetime').val();
        var endDateTime = $('#end-datetime').val();
        var carCode = $('#carCode').val();
        var reservationNum = $('#reservationNum').val();
        
        console.log(startDateTime);
        console.log(endDateTime);
        console.log(carCode);
        console.log(reservationNum);

        if (!startDateTime || !endDateTime) {
            alert("대여일과 반납일을 모두 선택하세요.");
            return;
        }

        $.ajax({
            url: '/checkReservationForUpdate', 
            method: 'POST', 
            data: { 
                startDateTime: startDateTime,
                endDateTime: endDateTime,
                carCode: carCode,
                reservationNum : reservationNum
            },
            success: function(response) {
                console.log(response);
                if (response === 'available') {
                    e.target.submit();
                } else {
                    alert("선택한 날짜에 예약이 불가능합니다.");
                }
            },
            error: function() {
                alert("예약 가능 여부를 확인하는 중 오류가 발생했습니다.");
            }
        });
    });
});
