<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
<title></title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">

</head>
<body>
	<table style="width: 100%;">
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><c:choose>
					<c:when test="${empty alumno}">
						<h3>Todos los Finales</h3>
					</c:when>
					<c:otherwise>
						<h3>
							Finales del Alumno :
							<c:out value="${alumno.id_alumno}" />
							-
							<c:out value="${alumno.apel_nombre}" />
						</h3>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>

	<table class="table table-striped table-hover table-dark" style="width: 100%;">
	<thead class="thead-dark">
		<tr>
			<th>Final ID</th>
			<th>Alumno</th>
			<th>Materia</th>
			<th>Nota</th>
			<th>Borrar Final</th>
		</tr>
		</thead>

		<c:forEach var="finalNota" items="${finales}">
			<tr>
				<td>${finalNota.id}</td>
				<td>${finalNota.apel_nombre}</td>
				<td>${finalNota.descripcion_materia}</td>
				<td>${finalNota.nota}</td>
				<td><a href="${finalNota.deleteURL}" class="btn btn-danger">Borrar</a>
				</td>

			</tr>
		</c:forEach>
	</table>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>

</body>
</html>