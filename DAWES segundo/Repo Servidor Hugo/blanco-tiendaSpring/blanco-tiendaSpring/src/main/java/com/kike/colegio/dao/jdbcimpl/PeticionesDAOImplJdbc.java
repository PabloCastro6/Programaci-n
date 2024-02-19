package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.PeticionesDAO;
import com.kike.colegio.dtos.PeticionesDTO;
import com.kike.colegio.utils.DBUtils;

@Component("peteicionesJDBC")
public class PeticionesDAOImplJdbc implements PeticionesDAO {
	private static final Logger logger = LoggerFactory.getLogger(CategoriasDAOImplJdbc.class);

	@Override
	public List<PeticionesDTO> obtenerTodosPeticiones() throws ClassNotFoundException, SQLException, NamingException {
		ResultSet categoriasResultSet = null;
		List<PeticionesDTO> listaCategorias = new ArrayList<PeticionesDTO>();
		Connection connection = DBUtils.conectaBBDD();

		Statement st = connection.createStatement();
		categoriasResultSet = st.executeQuery("SELECT * FROM peticiones");

		while (categoriasResultSet.next()) {
			listaCategorias.add(new PeticionesDTO(categoriasResultSet.getString(1), categoriasResultSet.getString(2)));
			logger.info(
					"añadido categoria " + categoriasResultSet.getString(1) + " " + categoriasResultSet.getString(2));
		}

		return listaCategorias;
	}

	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String cliente, String producto, String cantidad,
			String estado, String fecha) throws ClassNotFoundException, SQLException, NamingException {
		Connection connection = DBUtils.conectaBBDD();

		String sql = "SELECT p.ID_Peticiones, c.nombre AS nombreCliente, pr.nombre AS nombreProducto, "
				+ "p.cantidad, e.NombreEstado, p.FechaAñadido " + "FROM peticiones p "
				+ "LEFT JOIN clientes c ON c.ID_Cliente = p.ID_Cliente "
				+ "LEFT JOIN productos pr ON pr.ID_Producto = p.ID_Producto "
				+ "LEFT JOIN estadospedidos e ON e.EstadoID = p.Estado " + "WHERE p.ID_Peticiones LIKE ? ";

		List<String> condiciones = new ArrayList<>();

		if (!cliente.isEmpty()) {
			condiciones.add("p.ID_Cliente = ?");
		}

		if (!producto.isEmpty()) {
			condiciones.add("p.ID_Producto = ?");
		}

		if (!estado.isEmpty()) {
			condiciones.add("p.Estado = ?");
		}

		if (!condiciones.isEmpty()) {
			sql += "AND " + String.join(" AND ", condiciones);
		}

		List<PeticionesDTO> listaPeticiones = new ArrayList<>();

		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, "%" + id + "%");

			int parameterIndex = 2;
			if (!cliente.isEmpty()) {
				ps.setString(parameterIndex++, cliente);
			}

			if (!producto.isEmpty()) {
				ps.setString(parameterIndex++, producto);
			}

			if (!estado.isEmpty()) {
				ps.setString(parameterIndex, estado);
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				listaPeticiones.add(new PeticionesDTO(rs.getString("ID_Peticiones"), rs.getString("nombreCliente"),
						rs.getString("nombreProducto"), rs.getString("cantidad"), rs.getString("NombreEstado"),
						rs.getString("FechaAñadido")));
			}
		} finally {
			connection.close();
		}

		return listaPeticiones;
	}

	@Override
	public Integer insertarPeticiones(String cliente, String producto, String cantidad, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO peticiones ( ID_Cliente, ID_Producto,cantidad,Estado) " + "  VALUES (?,?,?, ?)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, cliente);
		ps.setString(2, producto);
		ps.setString(3, cantidad);
		ps.setString(4, estado);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarPeticiones(String id, String cliente, String producto, String cantidad, String estado,
			String fecha) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE peticiones SET ";

		List<String> updates = new ArrayList<>();
		if (cliente != null) {
			updates.add("ID_Cliente = ?");
		}
		if (producto != null) {
			updates.add("ID_Producto = ?");
		}
		if (cantidad != null) {
			updates.add("cantidad = ?");
		}
		if (estado != null) {
			updates.add("Estado = ?");
		}
		if (fecha != null && !fecha.isEmpty()) {
			updates.add("FechaAñadido = ?");
		}

		if (updates.isEmpty()) {
			// No hay nada para actualizar
			return 0;
		}

		sql += String.join(", ", updates) + " WHERE ID_Peticiones = ?";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		int parameterIndex = 1;
		if (cliente != null) {
			ps.setString(parameterIndex++, cliente);
		}
		if (producto != null) {
			ps.setString(parameterIndex++, producto);
		}
		if (cantidad != null) {
			ps.setString(parameterIndex++, cantidad);
		}
		if (estado != null) {
			ps.setString(parameterIndex++, estado);
		}
		if (fecha != null && !fecha.isEmpty()) {
			ps.setString(parameterIndex++, fecha);
		}

		// Agrega el parámetro del ID al final
		ps.setString(parameterIndex, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarPeticiones(String id) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE peticiones SET estado = 5 " + "WHERE ID_Peticiones = ? ";
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

}
