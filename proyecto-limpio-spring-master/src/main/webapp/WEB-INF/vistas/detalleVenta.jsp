<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="header.jsp" %>
      <%@include file="navAdministrador.jsp" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 id="login-title" class="text-center">Detalle Venta</h1>
 <div class="container"> 
      <h3>fecha: ${pedido.venta.fechaDeVenta}</h3>
      <h3>N° de pedido: ${pedido.id}</h3> 
      <h3>Estado: ${pedido.estado }</h3>
      <form action="cambiar-estado" class="form" method="post">
        <select id="estado" name="estado" class="form-control ">
   		<option value="facturado">facturado</option>
   		<option value="enviado">enviado</option>
   		<option value="entregado">entregado</option>
   		</select>
   		<input type="hidden" id="idPedido" name="idPedido" value=${pedido.id }>
   		<input type="hidden" id="idVenta" name="idVenta" value=${pedido.venta.id }>
     	<input class="btn btn-success "type="submit" value="Cambiar">
  </form>  
	<table class="table table-hover">
    <thead>
      <tr>
        <th>libro</th>
        <th>precio</th>
        <th>cantidad</th>
        <th>monto</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${librosComprados}" var="libro">
      <tr>
        <td> ${libro.libro.nombre }</td>
        <td> ${libro.libro.precio }</td>
        <th> ${libro.cantidad }</th>
        <th>$${libro.precioTotal }</th>
      </tr>
       </c:forEach>
      <tr>
        <td>Localidad envio:</td>
        <td><strong>${pedido.localidad.nombre }</strong></td>
        <td><strong>Precio Envio:</strong></td>
        <td><strong>$${pedido.localidad.precio}</strong></td>
                            
      </tr>
      <tr>
        <td></td>
        <td></td>
        <td><strong>Total</strong></td>
        <td><strong>$${pedido.venta.montoTotal}</strong></td>
                            
      </tr>
    </tbody>
  </table>
  
	</div>
</body>
</html>