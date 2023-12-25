<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Produit</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha384-dpnbvBUNxgHCYqnsaAe4vSapJAL90ltlr1LQHcYG5e9qex8e6R2bIov4eZtWPTDA" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th colspan="4" class="th1">Recherche des produits</th>
				</tr>
				<tr>
					<th colspan="4" class="th1">
						<form action="rechercheProduit.do" method="get">
							<input type="text" name="motCle" value="${ model.motCle }">
							<button type="submit" class="btn btn-dark">Chercher</button>
						</form>
					</th>
				</tr>
				<tr>
					<th scope="col">Nom</th>
					<th scope="col">Prix</th>
					<th scope="col">Quantité</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${model.produits}">
					<tr>
						<td>${p.nom}</td>
						<td>${p.prix} DH</td>
						<td>${p.quantite} pcs</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"  crossorigin="anonymous"></script>
</body>
</html>
