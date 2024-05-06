<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<c:import url="/header"/>
<script src="/resources/script/validation-delete.js"></script>
<body>
	<section id="root">
		<h2>회원탈퇴</h2>
		<form method="POST" action="/deleteFormAction">
			<div>
				<input type="password" id="password" name="password" placeholder="비밀번호">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
			</div>
			
			<input type="submit" value="회원탈퇴">
		</form>
	</section>
</body>
<c:import url="/footer"></c:import>
</html>