<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<title>Insert title here</title>

</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="principal"/>
		</sec:authorize>
	<nav class="navbar navbar-expand-sm bg-danger navbar-dark mb-3">

		<div class="container mt-3">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="/">HOME(Board)</a>

			<!-- Links -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/board/insert">BoardInsert</a></li>
				<li class="nav-item"><a class="nav-link" href="/board/list">BoardList</a></li>
				<li class="nav-item"><a class="nav-link" href="/file/insert">FileInsert</a></li>
				<li class="nav-item"><a class="nav-link" href="/file/list">FileList</a></li>
				<li class="nav-item"><a class="nav-link" href="/file2/insert">FileInsert2</a></li>
				<li class="nav-item"><a class="nav-link" href="/file2/list">FileList2</a></li>
			</ul>

			<ul class="navbar-nav">
			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="/join">회원가입</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item">
				<a class="nav-link" href="/logout">
				로그아웃(<sec:authentication property="principal.user.username"/>)</a></li>
			</sec:authorize>
			</ul>
			
		</div>
	</nav>