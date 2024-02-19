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

import com.kike.colegio.dao.PedidosDAO;
import com.kike.colegio.dtos.PedidosDTO;
import com.kike.colegio.utils.DBUtils;

@Component("pedidosJDBC")
public class PedidosDAOImplJdbc implements PedidosDAO {
	private static final Logger logger = LoggerFactory.getLogger(CategoriasDAOImplJdbc.class);

	@Override
	public List<PedidosDTO> obtenerTodosPedidos() throws ClassNotFoundException, SQLException, NamingException {
		ResultSet categoriasResultSet = null;
		List<PedidosDTO> listaCategorias = new ArrayList<PedidosDTO>();
		Connection connection = DBUtils.conectaBBDD();

		Statement st = connection.createStatement();
		categoriasResultSet = st.executeQuery("SELECT * FROM categorias");

		while (categoriasResultSet.next()) {
			listaCategorias.add(new PedidosDTO(categoriasResultSet.getString(1), categoriasResultSet.getString(2)));
			logger.info("añadido pedido " + categoriasResultSet.getString(1) + " " + categoriasResultSet.getString(2));
		}

		return listaCategorias;
	}

	@Override
	public List<PedidosDTO> buscarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException {

		String sql = "SELECT p.ID_Pedido, c.Nombre AS Cliente, e.NombreEstado AS Estado, p.FechaPedido "
				+ "FROM pedidos p " + "INNER JOIN clientes c ON p.ID_Cliente = c.ID_Cliente "
				+ "INNER JOIN estadospedidos e ON p.EstadoID = e.EstadoID "
				+ "WHERE (CAST(p.ID_Pedido AS CHAR) LIKE ? OR ? IS NULL) "
				+ "  AND (CAST(p.ID_Cliente AS CHAR) LIKE ? OR ? IS NULL) "
				+ "  AND (DATE_FORMAT(p.FechaPedido, '%Y-%m-%d') >= ? OR ? IS NULL) "
				+ "  AND (CAST(p.EstadoID AS CHAR) LIKE ? OR ? IS NULL)";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, "%" + id + "%");
		ps.setString(2, id);
		ps.setString(3, "%" + cliente + "%");
		ps.setString(4, cliente);
		ps.setString(5, fecha);
		ps.setString(6, fecha);
		ps.setString(7, "%" + estado + "%");
		ps.setString(8, estado);

		ResultSet rs = ps.executeQuery();

		List<PedidosDTO> listaCategorias = new ArrayList<>();

		while (rs.next()) {
			listaCategorias.add(new PedidosDTO(rs.getString("ID_Pedido"), rs.getString("Cliente"),
					rs.getString("Estado"), rs.getString("FechaPedido")));
		}

		return listaCategorias;
	}

	@Override
	public Integer insertarPedidos(String cliente, String idProducto, String cantidad, String precioUnitario)
			throws ClassNotFoundException, SQLException, NamingException {
		System.out.println(cantidad);

		Integer ultimoID = insertarPedido(cliente);
		Integer resultado = registrosDetallePedidos(ultimoID, idProducto, cantidad, precioUnitario);
		return resultado;
	}

	public int insertarPedido(String cliente) throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO pedidos (ID_Cliente, EstadoID) VALUES (?, 1)";

		try (Connection connection = DBUtils.conectaBBDD();
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, cliente);
			int filasAfectadas = ps.executeUpdate();

			if (filasAfectadas > 0) {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						int idPedidoGenerado = generatedKeys.getInt(1);
						return idPedidoGenerado;
					}
				}
			}
		}

		return -1;
	}

	public Integer registrosDetallePedidos(Integer idpeticion, String idproducto, String cantidad, String precio)
			throws ClassNotFoundException, SQLException {
		String sql = "INSERT INTO detalles_pedido ( ID_Pedido, ID_Producto, Cantidad, PrecioUnitario) "
				+ "  VALUES (?, ?, ?, ?)";
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setInt(1, idpeticion);
		ps.setString(2, idproducto);
		ps.setString(3, cantidad);
		ps.setString(4, precio);

		actualizarInventario(idproducto, cantidad);
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	public void actualizarInventario(String idProducto, String cantidad) throws ClassNotFoundException, SQLException {
		String sqlSelect = "SELECT CantidadEnStock FROM productos WHERE ID_Producto = ?";
		String sqlUpdate = "UPDATE productos SET CantidadEnStock = CantidadEnStock - ? WHERE ID_Producto = ?";
		int cantidadInt = Integer.parseInt(cantidad);
		try (Connection connection = DBUtils.conectaBBDD();
				PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
				PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate)) {

			psSelect.setString(1, idProducto);
			ResultSet rs = psSelect.executeQuery();

			if (rs.next()) {
				int cantidadActual = rs.getInt("CantidadEnStock");
				if (cantidadInt > cantidadActual) {
					throw new SQLException("La cantidad a restar es mayor que la cantidad en stock.");
				}
				psUpdate.setString(1, cantidad);
				psUpdate.setString(2, idProducto);
				int affectedRows = psUpdate.executeUpdate();

				if (affectedRows == 0) {
					throw new SQLException("Errror al actualizar inventario ");
				}
			} else {
				throw new SQLException("Producto no encontrado con ID: " + idProducto);
			}
		}
	}

	@Override
	public Integer actualizarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE pedidos SET ";

		List<String> updates = new ArrayList<>();
		if (cliente != null) {
			updates.add("ID_Cliente = ?");
		}
		if (fecha != null && !fecha.isEmpty()) {
			updates.add("FechaPedido = ?");
		}
		if (estado != null) {
			updates.add("EstadoID = ?");
		}

		if (updates.isEmpty()) {
			return 0;
		}

		sql += String.join(", ", updates) + " WHERE ID_Pedido = ?";

		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);

		int parameterIndex = 1;
		if (cliente != null) {
			ps.setString(parameterIndex++, cliente);
		}
		if (fecha != null && !fecha.isEmpty()) {
			ps.setString(parameterIndex++, fecha);
		}
		if (estado != null) {
			ps.setString(parameterIndex++, estado);
		}

		ps.setString(parameterIndex, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Double calcularPrecio(Integer idCliente, Double descuento) throws ClassNotFoundException {
		String sql = "SELECT SUM(dp.PrecioUnitario * dp.Cantidad) AS ComprasAcumuladas " + "FROM detalles_pedido dp "
				+ "JOIN pedidos p ON dp.ID_Pedido = p.ID_Pedido " + "WHERE p.ID_Cliente = ?";

		try (Connection connection = DBUtils.conectaBBDD(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, idCliente);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getDouble("ComprasAcumuladas");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;
	}

	@Override
	public Double obtenerComprasAcumuladasCliente(Integer idCliente) throws ClassNotFoundException {
		String sql = "SELECT SUM(dp.PrecioUnitario * dp.Cantidad) AS ComprasAcumuladas " + "FROM detalles_pedido dp "
				+ "JOIN pedidos p ON dp.ID_Pedido = p.ID_Pedido " + "WHERE p.ID_Cliente = ?";

		try (Connection connection = DBUtils.conectaBBDD(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, idCliente);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getDouble("ComprasAcumuladas");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;

	}

	@Override
	public Double obtenerDescuentoPorCompras(Double comprasAcumuladas) throws ClassNotFoundException {
		String sql = "SELECT descuento " + "FROM descuentos " + "WHERE cantidad <= ? " + "ORDER BY cantidad DESC "
				+ "LIMIT 1";

		try (Connection connection = DBUtils.conectaBBDD(); PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setDouble(1, comprasAcumuladas);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getDouble("descuento");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0.0;

	}

}
