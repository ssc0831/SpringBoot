<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="container mt-3">
  <form action="insert" method="post">
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <div class="form-group">
      <label for="pwd">글쓴이:</label>
      <input type="text" class="form-control" id="writer" 
      placeholder="Enter writer" name="writer" value='<sec:authentication property="principal.user.username"/>'
      readonly="readonly" >
    </div>
      <div class="form-group">
      <label for="content">내용</label>
     <textarea class="form-control" rows="5" id="content" name="content"></textarea>
    </div>
    <div class="form-group text-right">
      <button type="submit" class="btn btn-primary btn-sm">Submit</button>
     </div> 
  </form>
</div> 