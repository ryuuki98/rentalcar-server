<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="/header" />
<link rel="stylesheet" href="/resources/style/carsDetail.css">
</head>
<body>
	<div class="container">

		<form action="/moveReservationFormAction" method="POST">

			<div>
				<img src="${car.imageUrl }">
			</div>


			<div class="car-details">

				<h2>${car.carBrand }${car.carName}</h2>

				<h2>${car.carPrice } / 시간</h2>

				<p>${car.carType }</p>

				<p>${car.carYear }년형|${car.carOil }</p>
	
				<input type="hidden" id="carCode" name="carCode" value="${car.carCode }">

				<div class='car-reservation'>
					<label for="start">대여일</label> <input type="datetime-local" id="start-datetime"
						name="start-datetime"> <label for="end">반납일</label> <input
						type="datetime-local" id="end-datetime" name="end-datetime">
				</div>
			</div>

			<c:choose>
				<c:when test="${not empty user }">
					<input type='submit' value="예약하기">
				</c:when>

			</c:choose>
		</form>
	</div>
	<script src="/resources/script/validation-reservation.js"></script>

</body>
</html>