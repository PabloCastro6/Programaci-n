package com.gon.tienda.negocio;

import java.sql.SQLException;
import java.util.List;
import com.gon.tienda.dtos.ClienteDTO;
import com.gon.tienda.dtos.ComboDTO;

public interface IClientesService {
	
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion,
			String activo) throws ClassNotFoundException, SQLException;

	public Integer insertarClientes(String nombre, String correo, String idPoblacion,
			String activo) throws ClassNotFoundException, SQLException;

	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion,
			String activo) throws ClassNotFoundException, SQLException;
	
	public Integer borrarClientes(String id)throws ClassNotFoundException, SQLException;

}
