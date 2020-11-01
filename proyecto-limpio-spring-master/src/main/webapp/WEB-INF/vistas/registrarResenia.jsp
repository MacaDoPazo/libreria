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
        <th>Puntuación</th>
        <th>Comentario</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${librosComprados}" var="libro">
      <tr>
        <td> ${libro.libro.nombre }</td>
        <td> ${libro.libro.autor.nombre } ${libro.libro.autor.apellido }</td>
        <td> ${libro.libro.genero.nombre }</td>
        <td>
        
        <form action="guardar-resenia" method="post">
        
 
			 <input type="radio" name="puntuacion" id="1" value="1" checked>
			 <label for="1">1<i class="far fa-star"></i></label> 
			 <input type="radio" name="puntuacion" id="2" value="2">
			 <label for="3">2<i class="far fa-star"></i></label>
			 <input type="radio" name="puntuacion" id="3" value="3">
			 <label for="3">3<i class="far fa-star"></i></label>
			 <input type="radio" name="puntuacion" id="4" value="4">
			 <label for="4">4<i class="far fa-star"></i></label>
			 <input type="radio" name="puntuacion" id="5" value="5">
			 <label for="5">5<i class="far fa-star"></i></label>
		<textarea rows="10" name="comentario" style="width:100%;"></textarea>
		
		   	 <input type="hidden" id="idCliente" name="idCliente" value= "${sessionScope.usuario_id}">
		   	 <input type="hidden" id="idLibro" name="idLibro" value= "${libro.libro.id }">
		   	 <input type="hidden" id="idPedido" name="idPedido" value= "${pedido.id}">
          	 
   			 <input class="btn btn-success "type="submit" value="enviar">
     	</form>
     	</td> 
      </tr>
      
       </c:forEach>
      
    </tbody>
  </table>
  
	</div>
</body>
</html>
<%@include file="footer.jsp" %>