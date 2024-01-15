package com.gon.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import com.gon.tienda.dao.tiendaimpl.CategoriasDAOImplTienda;
import com.gon.tienda.dao.tiendaimpl.ClientesDAOImplTienda;
import com.gon.tienda.dtos.ClienteDTO;
import com.gon.tienda.negocio.IClientesService;

public class ClientesServices implements IClientesService{

	@Override
	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {
		
		return new ClientesDAOImplTienda().buscarClientes(id, nombre, correo,idPoblacion, activo);
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTienda().insertarClientes( nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idPoblacion, String activo)
			throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTienda().actualizarClientes(id, nombre, correo, idPoblacion, activo);
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException {

		return new ClientesDAOImplTienda().borrarClientes(id);
	}


	
	

}
