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

@WebServlet("/alumnos/borraralumno")
public class BorrarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrarAlumnosController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		IAlumnosService alumnoService = new AlumnosService();
		try {
			alumnoService.borrarAlumnos(id);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarAlumnos.jsp");
		d.forward(request, response);
	}

}
