package com.gon.tienda.controllers;

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

import com.gon.tienda.dao.ICombosDAO;
import com.gon.tienda.dtos.CategoriaDTO;
import com.gon.tienda.dtos.ComboDTO;
import com.gon.tienda.dtos.ProductoDTO;
import com.gon.tienda.negocio.IProductosService;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	IProductosService productosServicios;
	@Autowired
	ICombosDAO comboDAO;
	
	@GetMapping("listarproducto")
	
	public String getListadoProductos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
		
		return "vistaProductos/listadoProductos";
	}
	
	@PostMapping("listarproducto")
	public String buscarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria ,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException  {
		
		
		List<ProductoDTO>  listaProductos = productosServicios.buscarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
		
		model.addAttribute("lista", listaProductos);
		
		return "vistaProductos/listadoProductos";
	}
	
	@GetMapping("insertarproducto")
	public String getFormularioInsertarProducto(ModelMap model) throws ClassNotFoundException, SQLException {
		
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
		
		return "vistaProductos/insertadoProductos";
	}
	
	@PostMapping("insertarproducto")
	public String insertarProductos(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria ,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException{
		
		precio = (precio == "") ? "0" : precio;
		cantidadStock = (cantidadStock == "") ? "0" : cantidadStock;
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
		
		Integer resultado = productosServicios.insertarProductos(nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		model.addAttribute("resultado", resultado);	
		
		return "vistaProductos/insertadoProductos";
	}
	
	@GetMapping("formularioactualizarproductos")
	public String getFormularioActualizarProducto(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException  {
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
		
		return "vistaProductos/actualizadoProductos";
	}
	
	@PostMapping("formularioactualizarproductos")
	public String getFormulariosActualizarProducto(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria ,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException {
				
		List<ProductoDTO>  listaProductos = productosServicios.buscarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
	
		model.addAttribute("lista", listaProductos);
		
		return "vistaProductos/actualizadoProductos";
	}
	
	@PostMapping("actualizarproductos")
	public String actualizarProductoss(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, @RequestParam("precio") String precio,
			@RequestParam("cantidadStock") String cantidadStock, @RequestParam("idCategoria") String idCategoria ,
			@RequestParam("idProveedor") String idProveedor, ModelMap model)
			throws ClassNotFoundException, SQLException{
		
		precio = (precio == "") ? "0" : precio;
		cantidadStock = (cantidadStock == "") ? "0" : cantidadStock;
		
		List<ComboDTO> listaCategoria = comboDAO.recuperaComboCategorias();

		List<ComboDTO> listaProveedores = comboDAO.recuperaComboProveedores();

		model.addAttribute("comboCategorias", listaCategoria);
		model.addAttribute("comboProveedores", listaProveedores);
		
		productosServicios.actualizarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		
		return "vistaProductos/actualizadoProductos";
	}
	
}
