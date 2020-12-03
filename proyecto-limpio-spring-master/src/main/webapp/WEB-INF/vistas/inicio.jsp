<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
	<br>
	<div class="container">
	<c:if test="${empty error}">
		<hr style="height:2px;border-width:0;color:gray;background-color:gray">
		<h1 class="text-center">Porque te interesa el género <a href="listar-libros-genero?genero_id=${idGeneroSugerido}" style="text-decoration:none">${generoSugerido }</a></h1>
		
		<%-- <a href="listar-libros-autor?autor_id=${item.autor.id}" style="text-decoration:none"><h6>${item.autor.nombre} ${item.autor.apellido}</h6></a> --%>
		
		<hr style="height:2px;border-width:0;color:gray;background-color:gray">
	</c:if>	
 	<div class="w3-row-padding w3-padding-16 w3-center row" id="food">
	 	<div class="container" id="food">
    		<div class="card-deck">
		    	<c:forEach items="${listaGenero}" var="libro" varStatus="loop" >
		    	   <div class="w3-quarter col">
			      	   <a href="#" >
			      	   <img src="img/${libro.nombre_archivo}" alt="${libro.nombre_archivo}" style="width:100%">
			      	   </a>
			      		<div class="card-body">
			      			<h3 class="card-text">${libro.nombre}</h3>
				      		<a href="listar-libros-autor?autor_id=${libro.autor.id}" style="text-decoration:none">${libro.autor.nombre} ${libro.autor.apellido}</a>
				      		<p class="card-text">$ ${libro.precio}<p> 
				      		<%-- <div class="card-text d-flex justify-content-center"><a href="sumar-megusta?idLibro=${libro.id }"class="" id="botonlike"><i class="far fa-heart"></i> </a><p id="cantidadlikes"> &nbsp ${item.megusta}</p></div> --%>
				      		<b>${promedioMayorPuntaje[loop.index] }/5 <i class="fas fa-star"></i></b>
				      		<form action="agregar-al-carrito" >
				      		<input class="form-control " type="number" id="cantidad" name="canitdad" placeholder="0" style="width:50px" min=1 required><br>
				      		<input type="hidden" id="precio" name="idLibro" value= ${libro.id }>
				     		 <input type="hidden" id="precio" name="precio" value= ${libro.precio }>
				      		 <input class="btn btn-success mx-auto"type="submit" value="Añadir al carrito">
				      		</form>
				      		<a href="detalle-producto?idLibro=${libro.id}" class=" mx-auto"><button type="button" class="btn btn-outline-dark">+ info</button></a>
			      		</div>
		   			</div>           
		          </c:forEach>  
			</div>     	
  		</div>
  	</div>
  </div>
 <%@include file="footer.jsp" %>
  
  