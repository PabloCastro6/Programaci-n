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
			<h1> Panel de control Tienda de componentes informaticos </h1>
	</header>
	<%@include file="/menu.html"%>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/productos/insertarproductos"
				method="POST" id="formulario">

                    
				    <br>
					<label for="nombre"> Nombre Producto: </label> 
					<br>
					<input type="text" id="nombre" name="nombre"> 
					<br>
					<label for="descripcion"> Descripcion Producto: </label> 
					<br>
					<input type="text" id="descripcion" name="descripcion">
					<br> 
					<label for="precio"> Precio Producto: </label> 
					<br>
					<input type="text" id="precio" name="precio"> 
					<br>
					<label for="cantidad"> Cantidad en Stock: </label> 
					<br>
					<input type="text" id="cantidad" name="cantidad"> 
					<br>
					<label for="categoria"> Categoria: </label> 

					<select name="categorias" var="categorias" form="formulario">

   						 <c:forEach items="${combosCategorias}" var="categoria">
        					<option value="${categoria.id}">${categoria.nombre}</option>
    					</c:forEach>

    					<option value="${producto.idCategoria}">${producto.categoria}</option>
					</select>
					<br>
					<br>
       				<label for="proveedor"> Proveedor: </label> 

					<select name="proveedores" var="proveedores" form="formulario">

    					<c:forEach items="${combosProveedores}" var="proveedor">
        					<option value="${proveedor.id}">${proveedor.nombre}</option>
    					</c:forEach>

    					<option value="${producto.idProveedor}">${producto.proveedor}</option>
					</select>
					<br>
					<input type="submit" value="Insertar">

			</form>

		</div>


		<c:if test="${resultado == 1 }">
		
			<p> Producto insertado correctamente </p>

		</c:if>
	</div>

</body>
</html>
