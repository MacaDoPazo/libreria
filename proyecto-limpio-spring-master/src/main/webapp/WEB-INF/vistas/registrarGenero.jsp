<%@include file="header.jsp" %>
	<h1 id="login-title" class="text-center">Registrar Género</h1>
  	<div id="login-container" class="container">
	  	<div  style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2"> 
	        <form action="guardar-genero" method="post">
	            <label for="nombre">Ingrese el nombre del género a registrar: </label>
	            <input class="form-control col-xs-12" type="text" name="nombre" id="nombre" required>
	            <br>
	            <input id="submit-button" name="enviar" class="btn btn-success pull-right" type="submit" value="Registrar género">
	        </form>
        </div>
    </div>
    <br><br>
<%@include file="footer.jsp" %>