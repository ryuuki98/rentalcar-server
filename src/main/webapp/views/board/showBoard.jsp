<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세 보기</title>
<link rel="stylesheet" href="/resources/style/showBoard.css">
</head>
<jsp:include page="/header"></jsp:include>
<body>
    <div class="container">
        <div class="header">
            <p><strong>게시물 번호:</strong> ${board.boardCode}</p>
            <p><strong>작성자:</strong> ${board.userId}</p>
        </div>
        <div class="content">
            <h1>${board.title}</h1>
            <p>${board.content}</p>
               <form action="/moveUpdateFormAction" method="post">
                <input type="hidden" name="boardCode" value="${board.boardCode}">
                <button type="submit">수정</button>
            </form>
            <!-- 삭제 버튼 -->
            <form action="/deleteBoardAction" method="post">
                <input type="hidden" name="boardCode" value="${board.boardCode}">
                <button type="submit">삭제</button>
            </form>
        </div>
    </div>
    <jsp:include page="/footer"></jsp:include>
</body>
</html>
