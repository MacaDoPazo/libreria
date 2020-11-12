<%@include file="header.jsp" %>

	<section>
	<div class="container mb-5">
	<div class="alert alert-danger" role="alert">
  ${mensaje }
</div>
    <div class="row">
        <div class="col-16">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Producto</th>
                            
							
							<!-- holaa -->
							
                            <th scope="col" class="text-center">Cantidad</th>
                            <th scope="col" class="text-center">Precio unitario</th>
                            <th scope="col" class="text-center">Precio total</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${librosPedidos }" var="libros">
                        <tr>
                            <td><img src="img/${libros.libro.nombre_archivo}" width="50" height="50"> </td>
                            <td>${libros.libro.nombre} </td>
                            
                            <td class="text-center">${libros.cantidad }</td>
                            <td class="text-center">$${libros.libro.precio}</td>
                            <td class="text-center">$${libros.precioTotal}</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                   		</c:forEach>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-center">${subtotal } $</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text-right"><b>calcular envio:</b></td>
                            <td>
                            <form action="buscar-localidad">
                            		 <input class="form-control" type="number" id="cp" name="cp"><br>
   								   <input type="hidden" id="idCliente" name="idCliente" value= 1>
     						  		<input class="btn btn-success "type="submit" value="Calcular">
     						</form>  		
                            	</td>
                            <td>${localidad.nombre }</td>
                            <td>Envio</td>
                            <td class="text-center">${localidad.precio }$</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Total</strong></td>
                            <td class="text-center"><strong>${total } $</strong></td>
                            
                        </tr>
                        <a href="pantalla-inicial"><button type="button" class="btn btn-outline-dark float-right  btn-lg">Continuar comprando</button></a>
                    </tbody>
                </table>
            </div>
        </div>
        
        
        <h2 class="text-primary mt-6 mb-3 col-sm-12  col-md-12">Ya es hora de generar el pago con tu tarjeta:</h2>
        
       <form action="guardar-venta" class="container" method="POST" >  <!-- modelAttribute="venta" -->
            <input type="hidden" id="montoTotal" name="montoTotal" value= ${total }>
            <br>
       			<input type="hidden" id="idCliente" name="idCliente" value= 1>	
            <br>
               <input type="hidden" id="localidadEnvio" name="localidadEnvio" value= ${localidad.cp }>            
			 <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Nombre:</label>
	            <div class="col-sm-4">
	                <input type="text" name="nombreTitularTarjeta" class="form-control">
	            </div>
	        </div>	        
	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Apellido:</label>
	            <div class="col-sm-4">
	                <input type="text" name="apellidoTitularTarjeta" class="form-control">
	            </div>
	        </div>	        
	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">N° de tarjeta:</label>
	            <div class="col-sm-4">
	                <input type="text" name="numeroTarjeta" class="form-control border" id="numeroTarjeta">
	            </div>
        	</div>        	
        	<div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Fecha de caducidad:</label>
	            <div class="col-sm-4">
	                <input type="text" name="fechaCaducidadTarjeta" class="form-control" id="fechaCaducidadTarjeta">
	            </div>
	        </div>
	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Cod. de seguridad:</label>
	            <div class="col-sm-4">
	                <input type="number" name="codigoSeguridadTarjeta" class="form-control">
	            </div>
	        </div>	             
            <input id="submit-button" name="enviar" class="btn btn-success float-right btn-lg" type="submit" value="Finalizar Compra">
         
        </form>
        
               </div>
                
                
            </div>
    
	</section>
 <%@include file="footer.jsp" %>