package com.gon.tienda.negocio;

import java.sql.SQLException;
import java.util.List;

import com.gon.tienda.dtos.ProveedorDTO;

public interface IProveedoresService {
	
	public List<ProveedorDTO> buscarCategorias(String id_proveedor, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException;

	public Integer insertarCategorias( String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException;

	public Integer actualizarCategorias(String id_proveedor, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException;
	
	public Integer borrarCategorias(String id)throws ClassNotFoundException, SQLException;

}
