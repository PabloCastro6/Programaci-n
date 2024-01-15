package com.gon.tienda.controladores.Categorias;

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

import com.gon.tienda.dtos.CategoriaDTO;
import com.gon.tienda.negocio.impl.CategoriasServices;

@WebServlet("/categorias/formularioactualizarcategorias")
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
		String activo = request.getParameter("activo");
		String descripcion = request.getParameter("descripcion");
		
		activo = (activo != null) ? "1":"0";
		
		CategoriasServices categoriasService = new CategoriasServices();
		try {
			listadoCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoCategorias);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCategorias.jsp");
		d.forward(request, response);
	}

}
