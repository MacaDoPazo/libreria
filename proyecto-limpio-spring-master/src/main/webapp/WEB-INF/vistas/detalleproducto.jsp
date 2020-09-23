<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
		<title>Detalle de producto - Cumelén</title>
	</head>
    <body>

<section>
	<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-6 col-lg-4 d-flex justify-content-center">
      <img src="https://www.w3schools.com/w3images/cherries.jpg"  style=" height:400px">
    </div>
    <div class="col-sm-9 col-md-6 col-lg-8">
      <h2>Cherries, interrupted</h2>
      <h3>Autor:</h3><p>asdjaskdjad</p>
      <h3>Editorial:</h3><p>adadsads</p>
      <h3>Precio:</h3><span style="font-size:40px">$120</span>
      <div class="container-fluid">
      <form action="carrito-compras">
      <label for="cantidad">Cantidad</label>
      <input type="number" name="cantidad" style="width:50px" min=1>
      <input type="submit" value="Añadir al carrito">
      </form>
      </div>
    </div>
  </div>
</div>
<div class="container">
<h3>Descripcion: </h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
</div>
  	
</section>
<!--Section: Block Content-->
 
	</body>
</html>

<%@include file="footer.jsp" %>