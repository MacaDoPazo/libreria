<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- taglib para el formato de las fechas -->
<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Pedidos Clientes</h1>
 <div class="container"> 
       
	<table class="table table-hover">
    <thead class="bg-dark text-light">
      <tr>
        <th>Fecha</th>
        <th>Id pedido</th>
        <th>Estado</th>
        <th>Fecha de Entrega </th>
        <th>Monto</th>
        <th></th>
      </tr>
    </thead>
    <tbody class="bg-light">
      <c:forEach items="${listaPedidosCliente}" var="venta">
      <tr>
		<td><fmt:formatDate value="${venta.fechaDeVenta}" pattern="dd-MM-yyyy" /></td>
        <td> ${venta.pedido.id }</td>
        <td> ${venta.pedido.estado }</td>
        <td><fmt:formatDate value="${venta.pedido.fechaEntrega}" pattern="dd-MM-yyyy" /></td>
        <td>$${venta.montoTotal }</td>
        <td class="text-right"><a href="detalle-venta?pedidoId=${venta.pedido.id}&ventaId=${venta.id } "class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </a> </td>
      </tr>
       </c:forEach>
      
    </tbody>
  </table>
	</div>
<%@include file="footer.jsp" %>