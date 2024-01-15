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

@WebServlet("/categorias/formularioborrarcategorias")
public class FormularioBorrarCategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioBorrarCategoriasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategorias.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		List<CategoriaDTO> listadoCategorias = new ArrayList<>();
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");	
		String activo = request.getParameter("activo");

		
		activo = (activo != null) ? "1":"0";
		
		CategoriasServices categoriasService = new CategoriasServices();
		try {
			listadoCategorias = categoriasService.buscarCategorias(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoCategorias);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/borrarCategorias.jsp");
		d.forward(request, response);
	}

}