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
			<form action="http://localhost:8080/tienda/pedidos/listarpedidos"
				method="POST" id="formulario">
				<label for="id">Id Pedido</label> 
				<input name="id" type="text" id="id" name="id"> 
				<br>				    
				<label for="id">Clientes</label> 
				<select name="cliente" id="cliente" form="formulario">
					<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboClientes}" var="cliente">
						<option value="${cliente.id}">${cliente.descripcion}</option>
					</c:forEach>
				</select> 
				    <br>
				    <label for="fecha">Fecha desde:</label>
				    <input name="fecha" type="date" id="fecha">
				    <br>
				 <label for="estado">Estado</label> 	
				<select name="estado" id="estado" form="formulario">	
					<option value="">Seleccionar Estado</option>					
				<c:forEach items="${comboEstados}" var="estado">
					<option value="${estado.id}">${estado.descripcion}</option>
				</c:forEach>
				</select> <br>
			 	<input type="submit" value="Buscar">
			</form>
		</div>
		<c:if test="${not empty lista }">
			<table>
				<tr>
					<th>ID</th>
					<th>CLIENTE</th>
					<th>PRODUCTO</th>
					<th>CANTIDAD</th>
					<th>PRECIO</th>
				</tr>

				<c:forEach items="${lista}" var="pedido">

					<tr>
						<td>${pedido.id}</td>
						<td>${pedido.cliente}</td>
						<td>${pedido.producto}</td>
						<td>${pedido.cantidad}</td>
						<td>${pedido.precio}</td>
					</tr>

				</c:forEach>

			</table>
		</c:if>

	</div>
</body>
</html>