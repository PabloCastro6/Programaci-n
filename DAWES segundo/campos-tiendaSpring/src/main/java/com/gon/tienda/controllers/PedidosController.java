package com.gon.tienda.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gon.tienda.dtos.ClienteProductoDTO;
import com.gon.tienda.dtos.ItemDTO;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	@PostMapping("/calculaprecio")
	public @ResponseBody Double calculaPrecio(ModelMap modelMap,@RequestBody ClienteProductoDTO clienteProducto ) {
		
		System.out.println(clienteProducto.getCliente() + " " + clienteProducto.getProducto());
		return 3.0;
	}
	
	@PostMapping("/dopedido")
	public ResponseEntity<String> creaPedido(ModelMap modelMap, @RequestBody List<ItemDTO> lista){
		
		for(ItemDTO i : lista) {
			System.out.println(i.getClienteNombre() + " " + i.getProductoNombre());
		}
		
		return ResponseEntity.internalServerError().body("error al realizar la venta");
	}
}
