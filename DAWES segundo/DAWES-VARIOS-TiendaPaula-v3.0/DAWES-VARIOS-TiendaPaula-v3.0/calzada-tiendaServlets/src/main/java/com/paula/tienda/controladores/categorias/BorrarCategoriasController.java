package com.paula.tienda.controladores.categorias;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.paula.tienda.negocio.ICategoriasService;
import com.paula.tienda.negocio.impl.CategoriasServices;

@WebServlet("/categorias/borrarcategoria")
public class BorrarCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrarCategoriasController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		ICategoriasService categoriaService = new CategoriasServices();
		
		try {
			categoriaService.borrarCategorias(id);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategorias.jsp");
		d.forward(request, response);
	}

}
