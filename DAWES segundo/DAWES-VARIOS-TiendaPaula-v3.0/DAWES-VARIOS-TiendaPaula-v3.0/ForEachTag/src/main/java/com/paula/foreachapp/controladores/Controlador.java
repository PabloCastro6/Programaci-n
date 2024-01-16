package com.paula.foreachapp.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.paula.foreachapp.bean.ComboDTO;
import com.paula.foreachapp.bean.Persona;

@WebServlet("/obtenpersonas")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controlador() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Persona> listaPersonas = new ArrayList<>();
		
		listaPersonas.add( new Persona("Pepe", 1999));
		listaPersonas.add( new Persona("Kike", 2001));
		listaPersonas.add( new Persona("Juanita", 5000));
		listaPersonas.add( new Persona("Edurne", 3000));
		
		request.setAttribute("personas", listaPersonas);
		
		List<ComboDTO> listaProvincias = new ArrayList<>();
		
		ComboDTO c1 = new ComboDTO(1, "Alicante");
		ComboDTO c2 = new ComboDTO(2, "Bizkaia");
		ComboDTO c3 = new ComboDTO(3, "Salamanca");
		
		listaProvincias.add(c1);
		listaProvincias.add(c2);
		listaProvincias.add(c3);
		
		request.setAttribute("listaProvincias", listaProvincias);
		
		
		RequestDispatcher despachador = getServletContext().getRequestDispatcher("/WEB-INF/vistas/lista.jsp");
		despachador.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
