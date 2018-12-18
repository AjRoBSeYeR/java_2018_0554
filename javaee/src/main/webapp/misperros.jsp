<%@page import="com.ipartek.formacion.modelos.pojos.Perro, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Perro> perros = (ArrayList<Perro>) request.getAttribute("listado");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>MIS PERROS</h1>

<table>
	<thead>
			<tr>
				<th>ID</th>
				<th>raza</th>
				<th>Imagen</th>
			</tr>
		</thead>
		<tbody>
		<% if (perros.size()!=0) {%>
			<%
				for (Perro p : perros) {
			%>
			<tr>
				<th><%=p.getId()%></th>
				<td><%=p.getRaza()%></td>
				<td><img width=150 height=150 src="<%=p.getImagen()%>" alt="Imagen <%=p.getRaza()%>"></td>
			</tr>
			<%
				}
			}else{%>
			<tr>
				<td>NO</td>
				<td>EXISTEN</td>
				<td>PERROS</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	 

</body>
</html>