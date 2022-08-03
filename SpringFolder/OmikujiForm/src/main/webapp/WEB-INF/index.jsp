<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays" import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Form</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="head">Send an Omikuji!</h1>
	<div class="container">
		<form action="/form" method="post">
			<div class="mb-3">
				<label for="select" class="form-label">Pick a number from 5-25</label>
				<input type="number" name="number" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any city.</label>
			   	<input type="text" name="city" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter The name of any real person.</label>
			   	<input type="text" name="person" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter professional endeavor or hobby.</label>
			   	<input type="text" name="action" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Enter any type of living thing.</label>
			   	<input type="text" name="living" class="form-control">
			</div>
			<div class="mb-3">
				<label class="form-label">Say Something nice to someone:</label>
			   	<textarea name="comment" class="form-control" rows="5"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>