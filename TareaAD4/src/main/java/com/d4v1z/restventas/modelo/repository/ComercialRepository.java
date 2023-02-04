package com.d4v1z.restventas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.d4v1z.restventas.modelo.entities.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{
	
	@Query(value="select distinct c.* from pedidos P "
			+ "join comerciales C on p.id_comercial=c.id_comercial "
			+ "where p.id_cliente = ?1", nativeQuery=true)
	List<Comercial> verPorCliente(int idCliente);

	List<Comercial> listaComercialesCliente(int idCliente);

}
