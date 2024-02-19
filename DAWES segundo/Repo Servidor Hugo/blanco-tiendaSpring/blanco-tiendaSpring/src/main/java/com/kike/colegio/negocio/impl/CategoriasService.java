package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.CategoriasDAO;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.negocio.ICategoriasService;

@Component
public class CategoriasService implements ICategoriasService {

	@Autowired
	@Qualifier("CategoriasJPA")
	CategoriasDAO categoriasDAO;

	@Override
	public List<CategoriaDTO> obtenerTodosCategorias() throws ClassNotFoundException, SQLException, NamingException {
		return categoriasDAO.obtenerTodosCategorias();
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.buscarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.insertarCategorias(nombre, descripcion, activo);
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.actualizarCategorias(id, nombre, descripcion, activo);
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return categoriasDAO.borrarCategorias(id);
	}

}
