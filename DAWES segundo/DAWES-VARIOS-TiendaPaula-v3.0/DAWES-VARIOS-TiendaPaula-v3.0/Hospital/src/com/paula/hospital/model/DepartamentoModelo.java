package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.DepartamentoDTO;
import com.paula.hospital.utils.DBUtils;

public class DepartamentoModelo {

	public List<DepartamentoDTO> buscaDepartamento(String id, String nombre, String descripcion, String activo)
			throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM Departamentos WHERE ID LIKE ? AND Nombre LIKE ? AND Descripcion LIKE ? AND Activo LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, "%" + activo + "%");

		ResultSet departamentoRS = ps.executeQuery();
		List<DepartamentoDTO> listaDepartamentos = new ArrayList<>();

		while (departamentoRS.next()) {
			DepartamentoDTO d = new DepartamentoDTO(departamentoRS.getInt("ID"), departamentoRS.getString("Nombre"),
					departamentoRS.getString("Descripcion"), departamentoRS.getInt("Activo"));
			listaDepartamentos.add(d);
		}

		conexionBD.close();
		return listaDepartamentos;
	}

	public Integer insertarDepartamento(int id, String nombre, String descripcion, int activo)
			throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Departamentos (ID, Nombre, Descripcion, Activo) VALUES (?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setInt(4, activo);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarDepartamento(int id, String nombre, String descripcion, int activo)
			throws SQLException, ClassNotFoundException {
		String sql = "UPDATE Departamentos SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END, Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END, Activo = ? WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setString(4, descripcion);
		ps.setInt(5, activo);
		ps.setInt(6, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer borrarDepartamento(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM Departamentos WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
