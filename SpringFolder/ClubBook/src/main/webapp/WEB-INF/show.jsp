<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<!-- Formatting (dates) --> 
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<!-- form:form -->
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<!-- for rendering errors on PUT routes -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
  		<div class="container-fluid">
    		<a class="navbar-brand">Welcome, <c:out value="${ user.userName }"/></a>
    		<form class="d-flex">
    			<a href="/dashboard" class="btn1 btn btn-outline-primary" type="submit">Home</a>
      			<a href="/logout" class="btn1 btn btn-outline-primary" type="submit">Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<h1><c:out value="${ book.title }"/></h1>
		<br />
		<h5>
			<span class="name"><c:out value="${ book.user.userName }"/></span> read 
			<span class="title"><c:out value="${ book.title }"/></span> by 
			<span class="author"><c:out value="${ book.author }"/></span>
		</h5>
		<h5>Here are <c:out value="${ book.user.userName }"/> thoughts:</h5>
		<br />
    	<c:out value="${ book.thoughts }"/>
		<a class="btn btn-primary" href="/edit/${ book.id }">Edit</a>
	</div>
</body>
</html>