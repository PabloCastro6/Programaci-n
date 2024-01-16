package com.paula.tienda.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paula.tienda.dao.ICombosDAO;
import com.paula.tienda.dtos.CombosDTO;
import com.paula.tienda.dtos.ProductoDTO;
import com.paula.tienda.negocio.IProductosService;

@Controller
@RequestMapping("/productos/")
public class ProductosController {

	@Autowired
	IProductosService productosService;
	
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarproductos")

	public String getListadoProductos(ModelMap model) {
		
		List<CombosDTO> listaCategorias = null;
		List<CombosDTO> listaProveedores = null;
		try {
			listaCategorias = combosDAO.recuperarCombosCategorias();
			listaProveedores = combosDAO.recuperarCombosProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		return "/productos/listadoProductos";
	}

	@PostMapping("listarproductos")
	public String buscarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "precio", required = false) String precio,
			@RequestParam(value = "cantidad", required = false) String cantidad,
			@RequestParam("categorias") String categorias, @RequestParam("proveedores") String proveedores,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		precio = (precio.equals("")) ? "0" : precio;
		cantidad = (cantidad.equals("")) ? "0" : cantidad;

		List<ProductoDTO> listaProductos = productosService.buscarProductos(id, nombre, descripcion, precio, cantidad, categorias, proveedores);
		List<CombosDTO> listaCategorias = combosDAO.recuperarCombosCategorias();
		List<CombosDTO> listaProveedores = combosDAO.recuperarCombosProveedores();
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		model.addAttribute("lista", listaProductos);

		return "/productos/listadoProductos";
	}
	
	@GetMapping("insertarproductos")
	public String getFormularioInsertarProducto(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		List<CombosDTO> listaCategorias = combosDAO.recuperarCombosCategorias();
		List<CombosDTO> listaProveedores = combosDAO.recuperarCombosProveedores();
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		return "/productos/insertarProductos";
	}
	
	@PostMapping("insertarproductos")
	public String insertarProductos(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "precio", required = false) String precio,
			@RequestParam(value = "cantidad", required = false) String cantidad,
			@RequestParam("categorias") String categorias, @RequestParam("proveedores") String proveedores,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
	
		
		precio = (precio.equals("")) ? "0" : precio;
		cantidad = (cantidad.equals("")) ? "0" : cantidad;
		
		List<CombosDTO> listaCategorias = combosDAO.recuperarCombosCategorias();
		List<CombosDTO> listaProveedores = combosDAO.recuperarCombosProveedores();
		Integer resultado = productosService.insertarProductos(nombre, descripcion, precio, cantidad, categorias, proveedores);
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		model.addAttribute("resultado", resultado);

		return "/productos/insertarProductos";
		
	}
	
	@GetMapping("formularioactualizarproducto")

	public String getFormularioActualizarProducto(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listaCategorias = null;
		List<CombosDTO> listaProveedores = null;
		try {
			listaCategorias = combosDAO.recuperarCombosCategorias();
			listaProveedores = combosDAO.recuperarCombosProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		return "/productos/actualizarProductos";
	}
	
	@PostMapping("formularioactualizarproducto")
	public String  getFormularioActualizarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "precio", required = false) String precio,
			@RequestParam(value = "cantidad", required = false) String cantidad,
			@RequestParam("categorias") String categorias, @RequestParam("proveedores") String proveedores,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
				
		precio = (precio.equals("")) ? "0" : precio;
		cantidad = (cantidad.equals("")) ? "0" : cantidad;
		
		List<ProductoDTO> listaProductos = productosService.buscarProductos(id, nombre, descripcion, precio, cantidad, categorias, proveedores);
		List<CombosDTO> listaCategorias = combosDAO.recuperarCombosCategorias();
		List<CombosDTO> listaProveedores = combosDAO.recuperarCombosProveedores();
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		model.addAttribute("lista", listaProductos);

		return "/productos/actualizarProductos";
	}
	
	@PostMapping("actualizarproducto")
	public String  actualizarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "precio", required = false) String precio,
			@RequestParam(value = "cantidad", required = false) String cantidad,
			@RequestParam("categorias") String categorias, @RequestParam("proveedores") String proveedores,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		precio = (precio.equals("")) ? "0" : precio;
		cantidad = (cantidad.equals("")) ? "0" : cantidad;
		
		List<CombosDTO> listaCategorias = combosDAO.recuperarCombosCategorias();
		List<CombosDTO> listaProveedores = combosDAO.recuperarCombosProveedores();
		
		model.addAttribute("combosCategorias", listaCategorias);
		model.addAttribute("combosProveedores", listaProveedores);
		
		productosService.actualizarProductos(id, nombre, descripcion, precio, cantidad, categorias, proveedores);
		
		return "/productos/actualizarProductos";
		
	}	
}
