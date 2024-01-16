package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.EstadoFacturacionDTO;
import com.paula.hospital.utils.DBUtils;

public class EstadoFacturacionModelo {

	public List<EstadoFacturacionDTO> buscaEstadoFacturacion(String id, String estado)
			throws ClassNotFoundException, SQLException {

		String query = "SELECT * from estadofacturacion where ID LIKE ? AND Estado LIKE ? ";

		Connection conexionBD = DBUtils.conexionBBDD();

		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + estado + "%");

		ResultSet estadoCitaRS = ps.executeQuery();
		List<EstadoFacturacionDTO> listaEstadoFacturacion = new ArrayList<>();

		while (estadoCitaRS.next()) {
			EstadoFacturacionDTO e = new EstadoFacturacionDTO(estadoCitaRS.getInt("ID"),
					estadoCitaRS.getString("Estado"));
			listaEstadoFacturacion.add(e);
		}
		conexionBD.close();

		return listaEstadoFacturacion;
	}

	public Integer insertarEstadoFacturacion(int id, String estado) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO estadofacturacion ( ID, Estado) VALUES ( ?, ? )";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, estado);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}
	
	public Integer actualizarEstadoFacturacion(int id, String estado) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE estadofacturacion SET Estado = CASE WHEN ? = '' THEN Estado ELSE ? END " + "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, estado);
		ps.setString(2, estado);
		ps.setInt(3, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
