<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Languages</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>All Languages</h1>
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Creator</th>
					<th scope="col">Version</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ languages }" var="l">
				<tr>
					<td scope="row"><c:out value="${ l.id }"/></td>
					<td><a href="/languages/${l.id}"><c:out value="${ l.name }"/></a></td>
					<td><c:out value="${ l.creator }"/></td>
					<td><c:out value="${ l.version }"/></td>
					<td><a class="btn btn-primary" href="/edit/${l.id}">Edit</a> 
						<form:form action="/delete/${ l.id }" method="post">
							<input type="hidden" name="_method" value="delete" />
							<input type="submit" class="btn btn-primary" value="Delete" />
						</form:form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<form:form action="/languages" method="post" modelAttribute="language">
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
			<input type="submit" class="btn btn-primary" value="Create Language" />
		
		</form:form>
	</div>
</body>
</html>