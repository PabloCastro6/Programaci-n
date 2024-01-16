package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dao.jdbcimpl.ProductosDAOImpljdbc;
import com.paula.tienda.dtos.ProductoDTO;
import com.paula.tienda.negocio.IProductosService;

public class ProductosService implements IProductosService {

	public List<ProductoDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException {
		return new ProductosDAOImpljdbc().obtenerTodosProductos();
	}

	public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		return new ProductosDAOImpljdbc().buscarProductos(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
	}
	
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		return new ProductosDAOImpljdbc().insertarProductos(nombre, descripcion, precio, cantidad, categoria, proveedor);
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {		
		return new ProductosDAOImpljdbc().actualizarProductos(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
	}
}
