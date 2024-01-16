package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.AdmisionDTO;
import com.paula.hospital.utils.DBUtils;

public class AdmisionModelo {

	public List<AdmisionDTO> buscaAdmision(String id, String nombrePaciente, String tipoHabitacion, String fechaIngreso,
			String fechaSalida, String motivo) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM Admisiones a " + "INNER JOIN Pacientes p ON a.PacienteID = p.ID "
				+ "INNER JOIN Habitaciones h ON a.HabitacionID = h.ID " + "WHERE p.Nombre LIKE ? "
				+ "AND h.Tipo LIKE ? " + "AND a.ID LIKE ? " + "AND a.FechaDeIngreso LIKE ? "
				+ "AND a.FechaDeSalida LIKE ? " + "AND a.Motivo LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + nombrePaciente + "%");
		ps.setString(2, "%" + tipoHabitacion + "%");
		ps.setString(3, "%" + id + "%");
		ps.setString(4, "%" + fechaIngreso + "%");
		ps.setString(5, "%" + fechaSalida + "%");
		ps.setString(6, "%" + motivo + "%");

		ResultSet admisionRS = ps.executeQuery();
		List<AdmisionDTO> listaAdmisiones = new ArrayList<>();

		while (admisionRS.next()) {
			AdmisionDTO admision = new AdmisionDTO(admisionRS.getInt("ID"), admisionRS.getString("p.Nombre"),
					admisionRS.getString("h.Tipo"), admisionRS.getString("FechaDeIngreso"),
					admisionRS.getString("FechaDeSalida"), admisionRS.getString("Motivo"));
			listaAdmisiones.add(admision);
		}

		conexionBD.close();
		return listaAdmisiones;
	}

	public Integer insertarAdmision(int id, String nombrePaciente, String tipoHabitacion, String fechaIngreso,
			String fechaSalida, String motivo) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Admisiones (ID, PacienteID, HabitacionID, FechaDeIngreso, FechaDeSalida, Motivo)"
				+ "VALUES (?, (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ? ), (SELECT h.ID FROM Habitaciones h WHERE h.Tipo = ? ), ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombrePaciente);
		ps.setString(3, tipoHabitacion);
		ps.setString(4, fechaIngreso);
		ps.setString(5, fechaSalida);
		ps.setString(6, motivo);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarAdmision(int id, String nombrePaciente, String tipoHabitacion, String fechaIngreso,
			String fechaSalida, String motivo) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE admisiones SET PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ? ) END,"
				+ "HabitacionID = CASE WHEN ? = '' THEN HabitacionID ELSE (SELECT h.ID FROM Habitaciones h WHERE h.Tipo = ? ) END,"
				+ "FechaDeIngreso = CASE WHEN ? = '' THEN FechaDeIngreso ELSE ? END,"
				+ "FechaDeSalida = CASE WHEN ? = '' THEN FechaDeSalida ELSE ? END,"
				+ "Motivo = CASE WHEN ? = '' THEN Motivo ELSE ? END " + "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombrePaciente);
		ps.setString(2, nombrePaciente);

		ps.setString(3, tipoHabitacion);
		ps.setString(4, tipoHabitacion);

		ps.setString(5, fechaIngreso);
		ps.setString(6, fechaIngreso);

		ps.setString(7, fechaSalida);
		ps.setString(8, fechaSalida);

		ps.setString(9, motivo);
		ps.setString(10, motivo);

		ps.setInt(11, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}
}
