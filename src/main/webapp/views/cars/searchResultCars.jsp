<%@page import="rentalcarServer.cars.model.CarsResponseDto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>렌트카 사이트</title>
    <link rel="stylesheet" type="text/css" href="/resources/style/index.css">
</head>
<body>

    <jsp:include page="/header" />
    <jsp:include page="/searchDate"/>

    <div id="car-list" class="row">
        <!-- 차량 목록 출력 -->
        <c:forEach var="car" items="${sessionScope.carList}">
            <div class="col-md-6 col-lg-4 mb-4">
                <div class="listing d-block align-items-stretch">
                    <div class="listing-img h-100 mr-4">
                        <img src="${car.imageUrl}" class="img-fluid">
                    </div>
                    <div class="listing-contents h-100">
                        <h3>${car.carName}</h3>
                        <div class="rent-price">
                            <strong>${car.carPrice}원</strong><span class="mx-1">/</span>시간당
                        </div>
                        <div class="d-block d-md-flex mb-3 border-bottom pb-3">
                            <div class="listing-feature pr-4">
                                <span class="caption">좌석 수 : </span> <span class="number">${car.carSeat}</span>
                            </div>
                            <div class="listing-feature pr-4">
                                <span class="caption">연료 : </span> <span class="number">${car.carOil}</span>
                            </div>
                        </div>
                        <div>
                            <p>
                                <a href="/moveCarsDetail?carCode=${car.carCode}"
                                   class="reservation">예약</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <jsp:include page="/footer" />

</body>
</html>
