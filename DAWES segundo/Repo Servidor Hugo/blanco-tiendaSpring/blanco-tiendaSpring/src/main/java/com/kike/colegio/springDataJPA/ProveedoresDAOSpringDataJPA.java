package com.kike.colegio.springDataJPA;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.ProveedoresDAO;
import com.kike.colegio.dtos.ProvedoresDTO;
import com.kike.colegio.entities.ProveedorEntity;
import com.kike.colegio.repositories.ProveedoresRepository;

@Component("proveedoresJPA")

public class ProveedoresDAOSpringDataJPA implements ProveedoresDAO {

	@Autowired
	ProveedoresRepository proveedoresRepository;

	@Override
	public List<ProvedoresDTO> obtenerTodosProveedores() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProvedoresDTO> buscarProveedores(String id, String nombre, String contacto, String telefono,
			String correo, String direccion, String activo)
			throws ClassNotFoundException, SQLException, NamingException {
		return proveedoresRepository.buscarProveedores(nombre, contacto, telefono, correo, direccion, activo);

	}

	@Override
	public Integer insertarProveedor(String nombre, String contacto, String telefono, String correo, String direccion,
			String activo) throws ClassNotFoundException, SQLException, NamingException {
		ProveedorEntity proveedorEntity = new ProveedorEntity(nombre, contacto, telefono, correo, direccion, activo);
		proveedoresRepository.save(proveedorEntity);

		return proveedorEntity.getId();
	}

	@Override
	public Integer actualizarProveedor(String id, String nombre, String contacto, String telefono, String correo,
			String direccion, String activo) throws ClassNotFoundException, SQLException, NamingException {
		ProveedorEntity proveedorEntity = new ProveedorEntity(Integer.parseInt(id), nombre, contacto, telefono, correo,
				direccion, activo);
		proveedoresRepository.save(proveedorEntity);

		return proveedorEntity.getId();
	}

	@Override
	public Integer borrarProveedor(String id) throws ClassNotFoundException, SQLException, NamingException {
		ProveedorEntity proveedorEntity = proveedoresRepository.findById(Integer.parseInt(id)).get();
		proveedorEntity.setActivo("0");

		proveedoresRepository.save(proveedorEntity);

		return proveedorEntity.getId();
	}

}
