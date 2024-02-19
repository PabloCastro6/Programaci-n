package com.kike.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.ProductosDTO;

public interface IProductosService {
	public List<ProductosDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException;

	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException;

}
