package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.PedidosDAO;
import com.kike.colegio.dtos.PedidosDTO;
import com.kike.colegio.negocio.IPedidosService;

@Component
public class PedidosService implements IPedidosService {
	@Autowired
	@Qualifier("pedidosHIB")
	PedidosDAO pedidosDAO;

	@Override
	public List<PedidosDTO> obtenerTodosPedidos() throws ClassNotFoundException, SQLException, NamingException {
		return pedidosDAO.obtenerTodosPedidos();
	}

	@Override
	public List<PedidosDTO> buscarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		return pedidosDAO.buscarPedidos(id, cliente, fecha, estado);
	}

	@Override
	public Integer insertarPedidos(String cliente, String idProducto, String cantidad, String precioUnitario)
			throws ClassNotFoundException, SQLException, NamingException {
		return pedidosDAO.insertarPedidos(cliente, idProducto, cantidad, precioUnitario);
	}

	@Override
	public Integer actualizarPedidos(String id, String cliente, String fecha, String estado)
			throws ClassNotFoundException, SQLException, NamingException {
		return pedidosDAO.actualizarPedidos(id, cliente, fecha, estado);
	}

	@Override
	public Double calcularPrecio(Integer idCLiente, Double descuento) throws ClassNotFoundException {
		return pedidosDAO.calcularPrecio(idCLiente, descuento);

	}

	@Override
	public Double obtenerComprasAcumuladasCliente(Integer idCliente) throws ClassNotFoundException {
		return pedidosDAO.obtenerComprasAcumuladasCliente(idCliente);

	}

	@Override
	public Double obtenerDescuentoPorCompras(Double comprasAcumuladas) throws ClassNotFoundException {
		return pedidosDAO.obtenerDescuentoPorCompras(comprasAcumuladas);
	}

}
