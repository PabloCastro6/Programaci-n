package com.gon.tienda.controllers;


import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gon.tienda.dtos.CategoriaDTO;
import com.gon.tienda.negocio.ICategoriasService;


@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	ICategoriasService categoriasServicios;
	
	@GetMapping("listarcategoria")
	
	public String getListadoCategorias() {
		
		return "listadoCategorias";
	}
	
	@PostMapping("listarcategoria")
	public String buscarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
								@RequestParam("descripcion") String descripcion, @RequestParam(value="activo", required=false) String activo, ModelMap model)
								throws ClassNotFoundException, SQLException {
		
		activo = (activo != null)? "1":"0";
		
		List<CategoriaDTO>  listaCategorias = categoriasServicios.buscarCategorias(id, nombre, descripcion, activo);
		
		model.addAttribute("lista", listaCategorias);
		
		return "listadoCategorias";
	}
	
	@GetMapping("insertarcategoria")
	public String getFormularioInsertarCategoria(ModelMap model) throws ClassNotFoundException, SQLException {
		
		
		return "insertarCategorias";
	}
	
	@PostMapping("insertarcategoria")
	public String insertarCategoria(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value="activo", required=false) String activo, ModelMap model) throws ClassNotFoundException, SQLException {
		
		activo = (activo != null)? "1":"0";
		
		Integer resultado = categoriasServicios.insertarCategorias(nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);	
		
		return "insertarCategorias";
	}
	
	@GetMapping("formularioactualizarcategorias")
	public String getFormularioActualizarCategoria() {
		
		return "actualizarCategorias";
	}
	
	@PostMapping("formularioactualizarcategorias")
	public String getFormulariosActualizarCategoria(@RequestParam("id") String id, @RequestParam("nombre") String nombre, 
			@RequestParam("descripcion") String descripcion, @RequestParam(value="activo", required=false) String activo, ModelMap model) throws ClassNotFoundException, SQLException {
		
		activo = (activo != null)? "1":"0";
				
		List<CategoriaDTO>  listaCategorias = categoriasServicios.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("lista", listaCategorias);
		
		return "actualizarCategorias";
	}
	
	@PostMapping("actualizarcategorias")
	public String actualizarCategoria(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value="activo", required=false) String activo, ModelMap model) throws ClassNotFoundException, SQLException{
		
		activo = (activo != null)? "1":"0";
		
		categoriasServicios.actualizarCategorias(id, nombre, descripcion, activo);
		
		return "actualizarCategorias";
	}
	
	@GetMapping("formularioborrarcategorias")
	public String getFormularioBorrarCategoria() {
		
		return "borrarCategorias";
	}
	
	@PostMapping("formularioborrarcategorias")
	public String formularioBorrarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value="activo", required=false) String activo, ModelMap model) throws ClassNotFoundException, SQLException {
		
		activo = (activo != null)? "1":"0";
		
		List<CategoriaDTO>  listaCategorias = categoriasServicios.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("lista", listaCategorias);
		
		return "borrarCategorias";
	}
	
	@PostMapping("borrarcategorias")
	public String borrarCategoria(@RequestParam("id") String id) throws ClassNotFoundException, SQLException {
		categoriasServicios.borrarCategorias(id);
		
		return "borrarCategorias";
	}

}
