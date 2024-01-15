package com.gon.tienda.controladores.Productos;

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
import com.gon.tienda.dtos.ProductoDTO;
import com.gon.tienda.negocio.impl.ProductosServices;


@WebServlet("/productos/listarproducto")
public class ListarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ComboDTO> listadoProveedor = new ArrayList<>();
		List<ComboDTO> listadoCategoria= new ArrayList<>();
		
		ICombosDAO comboProveedor = new CombosDAOImpl();
		
		try {
			listadoProveedor = comboProveedor.recuperaComboProveedores();
			listadoCategoria = comboProveedor.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("comboProveedor", listadoProveedor);
		request.setAttribute("comboCategoria", listadoCategoria);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaProductos/listadoProductos.jsp");
		d.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");		
		String precio = request.getParameter("precio");
		String cantidadStock = request.getParameter("cantidadStock");
		String idCategoria = request.getParameter("idCategoria");
		String idProveedor = request.getParameter("idProveedor");
	
		
		List<ProductoDTO> listadoProductos = new ArrayList<>();
		
		ProductosServices productosService = new ProductosServices();
		try {
			listadoProductos = productosService.buscarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ComboDTO> listadoProveedor = new ArrayList<>();
		List<ComboDTO> listadoCategoria= new ArrayList<>();
		
		ICombosDAO comboProveedor = new CombosDAOImpl();
		
		try {
			listadoProveedor = comboProveedor.recuperaComboProveedores();
			listadoCategoria = comboProveedor.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("comboProveedor", listadoProveedor);
		request.setAttribute("comboCategoria", listadoCategoria);
		
		request.setAttribute("lista", listadoProductos);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaProductos/listadoProductos.jsp");
		d.forward(request, response);
	}

}
