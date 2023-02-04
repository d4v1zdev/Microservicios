package com.d4v1z.restventas.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.d4v1z.restventas.modelo.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Query("select p from Pedido p where p.comercial.idComercial = ?1")
	List<Pedido> buscarporComercial(int idComercial);

}
