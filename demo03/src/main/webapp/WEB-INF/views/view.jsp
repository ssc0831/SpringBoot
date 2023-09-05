<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>VIEW</h1>
	아이디 : ${member.id }<br/>
	이름 : ${member.name }<br/>
	이메일 : ${member.email }<br/>
	주소 : ${member.addr }<br/>
	메모 : ${member.memo }<br/>
	<a href="/update/${member.id }">수정</a>
</body>
</html>