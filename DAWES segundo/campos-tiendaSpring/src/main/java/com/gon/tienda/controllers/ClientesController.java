package com.gon.tienda.controllers;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gon.tienda.dao.ICombosDAO;
import com.gon.tienda.dtos.ClienteDTO;
import com.gon.tienda.dtos.ComboDTO;
import com.gon.tienda.negocio.IClientesService;


@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	IClientesService clientesService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarcliente")
	public String getListadoCliente(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		return "vistaClientes/listadoClientes";
	}

	@PostMapping("listarcliente")
	public String buscarCliente(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaCliente = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		model.addAttribute("lista", listaCliente);

		return "vistaClientes/listadoClientes";
	}

	@GetMapping("insertarcliente")
	public String getFormularioInsertarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		return "vistaClientes/insertadoClientes";

	}

	@PostMapping("insertarcliente")
	public String insertarCliente(@RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		Integer resultado = clientesService.insertarClientes(nombre, correo, idPoblacion, activo);

		model.addAttribute("resultado", resultado);

		return "vistaClientes/insertadoClientes";

	}
	
	@GetMapping("formularioactualizarcliente")
	public String getFormularioActualizarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		return "vistaClientes/actualizadoClientes";

	}
	
	@PostMapping("formularioactualizarcliente")
	public String getFormularioActualizarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaCliente = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		model.addAttribute("lista", listaCliente);

		return "vistaClientes/actualizadoClientes";
	}
	
	@PostMapping("actualizarcliente")
	public String actualizarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		
		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		clientesService.actualizarClientes(id, nombre, correo, idPoblacion, activo);

		return "vistaClientes/actualizadoClientes";
	}
	
	@GetMapping("formularioborrarcliente")
	public String getFormularioBorrarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);

		return "vistaClientes/borradoClientes";

	}
	
	@PostMapping("formularioborrarcliente")
	public String borrarCliente(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam(value = "correo", required = false) String correo,
			@RequestParam("idPoblacion") String idPoblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaCliente = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);

		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		model.addAttribute("lista", listaCliente);

		return "vistaClientes/borradoClientes";
	}
	
	@PostMapping("borrarclientes")
	public String borrarCliente(@RequestParam("id") String id, ModelMap model) throws ClassNotFoundException, SQLException {
		
		List<ComboDTO> listaClientes = combosDAO.recuperaComboMunicipios();

		model.addAttribute("comboMunicipio", listaClientes);
		
		clientesService.borrarClientes(id);
		
		return "vistaClientes/borradoClientes";
	}


}
