package com.paula.tienda.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.tienda.dtos.ClienteDTO;

public interface ClientesDAO {

	//public List<ClienteDTO> obtenerTodosClientes() throws ClassNotFoundException, SQLException, NamingException;

	public List<ClienteDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo) throws ClassNotFoundException, SQLException, NamingException;

    public Integer insertarClientes(String nombre, String correo, String poblacion, String activo) throws ClassNotFoundException, SQLException, NamingException;
	
    public Integer actualizarClientes(String id, String nombre, String correo, String poblacion, String activo) throws ClassNotFoundException, SQLException, NamingException;
    
    public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException;
}
