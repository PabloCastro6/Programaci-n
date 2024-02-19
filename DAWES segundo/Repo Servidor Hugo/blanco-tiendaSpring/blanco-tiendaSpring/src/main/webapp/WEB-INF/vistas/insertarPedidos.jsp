<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h1>Carrito de Compras</h1>
			    <label for="cliente">Seleccionar cliente:</label>
			<select id="cliente">
				<option value="">Seleccione una opcion</option>
				<c:forEach items="${comboClientes}" var="cliente">
					<option value="${cliente.id}">${cliente.descripcion}</option>
				</c:forEach>
			</select> <br> <br>  <label for="producto">Seleccionar producto:</label>
    		<select id="producto">
				<option value="" disabled selected>Seleccione una opción</option>
				<c:forEach items="${comboEstados}" var="producto">
					<option value="${producto.id}">${producto.descripcion}</option>
				</c:forEach>
			</select> <br> <br> <label for="cantidad">Cantidad:</label> <input
				type="number" id="cantidad" value="1"> <br> <br> <label
				for="precio">Precio:</label> <input type="number" id="precio" readonly>
			<br> <br>
			<button onclick="agregarAlCarrito()">Agregar al carrito</button>
			<button onclick="realizarVenta()">Realizar Venta</button>
		</div>

		<h2>Carrito</h2>
		<ul id="listaCarrito">
		</ul>
	</div>
	<script src="/tienda/js/script.js"></script>
</body>
</html>