<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false"%>
<html>
<head>
    <link rel="stylesheet" href="/tienda/css/index.css">
    <link rel="stylesheet" href="/tienda/css/formularios.css">
    <link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
<header>
    <h2>Panel de control Tienda de computadoras</h2>
</header>
<%@include file="/menu.html" %>

<div class="container">
    <h3> Borrar Proveedores</h3>
    <div class="form">
        <form action="http://localhost:8080/tienda/proveedores/formularioborrarproveedores" method="POST">
            <label for="id"> ID </label>
            <input type="text" id="id" name="id"><br>
            <label for="nombre"> Nombre </label>
            <input type="text" id="nombre" name="nombre"><br>
            <label for="contacto">Contacto</label>
            <input type="text" id="contacto" name="contacto"><br>
            <label for="telefono"> Telefono</label>
            <input type="text" id="telefono" name="telefono"><br>
            <label for="correo"> Correo Electrónico</label>
            <input type="text" id="correo" name="correo"><br>
            <label for="direccion"> Dirección</label>
            <input type="text" id="direccion" name="direccion"><br>
            <label for="activo">Activo</label>
            <input type="checkbox" id="activo" name="activo"><br>
            <input type="submit" value="Buscar">
        </form>
    </div>

    <h3> Resultados de la búsqueda</h3>
    <c:forEach items="${lista}" var="proveedor">
        <div class="form">
            <form action="http://localhost:8080/tienda/proveedores/borrarproveedores" method="POST" >
                <label for="idProv"> ID Proveedor</label>
                <input type="text" id="idProv" name="idProv" value="${proveedor.id}" readonly><br>
                <label for="nombreProv"> Nombre </label>
                <input type="text" id="nombreProv" name="nombreProv" value="${proveedor.nombre}"><br>
                <label for="contactoProv">Contacto</label>
                <input type="text" id="contactoProv" name="contactoProv" value="${proveedor.contacto}"><br>
                <label for="telefonoProv"> Telefono</label>
                <input type="text" id="telefonoProv" name="telefonoProv" value="${proveedor.telefono}"><br>
                <label for="correoProv"> Correo Electrónico</label>
                <input type="text" id="correoProv" name="correoProv" value="${proveedor.correo}"><br>
                <label for="direccionProv"> Dirección</label>
                <input type="text" id="direccionProv" name="direccionProv" value="${proveedor.direccion}"><br>
                <label for="activoProv">Activo</label>
                <c:if test="${proveedor.activo == 1}">
                    <input type="checkbox" id="activoProv" name="activoProv" checked>
                </c:if>
                <c:if test="${proveedor.activo == 0}">
                    <input type="checkbox" id="activoProv" name="activoProv">
                </c:if>
                <br>
                <input type="submit" value="Borrar">
            </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
