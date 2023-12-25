<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<style type="text/css">
	.form {
		margin: auto;
		padding-top: 50px;
		width: 50%;
	}
	</style>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<form class="form" action="LoginServlet" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> 
			<input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> 
			<input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
		</div>
		<input type="submit" class="btn btn-dark" value="Login">
	</form>
</body>
</html>
