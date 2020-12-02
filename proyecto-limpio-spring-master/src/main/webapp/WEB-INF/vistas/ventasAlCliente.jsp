<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- taglib para el formato de las fechas -->
<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Detalle de sus compras</h1>
 	<div class="container mb-4"> 
   	<div class="row">   
   		<div class="col-12">
           	<div class="table-responsive">
				<table class="table table-hover">
				    <thead class="bg-dark text-light">
				      <tr>
				        <th>ID</th>
				        <th>Fecha</th>
				        <th>Monto</th>
				        <th>Estado</th>
				        <th>Reseña</th>
				      </tr>
				    </thead>
				    <tbody class="bg-light">
				      <c:forEach items="${listadoVentasRealizadasAlCliente }" var="venta">
				      <tr>
				        <td>${venta.id }</td>
				        <td><fmt:formatDate value="${venta.fechaDeVenta}" pattern="dd-MM-yyyy" /></td>
				        <td>$${venta.montoTotal }</td>
				        <td>${venta.pedido.estado }</td>
				        <td><c:choose>
				        		<c:when test="${venta.pedido.estado == 'entregado'}">
				        			
				        			<!-- <a class="nav-link" href="registrar-resenia">Registrar reseña</a> -->
				        			
				        			       <form action="registrar-resenia" method="post">
				   							 <input type="hidden" id="idPedido" name="idPedido" value= ${venta.pedido.id }> 
				     						  	<input class="btn btn-success "type="submit" value="Registrar reseña">
				     						</form>
				        			
				        		</c:when>
				        	</c:choose>
				        </td>
				        
				      </tr>
				       </c:forEach>
				      
				    </tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>