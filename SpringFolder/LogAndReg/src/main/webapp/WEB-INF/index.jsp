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
	<title>Login And Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Hello World</h1>
		<h5>Join our growing community</h5>
		
		<div class="row justify-content-around">
			<div class="col-4">
				<h1>Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div class="mb-3">
						<form:errors path="userName" class="error"/>
					    <form:label path="userName" class="form-label">User Name</form:label>
					    <form:input type="text" path="userName" class="form-control" />
					</div>
					<div class="mb-3">
						<form:errors path="email" class="error" />
					    <form:label path="email" class="form-label">Email</form:label>
					    <form:input type="text" path="email" class="form-control" />
					</div>
					<div class="mb-3">
						<form:errors path="password" class="error" />
					    <form:label path="password" class="form-label">Password</form:label>
					    <form:input type="password" path="password" class="form-control" />
					</div>
					<div class="mb-3">
						<form:errors path="confirm" class="error" />
					    <form:label path="confirm" class="form-label">Confirm Password</form:label>
					    <form:input type="password" path="confirm" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
			<div class="col-4">
				<h1>Login</h1>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<div class="mb-3">
						<form:errors path="email" class="error" />
					    <form:label path="email" class="form-label">Email</form:label>
					    <form:input type="text" path="email" class="form-control" />
					</div>
					<div class="mb-3">
						<form:errors path="password" class="error" />
					    <form:label path="password" class="form-label">Password</form:label>
					    <form:input type="password" path="password" class="form-control" />
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
		
	</div>
</body>
</html>