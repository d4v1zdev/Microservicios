package com.d4v1z.restventas.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d4v1z.restventas.modelo.entities.Comercial;
import com.d4v1z.restventas.modelo.service.ComercialService;

@RestController
@RequestMapping("/apirest/comercial")
public class ComercialRestController {
	@Autowired
	private ComercialService coServ;
	
	@GetMapping("/todos")
	public List<Comercial> todas() {
		return coServ.buscarTodas();
	}
	
	@GetMapping("/uno/{id}")
	public Comercial buscarUno(@PathVariable("id") int id_comercial) {
		return coServ.buscarUna(id_comercial);
			
	}
	
	@PostMapping("/alta")
	public Comercial alta(@RequestBody Comercial comercial) {
		
		return coServ.altaComercial(comercial);
		
	}
	
	@PutMapping("/modificar")
	public Comercial modificar(@RequestBody Comercial comercial) {
		
		return coServ.modificarComercial(comercial);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id_comercial) {
		
		if (coServ.eliminarComercial(id_comercial))
			return "Comercial eliminado";
			else
				return "Comercial no existe";
		
	}

}
