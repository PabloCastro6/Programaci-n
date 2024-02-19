package com.kike.colegio.springDataJPA;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProductosDAO;
import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.entities.ProductoEntity;
import com.kike.colegio.repositories.ProductosRepository;
import com.kike.colegio.entities.CategoriaEntity;
import com.kike.colegio.entities.ProveedorEntity;

@Component("productoJPA")

public class ProductosDAOSpringDataJPA implements ProductosDAO {

	@Autowired
	private ProductosRepository productosRepository;

	@Override
	public List<ProductosDTO> obtenerTodosProductos() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		return null;

	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precioStr, String cantidadStr,
			String categoriaNombre, String proveedorId) throws ClassNotFoundException, SQLException, NamingException {
		return null;

	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precioStr,
			String cantidadStr, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		return null;

	}

}
