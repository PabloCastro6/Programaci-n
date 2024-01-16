package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dao.jdbcimpl.CategoriasDAOImpljdbc;
import com.paula.tienda.dtos.CategoriaDTO;
import com.paula.tienda.negocio.ICategoriasService;

public class CategoriasServices implements ICategoriasService {

	@Override
	public List<CategoriaDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		
		return new CategoriasDAOImpljdbc().obtenerTodasCategorias();
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return new CategoriasDAOImpljdbc().buscarCategorias(id, nombre, descripcion, activo);
	}
	
	public Integer insertarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return new CategoriasDAOImpljdbc().insertarCategorias(id, nombre, descripcion, activo);
	}
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException{
		return new CategoriasDAOImpljdbc().actualizarCategorias(id, nombre, descripcion, activo);
	}
	
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		return new CategoriasDAOImpljdbc().borrarCategorias(id);
	}

}
