package com.paula.IMC.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.paula.IMC.dtos.imcDTO;
import com.paula.IMC.negocio.CalculaIMC;

@WebServlet("/calculaIMC")
public class IMCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IMCController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");

		double imc = CalculaIMC.calculaIMC(nombre);

		request.setAttribute("nombre", nombre);
		request.setAttribute("imc", imc);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/imcVista.jsp");
		dispatcher.forward(request, response);
	}

}
