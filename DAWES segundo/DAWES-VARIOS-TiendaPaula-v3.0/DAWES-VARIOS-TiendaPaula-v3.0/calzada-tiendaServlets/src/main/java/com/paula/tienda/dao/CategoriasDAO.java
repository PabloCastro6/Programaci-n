package com.paula.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dtos.CategoriaDTO;



public interface CategoriasDAO {

	public List<CategoriaDTO> obtenerTodasCategorias() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException;

    public Integer insertarCategorias(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException;
    
    public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo) throws ClassNotFoundException, SQLException, NamingException;
    
    public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException, NamingException;
}
