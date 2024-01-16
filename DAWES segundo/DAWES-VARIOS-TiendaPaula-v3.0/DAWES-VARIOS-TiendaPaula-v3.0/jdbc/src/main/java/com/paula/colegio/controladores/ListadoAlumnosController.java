package com.paula.colegio.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paula.colegio.dtos.AlumnoDTO;
import com.paula.colegio.negocio.impl.AlumnosService;

@WebServlet("/alumnos/listaralumnos")
public class ListadoAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ListadoAlumnosController.class);   
   
    public ListadoAlumnosController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/listadoAlumnos.jsp");
		d.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		String activo = request.getParameter("activo");
		String famNumerosa = request.getParameter("famNumerosa");
		
		activo = (activo != null) ? "1" : "0";
		famNumerosa = (famNumerosa != null) ? "1" : "0"; //Esto es como un if
		
		
		List<AlumnoDTO> listadoAlumnos = new ArrayList<>();
		AlumnosService alumnoService = new AlumnosService();
		
		try {
			listadoAlumnos = alumnoService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoAlumnos);
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/listadoAlumnos.jsp");
		d.forward(request, response);
	}

}
