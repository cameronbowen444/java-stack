<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Books</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="create">
		<a class="btn btn-primary" href="/books/new">Add A Book</a>
	</div>
	<div class="container">
		<h1>Here Are All The Books!</h1>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
				    <th scope="col">Title</th>
				    <th scope="col">Language</th>
				    <th scope="col">Number Of Pages</th>
				    <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${books}" var="b">
			  	<tr>
			        <th scope="row"><c:out value="${ b.id }" /></th>
			        <td><c:out value="${ b.title }" /></td>
			        <td><c:out value="${ b.language }" /></td>
			        <td><c:out value="${ b.numberOfPages }" /></td>
			        <td><a class="btn btn-primary" href="/books/${b.id}" role="button">Show</a></td>
			    </tr>
			  </c:forEach>
			  </tbody>
		</table>
	</div>
</body>
</html>