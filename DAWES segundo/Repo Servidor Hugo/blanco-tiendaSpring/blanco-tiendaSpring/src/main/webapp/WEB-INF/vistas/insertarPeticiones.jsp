<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
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

	<h3> Insertar peticiones</h3>

		<div class="form">
			<form
				action="http://localhost:8080/tienda/peticiones/insertarpeticiones"
				method="POST" id="formulario">
				<label for="cliente"> Cliente</label>
				<select name="cliente" id="cliente" form="formulario">
				<c:forEach items="${comboCliente}" var="cliente">
					<option value="${cliente.id}">${cliente.descripcion}</option>
				</c:forEach>

				</select> <br>
				<label for="producto"> Producto</label>
				<select name="producto" id="producto" form="formulario">
				<c:forEach items="${comboProducto}" var="producto">
					<option value="${producto.id}">${producto.descripcion}</option>
				</c:forEach>

				</select> <br>
				<label for="cantidad">Cantidad</label> 
				<input type="text" id="cantidad" name="cantidad">
				<br> 
				<label for="estado">Estado</label> 	
				<select name="estado" id="estado" form="formulario">	
					<c:forEach items="${comboEstado}" var="estado">
						<option value="${estado.id}">${estado.descripcion}</option>
					</c:forEach>
				</select> <br>
				<input type ="submit" value="Insertar">
				
			</form>
		</div>
	</div>
</body>
</html>