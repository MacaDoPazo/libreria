<%@include file="header.jsp" %>
<section>
	<div class="container mt-2 ">
  <div class="row ">
    <div class="col-sm-3 col-md-6 col-lg-4 d-flex justify-content-center ">
     <img class="img-thumbnail" src="img/${libro.nombre_archivo}" alt="${libro.nombre_archivo}" style="width:90%;height: 95%">
    </div>
    <div class="col-sm-9 col-md-6 col-lg-8 shadow p-4 mb-4 bg-light">
      <div class="container bg-light ">
      <div class= "row">
      <div class="col-lg-4 titulos"><h1>${libro.nombre }</h1> </div>
    <div class="col-lg-8  pt-2"><b>${promedio }/5 <i class="fas fa-star text-warning"></i></b></div>
     <hr style="height:2px;border-width:0;color:gray;background-color:gray">
     <div class="col-lg-3 "><h3>Autor:</h3></div>
    <div class="col-lg-9 pt-2 "><a href="listar-libros-autor?autor_id=${libro.autor.id}" class=" mx-auto">${libro.autor.nombre} ${libro.autor.apellido }</a></div>
       <div class="col-lg-3"><h3>Género:</h3></div>
    <div class="col-lg-9 pt-2"><a href="listar-libros-genero?genero_id=${libro.genero.id}" style="text-decoration:none">${libro.genero.nombre }</a></div>
     <div class="col-lg-3"> <h3>Precio:</h3></div>
    <div class="col-lg-9 pt-2"><span style="font-size:20px">$${libro.precio}</span></div> 
      
     
      </div>
      <div class="container mt-3 ml-1 bg-warning col-lg-6 ">
      <form action="carrito-compras " class="row d-flex justify-content-center">
      <small id="passwordHelpBlock" class="form-text text-muted  col-lg-12">
  		Disponible ${libro.stock.cantidad } unidades
		</small>
      <label  class="mt-3 col-lg-3 py-1" for="cantidad" >Cantidad:</label>
      
      <input class="form-control col-lg-12" type="hidden" id="idLibroSolicitado" name="idLibroSolicitado" value= ${libro.id }>
       <input class="form-control col-lg-12" type="hidden" id="idCliente" name="idCliente" value= "${sessionScope.usuario_id}">
      <input class="form-control col-lg-3 text-right py-2" type="number" id="cantidad" name="cantidad" placeholder="0"  min=1 required><br>
      <input class="btn btn-danger col-lg-6 mx-2 mb-3"type="submit" value="Añadir al carrito">
      </form>
      </div>
      </div>
    </div>
  </div>
</div>

<div class="container mx-auto bg-dark">
<h3 class="col-lg-12 text-light">Reseñas del libro: </h3>

    	<div class="w3-row-padding w3-padding-16 w3-center row" id="food">
	 	<div class="container" id="food">
	    <div class="card-deck">
	    
	    
       <c:forEach items="${listaReseniasDelLibro}" var="item"> 		
 		<div class="card col-12 mx-3 my-3 ">
  		<div class="card-header ">
          			<c:choose>
				        		<c:when test="${item.puntuacion == 1}">
									<h6 class="card-subtitle mb-2 text-muted">1 estrella <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${item.puntuacion == 2}">
									<h6 class="card-subtitle mb-2 text-muted">2 estrellas <i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${item.puntuacion == 3}">
									<h6 class="card-subtitle mb-2 text-muted">3 estrellas <i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${item.puntuacion == 4}">
									<h6 class="card-subtitle mb-2 text-muted">4 estrellas <i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${item.puntuacion == 5}">
									<h6 class="card-subtitle mb-2 text-muted">5 estrellas <i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
					</c:choose>
		  </div>
		  <div class="card-body">
		    <blockquote class="blockquote mb-0">
		      <p>${item.comentario}</p>
		      <footer class="blockquote-footer"> <cite title="Source Title">${item.cliente.apellido} ${item.cliente.nombre}</cite></footer>
		    </blockquote>
		  </div>
		</div>
 	</c:forEach>

	</div>
	</div>
	</div>

</div>
<div class="container row  my-3 mx-auto">
<h3>Otros títulos disponibles que pertenecen a <b class="titulos">${libro.autor.nombre} ${libro.autor.apellido }</b> o al género <b class="titulos">${libro.genero.nombre }</b>: </h3>

    	
       <c:forEach items="${listaLibrosRelacionados}" var="item">
    
      	   
          <div class="w3-quarter col-lg-4 bg-light mx-2 ">
	      	   <a href="#" class="d-flex justify-content-center mt-1">
	      	   <img class="img-thumbnail" src="img/${item.nombre_archivo}" alt="${item.nombre_archivo}" style="width:150px; height:200px">
	      	   </a>
      		<div class="card-body ">
      			<h3 class="card-text text-center titulos">${item.nombre}</h3>
	      		<p class="card-text text-center">$ ${item.precio}<p> 
		      		<form action="agregar-al-carrito" class="row d-flex justify-content-center" >
			      		<input class="form-control col-lg-3 text-right py-2 mx-2 " type="number" id="cantidad" name="canitdad" placeholder="0" style="width:50px" min=1 required><br>
			      		<input type="hidden" id="precio" name="idLibro" value= ${item.id }>
			     		 <input type="hidden" id="precio" name="precio" value= ${item.precio }>
			      		 <input class="btn btn-warning mx-2"type="submit" value="Añadir al carrito">
		      		</form>
	      	</div>      		
   		 </div>
 

  	 </c:forEach>
</div>
  	
</section>
<!--Section: Block Content-->
<%@include file="footer.jsp" %>