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
	
	/**
	 * Metodo PUT para modificar el comercial
	 * @param comercial
	 * @return el comercial ya modificado
	 */
	
	@PutMapping("/modificar")
	public Comercial modificar(@RequestBody Comercial comercial) {
		
		return coServ.modificarComercial(comercial);
		
	}
	/**
	 * Metodo DELETE para eliminar de la bbdd el comercial cuyo id coincida
	 * @param id_comercial
	 * @return Comercial eliminado si el id existe o Comercial no existe si el Id 
	 * 		exite
	 */
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int id_comercial) {
		
		if (coServ.eliminarComercial(id_comercial))
			return "Comercial eliminado";
			else
				return "Comercial no existe";
		
	}
	
	/**
	 * Metodo Get Devolver la lista de los comerciales 
	 * que han atendido pedidos del cliente que coincida con ese id.
	 * @param idCliente
	 * @return lista de comerciales
	 */
	
	@GetMapping("/bycliente/{id}")
	public List<Comercial> porComercial(@PathVariable("id") int idCliente) {
		return coServ.verComPorCliente(idCliente);
	}
	
	/**
	 * Nos devuelve la lista de comerciales que han tenido algun pedido
	 * @return lista de comerciales
	 */
	
	@GetMapping("/conpedidos")
	public List<Comercial> conPedidos() {
		return this.coServ.comercYPed();
	}

}
