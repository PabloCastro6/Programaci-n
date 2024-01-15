package com.gon.tienda.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class PrincipalController {
	
	@GetMapping("/")
	
	public String getListadoCategorias() {
		
		return "index";
	}

}
