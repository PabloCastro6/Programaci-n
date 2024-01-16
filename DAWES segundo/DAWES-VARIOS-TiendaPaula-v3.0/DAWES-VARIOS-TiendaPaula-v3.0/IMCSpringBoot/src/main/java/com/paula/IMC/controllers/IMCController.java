package com.paula.IMC.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paula.IMC.negocio.ICalculaIMC;



@Controller
public class IMCController {
	
	@Autowired
	ICalculaIMC calcularElIMC;
	@RequestMapping(value = "/calculaIMC")
	public String calcularElIMCPesoAltura(@RequestParam("nombre") String nombre, ModelMap model) throws IOException {
		
		double imc = calcularElIMC.calculaIMC(nombre);
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("imc", imc);
		
		return "imcVista";
	}
}