<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.7.0.js">
</script>
<body>
<h1>UPDATE</h1>
ID : <input type="text" id="id" name="id" value="${member.id}" readonly="readonly">
Name : <input type="text" id="name" name="name" value="${member.name}"/><br/>
Password : <input type="password" id="password" name="password" value="${member.password}"/><br/>
Email : <input type="text" name="email" id="email" value="${member.email}"/><br/>
Addr : <input type="text" name="addr" id="addr" size="30" value="${member.addr}"/><br/>
Memo : <textarea rows="5" cols="50" name="memo" id="memo">${member.memo}</textarea><br/>
<button type="button" id="btnUpdate">수정하기</button>
<script src="/js/member.js">
</script>
</body>
</html>