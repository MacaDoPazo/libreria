<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogos libros</title>
</head>
<header>
	<h1>Libros Catalogo</h1>
	<main>
		<form action="guardarLibro">
			<label for="nombre">Nombre: </label>
			<input type="text" id="nombre" name="nombre">
			<input type="submit" value="enviar">
		</form>
		<form action="buscarLibroPorId">
			<label for="nombre">ID de libro: </label>
			<input type="number" id="id" name="id">
			<input type="submit" value="enviar">
		</form>
		<p>Libro encontrado es ${libro.nombre}</p>
		
		
	</main>
	
</header>
<body>

</body>
</html>
<%@include file="footer.jsp"%>