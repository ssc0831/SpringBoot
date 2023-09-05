<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container mt-3">

	<div class="form-group">
		<label for="username">UserName:</label> <input type="text" class="form-control"
			id="username" placeholder="Enter id" name="username">
	</div>
	<div class="form-group">
		<label for="password">Password:</label> <input type="password"
			class="form-control" id="password" placeholder="Enter password"
			name="password">
	</div>
	
	<div class="form-group">
		<label for="email">Email:</label> <input type="text"
			class="form-control" id="email" placeholder="Enter email"
			name="email">
	</div>
	
	
	
  <button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>

</div>

<script>
$("#btnJoin").click(function(){
	// 유효성 검사
	if($("#username").val() === ""){
	alert("이름을 입력하세요");
	$("#username").focus();
	return false;
	}
	if($("#password").val() === ""){
		alert("비밀번호를 입력하세요");
		$("#password").focus();
		return false;
	}

	if($("#email").val() === ""){
		alert("이메일을 입력하세요");
		$("#email").focus();
		return false;
	}

	let dataParam = {
		username: $('#username').val(),
		password: $('#password').val(),
		email: $('#email').val()
	};

	$.ajax({
		type: 'post',
		url: '/join',
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(dataParam)
	}).done(function(resp){
		if(resp === "success"){
			alert('회원가입 성공');
			location.href = '/login';
		} else if(resp === "fail"){
			alert('아이디 중복');
			$('#username').val("");
		}
	}).fail(function(){
		alert('회원가입 실패');
	});
});

</script>

<%@ include file="../include/footer.jsp"%>







