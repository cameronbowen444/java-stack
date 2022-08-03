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
	<title>Show Book</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.name }" /></a>
    		<form class="d-flex">
      			<a href="/books" class="btn1 btn btn-outline-primary" type="submit">Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" type="submit">Logout</a>
   			</form>
  		</div>
	</nav>
	<div class="container">
		<h1><c:out value="${ book.title }"/></h1>
		<br />
		<h5>
			<span class="name"><c:out value="${ book.user.name }"/></span> read 
			<span class="title"><c:out value="${ book.title }"/></span> by 
			<span class="author"><c:out value="${ book.author }"/></span>
		</h5>
		<h5>Here are <c:out value="${ book.user.name }"/> thoughts:</h5>
		<br />
    	<c:out value="${ book.myThoughts }"/>
    	<br />
    	<c:choose>
    		<c:when test="${user.id == book.user.id }">
    			<a class="btn btn-primary" href="/books/${ book.id }/edit">Edit</a>
    		</c:when>
    		<c:otherwise>
    			<a class="btn btn-primary" href="#">Cannot Edit</a>
    		</c:otherwise>
    	</c:choose>
	</div>
</body>
</html>