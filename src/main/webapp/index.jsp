<%@page import="rentalcarServer.board.model.BoardRequestDto"%>
<%@page import="rentalcarServer.board.model.BoardResponseDto"%>
<%@page import="java.util.List"%>
<%@page import="rentalcarServer.board.model.BoardDao"%>
<%@page import="rentalcarServer.user.model.UserRequestDto"%>
<%@page import="rentalcarServer.user.model.UserDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="rentalcarServer.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BoardDao boardDao = BoardDao.getInstance();

BoardRequestDto boardRequestDto = new BoardRequestDto();
boardRequestDto.setUserId("aaaa");
boardRequestDto.setTitle("들어가져라 얍");
boardRequestDto.setContent("들어가졌구연 wwww");

boardDao.createBoard(boardRequestDto);


List<BoardResponseDto> list = boardDao.findBoardAll();

for(int i = 0 ; i < list.size(); i++){
	System.out.println(list.get(i));
}
%>
</body>
</html>