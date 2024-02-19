package com.kike.colegio.hibernateimpl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.PedidosDAO;
import com.kike.colegio.dtos.PedidosDTO;
import com.kike.colegio.entities.ClienteEntity;
import com.kike.colegio.entities.DetallesPedidoEntity;
import com.kike.colegio.entities.EstadoPedidosEntity;
import com.kike.colegio.entities.PedidosEntity;
import com.kike.colegio.entities.PeticionesEntity;
import com.kike.colegio.entities.ProductoEntity;
import com.kike.colegio.utils.DBUtils;

@Component("pedidosHIB")
public class PedidosDAOhib implements PedidosDAO {
	private static SessionFactory sessionFactory = DBUtils.creadorSessionFactory();

	@Override
	public List<PedidosDTO> obtenerTodosPedidos() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidosDTO> buscarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarPedidos(String cliente, String idProducto, String cantidad, String precioUnitario)
			throws ClassNotFoundException, SQLException, NamingException {
		Integer ultimoID = insertarPedido(cliente);
		Integer resultado = registrosDetallePedidos(ultimoID, idProducto, cantidad, precioUnitario);
		return resultado;
	}

	public int insertarPedido(String cliente) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();

			ClienteEntity clienteEntity = session.get(ClienteEntity.class, cliente);
			EstadoPedidosEntity estadoPedido = session.get(EstadoPedidosEntity.class, 1);

			PeticionesEntity nuevoPedido = new PeticionesEntity();
			nuevoPedido.setCliente(clienteEntity);
			nuevoPedido.setEstado(estadoPedido);

			session.save(nuevoPedido);
			transaction.commit();

			return nuevoPedido.getIdPeticiones();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Integer registrosDetallePedidos(Integer idPedido, String idProducto, String cantidad, String precio) {
		Transaction transaction = null;
		Integer resultado = 0;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			DetallesPedidoEntity detallePedido = new DetallesPedidoEntity();

			PedidosEntity pedido = session.get(PedidosEntity.class, idPedido);
			detallePedido.setPeticion(pedido);

			ProductoEntity producto = session.get(ProductoEntity.class, idProducto);
			detallePedido.setProducto(producto);

			detallePedido.setCantidad(Integer.parseInt(cantidad));
			detallePedido.setPrecioUnitario(Double.parseDouble(precio));

			session.save(detallePedido);

			actualizarInventario(idProducto, cantidad);

			transaction.commit();
			resultado = 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return resultado;
	}

	public void actualizarInventario(String idProducto, String cantidad) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			String hqlSelect = "SELECT cantidadEnStock FROM Producto WHERE idProducto = :idProducto";
			Integer cantidadActual = (Integer) session.createQuery(hqlSelect).setParameter("idProducto", idProducto)
					.uniqueResult();

			if (cantidadActual == null) {
				throw new IllegalArgumentException("Producto no encontrado con ID: " + idProducto);
			}

			int cantidadInt = Integer.parseInt(cantidad);

			if (cantidadInt > cantidadActual) {
				throw new IllegalArgumentException("La cantidad a restar es mayor que la cantidad en stock.");
			}

			String hqlUpdate = "UPDATE Producto SET cantidadEnStock = cantidadEnStock - :cantidad WHERE idProducto = :idProducto";
			session.createQuery(hqlUpdate).setParameter("cantidad", cantidadInt).setParameter("idProducto", idProducto)
					.executeUpdate();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Integer actualizarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularPrecio(Integer idCLiente, Double descuento) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double obtenerComprasAcumuladasCliente(Integer idCliente) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double obtenerDescuentoPorCompras(Double comprasAcumuladas) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
