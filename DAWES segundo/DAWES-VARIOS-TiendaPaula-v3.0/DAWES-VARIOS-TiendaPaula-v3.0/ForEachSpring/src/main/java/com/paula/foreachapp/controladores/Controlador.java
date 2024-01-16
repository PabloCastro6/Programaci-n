package com.paula.foreachapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.paula.foreachapp.bean.ComboDTO;
import com.paula.foreachapp.bean.Persona;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controlador {

	@RequestMapping("/obtenpersonas")
	public String obtenerPersonas(Model model) {
		List<Persona> listaPersonas = new ArrayList<>();

		listaPersonas.add(new Persona("Pepe", 1000));
		listaPersonas.add(new Persona("Kike", 10000));
		listaPersonas.add(new Persona("Juanita", 1999));
		listaPersonas.add(new Persona("Edurne", -3000));

		model.addAttribute("personas", listaPersonas);

		List<ComboDTO> listaProvincias = new ArrayList<>();

		ComboDTO c1 = new ComboDTO(1, "Alicante");
		ComboDTO c2 = new ComboDTO(2, "Bizkaia");
		ComboDTO c3 = new ComboDTO(3, "Salamanca");

		listaProvincias.add(c1);
		listaProvincias.add(c2);
		listaProvincias.add(c3);

		model.addAttribute("listaProvincias", listaProvincias);

		return "lista";
	}
}
