<%@include file="header.jsp" %>
<section>
	<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-6 col-lg-4 d-flex justify-content-center">
     <img src="img/${libro.nombre_archivo}" alt="${libro.nombre_archivo}" style="width:100%">
    </div>
    <div class="col-sm-9 col-md-6 col-lg-8 shadow p-4 mb-4 bg-white">
      <div class="container">
      <h2>${libro.nombre }</h2>
      <h3>Autor:</h3><a href="listar-libros-autor?autor_id=${libro.autor.id}" class=" mx-auto">${libro.autor.nombre} ${libro.autor.apellido }</a>
      <h3>Género:</h3><a href="listar-libros-genero?genero_id=${libro.genero.id}" style="text-decoration:none">${libro.genero.nombre }</a>
      <h3>Precio:</h3><span style="font-size:40px">$${libro.precio}</span>
      <div class="container-fluid">
      <form action="carrito-compras">
      <label for="cantidad">Cantidad:</label>
      <small id="passwordHelpBlock" class="form-text text-muted">
  		Disponible ${libro.stock.cantidad } unidades
		</small>
      <input class="form-control" type="number" id="cantidad" name="cantidad" placeholder="0" style="width:50px" min=1 required><br>
      <input type="hidden" id="idLibroSolicitado" name="idLibroSolicitado" value= ${libro.id }>
       <input type="hidden" id="idCliente" name="idCliente" value= 1>
      <input class="btn btn-success "type="submit" value="Añadir al carrito">
      </form>
      </div>
      </div>
    </div>
  </div>
</div>
<div class="container">
<h3>Reseñas del libro: </h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
</div>
<div class="container">
<h3>Otros títulos disponibles que pertenecen a ${libro.autor.nombre} ${libro.autor.apellido } o al género ${libro.genero.nombre }: </h3>
</div>
    	<div class="w3-row-padding w3-padding-16 w3-center row" id="food">
	 	<div class="container" id="food">
	    <div class="card-deck">
       <c:forEach items="${listaLibrosRelacionados}" var="item">
    
      	   
          <div class="w3-quarter col">
	      	   <a href="#" >
	      	   <img src="img/${item.nombre_archivo}" alt="${item.nombre_archivo}" style="width:150px; height:200px">
	      	   </a>
      		<div class="card-body">
      			<h3 class="card-text">${item.nombre}</h3>
	      		<p class="card-text">$ ${item.precio}<p> 
		      		<form action="agregar-al-carrito" >
			      		<input class="form-control " type="number" id="cantidad" name="canitdad" placeholder="0" style="width:50px" min=1 required><br>
			      		<input type="hidden" id="precio" name="idLibro" value= ${item.id }>
			     		 <input type="hidden" id="precio" name="precio" value= ${item.precio }>
			      		 <input class="btn btn-success mx-auto"type="submit" value="Añadir al carrito">
		      		</form>
	      	</div>      		
   		 </div>
 

  	 </c:forEach>

  	
</section>
<!--Section: Block Content-->
<%@include file="footer.jsp" %>