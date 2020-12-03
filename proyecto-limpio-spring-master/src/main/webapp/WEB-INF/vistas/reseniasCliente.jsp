<%@include file="header.jsp" %>
<h1 id="login-title" class="text-center">Mis Resenias</h1>
  	<div class="container mb-4"> 
    	<div class="row">   
    		<div class="col-12">
            	<div class="table-responsive">
	<table class="table table-hover">
    <thead class="bg-dark text-light">
      <tr>
        <th>Libro</th>
        
        <th>Resenia</th>
      </tr>
    </thead>
    <tbody class="bg-light">
      <c:forEach items="${listaResenia}" var="resenia">
      <tr>
        <td class=" h-75">
        <div class="d-flex flex-column d-flex align-items-center bg-warning">
         <img class="img-thumbnail" src="img/${resenia.libro.nombre_archivo}" width="100" height="150">
        	<span>${resenia.libro.nombre}</span>
        </div>
        </td>
        <td>	
        <div class="card">
  		<div class="card-header ">
          			<c:choose>
				        		<c:when test="${resenia.resenia.puntuacion == 1}">
									<h6 class="card-subtitle mb-2 text-muted">1 estrella <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${resenia.resenia.puntuacion == 2}">
									<h6 class="card-subtitle mb-2 text-muted">2 estrellas <i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${resenia.resenia.puntuacion == 3}">
									<h6 class="card-subtitle mb-2 text-muted">3 estrellas <i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${resenia.resenia.puntuacion == 4}">
									<h6 class="card-subtitle mb-2 text-muted">4 estrellas <i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
				        		<c:when test="${resenia.resenia.puntuacion == 5}">
									<h6 class="card-subtitle mb-2 text-muted">5 estrellas <i class="fas fa-star text-warning"></i> <i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i><i class="fas fa-star text-warning"></i></h6>
				        		</c:when>
					</c:choose>
		  </div>
		  <div class="card-body">
		    <blockquote class="blockquote mb-0">
		      <p>${resenia.resenia.comentario}</p>
		      
		    </blockquote>
		  </div>
		</div></td>
        
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