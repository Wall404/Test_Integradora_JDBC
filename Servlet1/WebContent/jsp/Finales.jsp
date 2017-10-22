<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE HTML>

<html>
<head>
<title></title>
</head>
<body>
<table style="width: 100%;">
	<tr bgcolor='#CCCCFF' align='center' valign= 'middle' height='20'>
		<td><h3>UNPAZ - PRACTICA INTEGRADORA - EJEMPLO FORMULARIO CON SERVLET </h3></td>
	</tr>
</table>

<table style="width: 100%;">
	<tr  bgcolor="#CCCCCC" >
		<th>Final ID</th>
		<th>Materia</th>
		<th>Nota</th>
	</tr>
	
	<c:forEach var="finalNota" items="${finales}">
		<tr>
			<td>${finalNota.id}</td>
			<td>${finalNota.descripcion_materia}</td>
			<td>${finalNota.nota}</td>

		</tr>
	</c:forEach>
</table>

</body>
</html>