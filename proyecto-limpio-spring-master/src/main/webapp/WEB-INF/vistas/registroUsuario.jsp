<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Formulario de registro</h1>
	<div id="login-container" class="container"> 
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
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
			<label for="email">Email:</label>
			<input class="form-control col-xs-12" type="text" name="email" id="email" required>
			<br>
			<label for="password">Contraseña: </label>
			<input class="form-control col-xs-12" type="password" name="password" id="password" required>
			<br>
			<label for="password">Repita su contraseña: </label>
			<input class="form-control col-xs-12" type="password" name="passwordRepetido" id="passwordRepetido" required>
			<br>
			<input id="submit-button" name="enviar" class="btn btn-success pull-right" type="submit" value="Registrarse">
	      </form>
		</div>
	</div>
	<br><br><br>
 <%@include file="footer.jsp" %>