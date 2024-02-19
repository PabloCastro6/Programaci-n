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
			<form action="http://localhost:8080/tienda/productos/listarproductos"
				method="POST" id="formulario">
				<label for="id">Id producto</label> <input type="text" id="id"
					name="id"><br> <label for="nombre"> Nombre</label> <input
					type="text" id="nombre" name="nombre"><br> <label
					for="descripcion"> Descripcion</label> <input type="text"
					id="descripcion" name="descripcion"> <br> <label
					for="precio">Precio</label> <input type="text"
					id="precio" name="precio"><br> <label
					for="cantidad">Cantidad en stock</label> <input type="text"
					id="cantidad" name="cantidad"><br> <label for="categoria">Categoria</label>
				<select name="categoria" id="categoria" form="formulario">
										<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboCategoria}" var="categoria">

						<option value="${categoria.id}">${categoria.descripcion}</option>


					</c:forEach>

				</select> <br><label for="activo">Proveedor</label> <select name="proveedor"
					id="proveedor" form="formulario">
										<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboProveedor}" var="proveedor">

						<option value="${proveedor.id}">${proveedor.descripcion}</option>


					</c:forEach>

				</select> <br><input type="submit" value="Enviar">
			</form>
		</div>
		<c:if test="${not empty lista }">
			<table>
				<tr>
					<th>ID</th>
					<th>NOMBRE</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>CANTIDAD SOCK</th>
					<th>CATEGORIA</th>
					<th>PROVEEDOR</th>
				</tr>

				<c:forEach items="${lista}" var="producto">

					<tr>
						<td>${producto.id}</td>
						<td>${producto.nombre}</td>
						<td>${producto.descripcion}</td>
						<td>${producto.precio}</td>
						<td>${producto.cantidad}</td>
						<td>${producto.categoria}</td>
						<td>${producto.proveedor}</td>
					</tr>

				</c:forEach>

			</table>
		</c:if>

	</div>
</body>
</html>