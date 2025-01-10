package com.hlc.mvc_coche.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hlc.mvc_coche.entidades.Coche;

//Esta etiqueta se usa por que es una interfaz que extiende de Jpa
@DataJpaTest
class CocheRepositorioTest {

	// Para los tests si es recomendable puesto que no tiene constructor
	@Autowired
	private CocheRepositorio cocheRepositorio;
	
	@Test
	void testSaveAndFindAll() {
		//Crear y guardar coches
		Coche coche1 = new Coche("Honda" , "0860DLC", "Gris");
		Coche coche2 = new Coche("Toyota", "4212ERT", "Azul");
		
		cocheRepositorio.save(coche1);
		cocheRepositorio.save(coche2);
		
		List<Coche> coches = cocheRepositorio.findAll();
		
		Integer resultadoEsperado = 2;
		
		assertEquals(resultadoEsperado, coches.size(), "Debería haber 2 coches");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Honda")), "No hay Honda");
		assertTrue(coches.stream().anyMatch(c -> c.getMarca().equals("Toyota")), "Debería ser Toyota");
	}
}
