<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- taglib para el formato de las fechas -->
<%@include file="header.jsp" %>
	<h1 id="login-title">Listado de Usuarios No Frecuentes</h1>
	 <div class="container"> 
	 	<div style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	    <c:choose>
	    <c:when test="${not empty mensaje}">
	    <br>
	    	<div>
	    	<p class="alert alert-info text text-center">${mensaje}</p>
	    	</div>
    	<br>
	    </c:when>
	    <c:otherwise>
		    <c:choose>
			    <c:when test="${not empty lista_usuarios }">
				<table class="table table-hover">
			    <thead>
			      <tr>
			        <th>Apellido y Nombre</th>
			        <th>Fecha Último Login</th>
			        <th>Fecha Último Recordatorio</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach items="${lista_usuarios}" var="usuario">
			      <tr>
			        <td> ${usuario.apellido }, ${usuario.nombre }</td>
			        <td><fmt:formatDate value="${usuario.fecha_ultimo_login}" pattern="dd-MM-yyyy HH:mm" /> hs.</td>
			        <td><fmt:formatDate value="${usuario.fecha_ultimo_recordatorio}" pattern="dd-MM-yyyy HH:mm" /> hs.</td>
			      </tr>
			       </c:forEach>
			      
			    </tbody>
			  </table>
			  <br>
			  
			  	<a class="btn btn-success" href="enviar_recordatorios">Enviar Recordatorios</a>
			  </c:when>
			  <c:otherwise>
			  	<br>
			    	<div>
			    	<p class="alert alert-info">No se encontraron clientes no frecuentes</p>
			    	</div>
		    	<br>
			  </c:otherwise>
		  </c:choose>
	  </c:otherwise>
	  </c:choose>
	  </div>
	</div>
<%@include file="footer.jsp" %>