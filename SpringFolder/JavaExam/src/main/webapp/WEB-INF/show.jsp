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
	<title>Tv Show</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.name }"/></a>
    		<form class="d-flex">
      			<a href="/shows" class="btn1 btn btn-outline-primary" >Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" >Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h1>Project Details</h1>
		<dl class="row">
		
  			<dt class="col-sm-3">TV Show:</dt>
  			<dd class="col-sm-9"><c:out value="${ show.title }"/></dd>
  			
  			<dt class="col-sm-3">Network:</dt>
  			<dd class="col-sm-9"><c:out value="${ show.network }"/></dd>
  			
  			<dt class="col-sm-3">Description</dt>
  			<dd class="col-sm-9"><c:out value="${ show.description }"/></dd>

		</dl>
		<c:choose>
    		<c:when test="${user.id == show.user.id }">
    			<a class="btn btn-primary" href="/shows/${show.id}/edit">Edit</a>
    		</c:when>
    		<c:otherwise>
    			<a class="btn btn-primary" href="#">Cannot Edit</a>
    		</c:otherwise>
    	</c:choose>
		
	</div>
</body>
</html>