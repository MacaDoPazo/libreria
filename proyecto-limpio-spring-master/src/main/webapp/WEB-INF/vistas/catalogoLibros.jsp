
    <%@include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Libros cargados</title>
</head>
<body>
	<h1 id="login-title" class="text-center">Catalogo de libros cargados</h1>
 <div class="container"> 
       
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>Autor</th>
        <th>Genero</th>
        <th>Paginas</th>
        <th>Precio</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${lista }" var="libro">
      <tr>
        <td> ${libro.nombre }</td>
        <td>${libro.autor.nombre } ${libro.autor.apellido }</td>
        <td>${libro.genero.nombre}</td>
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
