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

import com.chuchi.tienda.dtos.CategoriasDTO;
import com.chuchi.tienda.entities.CategoriasEntity;
import com.chuchi.tienda.repositories.CategoriasRepository;
import com.chuchi.tienda.services.ICategoriasService;

@RestController
@RequestMapping("/v1")
public class CategoriasControllerRest {
	
	@Autowired
	ICategoriasService categoriasService;
	@Autowired
	CategoriasRepository categoriasRepository;
	
	@GetMapping("/categorias")
	public Iterable<CategoriasEntity> obtenerTodosCategorias(){
		
		Iterable<CategoriasEntity> categorias = categoriasRepository.findAll();
		
		return categorias;
		
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriasEntity> obtenerCategoriasPorId(@PathVariable("id") Integer id){
		
		CategoriasEntity categorias = categoriasRepository.findById(id).get();
		
		return new ResponseEntity(categorias, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/categorias", params = {"id", "nombre", "descripcion", "activo"})
	public ResponseEntity<CategoriasEntity> obtenerCategoriasConFiltros (@RequestParam (value = "id", required = false) Integer id,
																			@RequestParam (value = "nombre", required = false) String nombre,
																			@RequestParam (value = "descripcion", required = false) String descripcion,
																			@RequestParam (value = "activo", required = false) Integer activo){
		
		List<CategoriasDTO> listaCategorias = categoriasRepository.buscaCategorias(id.toString(), nombre, descripcion, activo);
		
		return new ResponseEntity(listaCategorias, HttpStatus.OK);
		
	}	
	
	@PostMapping("/categorias")
	public ResponseEntity insertarCategorias(@RequestBody CategoriasEntity categorias) throws ClassNotFoundException, SQLException, NamingException {
		
		categoriasService.insertarCategoria(categorias.getNombre(), categorias.getDescripcion(), categorias.getActivo().toString());
		
		return ResponseEntity.ok("Categoria insertada correctamente"); 
	}
	
	@PutMapping(value = "/categorias", params = {"id", "nombre", "descripcion", "activo"})
	public ResponseEntity actualizarCategorias(@RequestParam (value = "id", required = false) Integer id,
												@RequestParam (value = "nombre", required = false) String nombre,
												@RequestParam (value = "descripcion", required = false) String descripcion,
												@RequestParam (value = "activo", required = false) Integer activo) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = categoriasService.actualizarCategoria(id.toString(), nombre, descripcion, activo.toString());
		
		return ResponseEntity.ok("Categoria insertada correctamente");
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity borrarCategoria (@PathVariable("id") Integer id) throws ClassNotFoundException, SQLException, NamingException {
		
		
		categoriasService.borrarCategoria(id.toString());
		
		return ResponseEntity.ok("Categoria borrada correctamente");
	}
}
