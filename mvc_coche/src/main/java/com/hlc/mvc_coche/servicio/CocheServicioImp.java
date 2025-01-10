package com.hlc.mvc_coche.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlc.mvc_coche.entidades.Coche;
import com.hlc.mvc_coche.repositorio.CocheRepositorio;

@Service
public class CocheServicioImp implements CocheServicio{
	
	private CocheRepositorio cocheRepositorio;
	
	public CocheServicioImp(CocheRepositorio cocheRepositorio) {
		super();
		this.cocheRepositorio = cocheRepositorio;
	}

	@Override
	public List<Coche> obtenerTodosLosCoches() {
		return cocheRepositorio.findAll();
	}

	@Override
	public Coche obtenerCochePorId(Long id) {
		return cocheRepositorio.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Producto no encontrado " + id)
				);
	}

	@Override
	public Coche guardarCoche(Coche coche) {
		return cocheRepositorio.save(coche);
	}

	@Override
	public void eliminarCoche(Long id) {
		cocheRepositorio.deleteById(id);
		
	}

}
