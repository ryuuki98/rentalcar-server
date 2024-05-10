<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="rentalcarServer.board.model.BoardResponseDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 페이지</title>
<link rel="stylesheet" href="/resources/style/board.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<div class="page-header">
		<h1 style="float: left; margin: 0;">게시판 페이지</h1>
		<c:if test="${not empty user }">
		<a href="/writeBoard" class="btn-write" style="float: right;">글쓰기</a>
		</c:if>
	</div>
	
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td><c:if test="${board.admin}">공지</c:if><c:if test="${!board.admin}">${board.boardCode}</c:if></td>
			<td>${board.userId}</td>
			<td>
				<a href="/detail?boardCode=${board.boardCode}">
					${board.title}
				</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
<jsp:include page="/footer"></jsp:include>
</html>
