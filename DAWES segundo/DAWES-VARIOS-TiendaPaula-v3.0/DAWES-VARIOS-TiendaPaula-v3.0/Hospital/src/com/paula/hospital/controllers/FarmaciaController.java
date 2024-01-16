package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.FarmaciaDTO;
import com.paula.hospital.model.FarmaciaModelo;

public class FarmaciaController {

	public List<FarmaciaDTO> buscaFarmacia(String id, String nombre, String descripcion, String cantidadDisponible,
			String precio) throws ClassNotFoundException, SQLException {
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.buscaFarmacia(id, nombre, descripcion, cantidadDisponible, precio);
	}

	public Integer insertarFarmacia(int id, String nombre, String descripcion, int cantidadDisponible, double precio)
			throws SQLException, ClassNotFoundException {
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.insertarFarmacia(id, nombre, descripcion, cantidadDisponible, precio);
	}

	public Integer actualizarFarmacia(int id, String nombre, String descripcion, int cantidadDisponible, double precio)
			throws SQLException, ClassNotFoundException {
		FarmaciaModelo fm = new FarmaciaModelo();
		return fm.actualizarFarmacia(id, nombre, descripcion, cantidadDisponible, precio);
	}
}
