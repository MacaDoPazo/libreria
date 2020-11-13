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
			 <input type="radio" name="puntuacion" id="1" value="1" checked>
			 <label for="1"><i class="fas fa-star"></i></label> 
			 <input type="radio" name="puntuacion" id="2" value="2">
			 <label for="2"><i class="fas fa-star"></i></label>
			  <input type="radio" name="puntuacion" id="3" value="3">
			 <label for="3"><i class="fas fa-star"></i></label>
			  <input type="radio" name="puntuacion" id="4" value="4">
			 <label for="4"><i class="fas fa-star"></i></label>
			  <input type="radio" name="puntuacion" id="5" value="5">
			 <label for="5"><i class="fas fa-star"></i></label>
			 
			 </div>
			  <div class="form-group">
		<textarea rows="10" name="comentario" style="width:100%;"></textarea>
			</div>
		   	 <input type="hidden" id="idLibro" name="idLibro" value= "${libro.id }">
		   	 <input type="hidden" id="idPedido" name="idPedido" value= "${pedido.id}">
          	 
   			 <input class="btn btn-success "type="submit" value="enviar">
     	</form>
     	</div>
     	</div>

<%@include file="footer.jsp" %> 