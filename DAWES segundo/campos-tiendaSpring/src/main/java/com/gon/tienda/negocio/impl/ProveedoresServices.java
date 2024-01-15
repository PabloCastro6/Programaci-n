package com.gon.tienda.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import com.gon.tienda.dtos.ProveedorDTO;
import com.gon.tienda.negocio.IProveedoresService;

public class ProveedoresServices implements IProveedoresService{

	@Override
	public List<ProveedorDTO> buscarCategorias(String id_proveedor, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public Integer insertarCategorias(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarCategorias(String id_proveedor, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarCategorias(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
