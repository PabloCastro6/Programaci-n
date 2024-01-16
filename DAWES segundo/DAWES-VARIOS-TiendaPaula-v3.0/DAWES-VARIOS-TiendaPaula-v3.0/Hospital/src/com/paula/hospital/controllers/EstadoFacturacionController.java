package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.EstadoFacturacionDTO;
import com.paula.hospital.model.EstadoFacturacionModelo;

public class EstadoFacturacionController {

	public List<EstadoFacturacionDTO> buscaEstadoFacturacion(String id, String estado)
			throws ClassNotFoundException, SQLException {
		EstadoFacturacionModelo efm = new EstadoFacturacionModelo();
		return efm.buscaEstadoFacturacion(id, estado);
	}
	
	public Integer insertarEstadoFacturacion(int id, String estado) throws SQLException, ClassNotFoundException {
		EstadoFacturacionModelo efm = new EstadoFacturacionModelo();
		return efm.insertarEstadoFacturacion(id, estado);
	}
	
	public Integer actualizarEstadoFacturacion(int id, String estado) throws SQLException, ClassNotFoundException {
		EstadoFacturacionModelo efm = new EstadoFacturacionModelo();
		return efm.actualizarEstadoFacturacion(id, estado);
	}
	
}
