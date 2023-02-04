package com.d4v1z.restventas.modelo.service;

import java.util.List;

import com.d4v1z.restventas.modelo.entities.Comercial;

/**
 * Creacion de interface para implementar mas adelante
 * @author david
 *
 */

public interface ComercialService {
	
	Comercial altaComercial(Comercial comercial);
	boolean eliminarComercial(int id_comercial);
	Comercial buscarUna(int id_comercial);
	List<Comercial> buscarTodas();
	Comercial modificarComercial(Comercial comercial);
	List<Comercial> verComPorCliente(int idCliente);
	List<Comercial> comercYPed();

}
