package com.paula.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dtos.ProductoDTO;

public interface ProductosDAO {

	public List<ProductoDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion, String precio, String cantidad, String categoria, String proveedor ) throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad, String categoria, String proveedor ) throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidad, String categoria, String proveedor ) throws ClassNotFoundException, SQLException, NamingException;
}
