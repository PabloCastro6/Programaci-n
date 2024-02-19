package com.kike.colegio.springDataJPA;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.entities.CategoriaEntity;
import com.kike.colegio.entities.ProveedorEntity;
import com.kike.colegio.repositories.CategoriasRepository;
import com.kike.colegio.repositories.ProveedoresRepository;

public class CombosDAOImplSpringDataJPA implements ICombosDAO {

	ProveedoresRepository proveedoresRepository;
	CategoriasRepository categoriasRepository;

	@Override
	public List<ComboDTO> recuperaComboProveedores() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<ProveedorEntity> lista = proveedoresRepository.findAll();
		return combosProveedor(lista);
	}

	private List<ComboDTO> combosProveedor(Iterable<ProveedorEntity> lista) {
		List<ComboDTO> combo = new ArrayList<>();
		for (ProveedorEntity c : lista) {
			combo.add(new ComboDTO(c.getId(), c.getNombre()));
		}
		return combo;
	}

	@Override
	public List<ComboDTO> recuperaComboCategorias() throws ClassNotFoundException, SQLException, NamingException {
		Iterable<CategoriaEntity> lista = categoriasRepository.findAll();
		return combosCategorias(lista);
	}

	private List<ComboDTO> combosCategorias(Iterable<CategoriaEntity> lista) {
		List<ComboDTO> combo = new ArrayList<>();
		for (CategoriaEntity c : lista) {
			combo.add(new ComboDTO(c.getId(), c.getNombre()));
		}
		return combo;
	}

	@Override
	public List<ComboDTO> recuperaComboPoblacion() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperaComboClientes() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperaComboProductos() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComboDTO> recuperaComboEstados() throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
