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

@WebServlet("/productos/insertarproducto")
public class InsertarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertarProductosController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<ComboDTO> listadoProveedor = new ArrayList<>();
		List<ComboDTO> listadoCategoria= new ArrayList<>();
		
		ICombosDAO comboProveedor = new CombosDAOImpl();
		
		try {
			listadoProveedor = comboProveedor.recuperaComboProveedores();
			listadoCategoria = comboProveedor.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("comboProveedor", listadoProveedor);
		request.setAttribute("comboCategoria", listadoCategoria);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaProductos/insertadoProductos.jsp");
		d.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer resultado = 0;
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");		
		String precio = request.getParameter("precio");
		precio = (precio.equals("") ? "0" : precio);
		String cantidadStock = request.getParameter("cantidadStock");
		cantidadStock = (cantidadStock.equals("") ? "0" : cantidadStock);
		String idCategoria = request.getParameter("idCategoria");
		String idProveedor = request.getParameter("idProveedor");
	
		
		
		
		ProductosServices productosService = new ProductosServices();
		try {
			resultado = productosService.insertarProductos(nombre, descripcion, precio, cantidadStock, idCategoria, idProveedor);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		List<ComboDTO> insertaProveedor = new ArrayList<>();
		List<ComboDTO> insertaCategoria= new ArrayList<>();
		
		ICombosDAO comboProveedor = new CombosDAOImpl();
		
		try {
			insertaProveedor = comboProveedor.recuperaComboProveedores();
			insertaCategoria = comboProveedor.recuperaComboCategorias();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("comboProveedor", insertaProveedor);
		request.setAttribute("comboCategoria", insertaCategoria);	
		
		request.setAttribute("resultado", resultado);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistaProductos/insertadoProductos.jsp");
		d.forward(request, response);
	}

}
