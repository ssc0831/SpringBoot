<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container">
<form action="login" id="frm">
		<div class="form-group">
			<label for="id">ID:</label> <input type="text"
				class="form-control" id="id" placeholder="Enter id"
				name="id">
		</div>
		<div class="form-group">
			<label for="pass">Password:</label> <input type="password"
				class="form-control" id="pass" placeholder="Enter password"
				name="pass">
		</div>
	<div>
	<button type="button" class="btn btn-secondary" id="submit">submit로그인</button>
	<button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
	</div>
	</form>
</div>

	<script>
	$('#submit').click(function() {
		$.ajax({
			type:'post',
			url:'member/loginSubmit',
			data: $('#frm').serialize()//({'id':$('#id').val(), 'pass': $('#pass').val()})
	
		})
		.done(function(resp) {
			// alert(resp) //no, success, error
			if (resp=="no") {
				alert('회원이 아닙니다. 회원가입 하세요.')
				location.href="/member/join"
			}else if (resp=='success') {
				alert('로그인 성공.')
				location.href="/"
			}else {
				alert('비밀번호를 확인하세요.')
			}
		})
		.fail(function(resp) {
			alert('로그인 실패')
		})
		
	})
	$('#btnLogin').click(function() {
		$.ajax({
			type:'post',
			url:'/member/login',
			contentType:"application/json; charset=utf-8",
			data: JSON.stringify({'id':$('#id').val(), 'pass': $('#pass').val()})
	
		})
		.done(function(resp) {
			// alert(resp) //no, success, error
			if (resp=="no") {
				alert('회원이 아닙니다. 회원가입 하세요.')
				location.href="/member/join"
			}else if (resp=='success') {
				alert('로그인 성공.')
				location.href="/"
			}else {
				alert('비밀번호를 확인하세요.')
			}
		})
		.fail(function() {
			alert('로그인 실패');
		})
	})
	
	</script>


<%@ include file="../include/footer.jsp"%>
