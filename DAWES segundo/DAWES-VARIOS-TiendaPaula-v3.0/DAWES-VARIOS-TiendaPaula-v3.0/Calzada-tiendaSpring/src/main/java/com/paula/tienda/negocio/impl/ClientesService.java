package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.tienda.dao.ClientesDAO;
import com.paula.tienda.dao.jdbcimpl.ClientesDAOimpljdbc;
import com.paula.tienda.dtos.ClienteDTO;
import com.paula.tienda.negocio.IClientesService;

@Component
public class ClientesService implements IClientesService {

	@Autowired
	ClientesDAO clientesDAO;
//	@Override
//	public List<ClienteDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException {
//		
//		return  clientesDAO.obtenerTodosClientes();
//	}

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.buscarClientes(id, nombre, correo, poblacion, activo);
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.insertarClientes(nombre, correo, poblacion, activo);
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.actualizarClientes(id, nombre, correo, poblacion, activo) ;
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		return clientesDAO.borrarClientes(id);
	}

}
