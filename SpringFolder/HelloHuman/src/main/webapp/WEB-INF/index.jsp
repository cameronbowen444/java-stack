<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2><c:out value="${2+2}"/></h2>
	<% for (int i = 0; i <= 5; i++) { %>
		<h1><%= i %></h1>
	<% } %>
	<h3><c:out value="${50+5436}"/></h3>
</body>
</html>