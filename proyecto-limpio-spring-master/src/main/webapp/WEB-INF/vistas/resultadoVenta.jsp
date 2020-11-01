
    <%@include file="header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Datos de su pago:</h1>

		<p>El titular de la tarjeta es ${apellidoTitularTarjeta}  ${nombreTitularTarjeta}. </p>
		<p>El número de la tarjeta es ${numeroTarjeta}, con fecha de caducidad  ${fechaCaducidadTarjeta}, y código de seguridad ${codigoSeguridadTarjeta}. </p>
		<p>La localidad de envío es la que tiene el ID: ${localidadEnvio}</p>
		<p>El monto total de la venta es: ${montoTotal } </p>
		<p>La venta fue realizada para el cliente con ID: ${idCliente } </p>
	
		 <c:forEach items="${listaLibrosVendidos }" var="libros">
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <td>${libros.libro.nombre} </td>
                            
                            <td class="text-center">${libros.cantidad }</td>
                            <td class="text-center">$${libros.libro.precio}</td>
                            <td class="text-center">${libros.cantidad *libros.libro.precio} </td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                   		</c:forEach>

</body>
</html>