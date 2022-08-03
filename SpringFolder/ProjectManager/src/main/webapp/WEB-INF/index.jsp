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
	<title>Project Manager</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Project Manager</h1>
		<p>A place for teams to manage projects</p>
		
		<div class="row justify-content-around">
			<div class="col-4">
				<h1>Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div class="mb-3">
						<form:errors path="firstName" class="errors" />
						<form:label class="form-label" path="firstName">First Name</form:label>
						<form:input class="form-control" type="text" path="firstName" />
					</div>
					<div class="mb-3">
						<form:errors path="lastName" class="errors" />
						<form:label class="form-label" path="lastName">Last Name</form:label>
						<form:input class="form-control" type="text" path="lastName" />
					</div>
					<div class="mb-3">
						<form:errors path="email" class="errors" />
						<form:label class="form-label" path="email">Email</form:label>
						<form:input class="form-control" type="text" path="email" />
					</div>
					<div class="mb-3">
						<form:errors path="password" class="errors" />
						<form:label class="form-label" path="password">Password</form:label>
						<form:input class="form-control" type="password" path="password"/>
					</div>
					<div class="mb-3">
						<form:errors path="confirm" class="errors" />
						<form:label class="form-label" path="confirm">Confirm Password</form:label>
						<form:input class="form-control" type="password" path="confirm"/>
					</div>
					<input type="submit" class="btn btn-primary" value="Register" />
				</form:form>
			</div>
			<div class="col-4">
				<h1>Login</h1>
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<div class="mb-3">
						<form:errors path="email" class="errors" />
						<form:label class="form-label" path="email">Email</form:label>
						<form:input class="form-control" type="text" path="email"/>
					</div>
					<div class="mb-3">
						<form:errors path="password" class="errors" />
						<form:label class="form-label" path="password">Password</form:label>
						<form:input class="form-control" type="password" path="password"/>
					</div>
					<input type="submit" class="btn btn-primary" value="Login" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>