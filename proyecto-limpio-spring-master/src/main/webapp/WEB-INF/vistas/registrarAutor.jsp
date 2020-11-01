
 <%@include file="header.jsp" %>
  
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	   
	</head>
	<body>

    <h1 id="login-title" class="text-center">Registrar Autor</h1>
  	<div id="login-container" class="container"> 
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
			
                     
            <input id="submit-button" name="enviar" class="btn btn-success float-right mt-2" type="submit" value="Registrar autor">
        </form>
		</div>
	</body>
</html>
 <%@include file="footer.jsp" %>