package com.hlc.mvc_coche.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.mvc_coche.entidades.Coche;
import com.hlc.mvc_coche.repositorio.CocheRepositorio;
import com.hlc.mvc_coche.servicio.CocheServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	
	private CocheRepositorio cocheRepositorio;
	public InicializarDatos(CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}
	
	
	@PostConstruct
	public void init() {
		/*if(cocheRepositorio.findAll().iterator().hasNext()) {
			return;//Si existen datos en una base de datos, no crea los productos de abajo
		}*/
		
		Coche coche1 = new Coche();
		coche1.setMarca("Honda");
		coche1.setMatricula("0860DLC");
		coche1.setColor("Gris");
		cocheRepositorio.save(coche1);
		
		Coche coche2 = new Coche();
		coche2.setMarca("Toyota");
		coche2.setMatricula("4212ERT");
		coche2.setColor("Azul");
		cocheRepositorio.save(coche2);
	}
}
