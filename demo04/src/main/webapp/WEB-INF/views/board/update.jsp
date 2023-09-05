<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container mt-3">
	<h3>${board.user.username }의글보기</h3>
	<div class="form-group">
		<label for="num">글번호:</label> <input type="text" class="form-control"
			id="num" name="num" value="${board.num }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" value="${board.title }">
	</div>
	<div class="form-group">
		<label for="pwd">글쓴이:</label> <input type="text" class="form-control"
			id="writer" name="writer" value="${board.user.username }"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea class="form-control" rows="5" id="content" name="content">
		${board.content }</textarea>
	</div>
	<c:if test="${board.user.username == principal.user.username}">
		<div class="form-group text-right">
			<button type="button" class="btn btn-secondary btn-sm" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-danger btn-sm" id="btnDelete">삭제</button>
		</div>
	</c:if>
	</div>
<script>
//댓글 추가
	$("#btnUpdate").click(function(){		
		let data = {
			"num": $("#num").val(),
			"title": $("#title").val(),
			"content": $("#content").val()
		}
		
		$.ajax({
			type:'put',
			url:'/board/update/',
			contentType:"application/json; charset=utf-8",
			data: JSON.stringify(data)
		}).done(function(resp){
			alert("수정 성공")
			location.href="/board/list";
		})
		.fail(function(){
			alert("수정 실패");
		})
	})

</script>
