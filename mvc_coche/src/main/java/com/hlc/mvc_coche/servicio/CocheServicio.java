package com.hlc.mvc_coche.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hlc.mvc_coche.entidades.Coche;

public interface CocheServicio {
	List<Coche> obtenerTodosLosCoches();
	Coche obtenerCochePorId(Long id);
	Coche guardarCoche(Coche coche);
	void eliminarCoche(Long id);
}
