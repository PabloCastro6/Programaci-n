package com.gon.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.gon.tienda.dao.tiendaimpl.ProductosDAOImplTienda;
import com.gon.tienda.dtos.ProductoDTO;
import com.gon.tienda.negocio.IProductosService;

@Component
public class ProductosServices implements IProductosService{

	@Override
	public List<ProductoDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException {
		
		return new ProductosDAOImplTienda().buscarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidadStock,
			String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException {

		return new ProductosDAOImplTienda().insertarProductos(nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadStock, String idCategoria, String idProveedor) throws ClassNotFoundException, SQLException {
		
		return new ProductosDAOImplTienda().actualizarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
	}


	
	

}
