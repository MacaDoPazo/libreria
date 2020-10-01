<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
		<title>Inicio - Cumelén</title>
	</head>
	<body>
	
		<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
  </ol>
  </div>
  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://tap-multimedia-1113.nyc3.digitaloceanspaces.com/slider/2473/large/1200x300.jpg" class="d-block w-100" alt="https://tap-multimedia-1113.nyc3.digitaloceanspaces.com/slider/2473/large/1200x300.jpg">
    </div>
    <div class="carousel-item">
      <img src="https://tap-multimedia-1113.nyc3.digitaloceanspaces.com/slider/2473/large/1200x300.jpg" class="d-block w-100" alt="https://tap-multimedia-1113.nyc3.digitaloceanspaces.com/slider/2473/large/1200x300.jpg">
    </div>
    <div class="carousel-item">
      <img src="https://tap-multimedia-1113.nyc3.digitaloceanspaces.com/slider/2473/large/1200x300.jpg" class="d-block w-100" alt="https://tap-multimedia-1113.nyc3.digitaloceanspaces.com/slider/2473/large/1200x300.jpg">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<div>
	</div>
	<div class="container">
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	<h1 class="text-center">Libros destacados</h1>
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
   <div class="w3-row-padding w3-padding-16 w3-center row" id="food">
   
  <div class="container" id="food">
    <c:forEach items="${lista}" var="item" >
    	
  		
            
          <div class="w3-quarter col">
      	   <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="libro" style="width:100%"></a>
      		<div class="card-body">
      		
      		<a href="#" style="text-decoration:none"><h3>${item.nombre}</h3></a>
      		<a href="#" style="text-decoration:none"><h6>${item.autor.nombre} ${item.autor.apellido}</h6></a>
      		<p>$${item.precio}<p>
      		<a href="detalle-producto?idLibro=${item.id}"><button type="button" class="btn btn-outline-dark">Comprar</button></a>
      	</div>
      	   
   		 </div>           
          </c:forEach>   	
  </div>
  <div class="container" id="food">
    <div class="w3-quarter col">
      <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="Sandwich" style="width:100%"></a>
      <h3>The Perfect Sandwich, A Real NYC Classic</h3>
      <p>Just some random text, lorem ipsum text praesent tincidunt ipsum lipsum.</p>
    </div>
    <div class="w3-quarter col">
      <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="Steak" style="width:100%"></a>
      <h3>Let Me Tell You About This Steak</h3>
      <p>Once again, some random text to lorem lorem lorem lorem ipsum text praesent tincidunt ipsum lipsum.</p>
    </div>
    <div class="col w3-quarter">
      <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="Cherries" style="width:100%"></a>
      <h3>Cherries, interrupted</h3>
      <p>Lorem ipsum text praesent tincidunt ipsum lipsum.</p>
      <p>What else?</p>
    </div>
    <div class="col w3-quarter">
      <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="Cherries" style="width:100%"></a>
      <h3>Cherries, interrupted</h3>
      <p>Lorem ipsum text praesent tincidunt ipsum lipsum.</p>
      <p>What else?</p>
    </div>
  </div>
  </div>
  </div>
  
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	</body>
</html>
<%@include file="footer.jsp" %>