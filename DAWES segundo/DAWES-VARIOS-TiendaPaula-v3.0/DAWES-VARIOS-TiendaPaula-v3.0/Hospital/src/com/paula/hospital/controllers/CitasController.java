package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.CitaDTO;
import com.paula.hospital.model.CitasModelo;


public class CitasController {

	public List<CitaDTO> buscaCita(String id, String nombrePaciente, String nombreMedico, String fecha, String hora,
			String estado) throws ClassNotFoundException, SQLException {
		CitasModelo cm = new CitasModelo();
		return cm.buscaCita(id, nombrePaciente, nombreMedico, fecha, hora, estado);
	}

	public Integer insertarCita(int id, String nombrePaciente, String nombreMedico, String fecha, String hora,
			String estado) throws SQLException, ClassNotFoundException {
		CitasModelo cm = new CitasModelo();
		return cm.insertarCita(id, nombrePaciente, nombreMedico, fecha, hora, estado);
	}

	public Integer actualizarCita(int id, String nombrePaciente, String nombreMedico, String fecha, String hora,
			String estado) throws SQLException, ClassNotFoundException {
		CitasModelo cm = new CitasModelo();
		return cm.actualizarCita(id, nombrePaciente, nombreMedico, fecha, hora, estado);
	}
}
