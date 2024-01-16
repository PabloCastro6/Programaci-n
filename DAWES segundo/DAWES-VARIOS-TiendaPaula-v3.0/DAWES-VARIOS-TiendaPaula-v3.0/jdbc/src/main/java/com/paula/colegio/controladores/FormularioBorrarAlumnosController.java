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

import com.paula.colegio.dao.ICombosDAO;
import com.paula.colegio.dao.jdbcimpl.CombosDAOImpl;
import com.paula.colegio.dtos.AlumnoDTO;
import com.paula.colegio.dtos.ComboDTO;
import com.paula.colegio.negocio.impl.AlumnosService;

@WebServlet("/alumnos/formularioborraralumno")
public class FormularioBorrarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormularioBorrarAlumnosController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarAlumnos.jsp");
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<ComboDTO> listaMunicipios = new ArrayList<>();
		ICombosDAO combosMunicipios = new CombosDAOImpl();
		
		try {
			listaMunicipios = combosMunicipios.recuperarCombosMunicipio();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		request.setAttribute("comboMunicipios", listaMunicipios);

				
		List<AlumnoDTO> listadoAlumnos = new ArrayList<>();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		String activo = request.getParameter("activo");
		String famNumerosa = request.getParameter("famNumerosa");
		
		activo = (activo != null) ? "1" : "0";
		famNumerosa = (famNumerosa != null) ? "1" : "0"; 
		
		AlumnosService alumnosService = new AlumnosService();
		
		try {
			listadoAlumnos = alumnosService.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoAlumnos);
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarAlumnos.jsp");
		d.forward(request, response);
	}

}
