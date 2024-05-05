<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>My Board</title>
</head>
<body>
	<header>
		<h1>My Board</h1>
		
		<c:choose>
			<c:when test="${not empty user }">
		<button onclick="location.href = '/logoutAction'">로그아웃</button>			
			</c:when>
			<c:otherwise>
		<button onclick="location.href = '/login'">로그인</button>			
			</c:otherwise>
		</c:choose>
	</header>
</body>
</html>