package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.RecetaMedicaDTO;
import com.paula.hospital.model.RecetasMedicaModelo;

public class RecetasMedicasController {

	public List<RecetaMedicaDTO> buscaRecetaMedica(String id, String nombrePaciente, String nombreMedico,
			String nombreMedicamento, String fecha, String cantidadPrescrita) throws ClassNotFoundException, SQLException {
		RecetasMedicaModelo rm = new RecetasMedicaModelo();
		return rm.buscaRecetaMedica(id, nombrePaciente, nombreMedico, nombreMedicamento, fecha, cantidadPrescrita);
	
	}
	public Integer insertarRecetaMedica(int id, String nombrePaciente, String nombreMedico, String nombreMedicamento,
			String fecha, int cantidadPrescrita) throws SQLException, ClassNotFoundException {
		RecetasMedicaModelo rm = new RecetasMedicaModelo();
		return rm.insertarRecetaMedica(id, nombrePaciente, nombreMedico, nombreMedicamento, fecha, cantidadPrescrita);
	}
	
	public Integer actualizarRecetaMedica(int id, String nombrePaciente, String nombreMedico, String nombreMedicamento,
			String fecha, int cantidadPrescrita) throws SQLException, ClassNotFoundException {
		RecetasMedicaModelo rm = new RecetasMedicaModelo();
		return rm.actualizarRecetaMedica(id, nombrePaciente, nombreMedico, nombreMedicamento, fecha, cantidadPrescrita);
	}

}
