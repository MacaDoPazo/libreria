<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@include file="header.jsp" %>
  
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<body>
	<h1 id="login-title" class="text-center">Catalogo de libros cargados</h1>
 <div class="container"> 
       
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>Autor</th>
        <th>Paginas</th>
        <th>Precio</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${lista }" var="libro">
      <tr>
        <td> ${libro.nombre }</td>
        <td>${libro.autor.nombre } ${libro.autor.apellido }</td>
        <td>${libro.paginas }</td>
        <th>${libro.precio }</th>
        <td class="text-right"><button class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </button><a href="borrar-libro?idLibro=${libro.id }"class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
      </tr>
       </c:forEach>
      
    </tbody>
  </table>
	</div>
</body>
</html>
