<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="header.jsp" %>	
	<header>
		<h1>Datos del usuario registrado:</h1>
	</header>
	<main>
		<p>${nombre} ${apellido}, de sexo ${sexo}, nació el ${fechaNacimiento}, y se ha registrado con el mail ${mail} </p>


	</main>
</body>
</html>
 <%@include file="footer.jsp" %>