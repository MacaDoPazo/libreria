<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Catalogo de localidades cargados</h1>
 <div class="container"> 
       
	<table class="table table-hover">
    <thead class="bg-dark text-light">
      <tr>
        <th>Nombre</th>
        <th>cp</th>
        <th>Precio envío</th>
      </tr>
    </thead>
    <tbody class="bg-light">
      <c:forEach items="${listaLocalidades }" var="localidad">
      <tr>
        <td> ${localidad.nombre }</td>
        <td> ${localidad.cp }</td>
        <th> ${localidad.precio }</th>
        <td class="text-right"><button class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </button><a href="borrar-libro?idLibro=${libro.id }"class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
      </tr>
       </c:forEach>
      
    </tbody>
  </table>
</div>
<%@include file="footer.jsp" %>