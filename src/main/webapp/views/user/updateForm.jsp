<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/style/form.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
	<section id="root">
		<h2>회원정보 수정</h2>
		<form method="POST" action="/updateFormAction">
			<div>
				<input type="text" id="id" name="id" placeholder="아이디" value="${user.userId}" readonly="readonly"> 
				<input type="password" id="password" name="password" placeholder="비밀번호" ">
				<input type="password" id="password-new" name="password-new" placeholder="새로운 비밀번호">
				
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-id">* 아이디: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-id-dupl">아이디: 중복된 아이디입니다.</p>
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
			</div>
			<div>
				<input type="text" id="name" name="name" placeholder="이름" value="${user.userName }"> <input
					type="text" id="birth" name="birth" placeholder="생년월일 8자리" value="${user.userBirth }">
				<select id="telecom" name="telecom">
					<option selected disabled>통신사 선택</option>
					<option value="skt"${user.userTelecom eq 'skt' ? 'selected' : ''}>SKT</option>
					<option value="kt"${user.userTelecom eq 'kt' ? 'selected' : ''}>KT</option>
					<option value="lgt"${user.userTelecom eq 'lgt' ? 'selected' : ''}>LGU+</option>
				</select> <input type="text" id="phone" name="phone" placeholder="휴대전화번호"value="${user.userPhone }">
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
			<input type="submit" value="수정">
		</form>
	</section>
	<script src="/resources/script/validation-join.js"></script>
	<script src="/resources/script/validation-id.js"></script>
	
	
	
</body>
<jsp:include page="/footer"></jsp:include>
</html>