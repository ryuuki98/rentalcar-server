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
		<a href="/writeBoard" class="btn-write" style="float: right;">글쓰기</a>
	</div>
	
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
		</tr>
		<%
		List<BoardResponseDto> list = (List)session.getAttribute("list");
		for(BoardResponseDto board : list) {
		%>
		<tr>
			<td><%=board.getBoardCode()%></td>
			<td><%=board.getUserId()%></td>
			<td>
				<a href="/detail?boardCode=<%=board.getBoardCode()%>">
					<%=board.getTitle()%>
				</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
<jsp:include page="/footer"></jsp:include>
</html>
