<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/joinForm.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section id="root">
		<h2>회원가입</h2>
		<form method="POST" action="/joinFormAction">
			<div>
				<input type="text" id="id" name="id" placeholder="아이디"> <input
					type="password" id="password" name="password" placeholder="비밀번호">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-id">* 아이디: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
			</div>
			<div>
				<input type="text" id="name" name="name" placeholder="이름"> <input
					type="text" id="birth" name="birth" placeholder="생년월일 8자리">
				<select id="telecom" name="telecom">
					<option selected disabled>통신사 선택</option>
					<option value="skt">SKT</option>
					<option value="kt">KT</option>
					<option value="lg">LGU+</option>
				</select> <input type="text" id="phone" name="phone" placeholder="휴대전화번호">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-name">* 이름: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-birth">* 생년월일: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-birth-pattern">* 생년월일은 8자리
					숫자로 입력해 주세요.</p>
				<p class="error-msg" id="error-msg-telecom">* 통신사: 이용하는 통신사를 선택해
					주세요.</p>
				<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호:
					휴대전화번호는 하이픈 없이 11자리로 입력 해주십시요.</p>
			</div>
			<input type="submit" value="회원가입">
		</form>
	</section>
	<script src="/resources/script/validation-join.js"></script>
	
</body>
<jsp:include page="/footer"></jsp:include>
</html>