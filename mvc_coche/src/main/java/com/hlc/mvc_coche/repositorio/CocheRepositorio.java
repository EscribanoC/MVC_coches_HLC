package com.hlc.mvc_coche.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hlc.mvc_coche.entidades.Coche;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Long> {

}
