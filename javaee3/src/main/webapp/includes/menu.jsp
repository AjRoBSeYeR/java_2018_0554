<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
		<a class="navbar-brand" href="#">Videos</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Inicio
						<span class="sr-only">(current)</span>
				</a></li>
			<li class="nav-item active"><a class="nav-link" href="privado/usuarios">Usuarios
						<span class="sr-only">(current)</span>
				</a></li>
			<li class="nav-item active"><a class="nav-link" href="privado/videos">Videos
						<span class="sr-only">(current)</span>
				</a></li>
			</ul>
			<ul class="navbar-nav mr-auto border border-success">
			<li class="nav-item">
            <i class="fa fa-user-o fa-2x text-success" aria-hidden="true"></i>
          	</li>
          	<li class="nav-item">
          	<span class="text-warning">${sessionScope.usuario_logueado.email }</span>
          	</li>
			</ul>
			
				
			<form class="form-inline mt-2 mt-md-0" action="logout" method="POST">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerrar Sesi�n</button>
			</form>
		</div>
	</nav>