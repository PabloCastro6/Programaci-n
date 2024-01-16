package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.CitaDTO;
import com.paula.hospital.utils.DBUtils;

public class CitasModelo {

	public List<CitaDTO> buscaCita(String id, String nombrePaciente, String nombreMedico, String fecha, String hora,
			String estado) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM citas  c INNER JOIN pacientes p ON c.PacienteID = p.ID INNER JOIN medicos m ON c.MedicoID = m.ID INNER JOIN estadocitas ec ON c.EstadoID = ec.ID WHERE p.Nombre LIKE ? AND m.Nombre LIKE ? AND ec.Estado LIKE ? AND c.ID LIKE ? AND c.fecha LIKE ? AND c.hora LIKE ? ";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + nombrePaciente + "%");
		ps.setString(2, "%" + nombreMedico + "%");
		ps.setString(3, "%" + estado + "%");
		ps.setString(4, "%" + id + "%");
		ps.setString(5, "%" + fecha + "%");
		ps.setString(6, "%" + hora + "%");

		ResultSet citaRS = ps.executeQuery();
		List<CitaDTO> listaCitas = new ArrayList<>();

		while (citaRS.next()) {
			CitaDTO cita = new CitaDTO(citaRS.getInt("ID"), citaRS.getString("p.Nombre"), citaRS.getString("m.Nombre"),
					citaRS.getString("Fecha"), citaRS.getString("Hora"), citaRS.getString("Estado"));
			listaCitas.add(cita);
		}
		conexionBD.close();

		return listaCitas;
	}

	public Integer insertarCita(int id, String nombrePaciente, String nombreMedico, String fecha, String hora,
			String estado) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Citas (ID, PacienteID, MedicoID, Fecha, Hora, EstadoID)"
				+ "VALUES (?, (SELECT p.ID FROM pacientes p WHERE p.Nombre = ? ), (SELECT m.ID FROM medicos m WHERE m.Nombre = ? ), ?, ?, (SELECT ec.ID FROM estadocitas ec WHERE ec.Estado = ? ))";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombrePaciente);
		ps.setString(3, nombreMedico);
		ps.setString(4, fecha);
		ps.setString(5, hora);
		ps.setString(6, estado);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarCita(int id, String nombrePaciente, String nombreMedico, String fecha, String hora,
			String estado) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE Citas SET PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE (SELECT p.ID FROM pacientes p WHERE p.Nombre = ? ) END,"
				+ "MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE (SELECT m.ID FROM medicos m WHERE m.Nombre = ?) END,"
				+ "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END," + "Hora = CASE WHEN ? = '' THEN Hora ELSE ? END,"
				+ "EstadoID = CASE WHEN ? = '' THEN EstadoID ELSE (SELECT e.id FROM estadoCitas e WHERE e.estado = ?) END "
				+ "WHERE ID = ? ";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombrePaciente);
		ps.setString(2, nombrePaciente);

		ps.setString(3, nombreMedico);
		ps.setString(4, nombreMedico);

		ps.setString(5, fecha);
		ps.setString(6, fecha);

		ps.setString(7, hora);
		ps.setString(8, hora);

		ps.setString(9, estado);
		ps.setString(10, estado);

		ps.setInt(11, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
