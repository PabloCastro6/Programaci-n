<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Gestión de Tienda</h2>
	</header>
	<%@include file="/menu.html"%>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/clientes/listarclientes"
				method="POST" id="formulario">
				<label for="id">Id Cliente</label> 
				<input type="text" id="id" name="id"> 
				<br>
				<label for="nombre">Nombre</label>
				<input type="text" id="nombre" name="nombre"> 
				<br>
				<label for="correo">Correo Electronico</label>
				<input type="text" id="correo" name="correo"> 
				<br>
				<label for="idPoblacion">Poblacion</label>
				<select name="idPoblacion" id="idPoblacion" >
					<option value="">Seleccione una opcion</option>
						<c:forEach items="${comboPoblacion}" var="poblacion">
							<option value="${poblacion.id}">${poblacion.descripcion}</option>
						</c:forEach>
				</select>
				<br>
				<label for="activo">Activo:</label> 
				<input type="checkbox" id="activo" name="activo">
				<br>
			 	<input type="submit" value="Buscar">
			</form>
		</div>
		<c:if test="${not empty lista }">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>CORREO</th>
					<th>POBLACION</th>
				</tr>

				<c:forEach items="${lista}" var="cliente">

					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nombre}</td>
						<td>${cliente.correo}</td>
						<td>${cliente.nombrePoblacion}</td>
					</tr>

				</c:forEach>

			</table>
		</c:if>

	</div>
</body>
</html>