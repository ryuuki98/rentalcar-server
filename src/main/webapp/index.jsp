<%@page import="rentalcarServer.cars.model.CarsResponseDto"%>
<%@page import="java.util.List"%>
<%@page import="rentalcarServer.cars.model.CarsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/header" />
<body>
<% CarsDao carsDao = CarsDao.getInstance();
List<CarsResponseDto> list = carsDao.findCarsAll();

for(int i = 0; i < list.size(); i++){
	System.out.println(list.get(i));
}
%>
</body>
<jsp:include page="/footer" />

</html>