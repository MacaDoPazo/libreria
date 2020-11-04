<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Registrar Localidad</h1>
  	<div id="login-container" class="container"> 
  		<div  style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
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
	            <input id="submit-button" name="enviar" class="btn btn-success pull-right" type="submit" value="Registrar localidad">
	        </form>
		</div>
	</div>
<br><br>
<%@include file="footer.jsp" %>