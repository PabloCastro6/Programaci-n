package com.chuchi.tienda.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chuchi.tienda.dtos.ProductosDTO;
import com.chuchi.tienda.entities.ProductosEntity;
import com.chuchi.tienda.repositories.ProductosRepository;
import com.chuchi.tienda.services.IProductosService;

@RestController
@RequestMapping("/v1")
public class ProductosControllerRest {
	
	@Autowired
	IProductosService productosService;
	
	@Autowired
	ProductosRepository productosRepository;
	
	@GetMapping("/productos")
	public Iterable<ProductosEntity> obtenerTodosProductos(){
		
		Iterable<ProductosEntity> productos = productosRepository.findAll();
		
		return productos;
		
	}
	
	@GetMapping ("/productos/{id}")
	public ResponseEntity<ProductosEntity> ObtenerProductosPorId(@PathVariable("id") Integer id){
		
		ProductosEntity productos = productosRepository.findById(id).get();
		
		return new ResponseEntity(productos, HttpStatus.OK);
		
	}

	@GetMapping (value = "/productos", params = {"id", "nombre", "descripcion", "precio", "cantidadEnStock"})
	public ResponseEntity<ProductosEntity> obtenerProductosConFiltros(@RequestParam (value = "id", required = false) Integer id,
																		@RequestParam (value = "nombre", required = false) String nombre,
																		@RequestParam (value = "descripcion", required = false) String descripcion,
																		@RequestParam (value = "precio", required = false) Double precio,
																		@RequestParam (value = "cantidadEnStock", required = false) Integer cantidadEnStock){
		
		List<ProductosDTO> listaProductos = productosRepository.buscaProducto(id.toString(), nombre, descripcion, precio.toString(), cantidadEnStock.toString(), null, null);
		
		return new ResponseEntity(listaProductos, HttpStatus.OK);
		
	}
	
	@PostMapping("/productos")
	public ResponseEntity insertarProducto(@RequestBody ProductosEntity productos) throws ClassNotFoundException, SQLException {
		
		productosService.insertarProductos(productos.getNombre(),productos.getDescripcion(),productos.getPrecio().toString(),productos.getCantidadEnStock().toString(), productos.getCategoria().getId().toString(), productos.getProveedor().getId().toString());
		
		return ResponseEntity.ok("Producto insertado correctamente"); 
	}
	
	@PutMapping(value = "/productos", params = {"id", "nombre", "descripcion", "precio", "cantidadEnStock"})
	public ResponseEntity actualizarProducto(@RequestParam (value = "id", required = false) Integer id,
											@RequestParam (value = "nombre", required = false) String nombre,
											@RequestParam (value = "descripcion", required = false) String descripcion,
											@RequestParam (value = "precio", required = false) Double precio,
											@RequestParam (value = "cantidadEnStock", required = false) Integer cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		
		productosService.actualizarProductos(id.toString(), nombre, descripcion, precio.toString(), cantidadEnStock.toString(), null, null);
		
		return ResponseEntity.ok("Producto actualizado correctamente");
		
	}
	
}
