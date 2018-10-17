package ajedrez;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ArchivoTablero {

	static public ArrayList<Integer> leer(String path) throws IOException {

		File archivo = new File("" + path);
		Scanner sc = new Scanner(archivo);
		sc.useLocale(Locale.ENGLISH);

		int i, tamañoTablero = sc.nextInt(), cantidadReinas = sc.nextInt();
		sc.nextLine();
		
		ArrayList<Integer> vecTableroYcantidadConReinas = new ArrayList<Integer>();
				
		vecTableroYcantidadConReinas.add(0,tamañoTablero);
		vecTableroYcantidadConReinas.add(1,cantidadReinas);

		for (i = 2; i < (cantidadReinas*2)+2; i++)
			vecTableroYcantidadConReinas.add(i,sc.nextInt());

		sc.close();
		return vecTableroYcantidadConReinas;
	}

	static public void escribir(Tablero tablero) throws IOException {
		
		String pathSalida = "reinas.out";
		PrintWriter salida = new PrintWriter(new FileWriter("" + pathSalida));
		
		for (Reina reinaLista : tablero.getListaReinas()) {
			for(int i=0;i<=reinaLista.conflictos[0];i++)
				salida.print(reinaLista.conflictos[i]+" ");
			salida.println("");
		}
		salida.close();
	}
}
