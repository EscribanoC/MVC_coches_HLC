package com.hlc.mvc_coche.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlc.mvc_coche.entidades.Coche;
import com.hlc.mvc_coche.repositorio.CocheRepositorio;


@Service
public class CocheServicio {
	@Autowired
	private CocheRepositorio cocheRepositorio;
	
	public Iterable<Coche> listarCoches(){
		return cocheRepositorio.findAll();
	}
	
	public Coche guardarProducto(Coche producto) {
		return cocheRepositorio.save(producto);
	}
	
	public Coche obtenerPorId(Long id) {
		return cocheRepositorio.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Producto no encontrado " + id)
				);
	}	
	
	public void eliminarProducto(Long id) {
		cocheRepositorio.deleteById(id);
	}
}
