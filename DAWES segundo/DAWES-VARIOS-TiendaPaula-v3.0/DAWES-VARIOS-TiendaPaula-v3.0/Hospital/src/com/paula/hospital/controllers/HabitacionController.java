package com.paula.hospital.controllers;

import java.sql.SQLException;
import java.util.List;

import com.paula.hospital.dtos.HabitacionDTO;
import com.paula.hospital.model.HabitacionModelo;

public class HabitacionController {

	public List<HabitacionDTO> buscaHabitacion(String id, String tipo, String estado, String costoPorDia)
			throws ClassNotFoundException, SQLException {
		HabitacionModelo hm = new HabitacionModelo();
		return hm.buscaHabitacion(id, tipo, estado, costoPorDia);
	}

	public Integer insertarHabitacion(Integer id, String tipo, String estado, double costoPorDia)
			throws SQLException, ClassNotFoundException {
		HabitacionModelo hm = new HabitacionModelo();
		return hm.insertarHabitacion(id, tipo, estado, costoPorDia);

	}

	public Integer actualizarHabitacion(Integer id, String tipo, String estado, double costoPorDia)
			throws SQLException, ClassNotFoundException {
		HabitacionModelo hm = new HabitacionModelo();
		return hm.actualizarHabitacion(id, tipo, estado, costoPorDia);
	}

}
