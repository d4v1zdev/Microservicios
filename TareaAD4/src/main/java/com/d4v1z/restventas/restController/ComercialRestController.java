package com.d4v1z.restventas.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/comercial")
public class ComercialRestController {
	@Autowired
	private ComercialService coServ;
			
	
	/**
	 * Metodo GET para obtener todos los comerciales
	 * @return los datos de los comerciales
	 */
	@GetMapping("/todos")
	public ResponseEntity<List<Comercial>> todas() {
	  List<Comercial> comerciales = coServ.buscarTodas();
	  return new ResponseEntity<>(comerciales, HttpStatus.OK);
	}
	
	/**
	 * Este metodo GET devuelve los datos de un comercial pasando el id del comercial
	 * Se modifica el httpResponse si el comercial existe o no
	 * @param id_comercial
	 * @return los datos del comercial
	 */
	@GetMapping("/uno/{id}")
	public ResponseEntity<Object> buscarUno(@PathVariable("id") int id_comercial) {
	  Comercial comercial = coServ.buscarUna(id_comercial);
	  if (comercial == null) {
		  return new ResponseEntity<>("El comercial con id " + id_comercial 
				  + " no se encontró", HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<>(comercial, HttpStatus.OK);
	}


	/**
	 * Generamos el alta de un comercial. Como mejora queda la posibilidad de controlar
	 * con una funcion booleana en la clase Comercial, el tipo de dato que se introduce
	 * excepto el Id que es numerico autoincrementable. Pudiendo en los demas casos
	 * poder controlar el http response
	 * @param comercial
	 * @return genera el alta
	 * @version 1.0
	 */
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
	 * Metodo DELETE para eliminar de la bbdd el comercial cuyo id coincida.
	 * Se usa ResponseEntity para vusalizar esta personalizar las salidas http
	 * @param id_comercial
	 * @return Comercial eliminado si el id existe o Comercial no existe si el Id existe
	 */
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable("id") int id_comercial) {
		
		if (coServ.eliminarComercial(id_comercial)) {
			return new ResponseEntity<>("COMERCIAL ELIMINADO", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("EL COMERCIAL CON EL ID " 
					+ id_comercial + " NO SE ENCONTRO", HttpStatus.NOT_FOUND);
		}
		
	}
	
	/**
	 * Metodo que devuelve los comerciales que han atendido pedidos del cliente que
	 * corresponda con el ID que hemos pasado
	 * @param idCliente
	 * @return
	 */
	@GetMapping("/bycliente/{id}")
	public ResponseEntity<Object> porComercial(@PathVariable("id") int idCliente) {
	List<Comercial> comerciales = coServ.verComPorCliente(idCliente);
	if (comerciales.isEmpty()) {
		return new ResponseEntity<>("El cliente con id " + idCliente + " no se encontró", HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity<>(comerciales, HttpStatus.OK);
	}

	
	/**
	 * Metod GET que nos devuelve la lista de comerciales que han tenido algun pedido
	 * @return lista de comerciales
	 */
	@GetMapping("/conpedidos")
	public List<Comercial> conPedidos() {
		return this.coServ.comercYPed();
	}

}
