<%@ include file="../includes/header.jsp"  %>
<%@ include file="../includes/navbar.jsp"  %>
<%@ include file="../includes/mensajes.jsp"  %>
<main role="main" class="container en-dos">
	<div class="jumbotron">
		<form class="form-signin" action="login" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Reg�strate</h1>
			<label for="inputEmail" class="sr-only">Email</label>
			<input type="email" name="email" class="form-control" value="maria@gmail.com" placeholder="Email" required autofocus>
			<label for="inputPassword" class="sr-only">Contrase�a</label>
			<input type="password" name="pass" class="form-control" value="12345678" placeholder="Contrase�a" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
			<p class="error">${mensaje}</p>
		</form>
	</div>
	<div class="jumbotron">
		<a href="/libros" class="btn btn-lg btn-primary btn-block">Ver el libro</a>
	</div>
</main>