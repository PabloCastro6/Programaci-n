package com.kike.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.PedidosDTO;

public interface IPedidosService {
	public List<PedidosDTO> obtenerTodosPedidos() throws ClassNotFoundException, SQLException, NamingException;

	public List<PedidosDTO> buscarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarPedidos(String cliente, String idProducto, String cantidad, String precioUnitario)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException;

	public Double calcularPrecio(Integer idCLiente, Double descuento) throws ClassNotFoundException;

	public Double obtenerComprasAcumuladasCliente(Integer idCliente) throws ClassNotFoundException;

	public Double obtenerDescuentoPorCompras(Double comprasAcumuladas) throws ClassNotFoundException;
}
