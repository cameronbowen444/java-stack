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
	<title>Insert title here</title>
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
	      		<a href="/dojos" class="btn btn-outline-primary" type="submit">Home</a>
	    	</form>
	  	</div>
	</nav>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-4 box">
				<h1>New Dojo</h1>
				<form:form action="/ninjas" method="post" modelAttribute="ninja">
					<div class="mb-3">
						<form:label class="form-label" path="firstName">First Name</form:label>
						<form:input type="text" path="firstName" class="form-control" />
						
						<form:label class="form-label" path="lastName">Last Name</form:label>
						<form:input type="text" path="lastName" class="form-control" />
						
						<form:label class="form-label" path="age">Age</form:label>
						<form:input type="text" path="age" class="form-control" />
						
						<form:label class="form-label" path="dojo">Choose Dojo</form:label>
						<form:select class="form-select" path="dojo">
						
							<c:forEach items="${dojos}" var="d">
								<option value="${d.id}"><c:out value="${d.location}"/></option>
							</c:forEach>
							
						</form:select>
						<input type="submit" class="btn btn-primary" value="Add Dojo" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>