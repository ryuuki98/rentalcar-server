<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 확인 및 결제 페이지</title>
<link rel="stylesheet" href="/resources/style/reservationForm.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<h1>예약 내용 확인</h1>

	<div>
		<h2>차량 정보</h2>
		<div class="car-img">
			<img src="${car.imageUrl}">
		</div>
		<p>브랜드: ${car.carBrand}</p>
		<p>차량명: ${car.carName}</p>
		<p>가격: ${car.carPrice} 원/시간</p>
	</div>

	<div>
		<h2>대여 정보</h2>
		<p>
			대여일자:
			<fmt:formatDate value="${reservation.borrowDate}"
				pattern="yyyy-MM-dd HH:mm" />
		</p>

		<p>
			반납일자:
			<fmt:formatDate value="${reservation.returnDate}"
				pattern="yyyy-MM-dd HH:mm" />
		</p>

		<p>총 대여시간: ${reservation.carPrice / car.carPrice } 시간</p>
		<p>총 금액: ${reservation.carPrice} 원</p>
	</div>

	<div>
		<h2>사용자 정보</h2>
		<p>사용자 이름: ${user.userName}</p>
	</div>
			<button onclick="location.href = '/reservationAction'">예약</button>
			<button onclick="location.href = '/index.jsp'">취소</button>
	
	<jsp:include page="/footer"></jsp:include>
</body>
</html>
