package com.paula.tienda.controladores.categorias;

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

import com.paula.tienda.dtos.CategoriaDTO;
import com.paula.tienda.negocio.impl.CategoriasServices;

@WebServlet("/categorias/formularioactualizarcategoria")
public class FormularioActualizarCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FormularioActualizarCategoriasController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCategorias.jsp");
		d.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CategoriaDTO> listadoCategorias = new ArrayList<>();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String activo = request.getParameter("activo");
		
		activo = (activo != null) ? "1" : "0";
		
		CategoriasServices categoriaService = new CategoriasServices();
		
		try {
			listadoCategorias = categoriaService.buscarCategorias(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoCategorias);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCategorias.jsp");
		d.forward(request, response);
	}

}
