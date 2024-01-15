package com.gon.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gon.tienda.dtos.ComboDTO;


public interface ICombosDAO {
	
	public List<ComboDTO>recuperaComboProveedores() throws ClassNotFoundException, SQLException;
	
	public List<ComboDTO>recuperaComboCategorias() throws ClassNotFoundException, SQLException;

	public List<ComboDTO> recuperaComboMunicipios() throws ClassNotFoundException, SQLException;
	
	

}
