<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>
   
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
    <title>Catalogo de autores</title>
	</head>
	<body>

    <h1 id="login-title" class="text-center">Catalogo de autores cargados</h1>
  	<div class="container mb-4"> 
    	<div class="row">   
    		<div class="col-12">
            	<div class="table-responsive">
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Sexo</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${lista }" var="autor">
      <tr>
        <td> ${autor.nombre }</td>
        <td>${autor.apellido }</td>
        <td>${autor.sexo }</td>
        <td class="text-right"><button class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </button><a href="borrar-autor?idAutor=${autor.id }"class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
      </tr>
       </c:forEach>
      
    </tbody>
  </table>
						</div>
					</div>
				</div>
		</div>
	</body>
</html>
 <%@include file="footer.jsp" %>