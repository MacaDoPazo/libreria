<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <title>Registrar localidad</title>
	</head>
	<body>

    <h1 id="login-title" class="text-center">Registrar Localidad</h1>
  	<div id="login-container" class="container"> 
        <form action="guardar-localidad" method="post">
            <label for="nombre">Nombre: </label>
            <input class="form-control col-xs-12" type="text" name="nombre" id="nombre" required>
            <br>
            <label for="apellido">Código Postal: </label>
            <input class="form-control col-xs-12" type="number" name="cp" id="cp" required>
            <br>
             <label for="apellido">Precio envío: </label>
            <input class="form-control col-xs-12" type="number" name="precio" id="precio" required>
            <br>                     
            <input id="submit-button" name="enviar" class="btn btn-success float-right mt-2" type="submit" value="Registrar localidad">
        </form>
		</div>
	</body>
</html>
 <%@include file="footer.jsp" %>