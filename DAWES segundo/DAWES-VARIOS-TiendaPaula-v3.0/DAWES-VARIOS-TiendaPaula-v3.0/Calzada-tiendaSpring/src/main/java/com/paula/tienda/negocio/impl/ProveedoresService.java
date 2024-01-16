package com.paula.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.tienda.dao.ProveedoresDAO;
import com.paula.tienda.dtos.ProveedorDTO;
import com.paula.tienda.negocio.IProveedoresService;

@Component
public class ProveedoresService implements IProveedoresService {

	@Autowired
	ProveedoresDAO proveedorDAO;
	@Override
	public List<ProveedorDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return proveedorDAO.buscarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);
	}
	@Override
	public Integer insertarProveedores(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {
		return proveedorDAO.insertarProveedores(nombre, contacto, telefono, correo, direccion, activo);
	}
	@Override
	public Integer actualizarProveedores(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		return proveedorDAO.actualizarProveedores(id, nombre, contacto, telefono, correo, direccion, activo);
	}
	@Override
	public Integer borrarProveedores(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		return proveedorDAO.borrarProveedores(id);
	}

}
