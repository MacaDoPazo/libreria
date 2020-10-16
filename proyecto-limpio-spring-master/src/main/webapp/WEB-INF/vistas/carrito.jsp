<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <div class="col-16">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Producto</th>
                            
                            <th scope="col" class="text-center">Cantidad</th>
                            <th scope="col" class="text-center">Precio unitario</th>
                            <th scope="col" class="text-center">Precio total</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${librosPedidos }" var="libros">
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
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
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-16">
            <div class="row">
                <div class="col-16 ">
                   <a href="pantalla-inicial"><button type="button" class="btn btn-outline-dark btn-lg">Continuar comprando</button></a> 
                </div>
                <div class="col-16">
                    <a href="pantalla-inicial"><button type="button" class="btn btn-success btn-lg">Finalizar Compra</button></a>
                </div>
            </div>
        </div>
    </div>
</div>
	
	</section>
</body>
</html>
 <%@include file="footer.jsp" %>