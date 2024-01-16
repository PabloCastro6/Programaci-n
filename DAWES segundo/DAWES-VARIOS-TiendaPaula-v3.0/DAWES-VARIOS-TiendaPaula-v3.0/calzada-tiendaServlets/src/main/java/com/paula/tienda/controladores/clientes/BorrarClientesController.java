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
import com.paula.tienda.negocio.IClientesService;
import com.paula.tienda.negocio.impl.ClientesService;

@WebServlet("/clientes/borrarcliente")
public class BorrarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BorrarClientesController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ICombosDAO combos = new CombosDAOImpl();
		List<CombosDTO> listaCombosPoblaciones = new ArrayList<>();
		
		try {
			listaCombosPoblaciones = combos.recuperarCombosPoblaciones();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("combosPoblaciones", listaCombosPoblaciones);
		String id = request.getParameter("id");
		
		IClientesService clienteService = new ClientesService();
		
		try {
			clienteService.borrarClientes(id);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/clientes/borrarClientes.jsp");
		d.forward(request, response);
	}

}
