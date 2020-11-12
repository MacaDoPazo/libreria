<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
		
		<!--  >script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
		</script-->
		<title>Inicio - Cumelén</title>
	</head>
	<body>
	<header>
	<c:choose>
	<c:when test="${sessionScope.usuario_nombre ==null}">
	
	<div class="sticky-top">
	<nav class="navbar navbar-light bg-light sticky-float">
	  	<a class="navbar-brand" href="pantalla-inicial">
	    	<img src="https://getbootstrap.com/docs/4.5/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
	    	Cumelén
	  	</a>
		<ul class="nav justify-content-end">
		<li class="nav-item">
		<a href="login" class="nav-link" ><button class="btn btn-sm btn-success">Mi pedido<i class="fa fa-shopping-cart"></i></button></a> 
		</li>
	  	<li class="nav-item">
	    	<a class="nav-link" href="login">Iniciar Sesión</a>
	  	</li>
	  	<li class="nav-item">
	    	<a class="nav-link" href="registroUsuario">Registrarse</a>
	  	</li>
		</ul>
	</nav>
	</div>
	</c:when>
	<c:when test="${sessionScope.usuario_rol == 'Admin'}">
	<div class="sticky-top">
	<nav class="navbar navbar-light bg-light sticky-float">
	  	<a class="navbar-brand" href="pantalla-inicial">
	    	<img src="https://getbootstrap.com/docs/4.5/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
	    	Cumelén
	  	</a>
		<ul class="nav justify-content-end">
		<li class="nav-item">
		     <form action="listaVentasAlCliente" method="GET" modelAttribute="usuario">
	           <input type="hidden" name="idCliente" id="idCliente" value="${sessionScope.usuario_id}">
	            <button class="btn btn-sm btn-success">Mis pedidos realizados<i class="fa fa-shopping-cart"></i></button>
        	</form>

		<a href="ver-pedido?idCliente=${sessionScope.usuario_id}" class="nav-link" ><button class="btn btn-sm btn-success">Mi pedido<i class="fa fa-shopping-cart"></i></button></a> 
		</li>
	  	<li class="nav-item">
  			<div class="dropdown">
		  		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		            <i class="fa fa-user"></i>
                    <p class="text text-right">Bienvenido <c:out value="${sessionScope.usuario_nombre}"></c:out> </p>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="salir">
                    <i class="fa fa-sign-in">
                    </i> Salir</a>
                </div>
            </div>
	    </li>
		</ul>
		<a class="dropdown-item" href="salir">
                    <i class="fa fa-sign-in">
                    </i> Salir</a>
	</nav>
	<%@include file="navAdministrador.jsp" %>  
	</div>
	</c:when>
	<c:otherwise>
	<div class="sticky-top">
	<nav class="navbar navbar-light bg-light sticky-float">
	  	<a class="navbar-brand" href="pantalla-inicial">
	    	<img src="https://getbootstrap.com/docs/4.5/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
	    	Cumelén
	  	</a>
		<ul class="nav justify-content-end">
		<li class="nav-item">
		     <form action="listaVentasAlCliente" method="GET" modelAttribute="usuario">
	           <input type="hidden" name="idCliente" id="idCliente" value="${sessionScope.usuario_id}">
	            <button class="btn btn-sm btn-success">Mis pedidos realizados<i class="fa fa-shopping-cart"></i></button>
        	</form>

		<a href="ver-pedido?idCliente=1" class="nav-link" ><button class="btn btn-sm btn-success">Mi pedido<i class="fa fa-shopping-cart"></i></button></a> 
		</li>
	  	<li class="nav-item">
  			<div class="dropdown">
		  		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		            <i class="fa fa-user"></i>
                    <p class="text text-right">Bienvenido <c:out value="${sessionScope.usuario_nombre}"></c:out> </p>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="salir">
                    <i class="fa fa-sign-in">
                    </i> Salir</a>
                </div>
            </div>
	    </li>
	    <a class="dropdown-item" href="salir">
                    <i class="fa fa-sign-in">
                    </i> Salir</a>
		</ul>
	</nav>
	</div>
	</c:otherwise>
	</c:choose>
  	</header>
