<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container mt-3">
	<h2>게시판(${count })</h2>
	<!-- <div class="form-group text-right">
		<a href="/board/insert">
			<button type="button" class="btn btn-secondary btn-sm" id="writeBtn">글쓰기</button>
		</a>
	</div> -->

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
	<tbody>
    <c:forEach items="${boards}" var="board" varStatus="st">
        <tr>
            <td>${board.boardid}</td>
            <td><a href="/board/view/${board.boardid}">${board.title }[${board.replycnt }]</a></td>
            <td>${board.member.username}</td>
            <td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd" /></td>
            <td>${board.hitcount }</td>
        </tr>
    </c:forEach>
</tbody>
	
	</table>
	<div class="d-flex justify-content-between mt-5 mr-auto">
		<ul class="pagination">
				<li class="page-item">이전</li>
				<li class="page-item">다음</li>
			
		</ul>
		<form class="form-inline" action="/board/list" method="get">
			<select name='field' class="form-control mr-sm-1">
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select> <input type='text' name='word' class="form-control"
				placeholder="Search">
			<button class='btn btn-secondary'>Search</button>
		</form>
	</div>
</div>
