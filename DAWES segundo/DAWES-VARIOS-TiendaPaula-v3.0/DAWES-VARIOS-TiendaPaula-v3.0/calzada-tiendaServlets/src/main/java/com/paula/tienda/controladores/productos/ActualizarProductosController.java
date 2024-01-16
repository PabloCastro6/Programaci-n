package com.paula.tienda.controladores.productos;

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

import com.paula.tienda.dao.ICombosDAO;
import com.paula.tienda.dao.jdbcimpl.CombosDAOImpl;
import com.paula.tienda.dtos.CombosDTO;
import com.paula.tienda.negocio.IProductosService;
import com.paula.tienda.negocio.impl.ProductosService;

@WebServlet("/productos/actualizarproducto")
public class ActualizarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ActualizarProductosController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ICombosDAO combos = new CombosDAOImpl();
		List<CombosDTO> listaCombosCategorias = new ArrayList<>();
		List<CombosDTO> listaCombosProveedores = new ArrayList<>();
		try {
			listaCombosCategorias = combos.recuperarCombosCategorias();
			listaCombosProveedores = combos.recuperarCombosProveedores();
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("combosCategorias", listaCombosCategorias);
		request.setAttribute("combosProveedores", listaCombosProveedores);
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String precio = request.getParameter("precio");
		precio = (precio.equals("")) ? "0" : precio;
		String cantidad = request.getParameter("cantidad");
		cantidad = (cantidad.equals("")) ? "0" : cantidad;
		String categoria = request.getParameter("categorias");
		String proveedor = request.getParameter("proveedores");
	
		IProductosService productosService = new ProductosService();
		
		try {
			productosService.actualizarProductos(id, nombre, descripcion, precio, cantidad, categoria, proveedor);
		} catch (ClassNotFoundException | SQLException | NamingException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/WEB-INF/vistas/productos/actualizarProductos.jsp");
		d.forward(request, response);
	}

}
