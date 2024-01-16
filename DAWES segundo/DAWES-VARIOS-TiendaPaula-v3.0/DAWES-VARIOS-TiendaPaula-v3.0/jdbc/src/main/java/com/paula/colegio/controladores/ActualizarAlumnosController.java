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

import com.paula.colegio.negocio.impl.AlumnosService;
import com.paula.colegio.negocios.IAlumnosService;

@WebServlet("/alumnos/actualizaralumno")
public class ActualizarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ActualizarAlumnosController() {
        super();
       
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");         
		String apellido = request.getParameter("apellido");

		
		String activo = request.getParameter("activo");
		String famNumerosa = request.getParameter("famNumerosa");
		
		String municipios = request.getParameter("municipios");
		
		activo = (activo != null) ? "1" : "0";
		famNumerosa = (famNumerosa != null) ? "1" : "0";
		
		IAlumnosService alumnoService = new AlumnosService();
		try {
			alumnoService.actualizarAlumnos(id, nombre, apellido, activo, famNumerosa, municipios);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
	
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarAlumnos.jsp");
		d.forward(request, response);

	}

}
