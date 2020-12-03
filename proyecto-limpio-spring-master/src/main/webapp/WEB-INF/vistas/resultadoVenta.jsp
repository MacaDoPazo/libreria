<%@include file="header.jsp" %>

<div class = "container-fluid">

		 <div class= "card-4 row bg-light my-2 mx-2">
		 <h1 class ="titulos col-lg-12">Datos de su pago:</h1>
        <div class="col-lg-4 "><h3>El titular de la tarjeta es:</h3></div>
    <div class="col-lg-8 pt-2 ">${apellidoTitularTarjeta}  ${nombreTitularTarjeta}.</div>
       <div class="col-lg-4"><h3>El número de la tarjeta es:</h3></div>
    <div class="col-lg-8 pt-2">${numeroTarjeta}</div>
     <div class="col-lg-4"> <h3>El monto total de la venta es:</h3></div>
    <div class="col-lg-8 pt-2">$${montoTotal }</div> 
       </div>
		 
		<div class="table-responsive ">
                <table class="table table-striped mt-2">
                    <thead class="bg-dark text-light">
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Producto</th>
                            
                            <th scope="col" class="text-center">Cantidad</th>
                            <th scope="col" class="text-center">Precio unitario</th>
                            <th scope="col" class="text-center">Precio total</th>
                            
                        </tr>
                    </thead>
                    <tbody class="bg-light">
         <c:forEach items="${listaLibrosVendidos }" var="libros">
             <tr>
                 <td><img src="img/${libros.libro.nombre_archivo}" width="50" height="50" /> </td>
                 <td>${libros.libro.nombre} </td>
                 
                 <td class="text-center">${libros.cantidad }</td>
                 <td class="text-center">$${libros.libro.precio}</td>
                 <td class="text-center">${libros.cantidad *libros.libro.precio} </td>
                 
             </tr>
		</c:forEach>
                   </tbody>
                </table>
            </div>
</div>
		
<%@include file="footer.jsp" %>