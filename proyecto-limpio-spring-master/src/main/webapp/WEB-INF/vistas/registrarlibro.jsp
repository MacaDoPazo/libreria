<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="header.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>

    <h1 id="login-title" class="text-center">Registrar Libro</h1>
  	<div id="login-container" class="container"> 
        <form action="guardarLibro" method="post">
            <label for="nombre">Nombre: </label>
            <input class="form-control col-xs-12" type="text" name="nombre" id="nombre" required>
            <br>
            <label for="nombre">Cantidad de paginas: </label>
            <input class="form-control col-xs-12" type="text" name="paginas" id="nombre" required>
            <br>
            <label for="nombre">Precio: </label>
            <input class="form-control col-xs-12" type="text" name="precio" id="nombre" required>
            <br>
            <label for="nombre">Stock: </label>
            <input class="form-control col-xs-12" type="text" name="stock" id="nombre" required>
            <br>
            <label for="Autor">Autor: </label>
          	 
			<select id="Autor" name="idAutor">
        <c:forEach items="${lista}" var="item" >
    	
  		<option value="${item.id}" >${item.nombre}</option>
  
			
            </c:forEach>
          	</select>
                     
            <input id="submit-button" name="enviar" class="btn btn-success float-right mt-2" type="submit" value="Registrarse">
        </form>
          
        
           	         
			 
		</div>
	</body>
</html>
 <%@include file="footer.jsp" %>