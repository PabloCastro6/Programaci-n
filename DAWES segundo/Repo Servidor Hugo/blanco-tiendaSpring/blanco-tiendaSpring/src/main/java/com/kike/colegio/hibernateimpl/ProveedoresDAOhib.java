package com.kike.colegio.hibernateimpl;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProveedoresDAO;
import com.kike.colegio.dtos.ProvedoresDTO;
import com.kike.colegio.entities.ProveedorEntity;
import com.kike.colegio.utils.DBUtils;

@Component("proveedoresHIB")

public class ProveedoresDAOhib implements ProveedoresDAO {
	private static SessionFactory sessionFactory = DBUtils.creadorSessionFactory();

	@Override
	public List<ProvedoresDTO> obtenerTodosProveedores() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProvedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo) {
//	    try (Session session = sessionFactory.openSession()) {
//	        Query<ProveedorEntity> query = session.createQuery("FROM ProveedorEntity p WHERE " +
//	                "str(p.id) LIKE :id AND p.nombre LIKE :nombre AND p.contacto LIKE :contacto AND p.telefono LIKE :telefono " +
//	                "AND p.correo LIKE :correo AND p.direccion LIKE :direccion AND p.activo = :activo", ProveedorEntity.class);
//	        query.setParameter("id", "%" + id + "%");
//	        query.setParameter("nombre", "%" + nombre + "%");
//	        query.setParameter("contacto", "%" + contacto + "%");
//	        query.setParameter("telefono", "%" + telefono + "%");
//	        query.setParameter("correo", "%" + correo + "%");
//	        query.setParameter("direccion", "%" + direccion + "%");
//	        query.setParameter("activo", activo);
//
//	        List<ProveedorEntity> resultList = query.list();
//	        return resultList.stream()
//	                .map(entity -> new ProvedoresDTO(entity.getId(), entity.getNombre(), entity.getContacto(),
//	                        entity.getTelefono(), entity.getCorreo(), entity.getDireccion(),
//	                        entity.getActivo() != null ? Integer.parseInt(entity.getActivo()) : null))
//	                .collect(Collectors.toList());
//	    }
		return null;
	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) {
		Transaction transaction = null;
		Integer idProveedor = null;
		try (Session session = sessionFactory.openSession()) {
			// Comienza la transacción
			transaction = session.beginTransaction();

			ProveedorEntity proveedor = new ProveedorEntity();
			proveedor.setNombre(nombre);
			proveedor.setContacto(contacto);
			proveedor.setTelefono(telefono);
			proveedor.setCorreo(correo);
			proveedor.setDireccion(direccion);
			proveedor.setActivo(activo);

			// Guarda el proveedor en la base de datos
			idProveedor = (Integer) session.save(proveedor);

			// Finaliza la transacción
			transaction.commit();
		} catch (Exception e) {
			// Maneja las excepciones y realiza un rollback si es necesario
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace(); // o manejo de excepciones adecuado
		}
		return idProveedor;
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			ProveedorEntity proveedor = session.get(ProveedorEntity.class, Integer.parseInt(id));
			if (proveedor != null) {
				proveedor.setNombre(nombre);
				proveedor.setContacto(contacto);
				proveedor.setTelefono(telefono);
				proveedor.setCorreo(correo);
				proveedor.setDireccion(direccion);
				proveedor.setActivo(activo);
				session.update(proveedor);
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
	public Integer borrarProveedor(String id) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			ProveedorEntity proveedor = session.get(ProveedorEntity.class, Integer.parseInt(id));
			if (proveedor != null) {
				proveedor.setActivo("0");
				session.update(proveedor);
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

}
