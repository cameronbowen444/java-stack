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
	<title>Dojos and Ninjas</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
	  	<div class="container-fluid">
	   		<a class="navbar-brand">Dojos and Ninjas</a>
	    	<form class="d-flex">
	      		<a href="/ninjas/new" class="btn btn-outline-primary" type="submit">New Ninja</a>
	    	</form>
	  	</div>
	</nav>
	<div class="container">
		<div class="row justify-content-around">
			<div class="col-4 box">
				<h1>New Dojo</h1>
				<form:form action="/dojos" method="post" modelAttribute="dojo">
					<div class="mb-3">
						<form:label class="form-label" path="location">Dojo Location:</form:label>
						<form:errors path="location" />
						<form:input type="text" path="location" class="form-control" />
						<input type="submit" class="btn btn-primary" value="Add Dojo" />
					</div>
				</form:form>
			</div>
			<div class="col-4 box">
				<h1>All Dojos</h1>
				<div class="list-group" id="list-tab" role="tablist">
					<c:forEach items="${ dojos }" var="d">
						<a class="list-group-item list-group-item-action" href="/dojos/${ d.id }"><c:out value="${ d.location }"/></a>
					</c:forEach>
      			
    			</div>
			</div>
		</div>
	</div>
</body>
</html>