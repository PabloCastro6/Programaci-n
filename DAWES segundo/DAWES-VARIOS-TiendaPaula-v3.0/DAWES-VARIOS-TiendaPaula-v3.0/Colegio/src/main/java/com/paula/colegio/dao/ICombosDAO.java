package com.paula.colegio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.colegio.dtos.ComboDTO;

public interface ICombosDAO {

	public List<ComboDTO> recuperarCombosMunicipio() throws ClassNotFoundException, SQLException, NamingException;
}
