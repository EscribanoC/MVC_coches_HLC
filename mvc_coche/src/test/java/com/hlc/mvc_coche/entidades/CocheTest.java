package com.hlc.mvc_coche.entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CocheTest {
	
	private Coche coche;
	@BeforeEach	
	void setup() {
		coche  = new Coche();
	}
	
	@Test
	@DisplayName("Prueba de Getter y Setter de ID")//Nombre del test
	void testSetAndGetId() {
		Long id = 1L;
		coche.setId(1L);
		//El tercer parámetro es el mensaje de error si falla
		assertEquals(id, coche.getId(), "El ID no es el mismo");
	}
	
	@Test
	@DisplayName("Prueba de Getter y setter de Marca")
	void testSetAndGetMarca() {
		String marca = "Honda";
		coche.setMarca(marca);
		assertEquals(marca, coche.getMarca(), "La marca no es la misma");
	}
	
	@Test
	@DisplayName("Prueba de constructor con parámetros")
	void testConstructorConParametros() {
		String marca = "Honda";
		String matricula = "0860DLC";
		String color = "Gris";
		
		Coche coche = new Coche(marca, matricula, color);
		assertEquals(marca, coche.getMarca(), "La marca no es la misma.");
		assertEquals(matricula, coche.getMatricula(), "La matrícula no es la misma.");
		assertEquals(color, coche.getColor(), "El color no es el mismo.");
	}
}
