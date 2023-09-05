<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="include/header.jsp"%>


<div class="container mt-3">
<form action="login" method="post">
		<div class="form-group">
		<label for="username">ID:</label> 
		<input type="text" class="form-control"
			id="username" placeholder="Enter id" name="username">
	</div>
	<div class="form-group">
		<label for="pass">Password:</label>
		<input type="password" class="form-control"
			id="pass" name="password" placeholder="Enter Password">
	</div>
	
	<br />
		<div>
		<button type="submit" class="btn btn-primary">로그인</button>
		</div>
</form>
</div>


<%@ include file="include/footer.jsp"%>



