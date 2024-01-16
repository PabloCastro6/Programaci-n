package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.EstadoCitaDTO;
import com.paula.hospital.model.EstadoCitasModelo;

public class EstadoCitasController {

	public List<EstadoCitaDTO> buscaCita(String id, String estado) throws ClassNotFoundException, SQLException {
		EstadoCitasModelo em = new EstadoCitasModelo();
		return em.buscaCita(id, estado);
	}
	
	public Integer insertarEstadoCitas(int id, String estado) throws SQLException, ClassNotFoundException {
		EstadoCitasModelo em = new EstadoCitasModelo();
		return em.insertarEstadoCitas(id, estado);
	}
	
	public Integer actualizarEstadoCitas(int id, String estado) throws SQLException, ClassNotFoundException {
		EstadoCitasModelo em = new EstadoCitasModelo();
		return em.actualizarEstadoCitas(id, estado);
	}

}
