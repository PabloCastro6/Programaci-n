package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.HistorialMedicoDTO;
import com.paula.hospital.model.HistorialMedicoModelo;

public class HistorialMedicoController {

	public List<HistorialMedicoDTO> buscaHistorialMedico(String id, String nombrePaciente, String nombreMedico,
			String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {
		HistorialMedicoModelo hmm = new HistorialMedicoModelo();
		return hmm.buscaHistorialMedico(id, nombrePaciente, nombreMedico, fecha, diagnostico, tratamiento);
	}

	public Integer insertarHistorialMedico(int id, String nombrePaciente, String nombreMedico, String fecha,
			String diagnostico, String tratamiento) throws SQLException, ClassNotFoundException {
		HistorialMedicoModelo hmm = new HistorialMedicoModelo();
		return hmm.insertarHistorialMedico(id, nombrePaciente, nombreMedico, fecha, diagnostico, tratamiento);

	}

	public Integer actualizarHistorialMedico(int id, String nombrePaciente, String nombreMedico, String fecha,
			String diagnostico, String tratamiento) throws SQLException, ClassNotFoundException {
		HistorialMedicoModelo hmm = new HistorialMedicoModelo();
		return hmm.actualizarHistorialMedico(id, nombrePaciente, nombreMedico, fecha, diagnostico, tratamiento);
	}
}
