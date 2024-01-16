package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.FacturacionDTO;
import com.paula.hospital.utils.DBUtils;

public class FacturacionModelo {

	public List<FacturacionDTO> buscaFacturacion(String id,String nombrePaciente, String fecha, String monto, String estado)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM Facturacion f INNER JOIN Pacientes p ON f.PacienteID = p.ID "
				+ "INNER JOIN EstadoFacturacion ef ON f.EstadoID = ef.ID WHERE f.ID LIKE ? AND p.Nombre LIKE ? "
				+ "AND f.Fecha LIKE ? AND f.Monto LIKE ? AND ef.Estado LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);
		
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombrePaciente + "%");
		ps.setString(3, "%" + fecha + "%");
		ps.setString(4, "%" + monto + "%");
		ps.setString(5, "%" + estado + "%");

		ResultSet facturacionRS = ps.executeQuery();
		List<FacturacionDTO> listaFacturacion = new ArrayList<>();

		while (facturacionRS.next()) {
			FacturacionDTO facturacion = new FacturacionDTO(facturacionRS.getInt("f.ID"),
					facturacionRS.getString("p.Nombre"), facturacionRS.getString("f.Fecha"),
					facturacionRS.getDouble("f.Monto"), facturacionRS.getString("ef.Estado"));
			listaFacturacion.add(facturacion);
		}

		conexionBD.close();
		return listaFacturacion;
	}

	public Integer insertarFacturacion(int id, String nombrePaciente, String fecha, double monto, String estado)
			throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO Facturacion (ID, PacienteID, Fecha, Monto, EstadoID)"
				+ "VALUES (?, (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ?), ?, ?, (SELECT ef.ID FROM EstadoFacturacion ef WHERE ef.Estado = ?))";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombrePaciente);
		ps.setString(3, fecha);
		ps.setDouble(4, monto);
		ps.setString(5, estado);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarFacturacion(int id, String nombrePaciente, String fecha, double monto, String estado)
			throws SQLException, ClassNotFoundException {

		String sql = "UPDATE Facturacion SET PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ?) END,"
				+ "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END," + "Monto = CASE WHEN ? = '' THEN Monto ELSE ? END,"
				+ "EstadoID = CASE WHEN ? = '' THEN EstadoID ELSE (SELECT ef.ID FROM EstadoFacturacion ef WHERE ef.Estado = ?) END "
				+ "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombrePaciente);
		ps.setString(2, nombrePaciente);

		ps.setString(3, fecha);
		ps.setString(4, fecha);

		ps.setDouble(5, monto);
		ps.setDouble(6, monto);

		ps.setString(7, estado);
		ps.setString(8, estado);

		ps.setInt(9, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
