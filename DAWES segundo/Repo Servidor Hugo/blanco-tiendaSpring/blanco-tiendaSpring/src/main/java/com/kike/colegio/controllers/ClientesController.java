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
import com.kike.colegio.dtos.ClientesDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.dtos.ProductosDTO;
import com.kike.colegio.negocio.impl.ClientesService;
import com.kike.colegio.negocio.impl.ProductosService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/clientes/")
public class ClientesController {
	@Autowired
	ClientesService clientesService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarclientes")
	public String getListadoClientes(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		return "listadoClientes";
	}

	@PostMapping("listarclientes")
	public String buscarProductos(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam(value = "poblacion", required = false) String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		List<ClientesDTO> listaClientes = clientesService.buscarClientes(id, nombre, correo, poblacion, activo);

		model.addAttribute("lista", listaClientes);

		return "listadoClientes";

	}

	@GetMapping("insertarclientes")
	public String insertarCategorias(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		return "insertarClientes";
	}

	@PostMapping("insertarclientes")
	public String insertarCategorias(HttpServletRequest request, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);

		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String poblacion = request.getParameter("idPoblacion");
		String activo = request.getParameter("activo");
		activo = (activo != null) ? "1" : "0";

		Integer resultado = clientesService.insertarClientes(nombre, correo, poblacion, activo);
		model.addAttribute("resultado", resultado);

		return "insertarClientes";
	}

	@GetMapping("formularioactualizarclientes")
	public String getFormularioActualizarCategorias(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		return "actualizarClientes";
	}

	@PostMapping("formularioactualizarclientes")
	public String getFormulariosActualizarCategorias(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("correo") String correo,
			@RequestParam(value = "poblacion", required = false) String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		activo = (activo != null) ? "1" : "0";

		List<ClientesDTO> listaClientes = clientesService.buscarClientes(id, nombre, correo, poblacion, activo);

		model.addAttribute("lista", listaClientes);
		return "actualizarClientes";
	}

	@GetMapping("actualizarclientes")
	public String getoActualizarClientes(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		return "actualizarClientes";
	}

	@PostMapping("actualizarclientes")
	public String actualizarProductos(@RequestParam("idClien") String id, @RequestParam("name") String nombre,
			@RequestParam("correoElec") String correo,
			@RequestParam(value = "idPoblac", required = false) String poblacion,
			@RequestParam(value = "activ", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		activo = (activo != null) ? "1" : "0";

		clientesService.actualizarClientes(id, nombre, correo, poblacion, activo);

		return "actualizarClientes";
	}

	@GetMapping("formularioborrarclientes")
	public String formularioBorrarCategorias(ModelMap model) {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		return "borrarClientes";

	}

	@PostMapping("formularioborrarclientes")
	public String getFormulariosBorrarCategorias(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("correo") String correo,
			@RequestParam(value = "poblacion", required = false) String poblacion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		activo = (activo != null) ? "1" : "0";

		model.addAttribute("comboPoblacion", listaPoblacion);

		activo = (activo != null) ? "1" : "0";

		List<ClientesDTO> listaCategorias = clientesService.buscarClientes(id, nombre, correo, poblacion, activo);
		model.addAttribute("lista", listaCategorias);

		return "borrarClientes";
	}

	@PostMapping("borrarclientes")
	public String borrarCategorias(@RequestParam("idClien") String id, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaPoblacion = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaPoblacion = combosProveedores.recuperaComboPoblacion();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboPoblacion", listaPoblacion);
		clientesService.borrarClientes(id);

		return "borrarClientes";
	}

}
