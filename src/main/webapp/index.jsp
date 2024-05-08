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

<form action="">
    <div class="form-group">
        <label for="start-date">대여 일자</label>
        <input type="datetime-local" class="form-control" id="start-date" name="start-date">
    </div>
    <div class="form-group">
        <label for="end-date">반납 일자</label>
        <input type="datetime-local" class="form-control" id="end-date" name="end-date">
    </div>
    <button type="submit" class="btn btn-primary">검색</button>
</form>

<div id="car-list" class="row">
    <!-- 차량 목록 출력 -->
    <% CarsDao carsDao = CarsDao.getInstance();
    List<CarsResponseDto> list = carsDao.findCarsAll();

    for (CarsResponseDto car : list) { %>
        <div class="col-md-6 col-lg-4 mb-4">
            <div class="listing d-block align-items-stretch">
                <div class="listing-img h-100 mr-4">
                    <img src="<%= car.getImageUrl() %>" alt="차량 이미지" class="img-fluid">
                </div>
                <div class="listing-contents h-100">
                    <h3><%= car.getCarName() %></h3>
                    <div class="rent-price">
                        <strong><%= car.getCarPrice() %>원</strong><span class="mx-1">/</span>시간당
                    </div>
                    <div class="d-block d-md-flex mb-3 border-bottom pb-3">
                        <div class="listing-feature pr-4">
                            <span class="caption">좌석 수 : </span>
                            <span class="number"><%= car.getCarSeat() %></span>
                        </div>
                        <div class="listing-feature pr-4">
                            <span class="caption">연료 : </span>
                            <span class="number"><%= car.getCarOil() %></span>
                        </div>
                    </div>
                    <div>
                        <p><a href="/moveReservationAction?carCode=<%=car.getCarCode() %>" class="btn btn-primary btn-sm">예약</a></p>
                    </div>
                </div>
            </div>
        </div>
    <% } %>
</div>


<jsp:include page="/footer" />

</body>
</html>


