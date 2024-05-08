<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>My Board</title>
<link rel="stylesheet" href="/resources/style/header.css">

</head>
<body>
	<header>
		<div class="logo" onclick="location.href ='/index.jsp'">렌트다 렌트</div>
		<nav>
			<a href="/car-rental">차량대여</a> 
			<a href="/boardAction">게시판</a>
			<c:choose>
				<c:when test="${not empty user}">
					<a href="/logoutAction">로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href="/login">로그인</a>
				</c:otherwise>
			</c:choose>
		</nav>
	</header>
</body>
</html>
