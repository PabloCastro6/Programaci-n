package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.AdmisionDTO;
import com.paula.hospital.model.AdmisionModelo;

public class AdmisionController {

	public List<AdmisionDTO> buscaAdmision(String id, String nombrePaciente, String tipoHabitacion, String fechaIngreso,
			String fechaSalida, String motivo) throws ClassNotFoundException, SQLException {
		AdmisionModelo am = new AdmisionModelo();
		return am.buscaAdmision(id, nombrePaciente, tipoHabitacion, fechaIngreso, fechaSalida, motivo);
	}

	public Integer insertarAdmision(int id, String nombrePaciente, String tipoHabitacion, String fechaIngreso,
			String fechaSalida, String motivo) throws SQLException, ClassNotFoundException {
		AdmisionModelo am = new AdmisionModelo();
		return am.insertarAdmision(id, nombrePaciente, tipoHabitacion, fechaIngreso, fechaSalida, motivo);
	}

	public Integer actualizarAdmision(int id, String nombrePaciente, String tipoHabitacion, String fechaIngreso,
			String fechaSalida, String motivo) throws SQLException, ClassNotFoundException {
		AdmisionModelo am = new AdmisionModelo();
		return am.actualizarAdmision(id, nombrePaciente, tipoHabitacion, fechaIngreso, fechaSalida, motivo);
	}
}
