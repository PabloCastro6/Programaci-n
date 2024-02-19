package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.CategoriasDAO;
import com.kike.colegio.dao.ClientesDAO;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.dtos.ClientesDTO;
import com.kike.colegio.negocio.IClientesService;

@Component

public class ClientesService implements IClientesService {

	@Autowired
	@Qualifier("clientesHIB")
	ClientesDAO clientesDAO;

	@Override
	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
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
		return clientesDAO.actualizarClientes(id, nombre, correo, poblacion, activo);
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException {
		return clientesDAO.borrarClientes(id);
	}

}
