package com.paula.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;


import com.paula.tienda.dtos.CombosDTO;

public interface ICombosDAO {

	public List<CombosDTO> recuperarCombosCategorias() throws ClassNotFoundException, SQLException, NamingException;
	public List<CombosDTO> recuperarCombosProveedores() throws ClassNotFoundException, SQLException, NamingException;
	public List<CombosDTO> recuperarCombosPoblaciones()throws ClassNotFoundException, SQLException, NamingException;
}
