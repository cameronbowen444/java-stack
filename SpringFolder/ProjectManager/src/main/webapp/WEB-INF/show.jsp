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
	<title>Project Details</title>
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
		<h1>Project Details</h1>
		<dl class="row">
		
  			<dt class="col-sm-3">Title:</dt>
  			<dd class="col-sm-9"><c:out value="${ project.title }"/></dd>
  			
  			<dt class="col-sm-3">Description</dt>
  			<dd class="col-sm-9"><c:out value="${ project.description }"/></dd>

  			<dt class="col-sm-3">Due Date:</dt>
  			<dd class="col-sm-9"><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd, yyyy"/></dd>
  			
		</dl>
		<a class="btn btn-primary" href="/projects/${project.id}/tasks">See Tasks</a>
		<c:if test = "${project.lead.id==userId}">
    		<a class="btn btn-primary" href="/projects/delete/${project.id}">Delete Project</a>
		</c:if>
	</div>
</body>
</html>