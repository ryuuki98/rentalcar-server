<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="rentalcarServer.cars.model.CarsResponseDto"%>
<%@page import="java.util.List"%>
<%@page import="rentalcarServer.cars.model.CarsDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카 사이트</title>
<link rel="stylesheet" type="text/css" href="/resources/style/index.css">
</head>
<body>

<jsp:include page="/header" />

<form action="/searchCarsAction" method="POST">
    <div class="form-group">
        <label for="start-datetime">대여 날짜 및 시간</label>
        <input type="datetime-local" class="form-control" id="start-datetime" name="start-datetime">
    </div>
    <div class="form-group">
        <label for="end-datetime">반납 날짜 및 시간</label>
        <input type="datetime-local" class="form-control" id="end-datetime" name="end-datetime">
    </div>
    <button type="submit" class="btn btn-primary">검색</button>
</form>


<jsp:include page="/footer" />

<script src="/resources/script/validation-dateTime.js"></script>

</body>
</html>


