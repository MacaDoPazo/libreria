<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- taglib para el formato de las fechas -->
<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">¡Registre la reseña de los libros que ha comprado!</h1>
	<h3 id="login-subtitle" class="text-center">Su aporte nos ayuda a conocer sus preferencias y nos permite recomendarle contenido de su interés</h3>
	<div class="container"> 
	      
	      <br>
	      <h3>Fecha en que realizó el pedido: <fmt:formatDate value="${pedido.venta.fechaDeVenta}" pattern="dd-MM-yyyy" /></h3>
	      <h3>N° de pedido: ${pedido.id}</h3>
	      <br> 
	   
	      
		<table class="table table-hover">
	    <thead class="bg-dark text-light">
	      <tr>
	        <th>Libro</th>
	        <th>Autor</th>
	        <th>Género</th>
	        
	      </tr>
	    </thead>
	    <tbody class="bg-light">
	    
	      <c:forEach items="${librosComprados}" var="libro">
	      <tr>
	        <td> ${libro.libro.nombre }</td>
	        <td> ${libro.libro.autor.nombre } ${libro.libro.autor.apellido }</td>
	        <td> ${libro.libro.genero.nombre }</td>
	        <td>
	       <c:set var="Exisite" value="no" />
	    <c:forEach items="${listaResenia }" var="resenia">
	        <c:choose>
	        		<c:when test="${fn:contains(resenia.libro.id,libro.libro.id)}">
	        		 <c:set var="Exisite" value="${fn:replace(Exisite,'no','si') }" />
	        <form action="comentar-resenia" method="post">
	        
	 	   	 	   	 <input type="hidden" id="idCliente" name="idCliente" value= "${sessionScope.usuario_id}">
			   	 <input type="hidden" id="idLibro" name="idLibro" value= "${libro.libro.id }">
			   	 <input type="hidden" id="idPedido" name="idPedido" value= "${pedido.id}">
	          	 
	   			 <input class="btn btn-success "type="submit" value="Reseña" disabled>
	     	</form>
	     			
			        </c:when>
			        
			        </c:choose>
			</c:forEach> 
			<c:if test="${Exisite == 'no'}">
	        <form action="comentar-resenia" method="post">
	        
	 	   	 	   	 <input type="hidden" id="idCliente" name="idCliente" value= "${sessionScope.usuario_id}">
			   	 <input type="hidden" id="idLibro" name="idLibro" value= "${libro.libro.id }">
			   	 <input type="hidden" id="idPedido" name="idPedido" value= "${pedido.id}">
	          	 <br>
	   			 <input class="btn btn-success pull-right "type="submit" value="Reseña" >
	     	</form>
	     	
			        </c:if>
	     	</td> 
	      </tr>
	      
	       </c:forEach>
	      
	    </tbody>
	  </table>
	</div>
<%@include file="footer.jsp" %>