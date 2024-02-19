<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
<h2>Gestión de Tienda</h2>
	<%@include file="/menu.html"%>
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/productos/formularioactualizarproductos"
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

				</select> <br><input type="submit" value="Buscar">
			</form>
			
			
			<h3> Resultados de la búsqueda</h3>
			<c:forEach items="${lista}" var="producto">
    <div class="form">
        <form action="http://localhost:8080/tienda/productos/actualizarproductos" method="POST">
            <label for="ids"> ID</label>
            <input type="text" id="ids" name="ids" value="${producto.id}" readonly><br>
            <label for="nombres"> Nombre </label>
            <input type="text" id="nombres" name="nombres" value="${producto.nombre}"><br>
            <label for="descripciones"> Descripcion</label>
            <input type="text" id="descripciones" name="descripciones" value="${producto.descripcion}"><br>
            <label for="precios">Precio</label> 
            <input type="text" id="precios" name="precios" value="${producto.precio}" ><br> 
            <label for="cantidades">Cantidad en stock</label> 
            <input type="text" id="cantidades" name="cantidades" value="${producto.cantidad}" ><br> 
            <label for="categorias">Categoria</label>
            <select name="categorias" id="categorias">
                <c:forEach items="${comboCategoria}" var="categoria">
                    <option value="${categoria.id}" ${producto.categoria == categoria.id ? 'selected' : ''}>${categoria.descripcion}</option>
                </c:forEach>
            </select><br>
            <label for="proveedores">Proveedor</label> 
            <select name="proveedores" id="proveedores">
                <c:forEach items="${comboProveedor}" var="proveedor">
                    <option value="${proveedor.id}" ${producto.proveedor == proveedor.id ? 'selected' : ''}>${proveedor.descripcion}</option>
                </c:forEach>
            </select><br>
            <input type="submit" value="Modificar">
        </form>
    </div>
</c:forEach>
		</div>
		</div>
</body>
</html>