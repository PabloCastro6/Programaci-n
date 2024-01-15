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
	<h2>Gestión de Tiendas</h2>
</header>
<%@include file="/menu.html" %>
<div class = "container">

	<div class = "form">
		<form action ="http://localhost:8080/tienda/clientes/insertarcliente" method="POST" id="formulario">

			<label for = "nombre">Nombre de la Categoria</label>
				<input type = "text" id = "nombre" name = "nombre">
			<label for = "descripcion">Descripcion</label>
				<input type = "text" id = "descripcion" name = "descripcion">
				
			<select name ="municipios" id="municipios" form ="formulario">
				<c:forEach items ="${comboMunicipios}" var="municipio">
					
					<option value="${municipio.id}">${municipio.descripcion}</option>
					
				</c:forEach>
			
			</select>
			
			<label for = "activo">Activo</label>
				<input type = "checkbox" id="activo" name ="activo">

			<input type="submit" value ="insertar">
		</form>
		
	</div>

</div>

</body>
</html>