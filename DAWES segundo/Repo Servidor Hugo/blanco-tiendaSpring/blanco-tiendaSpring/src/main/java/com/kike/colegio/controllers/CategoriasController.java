package com.kike.colegio.controllers;

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

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dtos.CategoriaDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.negocio.ICategoriasService;

@Controller
@RequestMapping("/categorias/")
public class CategoriasController {

	@Autowired
	ICategoriasService categoriasService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarCategorias")
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
	public String insertarCategorias() {
		return "insertarCategorias";
	}

	@PostMapping("insertarCategorias")
	public String insertarCategorias(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		Integer resultado = categoriasService.insertarCategorias(nombre, descripcion, activo);
		model.addAttribute("resultado", resultado);

		return "insertarCategorias";
	}

	@GetMapping("formularioactualizarcategorias")
	public String getFormularioActualizarCategorias() {
		return "actualizarCategorias";
	}

	@PostMapping("formularioactualizarcategoria")
	public String getFormulariosActualizarCategorias(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CategoriaDTO> listaCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("lista", listaCategorias);

		return "actualizarCategorias";
	}

	@PostMapping("actualizarcategoria")
	public String actualizarCaracteristicas(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		categoriasService.actualizarCategorias(id, nombre, descripcion, activo);

		return "actualizarCategorias";
	}

	@GetMapping("formularioborrarcategorias")
	public String formularioBorrarCategorias() {
		return "borrarCategorias";

	}

	@PostMapping("formularioborrarcategoria")
	public String getFormulariosBorrarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<CategoriaDTO> listaCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);
		model.addAttribute("lista", listaCategorias);

		return "borrarCategorias";
	}

	@PostMapping("borrarcategoria")
	public String borrarCategorias(@RequestParam("id") String id)
			throws ClassNotFoundException, SQLException, NamingException {
		categoriasService.borrarCategorias(id);

		return "borrarCategorias";
	}

}
