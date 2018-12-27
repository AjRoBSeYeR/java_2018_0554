<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'eu_ES'}" scope="session" /> --%>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18nmessages" /> 

<!DOCTYPE html>
<html lang="${language}">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC4B14eczpGQrbfGNpc72jeBel2-dAEVoLkhwaVUTVoRCNYjym">

    <title>Login LibroCompartido</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body class="text-center">
  <!-- Leer cookie para idioma -->
  <c:set var="cIdioma" value="${not empty cookie.cIdioma ? cookie.cIdioma.value : 'eu_ES'}" scope="session" />
  <%-- <p>Idioma de la cookie ${cIdioma}</p> --%>
  
    <form class="form-signin" action="login" method="POST">
      <img class="mb-4" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC4B14eczpGQrbfGNpc72jeBel2-dAEVoLkhwaVUTVoRCNYjym" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">
      	<fmt:message key="login.texto"/>
      </h1>
      <label for="idioma"><fmt:message key="login.idioma"/></label>
      <select class="form-control mb-5" id="idioma" name="idioma">
		          		<option value="ee_ES" ${(cIdioma=="ee_ES")?"selected":""}>Castellano</option>
		          		<option value="eu_ES" ${(cIdioma=="eu_ES")?"selected":""}>Euskera</option>
	  </select>
      <label for="email" class="sr-only">Email</label>
      
      <!-- Leer cookie para idioma -->
  <c:set var="cEmail" value="${not empty cookie.cEmail ? cookie.cEmail.value : ''}" scope="session" />
      
      <input type="email" id="email" name="email" class="form-control" placeholder="usuario@mail.com" required autofocus value="${cEmail}">
      <label for="pass" class="sr-only">Password</label>
      <input type="password" id="pass" name="pass" class="form-control" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" name="recuerdame" id="recuerdame" value="remember-me"> <fmt:message key="login.checkbox"/>
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
      	<fmt:message key="login.boton"/>
      </button>
     <c:if test="${mensaje != null}">
     <div class="alert alert-danger">${mensaje }</div>
     </c:if>
     <c:if test="${sesionNoIniciada != null}">
     <div class="alert alert-danger">${sesionNoIniciada }</div>
     </c:if>
    <a href="libro" class="btn btn-lg btn-danger btn-block">
		<fmt:message key="login.boton2"/>
	</a>
    </form>
  </body>
</html>
