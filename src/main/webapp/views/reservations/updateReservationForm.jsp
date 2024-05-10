<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 수정</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
    <h1>예약 수정</h1>
    <form action="/updateReservationAction" method="POST">
        <input type="hidden" id="reservationNum" name="reservationNum" value="${reservation.reservationNum}">
        <input type="hidden" id="carCode" name="carCode" value="${reservation.carCode}">
        
        <p>예약번호: ${reservation.reservationNum}</p>
        <p>사용자 ID: ${reservation.userId}</p>
        <p>차량명: ${reservation.carName}</p>
        
        <p>대여 일시: <input type="datetime-local" id="start-datetime" name="start-datetime" value="<fmt:formatDate value="${reservation.borrowDate}" pattern="yyyy-MM-dd'T'HH:mm"/>"/></p>
        <p>반납 일시: <input type="datetime-local" id="end-datetime" name="end-datetime" value="<fmt:formatDate value="${reservation.returnDate}" pattern="yyyy-MM-dd'T'HH:mm"/>"/></p>       
                
        <input type="submit" value="예약 수정">
    </form>
    
    <jsp:include page="/footer"></jsp:include>
    	<script src="/resources/script/vaildation-reservationForUpdate.js"></script>
</body>
</html>
