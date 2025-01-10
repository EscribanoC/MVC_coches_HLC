package com.hlc.mvc_coche.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hlc.mvc_coche.entidades.Coche;
import com.hlc.mvc_coche.repositorio.CocheRepositorio;

class CocheServicioImpTest {

	@Mock // -> Simulamos el repositorio como Dependencia
	private CocheRepositorio cocheRepositorio;
	
	@InjectMocks // --> Creamos una instancia real de CocheServicioImpl y se inyecta automaticamente el mock de cocheRepositorio en este
	private CocheServicioImp cocheServicio;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void obtenerTodosLosCoches() {
		List<Coche> coches = Arrays.asList(
				new Coche("Honda", "0860DLC", "Gris"),
				new Coche("Toyota", "4212ERT", "Azul")
				);
		when(cocheRepositorio.findAll()).thenReturn(coches);
		
		//Llamar al servicio
		List<Coche> coches_servicio = cocheServicio.obtenerTodosLosCoches();
		Integer resultadoEsperado = 2;
		Integer resultado = coches_servicio.size();
		
		assertEquals(2, coches_servicio.size(), "Debe de devolver 2 coches");
		verify(cocheRepositorio, times(1));
	}

}
