package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.MedicoDTO;
import com.paula.hospital.utils.DBUtils;

public class MedicoModelo {

	public List<MedicoDTO> buscarMedico(String medicoId, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correo) throws ClassNotFoundException, SQLException {

		String query = "SELECT * from medicos WHERE ID LIKE ? AND Nombre LIKE ? AND Apellido LIKE ?  AND Especialidad LIKE ? AND LicenciaMedica LIKE ? AND Telefono LIKE ? AND CorreoElectronico LIKE ? ";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + medicoId + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, "%" + especialidad + "%");
		ps.setString(5, "%" + licenciaMedica + "%");
		ps.setString(6, "%" + telefono + "%");
		ps.setString(7, "%" + correo + "%");

		ResultSet medicoRS = ps.executeQuery();
		List<MedicoDTO> listaMedicos = new ArrayList<>();

		while (medicoRS.next()) {
			MedicoDTO m = new MedicoDTO(medicoRS.getInt("ID"), medicoRS.getString("Nombre"),
					medicoRS.getString("Apellido"), medicoRS.getString("Especialidad"),
					medicoRS.getString("LicenciaMedica"), medicoRS.getString("Telefono"),
					medicoRS.getString("CorreoElectronico"));
			listaMedicos.add(m);
		}
		conexionBD.close();

		return listaMedicos;
	}

	public Integer insertarMedico(int medicoId, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correo) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO medicos (ID, Nombre, Apellido, Especialidad, LicenciaMedica, Telefono, CorreoElectronico)"
				+ "VALUES  ( ?, ?, ?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;
		
		ps = connection.prepareStatement(sql);

		ps.setInt(1, medicoId);
		ps.setString(2, nombre);
		ps.setString(3, apellido);
		ps.setString(4, especialidad);
		ps.setString(5, licenciaMedica);
		ps.setString(6, telefono);
		ps.setString(7, correo);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarMedico(int medicoId, String nombre, String apellido, String especialidad,
			String licenciaMedica, String telefono, String correo) throws ClassNotFoundException, SQLException {

		String sql = "UPDATE medicos SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END,"
				+ "Apellido = CASE WHEN ? = '' THEN Apellido ELSE ? END,"
				+ "Especialidad = CASE WHEN ? = '' THEN Especialidad ELSE ? END,"
				+ "LicenciaMedica = CASE WHEN ? = '' THEN LicenciaMedica  ELSE ? END,"
				+ "Telefono = CASE WHEN ? = '' THEN Telefono ELSE ? END,"
				+ "CorreoElectronico = CASE WHEN ? = '' THEN CorreoElectronico ELSE ? END " + "WHERE ID = ? ";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);
		
		ps.setString(3, apellido);
		ps.setString(4, apellido);
		
		ps.setString(5, especialidad);
		ps.setString(6, especialidad);
		
		
		ps.setString(7, licenciaMedica);
		ps.setString(8, licenciaMedica);
		
		
		ps.setString(9, telefono);
		ps.setString(10, telefono);
		
		
		ps.setString(11, correo);
		ps.setString(12, correo);
		
		ps.setInt(13, medicoId);
		
		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}
}
