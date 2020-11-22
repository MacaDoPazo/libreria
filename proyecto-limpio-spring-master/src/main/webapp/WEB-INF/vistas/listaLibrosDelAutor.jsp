<%@include file="header.jsp" %>
 

	<div style="  padding-top: 50px;  padding-bottom: 50px;  padding-left: 50px;">
 		<h4>Te mostramos algunos títulos de ${nombreYApellidoDelAutor } que te pueden llegar a interesar:</h4>
 	</div> 
    
    	<div class="w3-row-padding w3-padding-16 w3-center row" id="food">
	 	<div class="container" id="food">
	    <div class="card-deck">
       <c:forEach items="${lista}" var="item">
    
      	   
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
   	
   
<%@include file="footer.jsp" %>