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
        UserDao instance = UserDao.getInstance();
        UserRequestDto userDto = new UserRequestDto();
        userDto.setUserId("fdsq");
        userDto.setUserPassword("fdsfs");
        userDto.setUserName("fds");
        userDto.setUserBirth("20001102");
        userDto.setUserTelecom("skt");
        userDto.setUserPhone("01012311231");
        userDto.setAdmin(false);
        instance.createUser(userDto);
    %>

</body>
</html>