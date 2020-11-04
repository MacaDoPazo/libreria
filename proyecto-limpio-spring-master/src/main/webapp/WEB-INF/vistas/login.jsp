<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<div class = "container">
	<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<form:form class="form-signin" action="validar-login" method="POST" modelAttribute="usuario">
		<h2 class="form-signin-heading">Ingresar al Sistema</h2>
		      <br>
		      <br>
		<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
		<form:input path="email" id="email" type="email" class="form-control" />
		<form:input path="password" type="password" id="password" class="form-control"/>     		  
		<br>
		<button class="btn btn-lg btn-primary btn-block" Type="Submit">Login</button>
		</form:form>
		
		<c:if test="${not empty error}">
		<br>
		<div class="alert alert-danger">${error}</div>
		<br>
		</c:if>	
	</div>
</div>
<br><br>
 <%@include file="footer.jsp" %>