package com.gon.tienda.controladores.Clientes;

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

import com.gon.tienda.dao.ICombosDAO;
import com.gon.tienda.dao.tiendaimpl.CombosDAOImpl;
import com.gon.tienda.dtos.ComboDTO;
import com.gon.tienda.negocio.IClientesService;
import com.gon.tienda.negocio.IProductosService;
import com.gon.tienda.negocio.impl.ClientesServices;
import com.gon.tienda.negocio.impl.ProductosServices;

@WebServlet("/clientes/actualizarcliente")
public class ActualizacionClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizacionClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String idPoblacion = request.getParameter("idPoblacion");
		String activo = request.getParameter("activo");
		activo = (activo != null) ? "1":"0";
		
		IClientesService clienteServicio = new ClientesServices();

		
		List<ComboDTO> listaClientes = new ArrayList();
		ICombosDAO combosClientes = new CombosDAOImpl();

		try {

			listaClientes = combosClientes.recuperaComboMunicipios();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("comboMunicipios", listaClientes);

		try {
			clienteServicio.actualizarClientes(id, nombre, correo, idPoblacion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaClientes/actualizadoClientes.jsp");
		d.forward(request, response);
	}

}
