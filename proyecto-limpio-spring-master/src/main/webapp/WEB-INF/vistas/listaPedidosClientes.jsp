
     <%@include file="header.jsp" %>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 id="login-title" class="text-center">Pedidos Clientes</h1>
 <div class="container"> 
       
	<table class="table table-hover">
    <thead>
      <tr>
        <th>fecha</th>
        <th>id pedido</th>
        <th>estado</th>
        <th>monto</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listaPedidosCliente}" var="venta">
      <tr>
        <td> ${venta.fechaDeVenta }</td>
        <td> ${venta.pedido.id }</td>
        <th> ${venta.pedido.estado }</th>
        <th>$${venta.montoTotal }</th>
        <td class="text-right"><a href="detalle-venta?pedidoId=${venta.pedido.id}&ventaId=${venta.id } "class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </a> </td>
      </tr>
       </c:forEach>
      
    </tbody>
  </table>
	</div>
</body>
</html>