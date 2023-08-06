package uf2181;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO Los test son una copia de los de otro compañero
//TODO Clase creada en el mismo paquete
public class FuncionesDGTTest {
	private static FuncionesDGT funcionesDgt;

	// TODO Bien instanciando el objeto para poder invocar a las funciones
	@BeforeAll
	static void inicializas() {
		funcionesDgt = new FuncionesDGT();
	}
	
	
	// TODO Bien instanciando el objeto para poder invocar a las funciones
	@Test
	void testMediaPuntos() {
		int v[] = {1,2,3};
		assertEquals(2,funcionesDgt.mediaPuntos(v));
		int v0[] = new int[0];
		assertThrows(ArrayIndexOutOfBoundsException.class,()->funcionesDgt.mediaPuntos(v0));
	}
	
	// TODO Método correcto, pero la forma en la que lo invocas es extraña 
	@Test
	void testMaximaTasaPermitida() {
		String tipo;
		boolean aire;
		assertEquals(0.25,funcionesDgt.maximaTasaPermitida(tipo="General",aire=true));
		assertEquals(0.5,funcionesDgt.maximaTasaPermitida(tipo="General",aire=false));
		assertEquals(0.15,funcionesDgt.maximaTasaPermitida(tipo="Novel",aire=true));
		assertEquals(0.3,funcionesDgt.maximaTasaPermitida(tipo="Novel",aire=false));
	}
}
