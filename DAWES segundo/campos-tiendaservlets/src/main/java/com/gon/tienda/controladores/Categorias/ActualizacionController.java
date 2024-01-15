package com.gon.tienda.controladores.Categorias;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.gon.tienda.negocio.ICategoriasService;
import com.gon.tienda.negocio.impl.CategoriasServices;


@WebServlet("/categorias/actualizarcategorias")
public class ActualizacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ActualizacionController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String activo = request.getParameter("activo");
		String descripcion = request.getParameter("descripcion");
		
		activo = (activo != null) ? "1":"0";
		
		ICategoriasService categoriasServicio = new CategoriasServices();
		
		try {
			categoriasServicio.actualizarCategorias(id, nombre, descripcion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/actualizarCategorias.jsp");
		d.forward(request, response);
	}

}
