<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Books</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1><c:out value="${ book.title }"/></h1>
		<h5>Description: <c:out value="${ book.description }"/></h5>
		<h5>Language: <c:out value="${ book.language }"/></h5>
		<h5>Number Of Pages: <c:out value="${ book.numberOfPages }"/></h5>
	</div>
</body>
</html>