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

@WebServlet("/categorias/actualizarcategoria")
public class ActualizarCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ActualizarCategoriasController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1" : "0";
		
		ICategoriasService categoriaService = new CategoriasServices();
		
		try {
			categoriaService.actualizarCategorias(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCategorias.jsp");
		d.forward(request, response);
	}

}
