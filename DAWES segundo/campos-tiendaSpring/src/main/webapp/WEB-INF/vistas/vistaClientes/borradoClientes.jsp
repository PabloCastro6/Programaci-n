<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/tienda/css/index.css">
	 <link rel="stylesheet" href="/tienda/css/formularios.css">
	 <link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
<header>
<h2>Gesti�n de Tiendas</h2>
</header>
<%@include file="/menu.html" %>

<div class = "container">

	<div class = "form">
	
		<form action = "http://localhost:8080/tienda/clientes/formularioborrarcliente" method = "POST">

			<label for = "id">ID Cliente</label>
				<input type = "text" id = "id" name = "id">
			<br>
			<label for = "nombre">Nombre</label>
				<input type = "text" id = "nombre" name = "nombre">
			<br>
			<label for = "correo">Correo Electr�nico</label>
				<input type = "text" id = "correo" name = "correo">
			<br>
			<label for = "idPoblacion">Poblacion</label>
			
			<select name ="idPoblacion" id="idPoblacion">
			<option value="" selected> - Selecciona una poblaci�n - </option>
				<c:forEach items ="${comboClientes}" var="poblacion">
					
					<option value="${poblacion.id}">${poblacion.nombre}</option>
					
				</c:forEach>
			
			</select>
			
			<label for = "activo">Activo</label>
				<input type = "checkbox" id="activo" name ="activo">
			<input type = "submit" value = "enviar">
		</form>
	
	</div>
	
	<c:forEach items="${lista}" var="cliente">
	
		<div class = "form">
	
		<form action = "http://localhost:8080/tienda/clientes/borrarclientes" method = "POST">

			<label for = "id">ID Cliente</label>
				<input type = "text" id = "id" name = "id" value="${cliente.id}" readonly>
			<br>
			<label for = "nombre">Nombre</label>
				<input type = "text" id = "nombre" name = "nombre" value="${cliente.nombre}">
			<br>
			<label for = "correo">Correo Electr�nico</label>
				<input type = "text" id = "correo" name = "correo" value="${cliente.correo}">
			<br>
			<label for = "idPoblacion">Poblacion</label>
			
			<select name ="idPoblacion" id="idPoblacion">
			<option value="" selected> - Selecciona una poblaci�n - </option>
				<c:forEach items ="${comboClientes}" var="poblacion">
					
					<option value="${poblacion.id}">${poblacion.nombre}</option>
					
				</c:forEach>
				
				<option value="${cliente.idPoblacion}" selected>${cliente.nombrePoblacion} </option>
			
			</select>
			
			<label for = "activo">Activo</label>
				<c:if test ="${cliente.activo == 1}">				
					<input type="checkbox" id="activo" name ="activo" checked>
				</c:if>
				
				<c:if test ="${cliente.activo == 0}">				
					<input type="checkbox" id="activo" name ="activo" >
				</c:if>
				
			<input type = "submit" value = "Modificar">
		</form>
	
		</div>
	
	</c:forEach>
	

</div>



</body>
</html>