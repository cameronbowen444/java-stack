<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1 class="header">Gold Game</h1>
	<div class="head">
		<div>
			<h3>Your Gold: </h3>
		</div>
		<div>
			<div class="box"> <c:out value="${goldValue}" /></div>
		</div>
	</div>
	
	<div class="container">
		<div class="row justify-content-around">
			<div class="box1"> 
				<form action="/farm" method="post">
					<h4 class="content">Farm</h4>
					<p class="content">(Earns 10-20 gold)</p>
					<input type="hidden" name="farmGold" value=0 />
					<input class="content btn btn-secondary" type="submit" value="Find Gold">
				</form>
			</div>
			<div class="box1">
				<form action="/cave" method="post">
					<h4 class="content">Cave</h4>
					<p class="content">(Earns 10-20 gold)</p>
					<input class="content btn btn-secondary" type="submit" value="Find Gold">
				</form>			
			</div>
			<div class="box1">
				<form action="/house" method="post">
					<h4 class="content">House</h4>
					<p class="content">(Earns 10-20 gold)</p>
					<input class="content btn btn-secondary" type="submit" value="Find Gold">
				</form>
			</div>
			<div class="box1">
				<form action="/quest" method="post">
					<h4 class="content">Quest</h4>
					<p class="content">(Earns/Takes 0-50 gold)</p>
					<input class="content btn btn-secondary" type="submit" value="Find Gold">
				</form>
			</div>
		</div>
	</div>
	
	<div>
		<h3 class="foot">Activites:</h3>
		<div class=box3> 
			<c:out value="${farmResult}"/>
		</div>
	</div>
</body>
</html>