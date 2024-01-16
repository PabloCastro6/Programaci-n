package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.HistorialMedicoDTO;
import com.paula.hospital.utils.DBUtils;

public class HistorialMedicoModelo {

	public List<HistorialMedicoDTO> buscaHistorialMedico(String id, String nombrePaciente, String nombreMedico,
			String fecha, String diagnostico, String tratamiento) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM HistorialMedico hm INNER JOIN Pacientes p ON hm.PacienteID = p.ID "
				+ "INNER JOIN Medicos m ON hm.MedicoID = m.ID WHERE p.Nombre LIKE ? AND m.Nombre LIKE ? "
				+ "AND hm.ID LIKE ? AND hm.Fecha LIKE ? AND hm.Diagnostico LIKE ? AND hm.Tratamiento LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + nombrePaciente + "%");
		ps.setString(2, "%" + nombreMedico + "%");
		ps.setString(3, "%" + id + "%");
		ps.setString(4, "%" + fecha + "%");
		ps.setString(5, "%" + diagnostico + "%");
		ps.setString(6, "%" + tratamiento + "%");

		ResultSet historialMedicoRS = ps.executeQuery();
		List<HistorialMedicoDTO> listaHistorialesMedicos = new ArrayList<>();

		while (historialMedicoRS.next()) {
			HistorialMedicoDTO historialMedico = new HistorialMedicoDTO(historialMedicoRS.getInt("ID"),
					historialMedicoRS.getString("p.Nombre"), historialMedicoRS.getString("m.Nombre"),
					historialMedicoRS.getString("Fecha"), historialMedicoRS.getString("Diagnostico"),
					historialMedicoRS.getString("Tratamiento"));
			listaHistorialesMedicos.add(historialMedico);
		}

		conexionBD.close();
		return listaHistorialesMedicos;
	}

	public Integer insertarHistorialMedico(int id, String nombrePaciente, String nombreMedico, String fecha,
			String diagnostico, String tratamiento) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO HistorialMedico (ID, PacienteID, MedicoID, Fecha, Diagnostico, Tratamiento)"
				+ "VALUES (?, (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ? ), (SELECT m.ID FROM Medicos m WHERE m.Nombre = ? ), ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombrePaciente);
		ps.setString(3, nombreMedico);
		ps.setString(4, fecha);
		ps.setString(5, diagnostico);
		ps.setString(6, tratamiento);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarHistorialMedico(int id, String nombrePaciente, String nombreMedico, String fecha,
			String diagnostico, String tratamiento) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE HistorialMedico SET PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ?) END,"
				+ "MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE (SELECT m.ID FROM Medicos m WHERE m.Nombre = ?) END,"
				+ "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END,"
				+ "Diagnostico = CASE WHEN ? = '' THEN Diagnostico ELSE ? END,"
				+ "Tratamiento = CASE WHEN ? = '' THEN Tratamiento ELSE ? END " + "WHERE ID = ?";

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

		ps.setString(7, diagnostico);
		ps.setString(8, diagnostico);

		ps.setString(9, tratamiento);
		ps.setString(10, tratamiento);

		ps.setInt(11, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}
}