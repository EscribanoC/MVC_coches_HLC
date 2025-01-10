package com.hlc.mvc_coche.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlc.mvc_coche.entidades.Coche;
import com.hlc.mvc_coche.repositorio.CocheRepositorio;
import com.hlc.mvc_coche.servicio.CocheServicio;

import jakarta.annotation.PostConstruct;

@Component
public class InicializarDatos {
	/*Se puede usar cocheRepositorio o cocheServicio, ambas clases funcionan y
	 puesto que al ser una clase de DESARROLLO, luego se borrará
	*/
	private CocheRepositorio cocheRepositorio;
	public InicializarDatos(CocheRepositorio cocheRepositorio) {
		this.cocheRepositorio = cocheRepositorio;
	}
	
	
	@PostConstruct
	public void init() {
		if(cocheRepositorio.findAll().iterator().hasNext()) {
			return;//Si existen datos en una base de datos, no crea los productos de abajo
		}
		
		Coche coche1 = new Coche("Honda", "0860DLC", "Gris");
		cocheRepositorio.save(coche1);
		
		Coche coche2 = new Coche("Toyota", "4212ERT", "Azul");
		cocheRepositorio.save(coche2);
	}
}
