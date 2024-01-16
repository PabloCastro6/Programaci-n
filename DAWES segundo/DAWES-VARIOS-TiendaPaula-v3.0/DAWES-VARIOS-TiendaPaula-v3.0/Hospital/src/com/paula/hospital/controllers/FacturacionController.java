package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.FacturacionDTO;
import com.paula.hospital.model.FacturacionModelo;

public class FacturacionController {

	public List<FacturacionDTO> buscaFacturacion(String id, String nombrePaciente, String fecha, String monto,
			String estado) throws ClassNotFoundException, SQLException {
		FacturacionModelo fm = new FacturacionModelo();
		return fm.buscaFacturacion(id, nombrePaciente, fecha, monto, estado);
	}

	public Integer insertarFacturacion(int id, String nombrePaciente, String fecha, double monto, String estado)
			throws SQLException, ClassNotFoundException {
		FacturacionModelo fm = new FacturacionModelo();
		return fm.insertarFacturacion(id, nombrePaciente, fecha, monto, estado);
	}

	public Integer actualizarFacturacion(int id, String nombrePaciente, String fecha, double monto, String estado)
			throws SQLException, ClassNotFoundException {
		FacturacionModelo fm = new FacturacionModelo();
		return fm.actualizarFacturacion(id, nombrePaciente, fecha, monto, estado);
	}
}
