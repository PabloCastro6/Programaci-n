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
	
		<form action = "http://localhost:8080/tienda/categorias/formularioactualizarcategorias" method = "POST">
			<label for = "id">ID Categoria</label>
				<input type = "text" id = "id" name = "id">
			<label for = "nombre">Nombre de la Categoria</label>
				<input type = "text" id = "nombre" name = "nombre">
			<label for = "descripcion">Descripcion</label>
				<input type = "text" id = "descripcion" name = "descripcion">
			<label for = "activo">Activo</label>
				<input type = "checkbox" id="activo" name ="activo">
			<input type = "submit" value = "Buscar">
		</form>
	
	</div>
	

	<c:forEach items ="${lista}" var ="categoria">
	
		<div class="form">
			<form action ="http://localhost:8080/tienda/categorias/actualizarcategorias" method="POST">
			
				<label for = "id">ID Categoria</label>
					<input type = "text" id = "id" name = "id" value="${categoria.id}" readonly>
			
				<label for = "id">Nombre de la Categoria</label>
					<input type = "text" id = "nombre" name = "nombre" value="${categoria.nombre}">
				<label for = "id">Descripcion</label>
					<input type = "text" id = "descripcion" name = "descripcion" value="${categoria.descripcion}">
				
				<label for = "activo">Activo</label>
				<c:if test ="${categoria.activo == 1}">				
					<input type="checkbox" id="activo" name ="activo" checked>
				</c:if>
				
				<c:if test ="${categoria.activo == 0}">				
					<input type="checkbox" id="activo" name ="activo" >
				</c:if>
								
				<input type="submit" value="Modificar">
			
			</form>
		</div>
		
	</c:forEach>

</div>



</body>
</html>
