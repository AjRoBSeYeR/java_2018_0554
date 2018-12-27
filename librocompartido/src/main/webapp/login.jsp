<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'es_ES'}" scope="session" />-->
<c:set var="cIdioma" value="${not empty cookie.cIdioma ? cookie.cIdioma.value : 'es_ES'}" scope="session" />
<c:set var="cVisita" value="${not empty cookie.cVisita ? cookie.cVisita.value : 'Primer acceso'}" scope="session" />
<c:set var="cEmail" value="${not empty cookie.cEmail ? cookie.cEmail.value : 'tu@mail.com'}" scope="session" />
<fmt:setLocale value="${cIdioma}" /> 
<fmt:setBundle basename="i18nmessages" /> 
<!doctype html>
<base href="${pageContext.request.contextPath}/">
<html lang="${cIdioma}">
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
    <form  action="login" class="form-signin" method="post">
  <img class="mb-4" src="https://getbootstrap.com/docs/4.2/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal"><fmt:message key="bienvenida.login"/></h1>
  <label for="inputEmail" class="sr-only"><fmt:message key="lu.login"/></label>
  <input type="email" value="${cEmail}" name="usu" id="inputEmail" class="form-control" placeholder="<fmt:message key="lu.login"/>" required autofocus>
  <label for="inputPassword" class="sr-only"><fmt:message key="lc.login"/></label>
  <input type="password" name="pass"id="inputPassword" class="form-control" placeholder="<fmt:message key="lc.login"/>" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> <fmt:message key="rec.chk"/>
    </label>
  </div>
  <input name ="idioma" type="hidden" value="${cIdioma}">
  <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.boton"/></button>
  <p class="mt-5 mb-3 text-muted">${error}</p>
  <p class="mt-5 mb-3 text-muted">${cVisita}</p>
  <p><a href="cambioidioma?i=es_ES">Castellano</a>&nbsp;<a href="cambioidioma?i=eu_ES">Euskera</a></p>
</form>
</body>
</html>