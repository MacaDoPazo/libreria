<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
    <%@include file="navAdministrador.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista localidades</title>
</head>
<body>
	<h1 id="login-title" class="text-center">Catalogo de libros cargados</h1>
 <div class="container"> 
       
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>cp</th>
        <th>Precio envío</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listaLocalidades }" var="localidad">
      <tr>
        <td> ${localidad.nombre }</td>
        <td> ${localidad.cp }</td>
        <th> ${localidad.precio }</th>
        <td class="text-right"><button class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </button><a href="borrar-libro?idLibro=${libro.id }"class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
      </tr>
       </c:forEach>
      
    </tbody>
  </table>
	</div>
</body>
</html>