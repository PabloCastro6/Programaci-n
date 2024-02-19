package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ClientesDAO;
import com.kike.colegio.dtos.ClientesDTO;
import com.kike.colegio.utils.DBUtils;

@Component("clientesJDBC")
public class ClientesDAOImplJdbc implements ClientesDAO {

	@Override
	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "SELECT c.ID_Cliente, c.Nombre, c.CorreoElectronico, c.ID_Poblacion, p.Nombre, c.activo"
				+ " FROM clientes c INNER JOIN poblacion p ON c.ID_Poblacion= p.ID"
				+ " WHERE (? IS NULL OR c.ID_Cliente LIKE ?)" + " AND (? IS NULL OR c.Nombre LIKE ?)"
				+ " AND (? IS NULL OR c.CorreoElectronico LIKE ?)" + " AND (? IS NULL OR c.ID_Poblacion = ?)"
				+ " AND (? IS NULL OR c.activo = ?);";

		Connection connection = DBUtils.conectaBBDD();
		List<ClientesDTO> listaClientes = new ArrayList<>();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, id);
			ps.setString(2, "%" + id + "%");
			ps.setString(3, nombre);
			ps.setString(4, "%" + nombre + "%");
			ps.setString(5, correo);
			ps.setString(6, "%" + correo + "%");
			ps.setString(7, poblacion);
			ps.setString(8, poblacion);
			ps.setString(9, activo);
			ps.setString(10, activo);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					listaClientes.add(new ClientesDTO(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6)));
				}
			}
		} finally {
			connection.close();
		}
		return listaClientes;
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String idpoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		Connection connection = null;

		String sqlObtenerNombrePoblacion = "SELECT ID, Nombre FROM poblacion WHERE ID = ?";
		connection = DBUtils.conectaBBDD();
		PreparedStatement psObtenerId = connection.prepareStatement(sqlObtenerNombrePoblacion);
		psObtenerId.setString(1, idpoblacion);
		ResultSet rs = psObtenerId.executeQuery();

		int poblacion = 0;
		if (rs.next()) {
			poblacion = rs.getInt("ID");
		} else {
			System.out.println("La población '" + idpoblacion + "' no se encontró.");
		}

		String sqlInsertar = "INSERT INTO clientes (Nombre, correoElectronico, Contraseña, ID_Poblacion, activo) VALUES (?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sqlInsertar);
		String contraseña = "";
		ps.setString(1, nombre);
		ps.setString(2, correo);
		ps.setString(3, contraseña);
		ps.setInt(4, poblacion);
		ps.setString(5, activo);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idpoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		Connection connection = null;
		connection = DBUtils.conectaBBDD();

		String sql = "";

		if (idpoblacion.equals("")) {
			sql = "UPDATE clientes SET Nombre = ?, CorreoElectronico = ?, activo = ?  WHERE ID_Cliente = ?";
		} else {
			sql = "UPDATE clientes SET Nombre = ?, CorreoElectronico = ?, ID_Poblacion = ?, activo = ?  WHERE ID_Cliente = ?";
		}

		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, nombre);
		ps.setString(2, correo);
		if (!idpoblacion.equals("")) {
			ps.setString(3, idpoblacion);
			ps.setString(4, activo);
			ps.setString(5, id);
		} else {
			ps.setString(3, activo);
			ps.setString(4, id);
		}

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE clientes SET activo = 0 WHERE ID_Cliente = ? ";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		ps.toString();
		connection.close();

		return resultado;
	}

}
