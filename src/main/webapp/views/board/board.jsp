<%@page import="rentalcarServer.board.model.BoardResponseDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 페이지</title>
</head>
<body>
	<h1>게시판 페이지</h1>
	
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>
		</tr>
		<%
		List<BoardResponseDto> list = (List)session.getAttribute("list");
			for(BoardResponseDto board : list) {
		%>
		<tr>
			<td><%=board.getBoardCode()%></td>
			<td><%=board.getUserId()%></td>
			<td><%=board.getTitle()%></td>
			<td><%=board.getContent()%></td>
			<td><%=board.getRegDate()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>