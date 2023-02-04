package com.d4v1z.restventas.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d4v1z.restventas.modelo.entities.Comercial;
import com.d4v1z.restventas.modelo.repository.ComercialRepository;

@Service
public class ComercialServiceImplMy8 implements ComercialService {

	@Autowired
	private ComercialRepository comRep;
	
	/**
	 * Metodo para dar de alta al comercial
	 */
	
	@Override
	public Comercial altaComercial(Comercial comercial) {
		if (buscarUna(comercial.getIdComercial()) == null)
			return comRep.save(comercial);
		return null;
	}
	
	/**
	 * Metodo para eliminar un comercial pasando el id del comercial
	 */
	
	@Override
	public boolean eliminarComercial(int id_comercial) {
		try {
		if (buscarUna(id_comercial) != null) {
			comRep.deleteById(id_comercial);
			return true;
		}
		} catch(Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * Metodo para buscar un comercial pasando el id del comercial
	 */

	@Override
	public Comercial buscarUna(int id_comercial) {
		// TODO Auto-generated method stub
		return comRep.findById(id_comercial).orElse(null);
	}
	
	/**
	 * Metodo para buscar todos los Comerciales
	 */

	@Override
	public List<Comercial> buscarTodas() {
		// TODO Auto-generated method stub
		return comRep.findAll();
	}
	
	/**
	 * Metodo para modificar los datos del comercial
	 */

	@Override
	public Comercial modificarComercial(Comercial comercial) {
		if (buscarUna(comercial.getIdComercial()) != null)
			return comRep.save(comercial);
		return null;
	}
	
	/**
	 * Este metodo devuelve la lista de comerciales que han atendido
	 * a 1 cliente pasando el Id de cliente
	 */
		@Override
		public List<Comercial> verComPorCliente(int idCliente) {
			
			try {
	            return this.comRep.verComercialXXCliente(idCliente);
	        } catch ( Exception e ) {
	            e.printStackTrace();
	            return null;
	        }
		}
		/**
		 * Metodo que devuelve la lista de comerciales que hayan atendido
		 * algun pedido
		 */
		
		@Override
	    public List<Comercial> comercYPed() {

	        try {
	            return this.comRep.comercialConPedidos();
	        } catch ( Exception e ) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	

}
