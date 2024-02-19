package com.kike.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.ProvedoresDTO;

public interface IProveedoresService {
	public List<ProvedoresDTO> obtenerTodosProveedores() throws ClassNotFoundException, SQLException, NamingException;

	public List<ProvedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarProveedor(String id) throws ClassNotFoundException, SQLException, NamingException;
}
