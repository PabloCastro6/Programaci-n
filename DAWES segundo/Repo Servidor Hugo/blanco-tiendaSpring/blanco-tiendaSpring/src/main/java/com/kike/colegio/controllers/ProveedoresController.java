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
import com.kike.colegio.dtos.ProvedoresDTO;
import com.kike.colegio.negocio.IProveedoresService;

@Controller
@RequestMapping("/proveedores/")
public class ProveedoresController {

	@Autowired
	IProveedoresService proveedoresService;
	@Autowired
	ICombosDAO combosDAO;

	@GetMapping("listarproveedores")
	public String getListadoProveedores() {
		return "listadoProveedores";
	}

	@PostMapping("listarproveedores")
	public String buscarProveedores(@RequestParam("nombre") String nombre, @RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";
		String id = "";
		List<ProvedoresDTO> listaProveedores = proveedoresService.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);

		model.addAttribute("lista", listaProveedores);

		return "listadoProveedores";
	}

	@GetMapping("insertarproveedores")
	public String insertarProveedores() {
		return "insertarProveedores";
	}

	@PostMapping("insertarproveedores")
	public String insertarProveedores(@RequestParam("nombre") String nombre, @RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		Integer resultado = proveedoresService.insertarProveedor(nombre, contacto, telefono, correo, direccion, activo);
		model.addAttribute("resultado", resultado);

		return "insertarProveedores";
	}

	@GetMapping("formularioactualizarproveedores")
	public String getFormularioActualizarProveedores() {
		return "actualizarProveedores";
	}

	@PostMapping("formularioactualizarproveedor")
	public String getFormulariosActualizarProveedores(@RequestParam("id") String id,
			@RequestParam("nombre") String nombre, @RequestParam("contacto") String contacto,
			@RequestParam("telefono") String telefono, @RequestParam("correo") String correo,
			@RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ProvedoresDTO> listaProveedores = proveedoresService.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);
		model.addAttribute("lista", listaProveedores);

		return "actualizarProveedores";
	}

	@PostMapping("actualizarproveedor")
	public String actualizarProveedor(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		proveedoresService.actualizarProveedor(id, nombre, contacto, telefono, correo, direccion, activo);

		return "actualizarProveedores";
	}

	@GetMapping("formularioborrarproveedores")
	public String formularioBorrarProveedores() {
		return "borrarProveedores";
	}

	@PostMapping("formularioborrarproveedores")
	public String getFormulariosBorrarProveedores(@RequestParam("id") String id, @RequestParam("nombre") String nombre,
			@RequestParam("contacto") String contacto, @RequestParam("telefono") String telefono,
			@RequestParam("correo") String correo, @RequestParam("direccion") String direccion,
			@RequestParam(value = "activo", required = false) String activo, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {

		activo = (activo != null) ? "1" : "0";

		List<ProvedoresDTO> listaProveedores = proveedoresService.buscarProveedores(id, nombre, contacto, telefono,
				correo, direccion, activo);
		model.addAttribute("lista", listaProveedores);

		return "borrarProveedores";
	}

	@PostMapping("borrarproveedores")
	public String borrarProveedores(@RequestParam("idProv") String id, ModelMap model)
			throws ClassNotFoundException, SQLException, NamingException {
		Integer resultado = proveedoresService.borrarProveedor(id);
		model.addAttribute("resultado", resultado);

		return "borrarProveedores";
	}

}
