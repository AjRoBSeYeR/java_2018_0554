<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<base href="${pageContext.request.contextPath}/">
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title></title>

    <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.2/examples/sign-in/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <form class="form-signin" action="login" method="post">
  <img class="mb-4" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Animal_footprint.svg/500px-Animal_footprint.svg.png" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">BIENVENIDO</h1>
  <label for="usuario" class="sr-only">Email</label>
  <input type="text" name="usu" id="usuario" class="form-control" placeholder="Usuario" required autofocus value="scooby">
  <label for="inputPassword" class="sr-only">Contrase�a</label>
  <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Contrase�a" required value="galletas">
  <p>${error}</p>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
</form>
</body>
</html>