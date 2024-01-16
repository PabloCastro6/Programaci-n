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

import com.paula.colegio.dao.jdbcimpl.CombosDAOImpl;
import com.paula.colegio.dtos.ComboDTO;
import com.paula.colegio.negocio.impl.AlumnosService;
import com.paula.colegio.dao.ICombosDAO;

@WebServlet("/alumnos/insertaralumnos")
public class InsertarAlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertarAlumnosController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ComboDTO> listaMunicipios = new ArrayList<>();
		ICombosDAO combosMunicipios = new CombosDAOImpl();

		try {
			listaMunicipios = combosMunicipios.recuperarCombosMunicipio();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}

		request.setAttribute("comboMunicipios", listaMunicipios);

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/insertarAlumnos.jsp");
		d.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer resultado = 0;
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");         
		String apellido = request.getParameter("apellido");

		
		String activo = request.getParameter("activo");
		String famNumerosa = request.getParameter("famNumerosa");
		
		String municipios = request.getParameter("municipios");
		
		activo = (activo != null) ? "1" : "0";
		famNumerosa = (famNumerosa != null) ? "1" : "0";
		
		try {
			resultado = new AlumnosService().insertarAlumnos(id, nombre, apellido, activo, famNumerosa, municipios);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("resultado", resultado);
		
		doGet(request ,response);
	}

}
