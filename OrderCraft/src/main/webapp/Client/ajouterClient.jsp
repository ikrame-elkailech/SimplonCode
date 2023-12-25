<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Ajouter Client</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha384-dpnbvBUNxgHCYqnsaAe4vSapJAL90ltlr1LQHcYG5e9qex8e6R2bIov4eZtWPTDA" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<form action="SaveClient.action" method="post">
			<table class="mt-3">
			<tr>
				<td>
					<label>Nom</label> 
				</td>
				<td>
					<input type="text" name="nom" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<td>
					<label>Adresse</label> 
				</td>
				<td>
					<input type="text" name="adresse" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<td>
					<label>Telephone</label> 
				</td>
				<td>
					<input type="text" name="telephone" class="form-control" required="required">
				</td>
			</tr>
			</table>
			<input type="submit" class="btn btn-dark" value="Ajouter">
		</form>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"  crossorigin="anonymous"></script>
</body>
</html>
