package com.paula.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.paula.colegio.dao.jdbcimpl.AlumnosDAOImpljdbc;
import com.paula.colegio.dtos.AlumnoDTO;
import com.paula.colegio.negocios.IAlumnosService;

public class AlumnosService implements IAlumnosService {

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {

		return new AlumnosDAOImpljdbc().obtenerTodosAlumnos();
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws ClassNotFoundException, SQLException, NamingException {

		return new AlumnosDAOImpljdbc().buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
	}

	@Override
	public Integer insertarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {

		return new AlumnosDAOImpljdbc().insertarAlumnos(id, nombre, apellido, activo, famNumerosa, municipio);
	}

	public Integer actualizarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {

		return new AlumnosDAOImpljdbc().actualizarAlumnos(id, nombre, apellido, activo, famNumerosa, municipio);
	}

	public Integer borrarAlumnos(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		return new AlumnosDAOImpljdbc().borrarAlumnos(id);
	}

}
