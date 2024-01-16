package com.paula.colegio.negocios;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.colegio.dtos.AlumnoDTO;

public interface IAlumnosService {

	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException;

	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer borrarAlumnos(String id) throws ClassNotFoundException, SQLException, NamingException;
}
