<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="header.jsp" %>
  <%@include file="navAdministrador.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de géneros</title>
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<h1 id="login-title" class="text-center">Registrar Género</h1>
  	<div id="login-container" class="container"> 
        <form action="guardar-genero" method="post">
            <label for="nombre">Ingrese el nombre del género a registrar: </label>
            <input class="form-control col-xs-12" type="text" name="nombre" id="nombre" required>
            <input id="submit-button" name="enviar" class="btn btn-success float-right mt-2" type="submit" value="Registrar género">
        </form>
    </div>
</body>
</html>
<%@include file="footer.jsp" %>