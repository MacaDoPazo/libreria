<%@include file="header.jsp" %>
<h1>Datos de su pago:</h1>

		<p>El titular de la tarjeta es ${apellidoTitularTarjeta}  ${nombreTitularTarjeta}. </p>
		<p>El n�mero de la tarjeta es ${numeroTarjeta}, con fecha de caducidad  ${fechaCaducidadTarjeta}, y c�digo de seguridad ${codigoSeguridadTarjeta}. </p>
		<p>La localidad de env�o es la que tiene el ID: ${localidadEnvio}</p>
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
<%@include file="footer.jsp" %>