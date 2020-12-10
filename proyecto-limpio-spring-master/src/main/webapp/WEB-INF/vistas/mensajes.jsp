<%@include file="header.jsp" %>
	<h1 id="login-title">Mensajes</h1>
	 <div class="container"> 
	 	<div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	    
		    <c:choose>
			    <c:when test="${not empty lista_mensajes }">
				<table class="table table-hover">
			    <thead>
			      <tr>
			      	<th>Asunto</th>
			      	<th>Cuerpo</th>
			        <th>Estado</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach items="${lista_mensajes}" var="mensaje" varStatus="loop">
			      <tr>
			        <td>${mensaje.asunto}</td>
			        <td>
			        	<button type="button" class="btn btn-primary" data-toggle="modal"  data-target="#myModal-${loop.index}">
						  Ver Mensaje
						</button>
					</td>
					<c:choose>
					<c:when test="${mensaje.leido}">
						<td>Leido</td>
					</c:when>
					<c:otherwise>
						<td>Sin Leer</td>
					</c:otherwise>
					</c:choose>
					
			      </tr>
			      <div class="modal fade" id="myModal-${loop.index}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					  <div class="modal-dialog modal-dialog-centered" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLongTitle">${mensaje.asunto}</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        ${mensaje.cuerpo}
					        <br>
					        <form action="listaVentasAlCliente" method="GET" modelAttribute="usuario">
					           <button class="btn btn-sm btn-success">Ir a Reseñas</button>
					       	</form>
					      </div>
					      <div class="modal-footer">
					      	<form action="actualizar_mensajes" method="POST" modelAttribute="mensaje">
					      		<c:set var="mensaje" value="${mensaje.leido=true}"/>
								<c:set var="mensajes_leidos" value="${sessionScope.mensajes = lista_mensajes}" scope="session"/>
					        	<button type="button" onClick="window.location.reload()" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
				        	</form>
					      </div>
					    </div>
					  </div>
					</div>
					
			       </c:forEach>
			      
			    </tbody>
			  </table>
			  <br>
			  
			  </c:when>
			  <c:otherwise>
			  	<br>
			    	<div>
			    	<p class="alert alert-info">No tiene mensajes nuevos sin leer</p>
			    	</div>
		    	<br>
			  </c:otherwise>
		  </c:choose>
	  
	  </div>
	</div>
<%@include file="footer.jsp" %>