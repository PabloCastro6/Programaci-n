package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.HabitacionDTO;
import com.paula.hospital.utils.DBUtils;

public class HabitacionModelo {

	public List<HabitacionDTO> buscaHabitacion(String id, String tipo, String estado, String costoPorDia)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM Habitaciones WHERE ID LIKE ? AND Tipo LIKE ? AND Estado LIKE ? AND CostoPorDia LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + tipo + "%");
		ps.setString(3, "%" + estado + "%");
		ps.setString(4, "%" + costoPorDia + "%");

		ResultSet habitacionRS = ps.executeQuery();
		List<HabitacionDTO> listaHabitaciones = new ArrayList<>();

		while (habitacionRS.next()) {
			HabitacionDTO habitacion = new HabitacionDTO(habitacionRS.getInt("ID"), habitacionRS.getString("Tipo"),
					habitacionRS.getString("Estado"), habitacionRS.getDouble("CostoPorDia"));
			listaHabitaciones.add(habitacion);
		}
		conexionBD.close();

		return listaHabitaciones;
	}

	public Integer insertarHabitacion(int id, String tipo, String estado, double costoPorDia)
			throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Habitaciones (ID, Tipo, Estado, CostoPorDia) VALUES (?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, tipo);
		ps.setString(3, estado);
		ps.setDouble(4, costoPorDia);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarHabitacion(Integer id, String tipo, String estado, double costoPorDia)
			throws SQLException, ClassNotFoundException {

		String sql = "UPDATE Habitaciones SET Tipo = CASE WHEN ? = '' THEN Tipo ELSE ? END,"
				+ "Estado = CASE WHEN ? = '' THEN Estado ELSE ? END,"
				+ "CostoPorDia = CASE WHEN ? = '' THEN CostoPorDia ELSE ? END " + "WHERE ID = ? ";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, tipo);
		ps.setString(2, tipo);

		ps.setString(3, estado);
		ps.setString(4, estado);

		ps.setDouble(5, costoPorDia);
		ps.setDouble(6, costoPorDia);

		ps.setInt(7, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
