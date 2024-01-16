package com.paula.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paula.colegio.dao.AlumnosDAO;
import com.paula.colegio.dtos.AlumnoDTO;
import com.paula.colegio.negocios.IAlumnosService;

@Component
public class AlumnosService implements IAlumnosService {

	@Autowired
	AlumnosDAO alumnosDAO;
	
	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {

		return alumnosDAO.obtenerTodosAlumnos(); 
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws ClassNotFoundException, SQLException, NamingException {

		return alumnosDAO.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
	}

	@Override
	public Integer insertarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {

		return alumnosDAO.insertarAlumnos(id, nombre, apellido, activo, famNumerosa, municipio);
	}

	public Integer actualizarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {

		return alumnosDAO.actualizarAlumnos(id, nombre, apellido, activo, famNumerosa, municipio);
	}

	public Integer borrarAlumnos(String id) throws ClassNotFoundException, SQLException, NamingException {
		
		return alumnosDAO.borrarAlumnos(id);
	}

}
