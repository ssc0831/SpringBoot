<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container">
	<form action="join" id="frm" method="post">
		<div class="form-group">
			<label for="name">Name:</label> <input type="text"
				class="form-control" id="name" placeholder="Enter Name" name="name">
		</div>
		<div class="row">
			<div class="col">
				<label for="id">UserID:</label> <input type="text"
					class="form-control" id="id" placeholder="Enter UserID"
					name="id" >
			</div>
			<div class="col align-self-end">
			<!-- 	<button type="button" class="btn btn-primary" id="idCheckBtn">중복확인</button> -->
			<span id="idcheck"></span>
			</div>
		</div>
		<div class="form-group">
			<label for="pass">Password:</label> <input type="password"
				class="form-control" id="pass" placeholder="Enter password"
				name="pass">
		</div>
		<div class="form-group">
			<label for="pass_check">Password_Check:</label> <input type="password"
				class="form-control" id="pass_check"
				placeholder="Enter password_check" name="pass_check">
		</div>
		<div class="form-group">
			<label for="addr">Address:</label> <input type="text"
				class="form-control" id="addr" placeholder="Enter Address"
				name="addr">
		</div>
		<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
	</form>
</div>
<script>
$("#btnJoin").click(function(){
	//유효성검사
	if($("#name").val()==""){
		alert("이름을 입력하세요");
		$("#name").focus();
		return false;
	}
	if($("#id").val()==""){
		alert("아이디를 입력하세요");
		$("#id").focus();
		return false;
	}
	if($("#pass").val()==""){
		alert("비밀번호를 입력하세요");
		$("#pass").focus();
		return false;
	}
	if($("#pass").val()!=$("#pass_check").val()){
		alert("비번이 맞지 않습니다.");
		$("#pass_check").focus();
		return false;
	}
	if($("#addr").val()==""){
		alert("주소를 입력하세요");
		$("#addr").focus();
		return false;
	}
	data = {
			id : $("#id").val(),
			name : $("#name").val(),
			pass : $("#pass").val(),
			addr : $("#addr").val()
	}
   $.ajax({
	   type: "post",
	   url: "/member/join",
	   contentType : "application/json;charset=utf-8",
	   data:JSON.stringify(data)
   })
   .done(function(resp){
	   if(resp=="success"){
		   alert("회원가입을 축하합니다.")
		   $("#idcheck").html("")
		   location.href="login"
	   }else if(resp=="fail"){
		  // alert("아이디 중복확인 하세요")
		  $("#idcheck").html("<b>아이디 중복확인 하세요</b>")
		  $("#id").val("");
	   }
   })
   .fail(function(e){
	   alert("회원가입실패")
   })
})

</script>
<%@ include file="../include/footer.jsp"%>
