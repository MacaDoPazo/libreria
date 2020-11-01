
 <%@include file="header.jsp" %>
 
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    
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