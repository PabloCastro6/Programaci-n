package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProveedoresDAO;
import com.kike.colegio.dtos.ProvedoresDTO;
import com.kike.colegio.negocio.IProveedoresService;

@Component
public class ProveedoresService implements IProveedoresService {

	@Autowired
	@Qualifier("proveedoresJPA")

	ProveedoresDAO proveedoresDAO;

	@Override
	public List<ProvedoresDTO> obtenerTodosProveedores() throws ClassNotFoundException, SQLException, NamingException {
		return proveedoresDAO.obtenerTodosProveedores();
	}

	@Override
	public List<ProvedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return proveedoresDAO.buscarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {
		return proveedoresDAO.insertarProveedor(nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		return proveedoresDAO.actualizarProveedor(id, nombre, contacto, telefono, correo, direccion, activo);
	}

	@Override
	public Integer borrarProveedor(String id) throws ClassNotFoundException, SQLException, NamingException {
		return proveedoresDAO.borrarProveedor(id);
	}

}
