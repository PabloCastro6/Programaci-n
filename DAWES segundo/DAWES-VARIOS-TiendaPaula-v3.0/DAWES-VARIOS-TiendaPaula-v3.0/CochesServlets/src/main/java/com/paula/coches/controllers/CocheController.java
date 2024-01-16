package com.paula.coches.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.paula.coches.negocio.NumeroCoches;

@WebServlet("/calculaNumeroCoches")
public class CocheController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CocheController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		NumeroCoches contar = new NumeroCoches();
		
		int cantidad = contar.calculaNumeroCoches(nombre);
		
		request.setAttribute("nombre", nombre);
		request.setAttribute("numCoches", cantidad);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/coches.jsp");
        dispatcher.forward(request, response);
		
	}

}
