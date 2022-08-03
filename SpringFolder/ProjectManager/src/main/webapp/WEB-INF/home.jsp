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
	<title>Project Manager Dashboard</title>
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
      			<a href="/projects/new" class="btn1 btn btn-outline-primary" >+ New Project</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" >Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h3>All Projects</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Project</th>
      				<th scope="col">Team Lead</th>
      				<th scope="col">Due Date</th>
      				<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${unassignedProjects}" var="un">
				<tr>
					<th scope="row"><a href="/projects/${un.id}">${un.title}</a></th>
      				<td><c:out value="${ un.lead.firstName }" /></td>
      				<td><fmt:formatDate value="${un.dueDate}" pattern="MMMM dd"/></td>
      				<td><a href="/dashboard/join/${un.id}">Join Team</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h3>Your Projects</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Project</th>
      				<th scope="col">Team Lead</th>
      				<th scope="col">Due Date</th>
      				<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assignedProjects}" var="pro">
				<tr>
					<th scope="row"><a href="/projects/${pro.id}">${pro.title}</a></th>
      				<td><c:out value="${ pro.lead.firstName }" /></td>
      				<td><fmt:formatDate value="${pro.dueDate}" pattern="MMMM dd"/></td>
      				<c:if test = "${pro.lead.id==user.id}">
		       			<td>	<a href="/projects/edit/${pro.id}">Edit Project</a></td>
		    		</c:if>
		    		<c:if test = "${pro.lead.id!=user.id}">
		       			<td><a href="/dashboard/leave/${pro.id}">Leave Team</a></td>
		    		</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>