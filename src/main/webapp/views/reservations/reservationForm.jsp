<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>예약 확인 및 결제 페이지</title>
</head>
<jsp:include page="/header"></jsp:include>
<body>
    <h1>예약 내용 확인</h1>

    <div>
        <h2>차량 정보</h2>
        <p>브랜드: ${car.carBrand}</p>
        <p>차량명: ${car.carName}</p>
        <p>가격: ${car.carPrice} 원/시간</p>
    </div>

    <div>
        <h2>대여 정보</h2>
        <p>대여 일시: ${requestScope.startDateTime}</p>
        <p>반납 일시: ${requestScope.endDateTime}</p>
    </div>

    <div>
        <h2>사용자 정보</h2>
        <p>사용자 이름: ${user.userName}</p>
    </div>

    <form action="/payment" method="POST">
        <!-- 여기에 결제 관련 필드를 추가하세요 -->
        <input type="submit" value="결제">
    </form>
    <jsp:include page="/footer"></jsp:include>
</body>
</html>
