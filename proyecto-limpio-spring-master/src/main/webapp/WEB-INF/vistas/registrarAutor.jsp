<%@include file="header.jsp" %>    <h1 id="login-title" class="text-center">Registrar Autor</h1>
<div id="login-container" class="container"> 
  	<div  style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form action="guardar-autor" method="post">
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
                     
            <input id="submit-button" name="enviar" class="btn btn-success pull-right" type="submit" value="Registrar autor">
        </form>
	</div>
</div>
<br><br>
<%@include file="footer.jsp" %>