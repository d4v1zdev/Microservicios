package com.d4v1z.restventas.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.d4v1z.restventas.modelo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
