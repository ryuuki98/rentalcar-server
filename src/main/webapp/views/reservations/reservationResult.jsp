<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 결과</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
    <h1>예약 결과</h1>
        <p>예약이 성공적으로 완료되었습니다.</p>
        <p>예약번호: ${reservation.reservationNum}</p>
        <p>사용자 ID: ${reservation.userId}</p>
        <p>차량명: ${reservation.carName}</p>
        <p>차량 가격: ${reservation.carPrice} 원</p>
        <p>대여 일시: <fmt:formatDate value="${reservation.borrowDate}" pattern="yyyy-MM-dd HH:mm"/></p>
        <p>반납 일시: <fmt:formatDate value="${reservation.returnDate}" pattern="yyyy-MM-dd HH:mm"/></p>
        <p>상태: ${reservation.status}</p>
        
    <jsp:include page="/footer"></jsp:include>
</body>
</html>
