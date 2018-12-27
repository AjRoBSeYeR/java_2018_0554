<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
<main role="main" class="container">
		<p>Autor: ${pagina.autor}</p>
	<div class="jumbotron">
		<p>Texto: ${pagina.texto}</p>
		
		
		
		<p>P�ginas totales: ${pagTotal}</p>
		<a href="libros">libros</a>
	</div>
		<p>Paginaci�n: ${pagActual+1} / ${pagTotal}</p>
		<a href="libros?pagina=${pagActual}">P�gina anterior</a>
		<form action="libros" method="get">
	      	<input type="number" name="pagina" >
	      	<input type="submit" value="ir a la p�gina">
      	</form>
		<a href="libros?pagina=${pagActual+2}">P�gina siguiente</a>
		
		<h2>Escribir nueva P�gina</h2>
		<form action="libros" method="post">
			<input type="text" name="autor" value="${usuario.email}"><br>
			<textarea name="texto" placeholder="minimo 50 caracteres"></textarea><br>
			<input type="submit" value="Nueva p�gina">
		</form>
</main>