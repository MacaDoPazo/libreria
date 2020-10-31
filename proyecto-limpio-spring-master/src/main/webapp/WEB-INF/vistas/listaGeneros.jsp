<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
    <%@include file="navAdministrador.jsp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista géneros</title>
</head>
<body>

	<h1 id="login-title" class="text-center">Listado de géneros cargados</h1>
	 <div class="container"> 
	       
		<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>Nombre</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${lista}" var="genero">
	      <tr>
	        <td> ${genero.id }</td>
	        <td> ${genero.nombre }</td>
	        <td class="text-right"><button class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </button><a href="borrar-genero?id=${genero.id }"class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
	      </tr>
	       </c:forEach>
	      
	    </tbody>
	  </table>
		</div>

</body>
</html>