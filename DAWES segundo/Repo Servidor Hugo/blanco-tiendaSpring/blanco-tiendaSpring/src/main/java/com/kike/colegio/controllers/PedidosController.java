package com.kike.colegio.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kike.colegio.dao.ICombosDAO;
import com.kike.colegio.dao.jdbcimpl.CombosDAOImpl;
import com.kike.colegio.dtos.ClienteProductoDTO;
import com.kike.colegio.dtos.ComboDTO;
import com.kike.colegio.dtos.ItemDTO;
import com.kike.colegio.dtos.PedidosDTO;
import com.kike.colegio.negocio.impl.PedidosService;

@Controller
@RequestMapping("/pedidos/")
public class PedidosController {
	@Autowired
	PedidosService pedidosService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarpedidos")
	public String getListadoPedidos(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);
		return "listarPedidos";
	}

	@PostMapping("listarpedidos")
	public String buscarProductos(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "estado", required = false) String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);
		List<PedidosDTO> listaPedidos = pedidosService.buscarPedidos(id, cliente, fecha, estado);

		model.addAttribute("lista", listaPedidos);

		return "listarPedidos";

	}

	@GetMapping("insertarpedidos")
	public String insertarCategorias(ModelMap model) throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaProductos = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaProductos = combosEstados.recuperaComboProductos();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaProductos);
		return "insertarPedidos";
	}

	@PostMapping("insertarpedidos")
	public String insertarCategorias(@RequestParam("id") String id, @RequestParam("producto") String idProducto,
			@RequestParam("cliente") String cliente, @RequestParam("cantidad") String cantidad,
			@RequestParam("precio") String precio, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);
		Integer resultado = pedidosService.insertarPedidos(cliente, idProducto, cantidad, precio);
		model.addAttribute("resultado", resultado);

		return "insertarPedidos";
	}

	@GetMapping("formularioactualizarpedidos")
	public String getFormularioActualizarPedidos(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);
		return "actualizarPedidos";
	}

	@PostMapping("formularioactualizarpedidos")
	public String getFormulariosActualizarPedidos(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "fecha", required = false) String fecha,
			@RequestParam(value = "estado", required = false) String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);
		List<PedidosDTO> listaCategorias = pedidosService.buscarPedidos(id, cliente, fecha, estado);
		model.addAttribute("lista", listaCategorias);

		return "actualizarPedidos";
	}

	@GetMapping("actualizarpedidos")
	public String getoActualizarCategorias(ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);
		return "actualizarPedidos";
	}

	@PostMapping("actualizarpedidos")
	public String actualizarPedidos(@RequestParam(value = "idPedido", required = false) String id,
			@RequestParam(value = "idcliente", required = false) String cliente,
			@RequestParam(value = "fechaDesde", required = false) String fecha,
			@RequestParam(value = "estad", required = false) String estado, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		List<ComboDTO> listaClientes = new ArrayList<>();
		ICombosDAO combosProveedores = new CombosDAOImpl();
		try {
			listaClientes = combosProveedores.recuperaComboClientes();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboClientes", listaClientes);
		List<ComboDTO> listaEstados = new ArrayList<>();
		ICombosDAO combosEstados = new CombosDAOImpl();
		try {
			listaEstados = combosEstados.recuperaComboEstados();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("comboEstados", listaEstados);

		pedidosService.actualizarPedidos(id, cliente, fecha, estado);

		return "actualizarPedidos";
	}

	@PostMapping("/calculaprecio")
	public @ResponseBody Double calcularPrecio(ModelMap model, @RequestBody ClienteProductoDTO clienteProductoDTO)
			throws ClassNotFoundException {
		Integer idCliente = clienteProductoDTO.getCliente();
		Integer idProducto = clienteProductoDTO.getProducto();

		Double comprasAcumuladas = pedidosService.obtenerComprasAcumuladasCliente(idCliente);

		Double descuento = pedidosService.obtenerDescuentoPorCompras(comprasAcumuladas);

		Double precioFinal = pedidosService.calcularPrecio(idProducto, descuento);
		return precioFinal;
	}

	@PostMapping("/dopedido")
	public ResponseEntity<String> crearPedido(ModelMap model, @RequestBody List<ItemDTO> carrito)
			throws ClassNotFoundException, SQLException, NamingException {
		for (ItemDTO i : carrito) {
			pedidosService.insertarPedidos(i.getClienteID(), i.getProductoID(), i.getCantidad(), i.getPrecio());
		}
		return ResponseEntity.ok("Venta realizada con exito");
	}

}
