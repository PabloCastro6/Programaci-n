package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.PacienteDTO;
import com.paula.hospital.utils.DBUtils;

public class PacienteModelo {

	public List<PacienteDTO> buscaPaciente(String id, String nombre, String apellido, String fechaDeNacimiento, String dni,
			String direccion, String telefono, String correo, String descripcionAlergia, String historiaMedica)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * from pacientes p INNER JOIN alergias a ON p.AlergiaID = a.ID WHERE p.ID LIKE ? AND p.Nombre LIKE ? AND p.Apellido LIKE ? AND p.FechaDeNacimiento LIKE ? AND p.DNI LIKE ? AND p.Direccion LIKE ? AND p.Telefono LIKE ? AND p.CorreoElectronico LIKE ? AND a.Descripcion LIKE ?  AND p.HistoriaMedica LIKE ? ";

		
		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1,"%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, "%" + fechaDeNacimiento + "%");
		ps.setString(5, "%" + dni + "%");
		ps.setString(6, "%" + direccion + "%");
		ps.setString(7, "%" + telefono + "%");
		ps.setString(8, "%" + correo + "%");
		ps.setString(9, "%" + descripcionAlergia + "%");
		ps.setString(10, "%" + historiaMedica + "%");

		ResultSet pacienteRS = ps.executeQuery();
		List<PacienteDTO> listaPacientes = new ArrayList<>();

		while (pacienteRS.next()) {
			PacienteDTO p = new PacienteDTO(pacienteRS.getInt("ID"), pacienteRS.getString("Nombre"),
					pacienteRS.getString("Apellido"), pacienteRS.getString("FechaDeNacimiento"),
					pacienteRS.getString("DNI"), pacienteRS.getString("Direccion"), pacienteRS.getString("Telefono"),
					pacienteRS.getString("CorreoElectronico"), pacienteRS.getString("a.Descripcion"),
					pacienteRS.getString("historiaMedica"));
			listaPacientes.add(p);
		}
		conexionBD.close();

		return listaPacientes;
	}

	public Integer insertarPacientes(int id, String nombre, String apellido, String fechaDeNacimiento, String dni,
			String direccion, String telefono, String correo, String descripcionAlergia, String historiaMedica)
			throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Pacientes (ID, Nombre, Apellido, FechaDeNacimiento, DNI, Direccion, Telefono, CorreoElectronico, AlergiaID, HistoriaMedica)"
				+ "VALUES  ( ?, ?, ?, ?, ?, ?, ?, ?, (SELECT a.id FROM alergias a WHERE a.descripcion = ?), ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, apellido);
		ps.setString(4, fechaDeNacimiento);
		ps.setString(5, dni);
		ps.setString(6, direccion);
		ps.setString(7, telefono);
		ps.setString(8, correo);
		ps.setString(9, descripcionAlergia);
		ps.setString(10, historiaMedica);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarPacientes(int id, String nombre, String apellido, String fechaDeNacimiento, String dni,
			String direccion, String telefono, String correo, String descripcionAlergia, String historiaMedica)
			throws SQLException, ClassNotFoundException {

		String sql = "UPDATE Pacientes SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END,"
				+ "Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END,"
				+ "FechaDeNacimiento = CASE WHEN ? = '' THEN FechaDeNacimiento ELSE ? END,"
				+ "DNI = CASE WHEN ? = '' THEN DNI ELSE ? END,"
				+ "Direccion = CASE WHEN ? = '' THEN Direccion ELSE ? END,"
				+ "Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END,"
				+ "CorreoElectronico = CASE WHEN ? = '' THEN CorreoElectronico ELSE ? END,"
				+ "AlergiaID = CASE WHEN ? = '' THEN AlergiaID ELSE (SELECT a.id FROM alergias a WHERE a.descripcion = ?) END,"
				+ "HistoriaMedica = CASE WHEN ? = '' THEN HistoriaMedica ELSE ? END " + "WHERE ID = ? ";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);

		ps.setString(3, apellido);
		ps.setString(4, apellido);

		ps.setString(5, fechaDeNacimiento);
		ps.setString(6, fechaDeNacimiento);

		ps.setString(7, dni);
		ps.setString(8, dni);

		ps.setString(9, direccion);
		ps.setString(10, direccion);

		ps.setString(11, telefono);
		ps.setString(12, telefono);

		ps.setString(13, correo);
		ps.setString(14, correo);

		ps.setString(15, descripcionAlergia);
		ps.setString(16, descripcionAlergia);

		ps.setString(17, historiaMedica);
		ps.setString(18, historiaMedica);

		ps.setInt(19, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}
}
