<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/style/searchDate.css">
</head>
<body>
	<form action="/searchCarsAction" method="POST">
		<div class="form-group">
			<label for="start-datetime">대여 날짜 및 시간</label> <input
				type="datetime-local" class="form-control" id="start-datetime"
				name="start-datetime">
		</div>
		<div class="form-group">
			<label for="end-datetime">반납 날짜 및 시간</label> <input
				type="datetime-local" class="form-control" id="end-datetime"
				name="end-datetime">
		</div>
		<button type="submit" class="btn btn-primary">검색</button>
	</form>
	<script src="/resources/script/validation-dateTime.js"></script>

</body>
</html>