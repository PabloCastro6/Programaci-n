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
		<h2>Panel de control Tienda de computadoras</h2>
	</header>
	<%@include file="/menu.html"%>
	<div class="container">
		<div class="form">
			<form
				action="http://localhost:8080/tienda/categorias/insertarCategorias"
				method="POST" id="formulario">
				<label for="nombre"> Nombre</label> <input type="text" id="nombre"
					name="nombre"><br> <label for="apellido">Descripcion</label>
				<input type="text" id="descripcion" name="descripcion"><br>
				<label for="activo">Activo</label> <input type="checkbox"
					id="activo" name="activo"><br> <input type="submit"
					value="Insertar">
			</form>
		</div>

		<c:if test="${resultado == 1}">

			<p>Categoria insertado correctamente</p>
		</c:if>
	</div>
</body>
</html>