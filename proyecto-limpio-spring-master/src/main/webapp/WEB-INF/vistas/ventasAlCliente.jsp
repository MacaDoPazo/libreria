 <%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- Bootstrap core CSS -->
		    <link href="css/bootstrap.min.css" rel="stylesheet" >
		    <!-- Bootstrap theme -->
		    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
		    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sus compras</title>
	</head>
	<body>
	
    <h1 id="login-title" class="text-center">Detalle de sus compras</h1>
  	<div class="container mb-4"> 
    	<div class="row">   
    		<div class="col-12">
            	<div class="table-responsive">
	<table class="table table-hover">
    <thead>
      <tr>
        <th>ID</th>
        <th>Fecha</th>
        <th>Monto</th>
        <th>Estado</th>
        <th>Reseña</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${listadoVentasRealizadasAlCliente }" var="venta">
      <tr>
        <td>${venta.id }</td>
        <td>${venta.fechaDeVenta }</td>
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
	</body>
</html>
<%@include file="footer.jsp" %>