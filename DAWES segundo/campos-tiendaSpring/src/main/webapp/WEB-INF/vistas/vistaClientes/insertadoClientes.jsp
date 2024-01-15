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
	
		<form action = "http://localhost:8080/tienda/clientes/insertarcliente" method = "POST" id="formulario">

			<label for = "nombre">Nombre</label>
				<input type = "text" id = "nombre" name = "nombre">
			<br>
			<label for = "correo">Correo Electr�nico</label>
				<input type = "text" id = "correo" name = "correo">
			<br>
			<label for = "idPoblacion">Poblacion</label>
			
			<select name ="idPoblacion" id="idPoblacion" form ="formulario">
			<option value="" selected> - Selecciona una poblaci�n - </option>
				<c:forEach items ="${comboMunicipio}" var="poblacion">
					
					<option value="${poblacion.id}">${poblacion.nombre}</option>
					
				</c:forEach>
				
				<option value="${cliente.idPoblacion}">${cliente.poblacion} </option>
			
			</select>
			
			<label for = "activo">Activo</label>
				<input type = "checkbox" id="activo" name ="activo">
			<input type = "submit" value = "enviar">
					
		</form>
	
	</div>
	
	<c:if test="${resultado ==1}">
		<h3>Cliente insertado con �xito</h3>
	</c:if>
	

</div>



</body>
</html>