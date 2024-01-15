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
import com.gon.tienda.negocio.IProductosService;
import com.gon.tienda.negocio.impl.ProductosServices;


@WebServlet("/productos/formularioactualizarproducto")
public class FormularioActualizacionProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FormularioActualizacionProductoController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaProductos/actualizadoProductos.jsp");
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ProductoDTO> listadoProducto = new ArrayList<>();
		
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
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		String cantidadStock = request.getParameter("cantidadStock");
		String idCategoria = request.getParameter("idCategoria");
		String idProveedor = request.getParameter("idProveedor");

		IProductosService productoServicio = new ProductosServices();

		try {
			 productoServicio.buscarProductos(id, nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lista", listadoProducto);

		RequestDispatcher d = getServletContext()
				.getRequestDispatcher("/WEB-INF/vistaProductos/actualizadoProductos.jsp");
		d.forward(request, response);
		
		
		
	}

}
