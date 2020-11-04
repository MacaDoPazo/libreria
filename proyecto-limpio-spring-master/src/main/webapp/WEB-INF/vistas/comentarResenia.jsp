<%@include file="header.jsp" %> 
	<div class="card">
  		<div class="card-body">
  		<div class="container-fluid">
  		<h5 class="card-title">${libro.nombre }</h5>
    	<h6 class="card-subtitle mb-2 text-muted">${libro.autor.nombre } ${libro.autor.apellido }</h6>
    	<h6 class="card-subtitle mb-2 text-muted">${libro.genero.nombre }</h6>
  		</div>
		<form action="guardar-resenia" method="post">
        
 			 <div class="form-group">
			 <input type="radio" name="puntuacion" id="positivo" value="positivo" checked>
			 <label for="positivo"><i class="far fa-thumbs-up"></i></label> 
			 <input type="radio" name="puntuacion" id="negativo" value="negativo">
			 <label for="negativo"><i class="far fa-thumbs-down"></i></label>
			 
			 </div>
			  <div class="form-group">
		<textarea rows="10" name="comentario" style="width:100%;"></textarea>
			</div>
		   	 <input type="hidden" id="idCliente" name="idCliente" value= "${sessionScope.usuario_id}">
		   	 <input type="hidden" id="idLibro" name="idLibro" value= "${libro.id }">
		   	 <input type="hidden" id="idPedido" name="idPedido" value= "${pedido.id}">
          	 
   			 <input class="btn btn-success "type="submit" value="enviar">
     	</form>
     	</div>
     	</div>

<%@include file="footer.jsp" %> 