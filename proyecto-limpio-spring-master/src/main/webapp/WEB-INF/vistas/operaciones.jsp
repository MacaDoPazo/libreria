<%@include file="header.jsp" %>
	<main>
		<p>sumar:</p>
		<form action="sumar">
			<label for="Numero 1">Numero 1: </label>
			<input type="number" id="numero1" name="num1">
			<label for="Numero 2">Numero 2: </label>
			<input type="text" id="numero2" name="num2">
			<input type="submit" value="enviar">
		</form>
		<p>La suma total es: ${suma}</p>
		<p>restar:</p>
		<form action="restar">
			<label for="Numero 1">Numero 1: </label>
			<input type="number" id="numero1" name="num1">
			<label for="Numero 2">Numero 2: </label>
			<input type="text" id="numero2" name="num2">
			<input type="submit" value="enviar">
		</form>
		<p>La resta total es: ${resta}</p>
		<p>multiplicar:</p>
		<form action="multiplicar">
			<label for="Numero 1">Numero 1: </label>
			<input type="number" id="numero1" name="num1">
			<label for="Numero 2">Numero 2: </label>
			<input type="text" id="numero2" name="num2">
			<input type="submit" value="enviar">
		</form>
		<p>La multiplicación total es: ${multiplicacion}</p>
		<p>dividir:</p>
		<form action="dividir">
			<label for="Numero 1">Numero 1: </label>
			<input type="number" id="numero1" name="num1">
			<label for="Numero 2">Numero 2: </label>
			<input type="text" id="numero2" name="num2">
			<input type="submit" value="enviar">
		</form>
		<p>La division total es: ${dividir}</p>
		<p>${error}</p>
		<br>
<%@include file="footer.jsp" %>