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
import com.gon.tienda.dtos.ClienteDTO;
import com.gon.tienda.dtos.ComboDTO;
import com.gon.tienda.dtos.ProductoDTO;
import com.gon.tienda.negocio.IClientesService;
import com.gon.tienda.negocio.IProductosService;
import com.gon.tienda.negocio.impl.ClientesServices;
import com.gon.tienda.negocio.impl.ProductosServices;

@WebServlet("/clientes/formularioactualizarcliente")
public class FormularioActualizarClientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioActualizarClientesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ComboDTO> listaClientes = new ArrayList();
		ICombosDAO combosClientes = new CombosDAOImpl();

		try {
			listaClientes = combosClientes.recuperaComboMunicipios();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("comboClientes", listaClientes);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaClientes/actualizadoClientes.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ComboDTO> listaMunicipios = new ArrayList();
		ICombosDAO combosClientes = new CombosDAOImpl();
		
		try {
			listaMunicipios = combosClientes.recuperaComboMunicipios();
			

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("comboClientes", listaMunicipios);
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String idPoblacion = request.getParameter("idPoblacion");
		String activo = request.getParameter("activo");
		activo = (activo != null) ? "1":"0";

		List<ClienteDTO> listadoClientes = new ArrayList<>();
		ClientesServices clientesService = new ClientesServices();

		try {
			listadoClientes = clientesService.buscarClientes(id, nombre, correo, idPoblacion, activo);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", listadoClientes);


		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistaClientes/actualizadoClientes.jsp");
		d.forward(request, response);
		
		
		
	}
	

}
