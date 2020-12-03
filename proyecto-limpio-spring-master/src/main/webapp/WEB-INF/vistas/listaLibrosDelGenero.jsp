<%@include file="header.jsp" %>
 

	<div style="  padding-top: 50px;  padding-bottom: 50px;  padding-left: 50px;">
 		<h4>Te mostramos algunos títulos del género <b class="titulos">${nombreDelGenero}</b> que te pueden llegar a interesar:</h4>
 	</div> 
    
    	<div class="container row d-flex justify-content-center" >
	    
       <c:forEach items="${lista}" var="item">
    
      	   
         <div class="w3-quarter col-lg-3 bg-light mx-2 my-2">
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
   	
   
<%@include file="footer.jsp" %>