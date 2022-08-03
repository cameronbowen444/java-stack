<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Formatting (dates) --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<!-- form:form -->
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- for rendering errors on PUT routes -->
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Props Page</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.firstName }"/></a>
    		<form class="d-flex">
      			<a href="/home" class="btn1 btn btn-outline-primary" >Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" >Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h1><c:out value="${ project.title }"/></h1>
		<p>Project Team Lead: <c:out value="${ project.lead.firstName }"/></p>
		
		<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
			<div class="mb-3">
				<form:errors path="name" class="errors" />
				<form:label class="form-label" path="name">Add a task ticket for this team:</form:label>
				<form:textarea class="form-control" rows="3" path="name"></form:textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="Add Project" />
		</form:form>
		
		<hr>
		<c:forEach var="task" items="${tasks}">
			<h4>Added by <c:out value="${task.creator.firstName}"></c:out> at <fmt:formatDate value="${task.createdAt}" pattern="h:mm a MMMM dd"/>:</h4>
			<p><c:out value="${task.name}"></c:out></p>
		</c:forEach>
	</div>
</body>
</html>