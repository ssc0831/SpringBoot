<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container">
<form id="frm" method="post">
		<div class="form-group">
			<label for="id">ID:</label> <input type="text"
				class="form-control" id="id"  value="${sMember.id}"
				name="id" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="pass">Password:</label> <input type="password"
				class="form-control" id="pass" value="${sMember.pass}"
				name="pass">
		</div>
		
		<div class="form-group">
			<label for="addr">addr:</label> <input type="text"
				class="form-control" id="addr" value="${sMember.addr}"
				name="addr">
		</div>
		
	<div>
	<button type="button" class="btn btn-secondary" id="btnUpdate">수정</button>
	<button type="reset" class="btn btn-primary" id="reset">수정취소</button>
	</div>
	</form>
</div>

	<script>
	$('#btnUpdate').click(function() {
		let data={
				'name':$('#name').val(),
				'id':$('#id').val(),
				'pass':$('#pass').val(),
				'passCheck':$('#pass').val()
		};
		$.ajax({
			type:'put',
			url:'/member/update',
			contentType:"application/json; charset=utf-8",
			data: JSON.stringify(data)
		})
		.done(function(resp) {
			if (resp=="success") {
				alert('회원변경 성공.')
				location.href="/member/login"
			}
		})
		.fail(function(e) {
			alert('회원변경 실패' + e)
		})
		
	})
	</script>


<%@ include file="../include/footer.jsp"%>
