package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.MedicoDTO;
import com.paula.hospital.model.MedicoModelo;

public class MedicoController {

	public List<MedicoDTO> buscarMedico(String medicoId, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correo) throws ClassNotFoundException, SQLException {
		MedicoModelo mm = new MedicoModelo();
		return mm.buscarMedico(medicoId, nombre, apellido, especialidad, licenciaMedica, telefono, correo);
	}
	
	public Integer insertarMedico(int medicoId, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correo) throws ClassNotFoundException, SQLException {
		MedicoModelo mm = new MedicoModelo();
		return mm.insertarMedico(medicoId, nombre, apellido, especialidad, licenciaMedica, telefono, correo);
	}
	
	public Integer actualizarMedico(int medicoId, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correo) throws ClassNotFoundException, SQLException {
		MedicoModelo mm = new MedicoModelo();
		return mm.actualizarMedico(medicoId, nombre, apellido, especialidad, licenciaMedica, telefono, correo);
	}
}
