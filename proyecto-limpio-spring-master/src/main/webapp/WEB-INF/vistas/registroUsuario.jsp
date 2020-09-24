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
	</head>
	<body>

    <h1 id="login-title" class="text-center">Formulario de registro</h1>
  	<div id="login-container" class="container"> 
        <form action="mostrarUsuarioRegistrado" method="post">
            <label for="nombre">Nombre: </label>
            <input class="form-control col-xs-12" type="text" name="nombre" id="nombre" required>
            <br>
            <label for="apellido">Apellido: </label>
            <input class="form-control col-xs-12" type="text" name="apellido" id="apellido" required>
            <br>
                     
			 <label for="sexo">Sexo:</label>
 
			 <input type="radio" name="sexo" id="femenino" value="femenino" checked>
			 <label for="femenino">Femenino</label> 
			 <input type="radio" name="sexo" id="masculino" value="masculino">
			 <label for="masculino">Masculino</label>
			 <input type="radio" name="sexo" id="otro" value="otro">
			 <label for="otro">Otro</label> 
			
            <br>
            <label for="fechaNacimiento">Fecha de nacimiento: </label>
            <input class="form-control col-xs-12" type="date" name="fechaNacimiento" id="fechaNacimiento">
            <br>            
            <label for="mail">Mail:</label>
            <input class="form-control col-xs-12" type="text" name="mail" id="mail" required>
            <br>
            <label for="password">Contraseña: </label>
            <input class="form-control col-xs-12" type="password" name="password" id="password" required>
            <br>
            <label for="password">Repita su contraseña: </label>
            <input class="form-control col-xs-12" type="password" name="passwordRepetido" id="passwordRepetido" required>
            <br>
          
            <input id="submit-button" name="enviar" class="btn btn-success float-right mt-2" type="submit" value="Registrarse">
        </form>
		</div>
	</body>
</html>
 <%@include file="footer.jsp" %>