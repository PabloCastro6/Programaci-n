package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.tienda.dao.ProductosDAO;
import com.paula.tienda.dtos.ProductoDTO;
import com.paula.tienda.negocio.IProductosService;

@Component
public class ProductosService implements IProductosService {

	@Autowired
	ProductosDAO productosDAO;
	
	public List<ProductoDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException {
		return productosDAO.obtenerTodosProductos();
	}

	public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		return productosDAO.buscarProductos(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
	}
	
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {
		return productosDAO.insertarProductos(nombre, descripcion, precio, cantidad, categoria, proveedor);
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidad,
			String categoria, String proveedor) throws ClassNotFoundException, SQLException, NamingException {		
		return productosDAO.actualizarProductos(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
	}
}
