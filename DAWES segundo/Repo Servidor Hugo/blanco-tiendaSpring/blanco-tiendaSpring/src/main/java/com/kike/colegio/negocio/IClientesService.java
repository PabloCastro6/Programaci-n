package com.kike.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.dtos.ClientesDTO;

public interface IClientesService {

	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarClientes(String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException;

}
