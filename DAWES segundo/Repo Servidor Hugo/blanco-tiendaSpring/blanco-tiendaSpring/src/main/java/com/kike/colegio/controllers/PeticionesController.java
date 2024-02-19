package com.kike.colegio.controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.dtos.PeticionesDTO;
import com.kike.colegio.negocio.impl.PeticonesSercive;

@Controller
@RequestMapping("/peticiones/")
public class PeticionesController {
	@Autowired
	PeticonesSercive peticionesService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarpeticiones")
	public String getListadoPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		return "listadoPeticiones";
	}

	@PostMapping("listarpeticiones")
	public String buscarPeticiones(@RequestParam("id") String id,
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "producto", required = false) String producto,
			@RequestParam("cantidad") String cantidad, @RequestParam(value = "estado", required = false) String estado,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);

		if (fecha != null && !fecha.isEmpty()) {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate fechaConvertida = LocalDate.parse(fecha, dateFormatter);
			fecha = dateFormatter.format(fechaConvertida);
		}

		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(id, cliente, producto, cantidad,
				estado, fecha);

		model.addAttribute("lista", listaPeticiones);

		return "listadoPeticiones";

	}

	@GetMapping("insertarpeticiones")
	public String insertarPeticiones(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		return "insertarPeticiones";
	}

	@PostMapping("insertarpeticiones")
	public String insertarPeticiones(@RequestParam("cliente") String cliente, @RequestParam("producto") String producto,
			@RequestParam("cantidad") String cantidad, @RequestParam(value = "estado", required = false) String estado,
			ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		Integer resultado = peticionesService.insertarPeticiones(cliente, producto, cantidad, estado);
		model.addAttribute("resultado", resultado);

		return "insertarPeticiones";
	}

	@GetMapping("formularioactualizarpeticiones")
	public String getFormularioActualizarPeticiones(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		return "actualizarPeticiones";
	}

	@PostMapping("formularioactualizarpeticiones")
	public String getFormulariosActualizarPeticiones(@RequestParam("id") String id,
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "producto", required = false) String producto,
			@RequestParam("cantidad") String cantidad, @RequestParam(value = "estado", required = false) String estado,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		List<PeticionesDTO> listaPeticiones = peticionesService.buscarPeticiones(id, cliente, producto, cantidad,
				estado, fecha);

		model.addAttribute("lista", listaPeticiones);
		return "actualizarPeticiones";
	}

	@GetMapping("actualizarpeticiones")
	public String getoActualizarPeticiones(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		return "actualizarPeticiones";
	}

	@PostMapping("actualizarpeticiones")
	public String actualizarPeticiones(@RequestParam("id") String id,
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "producto", required = false) String producto,
			@RequestParam("cantidad") String cantidad, @RequestParam(value = "estado", required = false) String estado,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		peticionesService.actualizarPeticiones(id, cliente, producto, cantidad, estado, fecha);

		return "actualizarPeticiones";
	}

	@GetMapping("formularioborrarpeticiones")
	public String formularioBorrarPeticiones(ModelMap model) {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		return "borrarPeticiones";

	}

	@PostMapping("formularioborrarpeticiones")
	public String getFormulariosBorrarPeticiones(@RequestParam("id") String id,
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam("producto") String producto, @RequestParam("cantidad") String cantidad,
			@RequestParam(value = "estado", required = false) String estado,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);

		List<PeticionesDTO> listaCategorias = peticionesService.buscarPeticiones(id, cliente, producto, cantidad,
				estado, fecha);
		model.addAttribute("lista", listaCategorias);

		return "borrarPeticiones";
	}

	@PostMapping("borrarpeticiones")
	public String borrarPeticiones(@RequestParam("idClien") String id, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosClientes = new CombosDAOImpl();
		try {
			listaClientes = combosClientes.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboCliente", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosProductos = new CombosDAOImpl();
		try {
			listaProductos = combosProductos.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboProducto", listaProductos);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstado", listaEstados);
		peticionesService.borrarPeticiones(id);

		return "borrarPeticiones";
	}

}
