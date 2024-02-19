package com.kike.colegio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.ComboDTO;

public interface ICombosDAO {

	public List<ComboDTO> recuperaComboProveedores() throws ClassNotFoundException, SQLException, NamingException;

	public List<ComboDTO> recuperaComboCategorias() throws ClassNotFoundException, SQLException, NamingException;

	public List<ComboDTO> recuperaComboPoblacion() throws ClassNotFoundException, SQLException, NamingException;

	public List<ComboDTO> recuperaComboClientes() throws ClassNotFoundException, SQLException, NamingException;

	public List<ComboDTO> recuperaComboProductos() throws ClassNotFoundException, SQLException, NamingException;

	public List<ComboDTO> recuperaComboEstados() throws ClassNotFoundException, SQLException, NamingException;

}
