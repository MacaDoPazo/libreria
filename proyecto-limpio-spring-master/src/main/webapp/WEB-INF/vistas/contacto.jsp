<%@include file="header.jsp" %>
<body>
	<header>
		<h1>${titulo}</h1>
	</header>
	
	<main>
	<p>El resultado de la suma es ${suma}</p>
		<form action="mostrarConfirmacion">
			<label for="nombre">Nombre: </label>
			<input type="text" id="nombre" name="nombre">
			<label for="apellido">Apellido: </label>
			<input type="text" id="apellido" name="apellido">
			<input type="submit" value="enviar">
		</form>
	</main>
</body>
</html>