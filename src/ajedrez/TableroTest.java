package ajedrez;

import java.io.IOException;

import org.junit.Test;

public class TableroTest {

	@Test
	public void probarResolver() throws IOException{

		//Tablero tab1 = new Tablero(ArchivoTablero.leer("reinas.in"));
		Tablero tab1 = new Tablero(ArchivoTablero.leer("reinas2.in"));
		tab1.resolver();
		tab1.ordenarConflictosEntreReinas();
		ArchivoTablero.escribir(tab1);
	}
	
}
