package com.paula.colegio.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;


import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.paula.colegio.negocio.impl.AlumnosService;

@WebServlet("/alumnos/obtenertodosalumnos")
public class ControladorPruebaConexionBBDD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ControladorPruebaConexionBBDD.class);

	public ControladorPruebaConexionBBDD() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setAttribute("listaAlumnos", new AlumnosService().obtenerTodosAlumnos());
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/alumnos.jsp");
		d.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
