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
	<title>Bookmarket</title>
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
      			<a href="/logout" class="btn1 btn btn-outline-primary" type="submit">Logout</a>
    		</form>
  		</div>
	</nav>
	<div class="container">
		<div class="shelf">
			<div class="t-head">
				<h5>Books From everyones Shelves:</h5>
				<a href="/new">+ Add a book to my shelf!</a>
			</div>
			<table class="table table-dark">
	  			<thead>
	    			<tr>
	      				<th scope="col">#</th>
	      				<th scope="col">Title</th>
	      				<th scope="col">Authors Name</th>
	      				<th scope="col">Actions</th>
	    			</tr>
	  			</thead>
	  			<tbody>
		  			<c:forEach items="${ books }" var="book">
		  			<tr>
	      				<th scope="row">${ book.id }</th>
	      				<td><a href="/show/${ book.id }">${ book.title }</a></td>
	      				<td>${ book.author }</td>
	      				<c:if test = "${book.user.id==user.id}">
			       			<td><a href="/books/edit/${book.id}">edit</a> <a href="/books/delete/${book.id}">delete</a></td>
			    		</c:if>
						<c:if test = "${book.user.id!=user.id}">
			       			<td><a href="/bookmarket/${book.id}">borrow</a></td>
			    		</c:if>
	    			</tr>
		  			</c:forEach>
	  			</tbody>
			</table>
		</div>
		
		<div class="shelf">
			<div class="t-head">
				<h5>Books From My Shelf:</h5>
				<a href="/new">+ Add a book to my shelf!</a>
			</div>
			<table class="table table-dark">
	  			<thead>
	    			<tr>
	      				<th scope="col">#</th>
	      				<th scope="col">Title</th>
	      				<th scope="col">Authors Name</th>
	      				<th scope="col">Actions</th>
	    			</tr>
	  			</thead>
	  			<tbody>
		  			<c:forEach items="${ myBooks }" var="books">
		  			<tr>
	      				<th scope="row">${ books.id }</th>
	      				<td><a href="/show/${ books.id }">${ books.title }</a></td>
	      				<td>${ book.author }</td>
	      				<td><a href="/bookmarket/return/${books.id}">return</a></td>
	    			</tr>
		  			</c:forEach>
	  			</tbody>
			</table>
		</div>
	</div>
</body>
</html>