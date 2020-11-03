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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
		<title>Inicio - Cumelén</title>
	</head>
	<body>
	<br>
	<c:if test="${cerro!=null}">
	<div class="alert alert-info">Ha salido del sistema</div>
	<br>
	</c:if>
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
      <img src="img/carrousel1.jpg" alt="im1"  width="850px" height="450px" >
    </div>
    <div class="carousel-item">
      <img src="img/carrousel2.jpg" alt="im2"  width="850px" height="450px" >
    </div>
    <div class="carousel-item">
      <img src="img/carrousel3.jpg" alt="im3"  width="850px" height="450px" >
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
	<h1 class="text-center">Libros populares</h1>
	<hr style="height:2px;border-width:0;color:gray;background-color:gray">
   <div class="w3-row-padding w3-padding-16 w3-center row" id="food">
 
  
  <div class="container" id="food">
    <div class="card-deck">
    <c:forEach items="${lista}" var="item" >
    	   
          <div class="w3-quarter col">
      	   <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="libro" style="width:100%"></a>
      		<div class="card-body">
      		
      		<h3 class="card-text">${item.nombre}</h3>
      		<a href="#" style="text-decoration:none"><h6>${item.autor.nombre} ${item.autor.apellido}</h6></a>
      		<p class="card-text">$${item.precio}<p> 
      		<div class="card-text d-flex justify-content-center"><a href="sumar-megusta?idLibro=${item.id }"class="" id="botonlike"><i class="far fa-heart"></i> </a><p id="cantidadlikes"> &nbsp ${item.megusta}</p></div>
      		<form action="agregar-al-carrito" >
      		<input class="form-control mx-auto" type="number" id="cantidad" name="canitdad" placeholder="0" style="width:50px" min=1 required><br>
      		<input type="hidden" id="precio" name="idLibro" value= ${item.id }>
     		 <input type="hidden" id="precio" name="precio" value= ${item.precio }>
      		<input type="hidden" id="precio" name="idCliente" value=1>
     		 <input class="btn btn-success mx-auto"type="submit" value="Añadir al carrito">
      		</form>
      		<a href="detalle-producto?idLibro=${item.id}" class=" mx-auto"><button type="button" class="btn btn-outline-dark">Comprar</button></a>
      	</div>
      		
   		 </div>           
          </c:forEach>  
      </div>     	
  </div>
  </div>
  </div>
  
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
	</body>
	<script>
	$(document).ready(function()
			 {
			 $(".botonlike").click(function()
			 {
			     if($(".material-icons").text()=="favorite_border"){
					 $(".material-icons").text("favorite");
			         
			     }
			     else
			     {
			    	 $(".material-icons").text("favorite_border");
			         
			     }
			     
			 })
           
			 })
	</script>
</html>
<%@include file="footer.jsp" %>