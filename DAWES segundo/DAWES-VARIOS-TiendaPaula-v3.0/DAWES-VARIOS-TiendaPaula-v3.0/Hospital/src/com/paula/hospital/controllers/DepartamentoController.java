package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.DepartamentoDTO;
import com.paula.hospital.model.DepartamentoModelo;

public class DepartamentoController {

	public List<DepartamentoDTO> buscaDepartamento(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {
		DepartamentoModelo dm = new DepartamentoModelo();
		return dm.buscaDepartamento(id, nombre, descripcion, activo);
	}

	public Integer insertarDepartamento(int id, String nombre, String descripcion, int activo)
			throws SQLException, ClassNotFoundException {
		DepartamentoModelo dm = new DepartamentoModelo();
		return dm.insertarDepartamento(id, nombre, descripcion, activo);
	}

	public Integer actualizarDepartamento(int id, String nombre, String descripcion, int activo)
			throws SQLException, ClassNotFoundException {
		DepartamentoModelo dm = new DepartamentoModelo();
		return dm.actualizarDepartamento(id, nombre, descripcion, activo);
	}

	public Integer borrarDepartamento(int id) throws ClassNotFoundException, SQLException {
		DepartamentoModelo dm = new DepartamentoModelo();
		return dm.borrarDepartamento(id);
	}
}
