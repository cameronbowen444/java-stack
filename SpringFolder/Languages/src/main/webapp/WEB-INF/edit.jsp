<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Language</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Test</h1>
		<form:form action="/edit/${language.id}" method="post" modelAttribute="language">
			<input type="hidden" name="_method" value="put" />
			<div class="mb-3">
				<form:label class="form-label" path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input class="form-control" path="name"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="creator">Creator</form:label>
				<form:errors path="creator"/>
				<form:input class="form-control" path="creator"/>
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="version">Version</form:label>
				<form:errors path="version"/>
				<form:input class="form-control" path="version"/>
			</div>
			<input type="submit" class="btn btn-primary" value="Update Language" />
		</form:form>
	</div>
</body>
</html>