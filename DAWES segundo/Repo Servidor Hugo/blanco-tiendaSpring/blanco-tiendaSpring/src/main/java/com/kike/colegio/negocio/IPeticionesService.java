package com.kike.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.PeticionesDTO;

public interface IPeticionesService {
	public List<PeticionesDTO> obtenerTodosPeticiones() throws ClassNotFoundException, SQLException, NamingException;

	public List<PeticionesDTO> buscarPeticiones(String id, String cliente, String producto, String cantidad,
			String estado, String fecha) throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarPeticiones(String cliente, String producto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarPeticiones(String id, String cliente, String producto, String cantidad, String estado,
			String fecha) throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarPeticiones(String id) throws ClassNotFoundException, SQLException, NamingException;

}
