<%@include file="header.jsp" %>
	<h1 id="login-title" class="text-center">Listado de géneros cargados</h1>
	 <div class="container"> 
	       
		<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Id</th>
	        <th>Nombre</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach items="${lista}" var="genero">
	      <tr>
	        <td> ${genero.id }</td>
	        <td> ${genero.nombre }</td>
	        <td class="text-right"><button class="btn btn-sm btn-secondary"><i class="fa fa-tasks"></i> </button><a href="borrar-genero?id=${genero.id }"class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a> </td>
	      </tr>
	       </c:forEach>
	      
	    </tbody>
	  </table>
	</div>
<%@include file="footer.jsp" %>