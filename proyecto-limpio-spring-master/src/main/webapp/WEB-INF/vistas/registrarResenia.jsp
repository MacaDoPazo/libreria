<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de reseña</title>
	   
</head>
<body>
	<h1 id="login-title" class="text-center">¡Registre la reseña de los libros que ha comprado!</h1>
	<h3 id="login-subtitle" class="text-center">Su aporte nos ayuda a conocer sus preferencias y nos permite recomendarle contenido de su interés</h3>

<div class="container"> 
      <h3>fecha: ${pedido.venta.fechaDeVenta}</h3>
      <h3>N° de pedido: ${pedido.id}</h3> 
   
      
	<table class="table table-hover">
    <thead>
      <tr>
        <th>Libro</th>
        <th>Autor</th>
        <th>Género</th>
        
      </tr>
    </thead>
    <tbody>
    
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
          	 
   			 <input class="btn btn-success "type="submit" value="Reseña" >
     	</form>
     	
		        </c:if>
     	</td> 
      </tr>
      
       </c:forEach>
      
    </tbody>
  </table>
  
	</div>
</body>
</html>
<%@include file="footer.jsp" %>