package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.FarmaciaDTO;
import com.paula.hospital.utils.DBUtils;

public class FarmaciaModelo {

	public List<FarmaciaDTO> buscaFarmacia(String id, String nombre, String descripcion, String cantidadDisponible,
			String precio) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM Farmacia WHERE ID LIKE ? AND Nombre LIKE ? AND Descripcion LIKE ? AND CantidadDisponible LIKE ? AND Precio LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + descripcion + "%");
		ps.setString(4, "%" +  cantidadDisponible + "%");
		ps.setString(5, "%" + precio + "%");

		ResultSet farmaciaRS = ps.executeQuery();
		List<FarmaciaDTO> listaFarmacia = new ArrayList<>();

		while (farmaciaRS.next()) {
			FarmaciaDTO medicamento = new FarmaciaDTO(farmaciaRS.getInt("ID"), farmaciaRS.getString("Nombre"),
					farmaciaRS.getString("Descripcion"), farmaciaRS.getInt("CantidadDisponible"),
					farmaciaRS.getDouble("Precio"));
			listaFarmacia.add(medicamento);
		}
		conexionBD.close();

		return listaFarmacia;
	}

	public Integer insertarFarmacia(int id, String nombre, String descripcion, int cantidadDisponible, double precio)
			throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Farmacia (ID, Nombre, Descripcion, CantidadDisponible, Precio) VALUES (?, ?, ?, ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, descripcion);
		ps.setInt(4, cantidadDisponible);
		ps.setDouble(5, precio);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarFarmacia(int id, String nombre, String descripcion, int cantidadDisponible,
			double precio) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE Farmacia SET Nombre = CASE WHEN ? = '' THEN Nombre ELSE ? END,"
				+ "Descripcion = CASE WHEN ? = '' THEN Descripcion ELSE ? END,"
				+ "CantidadDisponible = CASE WHEN ? = '' THEN CantidadDisponible ELSE ? END,"
				+ "Precio = CASE WHEN ? = '' THEN Precio ELSE ? END " + "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, nombre);

		ps.setString(3, descripcion);
		ps.setString(4, descripcion);

		ps.setInt(5, cantidadDisponible);
		ps.setInt(6, cantidadDisponible);

		ps.setDouble(7, precio);
		ps.setDouble(8, precio);

		ps.setInt(9, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
