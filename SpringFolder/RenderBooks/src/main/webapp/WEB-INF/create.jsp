<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Book</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="title">New Books</h1>
	<div class="container box">
		 <div class="row justify-content-center">
		 	<div class="col-4">
		      <form:form action="/create" method="post" modelAttribute="book">
		      		<div class="mb-3">
					    <form:label path="title" class="form-label">Title</form:label>
					    <form:errors path="title"/>
					    <form:input type="text" path="title" class="form-control" />
					</div>
					<div class="mb-3">
					    <form:label path="description" class="form-label">Description</form:label>
					    <form:errors path="description"/>
					    <form:input type="text" path="description" class="form-control" />
					</div>
					<div class="mb-3">
					    <form:label path="language" class="form-label">Language</form:label>
					    <form:errors path="language"/>
					    <form:input type="text" path="language" class="form-control"/>
					</div>
					<div class="mb-3">
					    <form:label path="numberOfPages" class="form-label">Number Of Pages</form:label>
					    <form:errors path="numberOfPages" />
					    <form:input type="number" path="numberOfPages" class="form-control"/>
					</div>
					<input type="submit" class="btn btn-primary" value="Create Book" />
		      </form:form>
			</div>
		  </div>
	</div>
	<a class="btn btn-primary home" href="/books">Home Page</a>
</body>
</html>