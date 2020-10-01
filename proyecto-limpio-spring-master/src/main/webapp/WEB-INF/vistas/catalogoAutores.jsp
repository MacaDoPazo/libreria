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
	    <title>Catalogo de autores</title>
	</head>
	<body>

    <h1 id="login-title" class="text-center">Catalogo de autores Cargados</h1>
  	<div class="container"> 
        <p>Autor ${nombre} ${apellido} cargado<p><br>
        <c:forEach items="${lista }" var="autor">
        <div class="card-body">
        ${autor.nombre } ${autor.apellido }<br>
        </div>
        </c:forEach>
		</div>
	</body>
</html>
 <%@include file="footer.jsp" %>