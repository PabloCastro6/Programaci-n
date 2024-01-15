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

import javax.naming.NamingException;

import com.gon.tienda.dao.ICombosDAO;
import com.gon.tienda.dao.tiendaimpl.CombosDAOImpl;
import com.gon.tienda.dtos.ComboDTO;
import com.gon.tienda.negocio.IProductosService;
import com.gon.tienda.negocio.impl.ProductosServices;

@WebServlet("/productos/actualizarproducto")
public class ActualizacionProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActualizacionProductoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");		
		String precio = request.getParameter("precio");
		String cantidadStock = request.getParameter("cantidadStock");
		String idCategoria = request.getParameter("idCategoria");
		String idProveedor = request.getParameter("idProveedor");
		
		precio = (precio == "") ? "0" : precio;
		cantidadStock = (cantidadStock == "") ? "0" : cantidadStock;

		IProductosService productoServicio = new ProductosServices();
		List<ComboDTO> listaCategoria = new ArrayList();
		ICombosDAO combosCategorias = new CombosDAOImpl();

		List<ComboDTO> listaProveedores = new ArrayList();
		ICombosDAO combosProveedores = new CombosDAOImpl();

		try {
			listaCategoria = combosCategorias.recuperaComboCategorias();
			listaProveedores = combosProveedores.recuperaComboProveedores();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		request.setAttribute("comboCategorias", listaCategoria);
		request.setAttribute("comboProveedores", listaProveedores);


		try {
			productoServicio.actualizarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaProductos/actualizadoProductos.jsp");
		d.forward(request, response);
	}


}
