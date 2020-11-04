<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Registrar Libro</h1>
  	<div  class="container">
  		<div  style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2"> 
        <form action="guardar-libro" method="post">
            <label for="nombre">Nombre: </label>
            <input class="form-control col-xs-12" type="text" name="nombre" id="nombre" required>
            <br>
            <label for="nombre">Cantidad de páginas: </label>
            <input class="form-control col-xs-12" type="text" name="paginas" id="nombre" required>
            <br>
            <label for="nombre">Precio: </label>
            <input class="form-control col-xs-12" type="text" name="precio" id="nombre" required>
            <br>
            <label for="nombre">Stock: </label>
            <input class="form-control col-xs-12" type="text" name="cantidad" id="nombre" required>
            <br>
            <label for="Autor">Autor: </label>          	 
				<select id="Autor" name="idAutor" class="form-control col-xs-12">
		        	<c:forEach items="${lista}" var="item" >    	
		  				<option value="${item.id}" >${item.nombre} ${item.apellido }</option>			
		            </c:forEach>
	          	</select>
	         <br>
             <label for="Genero">Género: </label>          	 
				<select id="Genero" name="idGenero" class="form-control col-xs-12">
		        	<c:forEach items="${listaGeneros}" var="itemGenero" >    	
		  				<option value="${itemGenero.id}" >${itemGenero.nombre}</option>			
		            </c:forEach>
	          	</select>
                 <br>
            <input id="submit-button" name="enviar" class="btn btn-success pull-right" type="submit" value="Registrar libro">
        </form>
        </div>
	</div>
<br><br>
 <%@include file="footer.jsp" %>
