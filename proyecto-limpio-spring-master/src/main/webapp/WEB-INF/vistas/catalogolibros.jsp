<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Libros Cargados</title>
</head>
<body>
 <p>Libro ${nombre } del autor ${autorLibro.nombre}</p>
 <h1 id="login-title" class="text-center">Catalogo de Libros Cargados</h1>
  	<div id="login-container" class="container"> 
        <c:forEach items="${lista}" var="item" >
    	
  		
            
          <div class="w3-quarter col">
      	   <a href="#"><img src="https://www.w3schools.com/w3images/cherries.jpg" alt="libro" style="width:100%"></a>
      		<div class="card-body">
      		<a href="#" style="text-decoration:none"><h3>${item.nombre}</h3></a>
      		<a href="#" style="text-decoration:none"><h6>${item.autor.nombre} ${item.autor.apellido}</h6></a>
      		<p>$${item.precio}<p>
      		<a href="detalle-producto"><button type="button" class="btn btn-outline-dark">Comprar</button></a>
      	</div>
      	   
   		 </div>           
          </c:forEach>   	         
	</div>
</body>
</html>