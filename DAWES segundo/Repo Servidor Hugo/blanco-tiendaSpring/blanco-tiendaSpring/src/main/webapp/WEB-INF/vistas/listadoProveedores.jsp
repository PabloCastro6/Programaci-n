<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/tienda/css/index.css">
	 <link rel="stylesheet" href="/tienda/css/formularios.css">
	 <link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
<header>
</header>
<h2>Panel de control Tienda de computadoras</h2>

<%@include file="/menu.html" %>


<div class="container">
	<div class= "form">
		<form action="http://localhost:8080/tienda/proveedores/listarproveedores" method ="POST">
			
			<label for="nombre"> Nombre</label>
			<input type ="text" id="nombre" name="nombre"><br>
			<label for="contacto">Contacto</label>
			<input type ="text" id="contacto" name="contacto"><br>
			<label for="telefono"> Telefono</label>
			<input type ="text" id="telefono" name="telefono"><br>
			<label for="correo"> Correo Electronico</label>
			<input type ="text" id="correo" name="correo"><br>
			<label for="direccion"> Direccion</label>
			<input type ="text" id="direccion" name="direccion"><br>
			<label for="activo">Activo</label>
			<input type="checkbox" id="activo" name="activo"><br>
			<input type ="submit" value="Enviar">
		
		</form>
	
	
	</div>

<c:if test="${not empty lista }">
	<table>
		<tr>
			<th>ID PROVEEDOR</th>
			<th>NOMBRE </th>
			<th>CONTACTO</th>
			<th>TELEFONO</th>
			<th>CORREO </th>
			<th>DIRECCION </th>
		</tr>
		
		<c:forEach items="${lista}" var="proveedor">
		
			<tr>
				<td> ${proveedor.id} </td>
				<td> ${proveedor.nombre} </td>
				<td> ${proveedor.contacto } </td>
				<td> ${proveedor.telefono } </td>
				<td> ${proveedor.correo } </td>
				<td> ${proveedor.direccion } </td>
			</tr>
		
		</c:forEach>
	
	</table>
</c:if>

</div>



</body>
</html>
