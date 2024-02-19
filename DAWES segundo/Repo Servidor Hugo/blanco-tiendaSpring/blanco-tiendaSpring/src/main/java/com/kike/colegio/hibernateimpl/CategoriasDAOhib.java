package com.kike.colegio.hibernateimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.CategoriasDAO;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.entities.CategoriaEntity;
import com.kike.colegio.utils.DBUtils;

@Component("categoriasHIB")
public class CategoriasDAOhib implements CategoriasDAO {

	private static SessionFactory sessionFactory = DBUtils.creadorSessionFactory();

	@Override
	public List<CategoriaDTO> obtenerTodosCategorias() {
		try (Session session = sessionFactory.openSession()) {
			Query<CategoriaEntity> query = session.createQuery("FROM CategoriaEntity", CategoriaEntity.class);
			List<CategoriaEntity> resultList = query.list();
			return resultList.stream()
					.map(entity -> new CategoriaDTO(entity.getId(), entity.getNombre(), entity.getDescripcion(),
							entity.getActivo() != null ? entity.getActivo().intValue() : null))
					.collect(Collectors.toList());
		}
	}

	@Override
	public List<CategoriaDTO> buscarCategorias(String id, String nombre, String descripcion, String activo) {
		try (Session session = sessionFactory.openSession()) {
			Query<CategoriaEntity> query = session.createQuery("FROM CategoriaEntity c WHERE "
					+ "str(c.id) LIKE :id AND c.nombre LIKE :nombre AND c.descripcion LIKE :descripcion AND c.activo = :activo",
					CategoriaEntity.class);
			query.setParameter("id", "%" + id + "%");
			query.setParameter("nombre", "%" + nombre + "%");
			query.setParameter("descripcion", "%" + descripcion + "%");
			query.setParameter("activo", Short.valueOf(activo));
			List<CategoriaEntity> resultList = query.list();
			return resultList.stream()
					.map(entity -> new CategoriaDTO(entity.getId(), entity.getNombre(), entity.getDescripcion(),
							entity.getActivo() != null ? entity.getActivo().intValue() : null))
					.collect(Collectors.toList());
		}
	}

	@Override
	public Integer insertarCategorias(String nombre, String descripcion, String activo) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			CategoriaEntity categoria = new CategoriaEntity();
			categoria.setNombre(nombre);
			categoria.setDescripcion(descripcion);
			categoria.setActivo(Integer.parseInt(activo));
			session.save(categoria);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer actualizarCategorias(String id, String nombre, String descripcion, String activo) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			CategoriaEntity categoria = session.get(CategoriaEntity.class, Integer.parseInt(id));
			if (categoria != null) {
				categoria.setNombre(nombre);
				categoria.setDescripcion(descripcion);
				categoria.setActivo(Integer.parseInt(activo));
				session.update(categoria);
				transaction.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Integer borrarCategorias(String id) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			CategoriaEntity categoria = session.get(CategoriaEntity.class, Integer.parseInt(id));
			if (categoria != null) {
				categoria.setActivo((Integer) 0);
				session.update(categoria);
				transaction.commit();
				return 1;
			}
			return 0;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return 0;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
