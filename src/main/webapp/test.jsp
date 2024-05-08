<%@page import="java.sql.Timestamp"%>
<%@page import="rentalcarServer.reservations.model.ReservationsResponseDto"%>
<%@page import="rentalcarServer.reservations.model.ReservationsRequestDto"%>
<%@page import="rentalcarServer.reservations.model.ReservationsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
ReservationsDao reservationsDao = ReservationsDao.getInstance();

ReservationsRequestDto reservationsRequestDto = new ReservationsRequestDto();
reservationsRequestDto.setUserId("aaaa");
reservationsRequestDto.setCarCode(1000);
reservationsRequestDto.setCarPrice(100000);
Timestamp borrowDate = new Timestamp(System.currentTimeMillis());
reservationsRequestDto.setBorrowDate(borrowDate);
reservationsRequestDto.setReturnDate(borrowDate);

reservationsDao.createReservation(reservationsRequestDto);


%>

</body>
</html>