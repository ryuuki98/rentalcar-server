<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
    <style>
        /* 폼 스타일 */
        form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<jsp:include page="/header"></jsp:include>
<body>
    <h1>글쓰기</h1>
    <form action="/writeBoardAction" method="POST">
        <label for="title">제목</label>
        <input type="text" id="title" name="title">

        <label for="content">내용</label>
        <textarea id="content" name="content" rows="8"></textarea>

        <input type="submit" value="작성">
    </form>
</body>
<jsp:include page="/footer"></jsp:include>
</html>
