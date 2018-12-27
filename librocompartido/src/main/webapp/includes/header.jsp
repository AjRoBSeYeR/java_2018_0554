<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="idioma"
	value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}"
	scope="session" />
<fmt:setLocale value="${idioma}" />
<fmt:setBundle basename="i18nmessages" />
<!doctype html>
<html lang="${idioma}">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>P�gina</title>
<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="css/logueo.css">
<link rel="stylesheet" type="text/css" href="css/misestilos.css">
<!-- Custom styles for this template -->
</head>