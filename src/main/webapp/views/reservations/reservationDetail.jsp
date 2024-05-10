<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 상세</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<h1>예약 상세보기</h1>
	<p>예약번호: ${reservation.reservationNum}</p>
	<p>사용자 ID: ${reservation.userId}</p>
	<p>차량명: ${reservation.carName}</p>
	<p>차량 가격: ${reservation.carPrice} 원</p>
	<p>
		대여 일시:
		<fmt:formatDate value="${reservation.borrowDate}"
			pattern="yyyy-MM-dd HH:mm" />
	</p>
	<p>
		반납 일시:
		<fmt:formatDate value="${reservation.returnDate}"
			pattern="yyyy-MM-dd HH:mm" />
	</p>
	<p>상태: ${reservation.status}</p>
	
	
		<button onclick="location.href = '/myReservationAction'">내 예약목록</button>
	
	<c:if test="${reservation.status eq '예약중'}">
	<form action="/moveUpdateReservationForm" method="post">
		<input type="hidden" name="reservationNum" value="${reservation.reservationNum}">
		<button type="submit">수정</button>
	</form>
	</c:if>
	
	<c:if test="${reservation.status eq '예약중' }">
	<form action="/deleteReservationAction" method="post">
		<input type="hidden" name="reservationNum" value="${reservation.reservationNum}">
		<button type="submit">예약취소</button>
	</form>
	</c:if>

	<jsp:include page="/footer"></jsp:include>
</body>
</html>
