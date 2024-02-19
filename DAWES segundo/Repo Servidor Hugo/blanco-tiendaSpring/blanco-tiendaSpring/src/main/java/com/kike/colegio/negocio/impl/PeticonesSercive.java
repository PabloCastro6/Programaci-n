package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.PeticionesDAO;
import com.kike.colegio.dtos.PeticionesDTO;
import com.kike.colegio.negocio.IPeticionesService;

@Component
public class PeticonesSercive implements IPeticionesService {
	@Autowired
	@Qualifier("peteicionesHIB")
	PeticionesDAO peticionesDAO;

	@Override
	public List<PeticionesDTO> obtenerTodosPeticiones() throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.obtenerTodosPeticiones();

	}

	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String cliente, String producto, String cantidad,
			String estado, String fecha) throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.buscarPeticiones(id, cliente, producto, cantidad, estado, fecha);

	}

	@Override
	public Integer insertarPeticiones(String cliente, String producto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.insertarPeticiones(cliente, producto, cantidad, estado);

	}

	@Override
	public Integer actualizarPeticiones(String id, String cliente, String producto, String cantidad, String estado,
			String fecha) throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.actualizarPeticiones(id, cliente, producto, cantidad, estado, fecha);

	}

	@Override
	public Integer borrarPeticiones(String id) throws ClassNotFoundException, SQLException, NamingException {
		return peticionesDAO.borrarPeticiones(id);

	}

}
