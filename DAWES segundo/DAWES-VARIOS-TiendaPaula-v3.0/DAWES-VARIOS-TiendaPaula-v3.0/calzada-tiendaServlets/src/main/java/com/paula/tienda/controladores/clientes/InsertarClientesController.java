package com.paula.tienda.controladores.clientes;

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

import com.paula.tienda.dao.ICombosDAO;
import com.paula.tienda.dao.jdbcimpl.CombosDAOImpl;
import com.paula.tienda.dtos.CombosDTO;
import com.paula.tienda.negocio.impl.ClientesService;

@WebServlet("/clientes/insertarclientes")
public class InsertarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertarClientesController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICombosDAO combos = new CombosDAOImpl();
		List<CombosDTO> listaCombosPoblaciones = new ArrayList<>();
		
		try {
			listaCombosPoblaciones = combos.recuperarCombosPoblaciones();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("combosPoblaciones", listaCombosPoblaciones);
		
		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistas/clientes/insertarClientes.jsp");
		d.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer resultado = 0;
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String poblacion = request.getParameter("poblaciones");
        String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1" : "0";
		
		try {
			resultado = new ClientesService().insertarClientes(nombre, correo, poblacion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("resultado", resultado);
		
		doGet(request, response);
	}

}
