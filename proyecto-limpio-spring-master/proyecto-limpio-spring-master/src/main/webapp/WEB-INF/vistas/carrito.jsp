<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>carrito compras</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body>
	<section>
	<div class="container mb-5">
    <div class="row">
        <div class="col-15">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Producto</th>
                            <!-- <th scope="col">Disponible</th> -->
                            <th scope="col" class="text-center">Cantidad</th>
                            <th scope="col" class="text-center">Precio unitario</th>
                            <th scope="col" class="text-center">Precio total</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <td>${libro.nombre}</td>
                            <!-- <td>en stock</td> -->
                            <td class="text-center">${cantidad}</td>
                            <td class="text-center">$${libro.precio}</td>
                            <td class="text-center">$${precioTotal}</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <td>Cherries, interrupted</td>
                           <!--  <td>en stock</td> -->
                            <td><input class="form-control" type="text" value="1" /></td>
                            <td class="text-center">500$</td>
                            <td class="text-center">500$</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <td>Cherries, interrupted</td>
                            <!-- <td>en stock</td> -->
                            <td><input class="form-control" type="text" value="1" /></td>
                            <td class="text-center">200$</td>
                            <td class="text-center">500$</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-center">820 $</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td class="text-right"><b>calcular envio:</b></td>
                            <td><form action="buscar-localidad" method="post">
                            		<input class="form-control" type="number" placeholder=CP name="cp">
                            		<input type="submit" value=Calcular class="btn btn-success">
                            	</form></td>
                            <td></td>
                            <td>Envio</td>
                            <td class="text-center">${localidad.precio }$</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>Total</strong></td>
                            <td class="text-center"><strong>820 $</strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        

       <div class="col-sm-6  col-md-6">
          <a href="pantalla-inicial"><button class="btn btn-lg btn-block btn-outline-dark text-uppercase">Continuar comprando</button></a> 
       </div>      
       
        
        <h2 class="text-primary mt-6 mb-3 col-sm-12  col-md-12">Ya es hora de generar el pago con tu tarjeta:</h2>
        
        
         <form action="" class="container" id="form-pago">
	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Nombre:</label>
	            <div class="col-sm-4">
	                <input type="text" name="nombre" class="form-control">
	            </div>
	        </div>
	        
	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Apellido:</label>
	            <div class="col-sm-4">
	                <input type="text" name="apellido" class="form-control">
	            </div>
	        </div>
	        
	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">N° de tarjeta:</label>
	            <div class="col-sm-4">
	                <input type="text" name="numeroTarjeta" class="form-control border" id="numero-tarjeta">
	            </div>
        	</div>
        	
        	<div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Fecha de caducidad:</label>
	            <div class="col-sm-4">
	                <input type="text" name="fechaCaducidad" class="form-control" id="fecha-caducidad">
	            </div>
	        </div>

	        <div class="form-group row">
	            <label for="" class="text-secondary col-sm-2 col-form-label">Cod. de seguridad:</label>
	            <div class="col-sm-4">
	                <input type="number" name="codigoSeguridad" class="form-control">
	            </div>
	        </div>
	        
	     </form>
	     
	   <div class="col-sm-12  col-md-6">
           <button class="btn btn-lg btn-block btn-success text-uppercase">Finalizar compra</button>
       </div>  
        
<!--         <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                   <a href="pantalla-inicial"><button class="btn btn-lg btn-block btn-outline-dark">Continuar comprando</button></a> 
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase">Finalizar compra</button>
                </div>
            </div>
        </div> -->
    </div>
</div>
	
	</section>
</body>
</html>
 <%@include file="footer.jsp" %>