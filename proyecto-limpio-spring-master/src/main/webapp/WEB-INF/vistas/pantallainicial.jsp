<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
	<br>
	
	<c:choose>
	<c:when test="${sessionScope.usuario_nombre ==null}">
	
	<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
		  <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
		  <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
		  <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
	  	</ol>
	</div>
	<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="img/carrousel1.jpg" alt="im1"  width="850px" height="450px" >
	    </div>
	    <div class="carousel-item">
	      <img src="img/carrousel2.jpg" alt="im2"  width="850px" height="450px" >
	    </div>
	    <div class="carousel-item">
	      <img src="img/carrousel3.jpg" alt="im3"  width="850px" height="450px" >
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	
	</c:when>
	<c:otherwise>
	
	<div class="container">
	<div class="row margin_top40">
		<div class="col-md-12">
			<h1 class=" text-center">Buscar libro</h1>
		</div>
	</div>
	
	<form action="busqueda-libro" class="margin_top40">
		  <div class="row ">
			<label class="col-md-3 text-right h5">Datos del libro a buscar:</label>
		    <div  class="col-md-5">
		    	<input type="text"  class="form-control" name="busqueda"  placeholder="Ingrese nombre del libro buscado" >
			</div>
			<div class="col-md-2">
				<input type="submit" value="Buscar" class="btn btn-primary">
			</div>
		  </div>
	</div>
 	</form>	
	
	<div class="container-fluid">
	<c:if test="${empty error}">
		<hr style="height:2px;border-width:0;color:gray;background-color:white">
		<h1 class="text-center">Porque te interesa el g�nero <a class="titulos" href="listar-libros-genero?genero_id=${idGeneroSugerido}" style="text-decoration:none">${generoSugerido }</a></h1>
		
		<%-- <a href="listar-libros-autor?autor_id=${item.autor.id}" style="text-decoration:none"><h6>${item.autor.nombre} ${item.autor.apellido}</h6></a> --%>
		
		<hr style="height:2px;border-width:0;color:gray;background-color:white">
	</c:if>	
		 
	    <div class="container mx-auto  row d-flex justify-content-center">
    <c:forEach items="${listaGenero}" var="libro" varStatus="loop" >
    	   
          <div class="container col-lg-3 col-md-5 my-md-1 mx-md-1 bg-light my-2 mx-2 p-md-2 w-md-25">
      	   <a href="#" class="d-flex justify-content-center mt-1" >
      	   <img class="img-thumbnail" src="img/${libro.nombre_archivo}" alt="${libro.nombre_archivo}" style="width:40%;height: 40%">
      	   </a>
      		<div class="card-body row  ml-4">
      			<b class="card-text col-6 titulos ">${libro.nombre}</b><div class="col-6"><b>${promedioMayorPuntaje[loop.index] }/5 <i class="fas fa-star text-warning"></i></b></div>
	      		<a class="card-text col-12" href="listar-libros-autor?autor_id=${libro.autor.id}" style="text-decoration:none">${libro.autor.nombre} ${libro.autor.apellido}</a>
	      		<p class="card-text col-12">$ ${libro.precio}<p> 
	      		<%-- <div class="card-text d-flex justify-content-center"><a href="sumar-megusta?idLibro=${libro.id }"class="" id="botonlike"><i class="far fa-heart"></i> </a><p id="cantidadlikes"> &nbsp ${item.megusta}</p></div> --%>
	      		<div class="col-12 mx-2 my-2 "><a href="detalle-producto?idLibro=${libro.id}&promedio=${promedioMayorPuntaje[loop.index] }" ><button type="button" class="btn btn-outline-dark mx-auto col-lg-8 mx-2 my-2">+ info</button></a></div>
	      		<form action="agregar-al-carrito " class="d-flex justify-content-center px-2" >
	      		<input class="form-control col-lg-4 text-right mx-2 my-2" type="number" id="cantidad" name="canitdad" placeholder="0" min=1 required>
	      		<input type="hidden" id="precio" name="idLibro" value= ${libro.id }>
	     		 <input type="hidden" id="precio" name="precio" value= ${libro.precio }>
	      		 <button class="btn btn-warning  mx-auto col-lg-6 mx-2 my-2" ><i class="fa fa-shopping-cart"></i>A�adir</button>
	      		</form>
	      		
	      	</div>
      		
   		 </div>           
          </c:forEach>  
      </div>     	
  
	</c:otherwise>
	</c:choose>	
	<hr style="height:2px;border-width:0;color:gray;background-color:white">
		<h1 class="text-center">Libros populares</h1>
		<hr style="height:2px;border-width:0;color:gray;background-color:white">
	   
	    <div class="container mx-auto  row d-flex justify-content-center">
    <c:forEach items="${lista}" var="libro" varStatus="loop" >
    	   
          <div class="w3-quarter col-lg-3 col-md-5 my-md-1 mx-md-1 bg-light my-2 mx-2 p-md-2 w-md-25">
      	  <a href="#" class="d-flex justify-content-center mt-1" >
      	   <img class="img-thumbnail" src="img/${libro.nombre_archivo}" alt="${libro.nombre_archivo}" style="width:40%;height: 40%">
      	   </a>
      		<div class="card-body row  mx-2 ml-4  px-2">
      			<b class="card-text col-6 titulos ">${libro.nombre}</b><div class="col-6"><b>${listaPromedio[loop.index] }/5 <i class="fas fa-star text-warning"></i></b></div>
	      		<a class="card-text col-12" href="listar-libros-autor?autor_id=${libro.autor.id}" style="text-decoration:none">${libro.autor.nombre} ${libro.autor.apellido}</a>
	      		<p class="card-text col-12">$ ${libro.precio}<p> 
	      		<%-- <div class="card-text d-flex justify-content-center"><a href="sumar-megusta?idLibro=${libro.id }"class="" id="botonlike"><i class="far fa-heart"></i> </a><p id="cantidadlikes"> &nbsp ${item.megusta}</p></div> --%>
	      		<div class="col-12 mx-2 my-2 "><a href="detalle-producto?idLibro=${libro.id}&promedio=${listaPromedio[loop.index] }" ><button type="button" class="btn btn-outline-dark mx-auto col-lg-8 mx-2 my-2">+ info</button></a></div>
	      		<form action="agregar-al-carrito "  class="d-flex justify-content-center px-2" >
	      		<input class="form-control col-lg-4 text-right mx-2 my-2" type="number" id="cantidad" name="canitdad" placeholder="0" min=1 required>
	      		<input type="hidden" id="precio" name="idLibro" value= ${libro.id }>
	     		 <input type="hidden" id="precio" name="precio" value= ${libro.precio }>
	      		 <button class="btn btn-warning  mx-auto col-lg-6 col-md-6 mx-2 my-2" ><i class="fa fa-shopping-cart"></i>A�adir</button>
	      		</form>
	      		
	      	</div>
      		
   		 </div>           
          </c:forEach>  
      </div> 
      <c:if test="${not empty error}">
		<br>
		<div class="alert alert-danger">${error}</div>
		<br>
		
		</c:if>	 
		
  
  
 <%@include file="footer.jsp" %>
  