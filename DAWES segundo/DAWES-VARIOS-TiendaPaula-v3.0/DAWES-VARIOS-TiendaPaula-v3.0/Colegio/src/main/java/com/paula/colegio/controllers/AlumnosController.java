package com.paula.colegio.controllers;

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

import com.paula.colegio.dao.ICombosDAO;
import com.paula.colegio.dtos.AlumnoDTO;
import com.paula.colegio.dtos.ComboDTO;
import com.paula.colegio.negocios.IAlumnosService;

@Controller
@RequestMapping("/alumnos/")
public class AlumnosController {

	@Autowired
	IAlumnosService alumnosService;

	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listaralumnos")

	public String getListadoAlumnos() {
		return "listadoAlumnos";
	}

	@PostMapping("listaralumnos")
	public String buscarAlumnos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		List<AlumnoDTO> listaAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, famNumerosa, activo);

		model.addAttribute("lista", listaAlumnos);

		return "listadoAlumnos";
	}

	@GetMapping("insertaralumnos")

	public String getFormularioInsertarAlumno(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaMunicipios = combosDAO.recuperarCombosMunicipio();

		model.addAttribute("comboMunicipios", listaMunicipios);

		return "insertarAlumnos";
	}

	@PostMapping("insertaralumnos")
	public String insertarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo,
			@RequestParam("municipios") String municipios, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaMunicipios = combosDAO.recuperarCombosMunicipio();

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		Integer resultado = alumnosService.insertarAlumnos(id, nombre, apellido, activo, famNumerosa, municipios);

		model.addAttribute("resultado", resultado);

		model.addAttribute("comboMunicipios", listaMunicipios);

		return "insertarAlumnos";
	}

	@GetMapping("formularioactualizaralumno")

	public String getFormularioActualizarAlumno(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "actualizarAlumnos";
	}

	@PostMapping("formularioactualizaralumno")
	public String getFormularioActualizarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaMunicipios = combosDAO.recuperarCombosMunicipio();
		List<AlumnoDTO> listaAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);

		model.addAttribute("comboMunicipios", listaMunicipios);
		model.addAttribute("lista", listaAlumnos);

		return "actualizarAlumnos";
	}

	@PostMapping("actualizaralumno")
	public String actualizarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo,
			@RequestParam("municipios") String municipios, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		
		alumnosService.actualizarAlumnos(id, nombre, apellido, activo, famNumerosa, municipios);

		return "actualizarAlumnos";
	}
	
	@GetMapping("formularioborraralumno")

	public String getFormularioBorrarAlumno(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		return "borrarAlumnos";
	}
	@PostMapping("formularioborraralumno")
	public String getFormularioBorrarAlumno(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam(value = "famNumerosa", required = false) String famNumerosa,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		famNumerosa = (famNumerosa != null) ? "1" : "0";
		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaMunicipios = combosDAO.recuperarCombosMunicipio();
		List<AlumnoDTO> listaAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);

		model.addAttribute("comboMunicipios", listaMunicipios);
		model.addAttribute("lista", listaAlumnos);

		return "borrarAlumnos";
	}
	
	@PostMapping("borraralumno")
	public String borrarAlumno(@RequestParam("id") String id)
			throws ClassNotFoundException, SQLException, NamingException {

		alumnosService.borrarAlumnos(id);

		return "borrarAlumnos";
	}


}
