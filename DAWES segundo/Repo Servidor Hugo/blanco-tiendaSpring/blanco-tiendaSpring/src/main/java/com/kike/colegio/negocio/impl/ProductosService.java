package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProductosDAO;
import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.negocio.IProductosService;

@Component
public class ProductosService implements IProductosService {
	@Autowired
	@Qualifier("productoJPA")
	ProductosDAO productosDAO;

	@Override
	public List<ProductosDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException {
		return productosDAO.obtenerTodosProductos();
	}

	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		return productosDAO.buscarProductos(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
	}

	@Override
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
