package com.d4v1z.restventas.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4v1z.restventas.modelo.entities.Pedido;
import com.d4v1z.restventas.modelo.repository.PedidoRepository;

@RestController
@RequestMapping("/comercial")
public class PedidoRestController {
	
	@Autowired
	private PedidoRepository pedRepo;
			
	/**
	 * Metod GET que nos devuelve los pedidos gestionados por comercial que
	 * le pasamos. 
	 * Controlamos si el comercial existe o no con el ResponseEntity
	 * @param id_comercial
	 * @return los pedidos
	 */
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Object> porComercial(@PathVariable("id") int id_comercial) {
	  List<Pedido> pedidos = pedRepo.buscarporComercial(id_comercial);
	  if (pedidos.isEmpty()) {
	    return new ResponseEntity<>("El comercial con id " + id_comercial + " no se encontró", HttpStatus.NOT_FOUND);
	  } else {
	    return new ResponseEntity<>(pedidos, HttpStatus.OK);
	  }
	}


}
