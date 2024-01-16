package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.PacienteDTO;
import com.paula.hospital.model.PacienteModelo;

public class PacienteController {

	public List<PacienteDTO> buscaPaciente(String id, String nombre, String apellido, String fechaDeNacimiento,
			String dni, String direccion, String telefono, String correo, String descripcionAlergia,
			String historiaMedica) throws ClassNotFoundException, SQLException {
		PacienteModelo pm = new PacienteModelo();
		return pm.buscaPaciente(id, nombre, apellido, fechaDeNacimiento, dni, direccion, telefono, correo,
				descripcionAlergia, historiaMedica);
	}

	public Integer insertarPacientes(int id, String nombre, String apellido, String fechaDeNacimiento, String dni,
			String direccion, String telefono, String correo, String descripcionAlergia, String historiaMedica)
			throws SQLException, ClassNotFoundException {
		PacienteModelo pm = new PacienteModelo();
		return pm.insertarPacientes(id, nombre, apellido, fechaDeNacimiento, dni, direccion, telefono, correo,
				descripcionAlergia, historiaMedica);

	}

	public Integer actualizarPacientes(int id, String nombre, String apellido, String fechaDeNacimiento, String dni,
			String direccion, String telefono, String correo, String descripcionAlergia, String historiaMedica)
			throws SQLException, ClassNotFoundException {
		PacienteModelo pm = new PacienteModelo();
		return pm.actualizarPacientes(id, nombre, apellido, fechaDeNacimiento, dni, direccion, telefono, correo,
				descripcionAlergia, historiaMedica);
	}

}
