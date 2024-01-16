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

import com.paula.tienda.dtos.CategoriaDTO;
import com.paula.tienda.negocio.ICategoriasService;

@Controller
@RequestMapping("/categorias/")
public class CategoriasController {

	@Autowired
	ICategoriasService categoriasService;

	@GetMapping("listarcategorias")

	public String getListadoCategorias() {
		return "listadoCategorias";
	}

	@PostMapping("listarcategorias")
	public String buscarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CategoriaDTO> listaCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);

		model.addAttribute("lista", listaCategorias);

		return "listadoCategorias";
	}

	@GetMapping("insertarcategorias")
	public String getFormularioInsertarCategoria(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "insertarCategorias";
	}

	@PostMapping("insertarcategorias")
	public String insertarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		Integer resultado = categoriasService.insertarCategorias(id, nombre, descripcion, activo);

		model.addAttribute("resultado", resultado);

		return "insertarCategorias";
	}

	@GetMapping("formularioactualizarcategoria")

	public String getFormularioActualizarCategoria(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "actualizarCategorias";
	}

	@PostMapping("formularioactualizarcategoria")
	public String getFormularioActualizarCategorias(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		List<CategoriaDTO> listaCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);

		model.addAttribute("lista", listaCategorias);

		return "actualizarCategorias";
	}

	@PostMapping("actualizarcategoria")
	public String actualizarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
	
		activo = (activo != null) ? "1" : "0";
		categoriasService.actualizarCategorias(id, nombre, descripcion, activo);
		
		return "actualizarCategorias";
		
	}
	@GetMapping("formularioborrarcategoria")

	public String getFormularioBorrarCategoria(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "borrarCategorias";
	}
	@PostMapping("formularioborrarcategoria")
	public String getFormularioBorrarCategorias(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
	
		activo = (activo != null) ? "1" : "0";
		List<CategoriaDTO> listaCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);

		model.addAttribute("lista", listaCategorias);

		return "borrarCategorias";
	}
	@PostMapping("borrarcategoria")
	public String borrarCategoria(@RequestParam("id") String id)
			throws ClassNotFoundException, SQLException, NamingException {

		categoriasService.borrarCategorias(id);

		return "borrarCategorias";
	}
	}
	

