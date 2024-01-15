package com.gon.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import com.gon.tienda.dao.tiendaimpl.CategoriasDAOImplTienda;
import com.gon.tienda.dtos.CategoriaDTO;
import com.gon.tienda.negocio.ICategoriasService;

public class CategoriasServices implements ICategoriasService{

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		return new CategoriasDAOImplTienda().buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		return new CategoriasDAOImplTienda().insertarCategorias(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {

		return new CategoriasDAOImplTienda().actualizarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException {

		return new CategoriasDAOImplTienda().borrarCategorias(id);
	}

}
