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
import com.paula.tienda.dtos.ClienteDTO;
import com.paula.tienda.dtos.CombosDTO;
import com.paula.tienda.negocio.IClientesService;

@Controller
@RequestMapping("/clientes/")
public class ClientesController {

	@Autowired
	IClientesService clientesService;

	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarclientes")

	public String getListadoProductos(ModelMap model) {

		List<CombosDTO> listaPoblaciones = null;

		try {
			listaPoblaciones = combosDAO.recuperarCombosPoblaciones();
		} catch (ClassNotFoundException | SQLException | NamingException e) {

			e.printStackTrace();
		}

		model.addAttribute("combosPoblaciones", listaPoblaciones);

		return "/clientes/listadoClientes";
	}

	@PostMapping("listarclientes")

	public String buscarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblaciones") String poblaciones,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ClienteDTO> listaClientes = clientesService.buscarClientes(id, nombre, correo, poblaciones, activo);
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();

		model.addAttribute("combosPoblaciones", listaPoblaciones);
		model.addAttribute("lista", listaClientes);

		return "/clientes/listadoClientes";
	}

	@GetMapping("insertarclientes")
	public String getFormularioInsertarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();

		model.addAttribute("combosPoblaciones", listaPoblaciones);
		
		return "/clientes/insertarClientes";
		
	}
	
	@PostMapping("insertarclientes")
	public String insertarClientes(@RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblaciones") String poblaciones,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		
		activo = (activo != null) ? "1" : "0";
		
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();
		Integer resultado = clientesService.insertarClientes(nombre, correo, poblaciones, activo);
		
		model.addAttribute("combosPoblaciones", listaPoblaciones);
		model.addAttribute("resultado", resultado);
		
		return "/clientes/insertarClientes";
	}
	
	@GetMapping("formularioactualizarcliente")
	public String getFormularioActualizarCliente(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
	
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();

		model.addAttribute("combosPoblaciones", listaPoblaciones);
		
		return "/clientes/actualizarClientes";
	}
	
	@PostMapping("formularioactualizarcliente")
	public String getFormularioActualizarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblaciones") String poblaciones,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		
		List<ClienteDTO> listaClientes = clientesService.buscarClientes(id, nombre, correo, poblaciones, activo);
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();
		
		model.addAttribute("combosPoblaciones", listaPoblaciones);
		model.addAttribute("lista", listaClientes);
		return "/clientes/actualizarClientes";
	}
	@PostMapping("actualizarcliente")
	public String actualizarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblaciones") String poblaciones,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();
		
		model.addAttribute("combosPoblaciones", listaPoblaciones);
		
		clientesService.actualizarClientes(id, nombre, correo, poblaciones, activo);
		
		return "/clientes/actualizarClientes";
	}
	
	@GetMapping("formularioborrarcliente")
	
	public String getFormularioBorrarCliente(ModelMap model)throws ClassNotFoundException, SQLException, NamingException {
		
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();
		
		model.addAttribute("combosPoblaciones", listaPoblaciones);
		
		return "/clientes/borrarClientes";
	}
	
	@PostMapping("formularioborrarcliente")
	public String getFormularioBorrarClientes(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo, @RequestParam("poblaciones") String poblaciones,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		activo = (activo != null) ? "1" : "0";
		
		List<ClienteDTO> listaClientes = clientesService.buscarClientes(id, nombre, correo, poblaciones, activo);
		List<CombosDTO> listaPoblaciones = combosDAO.recuperarCombosPoblaciones();
		
		model.addAttribute("combosPoblaciones", listaPoblaciones);
		model.addAttribute("lista", listaClientes);
		return "/clientes/borrarClientes";
	}
	
	@PostMapping("borrarcliente")
	public String borrarCliente(@RequestParam("id") String id)
			throws ClassNotFoundException, SQLException, NamingException {

		clientesService.borrarClientes(id);
		
		return "/clientes/borrarClientes";
	}
}
