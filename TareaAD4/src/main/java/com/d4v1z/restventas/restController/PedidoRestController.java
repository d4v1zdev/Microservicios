package com.d4v1z.restventas.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4v1z.restventas.modelo.entities.Pedido;
import com.d4v1z.restventas.modelo.repository.PedidoRepository;

@RestController
@RequestMapping("/apirest/")
public class PedidoRestController {
	
	@Autowired
	private PedidoRepository pedRepo;
	
	@GetMapping("/pedidos/{id}")
	public List<Pedido> porComercial(@PathVariable("id") int id_comercial) {
		return pedRepo.buscarporComercial(id_comercial);
	}
	

}
