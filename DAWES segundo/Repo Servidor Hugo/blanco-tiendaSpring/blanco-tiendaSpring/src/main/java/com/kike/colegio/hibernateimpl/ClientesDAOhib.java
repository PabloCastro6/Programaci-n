package com.kike.colegio.hibernateimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ClientesDAO;
import com.kike.colegio.dtos.ClientesDTO;
import com.kike.colegio.entities.ClienteEntity;
import com.kike.colegio.entities.PoblacionEntity;
import com.kike.colegio.utils.DBUtils;

@Component("clientesHIB")
public class ClientesDAOhib implements ClientesDAO {
	private static SessionFactory sessionFactory = DBUtils.creadorSessionFactory();

	@Override
	public List<ClientesDTO> buscarClientes(String id, String nombre, String correo, String poblacion, String activo) {
//	     try (Session session = sessionFactory.openSession()) {
//	    	 List<ClientesDTO> listaClientes = new ArrayList<>();
//
//			 try (Session sesion = sessionFactory.openSession()) {
//	             String hql = "SELECT c.id, c.nombre, c.correoElectronico, p.id, p.nombre, c.activo " +
//	                     "FROM ClienteEntity c " +
//	                     "JOIN c.cliente p " +
//	                     "WHERE (:id IS NULL OR c.id LIKE :id) " +
//	                     "AND (:nombre IS NULL OR c.nombre LIKE :nombre) " +
//	                     "AND (:correo IS NULL OR c.correoElectronico LIKE :correo) " +
//	                     "AND (:poblacion IS NULL OR c.cliente.id = :poblacion) " +
//	                     "AND (:activo IS NULL OR c.activo = :activo)";
//
//	             Query<Object[]> query = session.createQuery(hql, Object[].class);
//	             query.setParameter("id", id);
//	             query.setParameter("nombre", "%" + nombre + "%");
//	             query.setParameter("correo", "%" + correo + "%");
//	             query.setParameter("poblacion", poblacion);
//	             query.setParameter("activo", activo);
//
//	             List<Object[]> results = query.getResultList();
//	             for (Object[] result : results) {
//	                 listaClientes.add(new ClientesDTO(
//	                         result[0].toString(),
//	                         result[1].toString(),
//	                         result[2].toString(),
//	                         result[3].toString(),
//	                         result[4].toString(),
//	                         result[5].toString()
//	                 ));
//	             }
//	         }
//
//	         return listaClientes;
//	     }
		return null;
	}

	@Override
	public Integer insertarClientes(String nombre, String correo, String idpoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

//	        Integer resultado = 0;
//	        Transaction transaction = null;
//
//	        try (Session session = sessionFactory.openSession()) {
//	            transaction = session.beginTransaction();
//
//	            int poblacionId = Integer.parseInt(idpoblacion);
//	            PoblacionEntity poblacionEntity = session.get(PoblacionEntity.class, poblacionId);
//
//	            if (poblacionEntity != null) {
//	                ClienteEntity clienteEntity = new ClienteEntity();
//	                clienteEntity.setNombre(nombre);
//	                clienteEntity.setCorreoElectronico(correo);
//	                clienteEntity.setActivo(Integer.parseInt(activo));
//	                session.save(clienteEntity);
//
//	                resultado = 1; 
//	            } else {
//	                System.out.println("La población '" + idpoblacion + "' no se encontró.");
//	            }
//
//	            transaction.commit();
//	        } catch (Exception e) {
//	            if (transaction != null) {
//	                transaction.rollback();
//	            }
//	            e.printStackTrace();
//	        }
//
//	        return resultado;
		return null;

	}

	@Override
	public Integer actualizarClientes(String id, String nombre, String correo, String idpoblacion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {

//	        Integer resultado = 0;
//	        Transaction transaction = null;
//
//	        try (Session session = sessionFactory.openSession()) {
//	            transaction = session.beginTransaction();
//
//	            int clienteId = Integer.parseInt(id);
//	            ClienteEntity clienteEntity = session.get(ClienteEntity.class, clienteId);
//
//	            if (clienteEntity != null) {
//	                clienteEntity.setNombre(nombre);
//	                clienteEntity.setCorreoElectronico(correo);
//
//	                if (!idpoblacion.isEmpty()) {
//	                    int poblacionId = Integer.parseInt(idpoblacion);
//	                    PoblacionEntity poblacionEntity = session.get(PoblacionEntity.class, poblacionId);
//
//	                    if (poblacionEntity != null) {
//	                        clienteEntity.setCliente(poblacionEntity);
//	                    } else {
//	                        System.out.println("La población '" + idpoblacion + "' no se encontró.");
//	                        transaction.rollback();
//	                        return resultado;
//	                    }
//	                }
//
//	                clienteEntity.setActivo(Integer.parseInt(activo));
//
//	                session.update(clienteEntity);
//
//	                resultado = 1; 
//	            } else {
//	                System.out.println("El cliente con ID '" + id + "' no se encontró.");
//	            }
//
//	            transaction.commit();
//	        } catch (Exception e) {
//	            if (transaction != null) {
//	                transaction.rollback();
//	            }
//	            e.printStackTrace();
//	        }
//
//	        return resultado;
		return null;

	}

	@Override
	public Integer borrarClientes(String id) throws ClassNotFoundException, SQLException, NamingException {

//	        Integer resultado = 0;
//	        Transaction transaction = null;
//
//	        try (Session session = sessionFactory.openSession()) {
//	            transaction = session.beginTransaction();
//
//	            int clienteId = Integer.parseInt(id);
//	            ClienteEntity clienteEntity = session.get(ClienteEntity.class, clienteId);
//
//	            if (clienteEntity != null) {
//	                clienteEntity.setActivo(0);
//
//	                session.update(clienteEntity);
//
//	                resultado = 1; 
//	            } else {
//	                System.out.println("El cliente con ID '" + id + "' no se encontró.");
//	            }
//
//	            transaction.commit();
//	        } catch (Exception e) {
//	            if (transaction != null) {
//	                transaction.rollback();
//	            }
//	            e.printStackTrace();
//	        }
//
//	        return resultado;
//	    }
		return null;
	}

}
