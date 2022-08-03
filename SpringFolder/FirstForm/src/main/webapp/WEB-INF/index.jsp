<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>First Form</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Fill The Form NOW!</h1>
	<div class="container">
		<form action="/login" method="post">
		  <div class="mb-3">
		    <label for="exampleInputEmail1" class="form-label">Email</label>
		    <input type="text" class="form-control" name="email">
		  </div>
		  <div class="mb-3">
		    <label for="exampleInputPassword1" class="form-label">Password</label>
		    <input type="password" class="form-control" name="password">
		  </div>
		  <input type="submit" class="btn btn-primary"/>
		</form>
	</div>
</body>
</html>