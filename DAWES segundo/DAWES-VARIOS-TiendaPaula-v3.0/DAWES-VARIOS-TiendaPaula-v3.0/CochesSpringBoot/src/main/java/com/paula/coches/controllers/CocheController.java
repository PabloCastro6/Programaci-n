package com.paula.coches.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paula.coches.negocio.INumeroCoches;

@Controller
public class CocheController {
	
	@Autowired
	INumeroCoches numCoches;


	@RequestMapping(value = "/calculaNumeroCoches")
	public String calculaNumCoches(@RequestParam("nombre") String nombre, ModelMap model) throws IOException {
		
		Integer cantidad = numCoches.calculaNumeroCoches(nombre);
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("numCoches", cantidad);
		
		return "coches";
	}
}