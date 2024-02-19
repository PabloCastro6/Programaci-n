package com.kike.colegio.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dao.jdbcimpl.CombosDAOImpl;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.negocio.ICategoriasService;
import com.kike.colegio.negocio.impl.ProductosService;

import jakarta.servlet.RequestDispatcher;

@Controller
@RequestMapping("/productos/")
public class ProductosController {
	@Autowired
	ProductosService productosService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarproductos")
	public String getListadoCategorias(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaProveedores = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaProveedores = combosProveedores.recuperaComboProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProveedor", listaProveedores);
		List<ComboDTO> listaCategorias = new ArrayList<>();
		ICombosDAO combosCategorias = new CombosDAOImpl();
		try {
			listaCategorias = combosCategorias.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCategoria", listaCategorias);
		return "listarProductos";
	}

	@PostMapping("listarproductos")
	public String buscarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidad") String cantidad, @RequestParam("categoria") String categorias,
			@RequestParam("proveedor") String proveedores, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ProductosDTO> listaProductos = productosService.buscarProductos(id, nombre, descripcion, precio, cantidad,
				categorias, proveedores);

		model.addAttribute("lista", listaProductos);

		return "listarProductos";

	}

	@GetMapping("insertarproductos")
	public String insertarCategorias(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaProveedores = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaProveedores = combosProveedores.recuperaComboProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProveedor", listaProveedores);
		List<ComboDTO> listaCategorias = new ArrayList<>();
		ICombosDAO combosCategorias = new CombosDAOImpl();
		try {
			listaCategorias = combosCategorias.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCategoria", listaCategorias);
		return "insertarProductos";
	}

	@PostMapping("insertarproductos")
	public String insertarCategorias(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidad") String cantidad, @RequestParam("categoria") String categorias,
			@RequestParam("proveedor") String proveedores, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		Integer resultado = productosService.insertarProductos(nombre, descripcion, precio, cantidad, categorias,
				proveedores);
		model.addAttribute("resultado", resultado);

		return "insertarProductos";
	}

	@GetMapping("formularioactualizarproductos")
	public String getFormularioActualizarCategorias(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaProveedores = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaProveedores = combosProveedores.recuperaComboProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProveedor", listaProveedores);
		List<ComboDTO> listaCategorias = new ArrayList<>();
		ICombosDAO combosCategorias = new CombosDAOImpl();
		try {
			listaCategorias = combosCategorias.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCategoria", listaCategorias);
		return "actualizarProductos";
	}

	@PostMapping("formularioactualizarproductos")
	public String getFormulariosActualizarCategorias(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("precio") String precio, @RequestParam("cantidad") String cantidad,
			@RequestParam("categoria") String categorias, @RequestParam("proveedor") String proveedores, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaProveedores = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaProveedores = combosProveedores.recuperaComboProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProveedor", listaProveedores);
		List<ComboDTO> listCategorias = new ArrayList<>();
		ICombosDAO combosCategorias = new CombosDAOImpl();
		try {
			listCategorias = combosCategorias.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCategoria", listCategorias);
		List<ProductosDTO> listaCategorias = productosService.buscarProductos(id, nombre, descripcion, precio, cantidad,
				categorias, proveedores);
		model.addAttribute("lista", listaCategorias);

		return "actualizarProductos";
	}

	@GetMapping("actualizarproductos")
	public String getoActualizarCategorias(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaProveedores = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaProveedores = combosProveedores.recuperaComboProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProveedor", listaProveedores);
		List<ComboDTO> listaCategorias = new ArrayList<>();
		ICombosDAO combosCategorias = new CombosDAOImpl();
		try {
			listaCategorias = combosCategorias.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCategoria", listaCategorias);
		return "actualizarProductos";
	}

	@PostMapping("actualizarproductos")
	public String actualizarProductos(@RequestParam("ids") String id, @RequestParam("nombres") String nombre,
			@RequestParam("descripciones") String descripcion, @RequestParam("precios") String precio,
			@RequestParam("cantidades") String cantidad, @RequestParam("categorias") String categorias,
			@RequestParam("proveedores") String proveedores, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaProveedores = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaProveedores = combosProveedores.recuperaComboProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProveedor", listaProveedores);
		List<ComboDTO> listaCategorias = new ArrayList<>();
		ICombosDAO combosCategorias = new CombosDAOImpl();
		try {
			listaCategorias = combosCategorias.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCategoria", listaCategorias);

		productosService.actualizarProductos(id, nombre, descripcion, precio, cantidad, categorias, proveedores);

		return "actualizarProductos";
	}

}
