package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.tienda.dao.CategoriasDAO;
import com.paula.tienda.dtos.CategoriaDTO;
import com.paula.tienda.negocio.ICategoriasService;

@Component
public class CategoriasServices implements ICategoriasService {

	@Autowired
	CategoriasDAO categoriasDAO;
	@Override
	public List<CategoriaDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException {
		
		return categoriasDAO.obtenerTodasCategorias();
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return categoriasDAO.buscarCategorias(id, nombre, descripcion, activo);
	}
	
	public Integer insertarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.insertarCategorias(id, nombre, descripcion, activo);
	}
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException{
		return categoriasDAO.actualizarCategorias(id, nombre, descripcion, activo);
	}
	
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.borrarCategorias(id);
	}

}
