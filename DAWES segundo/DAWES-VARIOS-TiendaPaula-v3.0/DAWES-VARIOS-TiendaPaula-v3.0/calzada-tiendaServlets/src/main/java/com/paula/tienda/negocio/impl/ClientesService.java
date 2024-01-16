package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dao.jdbcimpl.ClientesDAOimpljdbc;
import com.paula.tienda.dtos.ClienteDTO;
import com.paula.tienda.negocio.IClientesService;

public class ClientesService implements IClientesService {

//	@Override
//	public List<ClienteDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException {
//		
//		return new ClientesDAOimpljdbc().obtenerTodosClientes();
//	}

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return new ClientesDAOimpljdbc().buscarClientes(id, nombre, correo, poblacion, activo);
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return new ClientesDAOimpljdbc().insertarClientes(nombre, correo, poblacion, activo);
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return new ClientesDAOimpljdbc().actualizarClientes(id, nombre, correo, poblacion, activo) ;
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		return new ClientesDAOimpljdbc().borrarClientes(id);
	}

}
