package com.d4v1z.restventas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.d4v1z.restventas.modelo.entities.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{
	
	/**
	 * Con esta Query accedemos a MySQL y extraemos los comerciales que han 
	 * atendido a 1 cliente
	 * @param idCliente
	 * @return datos de la bbdd ventasbbdd_2023
	 */
	
	@Query( value="select distinct c.* from pedidos P "
			+ "join comerciales C on p.id_comercial=c.id_comercial "
			+ "where p.id_cliente = ?1", nativeQuery=true)
	
	List<Comercial> verComercialXXCliente(int idCliente);
	
	/**
	 * Con esta Query sacamos el listado de comerciales que han atendido pedido
	 * @return los datos de la bbdd
	 */
	
	@Query( value = "select * from comerciales where id_comercial in "
			+ "(select id_comercial from pedidos)", nativeQuery = true )
    List<Comercial> comercialConPedidos();

}
