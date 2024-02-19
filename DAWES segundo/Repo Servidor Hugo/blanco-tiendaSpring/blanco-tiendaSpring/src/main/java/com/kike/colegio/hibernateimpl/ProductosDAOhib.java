package com.kike.colegio.hibernateimpl;

import java.math.BigDecimal;
import java.sql.SQLException;

import java.util.List;
import java.util.stream.Collectors;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProductosDAO;
import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.entities.CategoriaEntity;
import com.kike.colegio.entities.ProductoEntity;
import com.kike.colegio.entities.ProveedorEntity;
import com.kike.colegio.utils.DBUtils;

@Component("productosHIB")
public class ProductosDAOhib implements ProductosDAO {

	private static SessionFactory sessionFactory = DBUtils.creadorSessionFactory();

	@Override
	public List<ProductosDTO> obtenerTodosProductos() {
		return null;

	}

	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidad, String categoria, String proveedor)
			throws ClassNotFoundException, SQLException, NamingException {
		try (Session session = sessionFactory.openSession()) {
			Query<ProductoEntity> query = session.createQuery(
					"FROM ProductoEntity p WHERE "
							+ "str(p.id) LIKE :id AND p.nombre LIKE :nombre AND p.descripcion LIKE :descripcion "
							+ "AND str(p.precio) LIKE :precio AND str(p.cantidadEnStock) LIKE :cantidad "
							+ "AND p.categoria.nombre LIKE :categoria AND p.proveedor.nombre LIKE :proveedor",
					ProductoEntity.class);

			query.setParameter("id", "%" + id + "%");
			query.setParameter("nombre", "%" + nombre + "%");
			query.setParameter("descripcion", "%" + descripcion + "%");
			query.setParameter("precio", "%" + precio + "%");
			query.setParameter("cantidad", "%" + cantidad + "%");
			query.setParameter("categoria", "%" + categoria + "%");
			query.setParameter("proveedor", "%" + proveedor + "%");

			List<ProductoEntity> resultList = query.list();

			return resultList.stream()
					.map(entity -> new ProductosDTO(String.valueOf(entity.getId()), entity.getNombre(),
							entity.getDescripcion(), String.valueOf(entity.getPrecio()),
							String.valueOf(entity.getCantidadEnStock()), entity.getCategoria().getNombre(),
							entity.getProveedor().getNombre()))
					.collect(Collectors.toList());
		}
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidad,
			String idCategoria, String idProveedor) {
		try (Session session = sessionFactory.openSession()) {
			ProductoEntity producto = new ProductoEntity();
			producto.setNombre(nombre);
			producto.setDescripcion(descripcion);
			producto.setPrecio(new BigDecimal(precio));
			producto.setCantidadEnStock(Integer.parseInt(cantidad));

			producto.setCategoria(new CategoriaEntity(Integer.parseInt(idCategoria)));
			producto.setProveedor(new ProveedorEntity(Integer.parseInt(idProveedor)));

			Integer idProducto = (Integer) session.save(producto);

			return idProducto;
		}
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidad,
			String idCategoria, String idProveedor) {
		try (Session session = sessionFactory.openSession()) {
			ProductoEntity producto = session.get(ProductoEntity.class, Integer.parseInt(id));

			if (producto != null) {
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setPrecio(new BigDecimal(precio));
				producto.setCantidadEnStock(Integer.parseInt(cantidad));

				producto.setCategoria(new CategoriaEntity(Integer.parseInt(idCategoria)));
				producto.setProveedor(new ProveedorEntity(Integer.parseInt(idProveedor)));

				session.beginTransaction();
				session.update(producto);
				session.getTransaction().commit();

				return 1;
			} else {
				return 0;
			}
		}
	}
}
