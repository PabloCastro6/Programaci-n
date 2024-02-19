package com.chuchi.tienda.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuchi.tienda.dtos.ProveedoresDTO;
import com.chuchi.tienda.entities.ProveedorEntity;
import com.chuchi.tienda.repositories.ProveedoresRepository;
import com.chuchi.tienda.services.IProveedoresService;

@RestController
@RequestMapping("/v1")
public class ProveedoresControllerRest {
	
	@Autowired
	IProveedoresService proveedoresService;
	
	@Autowired
	ProveedoresRepository proveedoresRepository;
	
	@GetMapping("/proveedores")
	public Iterable<ProveedorEntity> buscarTodosProveedores(){
		
		Iterable<ProveedorEntity> proveedores = proveedoresRepository.findAll();
		
		return proveedores;
	}
	
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<ProveedorEntity> obtenerProveedoresPorId(@PathVariable("id") Integer id){
		
		ProveedorEntity proveedor = proveedoresRepository.findById(id).get();
		
		return new ResponseEntity (proveedor, HttpStatus.OK);
	}
	
	@GetMapping(value = "/proveedores", params = {"id", "nombre", "contacto", "telefono", "correo", "direccion", "activo"})
	public ResponseEntity<ProveedorEntity> obtenerProveedoresConFiltros(@RequestParam (value = "id", required = false) Integer id,
																		@RequestParam (value = "nombre", required = false) String nombre,
																		@RequestParam (value = "contacto", required = false) String contacto,
																		@RequestParam (value = "telefono", required = false) String telefono,
																		@RequestParam (value = "correo", required = false) String correo,
																		@RequestParam (value = "direccion", required = false) String direccion,
																		@RequestParam (value = "activo", required = false) Integer activo){
		
		List<ProveedoresDTO> listaProveedores = proveedoresRepository.buscaProveedores(id.toString(), nombre, contacto, telefono, correo, direccion, activo);
		
		return new ResponseEntity(listaProveedores, HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("/proveedores")
	public ResponseEntity insertarProveedor (@RequestBody ProveedorEntity proveedor) throws ClassNotFoundException, SQLException {
		
		proveedoresService.insertarProveedores(proveedor.getNombre(), proveedor.getContacto(), proveedor.getTelefono(), proveedor.getCorreoElectronico(), proveedor.getDireccion(), proveedor.getActivo().toString());
		
		return ResponseEntity.ok("Proveedor insertado correctamente"); 
		
	}
	
	@PutMapping(value = "/proveedores", params = {"id", "nombre", "contacto", "telefono", "correo", "direccion", "activo"})
	public ResponseEntity actualizarProveedor(@RequestParam (value = "id", required = false) Integer id,
																@RequestParam (value = "nombre", required = false) String nombre,
																@RequestParam (value = "contacto", required = false) String contacto,
																@RequestParam (value = "telefono", required = false) String telefono,
																@RequestParam (value = "correo", required = false) String correo,
																@RequestParam (value = "direccion", required = false) String direccion,
																@RequestParam (value = "activo", required = false) Integer activo) throws ClassNotFoundException, SQLException, NamingException{
		
		proveedoresService.actualizarProveedores(id.toString(), nombre, contacto, telefono, correo, direccion, activo.toString());
		
		return ResponseEntity.ok("Proveedor actualizado correctamente");
		
	}
	
	@DeleteMapping("/proveedores/{id}")
	public ResponseEntity borrarProveedor(@PathVariable("id") Integer id) throws ClassNotFoundException, SQLException {
		
		proveedoresService.borrarProveedores(id.toString());
		
		return ResponseEntity.ok("Proveedor borrado correctamente");
		
	}

}
