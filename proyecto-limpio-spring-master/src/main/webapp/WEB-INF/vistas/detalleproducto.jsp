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
<h3>Descripcion: </h3>
<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
</div>
  	
</section>
<!--Section: Block Content-->
<%@include file="footer.jsp" %>