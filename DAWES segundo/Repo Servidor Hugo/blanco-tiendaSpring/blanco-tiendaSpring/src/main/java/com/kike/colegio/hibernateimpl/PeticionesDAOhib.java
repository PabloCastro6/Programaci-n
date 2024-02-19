package com.kike.colegio.hibernateimpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NamingException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.PeticionesDAO;
import com.kike.colegio.dtos.PeticionesDTO;
import com.kike.colegio.entities.ClienteEntity;
import com.kike.colegio.entities.EstadoPedidosEntity;
import com.kike.colegio.entities.PeticionesEntity;
import com.kike.colegio.entities.ProductoEntity;
import com.kike.colegio.utils.DBUtils;

@Component("peteicionesHIB")

public class PeticionesDAOhib implements PeticionesDAO {
	private static SessionFactory sessionFactory = DBUtils.creadorSessionFactory();

	@Override
	public List<PeticionesDTO> obtenerTodosPeticiones() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String idCliente, String idProducto, String fecha,
			String cantidad, String idEstado) {
		SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<PeticionesDTO> listaPeticiones = null;

		try {
			transaction = session.beginTransaction();

			String sql = "SELECT p.ID_Peticiones, c.nombre AS nombreCliente, pr.nombre AS nombreProducto, "
					+ "p.cantidad, e.NombreEstado, p.FechaAñadido " + "FROM peticiones p "
					+ "LEFT JOIN clientes c ON c.ID_Cliente = p.ID_Cliente "
					+ "LEFT JOIN productos pr ON pr.ID_Producto = p.ID_Producto "
					+ "LEFT JOIN estadospedidos e ON e.EstadoID = p.Estado "
					+ "WHERE (:idPeticiones IS NULL OR p.ID_Peticiones = :idPeticiones) "
					+ "AND (:cliente IS NULL OR c.ID_Cliente = :cliente) "
					+ "AND (:producto IS NULL OR pr.ID_Producto = :producto) "
					+ "AND (:estado IS NULL OR e.EstadoID = :estado) "
					+ "AND (:fechaAñadido IS NULL OR p.FechaAñadido >= :fechaAñadido) "
					+ "AND (:cantidad IS NULL OR p.cantidad >= :cantidad) " + "ORDER BY p.ID_Peticiones ASC";

			Query query = session.createNativeQuery(sql);

			query.setParameter("idPeticiones", (id != null && !id.isEmpty()) ? Integer.parseInt(id) : null);
			query.setParameter("cliente",
					(idCliente != null && !idCliente.isEmpty()) ? Integer.parseInt(idCliente) : null);
			query.setParameter("producto",
					(idProducto != null && !idProducto.isEmpty()) ? Integer.parseInt(idProducto) : null);
			query.setParameter("estado", (idEstado != null && !idEstado.isEmpty()) ? Integer.parseInt(idEstado) : null);
			query.setParameter("fechaAñadido", (fecha != null && !fecha.isEmpty()) ? LocalDate.parse(fecha) : null);
			query.setParameter("cantidad",
					(cantidad != null && !cantidad.isEmpty()) ? Integer.parseInt(cantidad) : null);

			List<Object[]> results = query.getResultList();
			listaPeticiones = new ArrayList<>();

			for (Object[] row : results) {
				PeticionesDTO peticion = new PeticionesDTO(String.valueOf(row[0]), String.valueOf(row[1]),
						String.valueOf(row[2]), String.valueOf(row[3]), String.valueOf(row[4]), String.valueOf(row[5]));
				listaPeticiones.add(peticion);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return listaPeticiones;
	}

	@Override
	public Integer insertarPeticiones(String cliente, String producto, String cantidad, String estado) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();

			try {
				ClienteEntity clienteEntity = new ClienteEntity();
				clienteEntity.setId(Integer.parseInt(cliente));

				ProductoEntity productoEntity = new ProductoEntity();
				productoEntity.setId(Integer.parseInt(producto));

				EstadoPedidosEntity estadoEntity = new EstadoPedidosEntity();
				estadoEntity.setEstadoId(Integer.parseInt(estado));

				PeticionesEntity peticion = new PeticionesEntity();
				peticion.setCliente(clienteEntity);
				peticion.setProducto(productoEntity);
				peticion.setCantidad(Integer.parseInt(cantidad));
				peticion.setEstado(estadoEntity);

				peticion.setFechaAñadido(null);

				session.save(peticion);

				transaction.commit();
				return 1;
			} catch (Exception e) {
				transaction.rollback();
				e.printStackTrace();
				return 0;
			}
		}
	}

	@Override
	public Integer actualizarPeticiones(String id, String cliente, String producto, String cantidad, String estado,
			String fecha) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer resultado = 0;

		try {
			sessionFactory = DBUtils.creadorSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			StringBuilder hql = new StringBuilder("UPDATE PeticionesEntity SET ");
			List<String> updates = new ArrayList<>();
			if (cliente != null) {
				updates.add("cliente.id = :cliente");
			}
			if (producto != null) {
				updates.add("producto.id = :producto");
			}
			if (cantidad != null) {
				updates.add("cantidad = :cantidad");
			}
			if (estado != null) {
				updates.add("estado = :estado");
			}
			if (fecha != null && !fecha.isEmpty()) {
				updates.add("fechaAñadido = :fechaAñadido");
			}
			hql.append(String.join(", ", updates));
			hql.append(" WHERE id = :id");

			Query query = session.createQuery(hql.toString());

			if (cliente != null) {
				query.setParameter("cliente", Integer.parseInt(cliente));
			}
			if (producto != null) {
				query.setParameter("producto", Integer.parseInt(producto));
			}
			if (cantidad != null) {
				query.setParameter("cantidad", Integer.parseInt(cantidad));
			}
			if (estado != null) {
				query.setParameter("estado", estado);
			}
			if (fecha != null && !fecha.isEmpty()) {
				query.setParameter("fechaAñadido", LocalDate.parse(fecha));
			}
			query.setParameter("id", Integer.parseInt(id));

			resultado = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return resultado;
	}

	@Override
	public Integer borrarPeticiones(String id) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer resultado = 0;

		try {
			sessionFactory = DBUtils.creadorSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			EstadoPedidosEntity estadoCancelado = session.load(EstadoPedidosEntity.class, 5);

			String hql = "UPDATE PeticionesEntity SET estado = :estado WHERE id = :id";
			Query query = session.createQuery(hql);

			query.setParameter("estado", estadoCancelado);
			query.setParameter("id", Integer.parseInt(id));

			resultado = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return resultado;
	}

}
