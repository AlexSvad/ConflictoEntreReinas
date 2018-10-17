package ajedrez;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Tablero {

	private int cantidadReinas;
	private int tamañoTablero;
	private LinkedList<Reina> listaReinas = new LinkedList<Reina>();

	public void resolver() {

		System.out.println("Reinas en la lista:");
		for (Reina r1 : listaReinas)
			System.out.println("Reina: " + r1.posLlegada + " F:" + r1.fil + " C:" + r1.col);
		
		System.out.println("La lista mide:"+listaReinas.size()+"\n");
		
		int pos = -1;
		int fil,col;
		int cantidadConflictos=0;
		
		for (int j = 0; j < cantidadReinas; j++) {
			cantidadConflictos = 0;
			fil = listaReinas.get(j).fil;
			col = listaReinas.get(j).col;
			Reina reinaAux = new Reina(fil,col);
				
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.fil -= 1;
						reinaAux.col -= 1;
				
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
						if (reinaAux.col <= 0 || reinaAux.fil <= 0 || ban==1) break;
					}
		
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.fil += 1;
						reinaAux.col += 1;
		
						if (reinaAux.col > tamañoTablero || reinaAux.fil > tamañoTablero || ban==1) break;
		
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
					
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.fil -= 1;
						reinaAux.col += 1;
		
						if (reinaAux.col > tamañoTablero || reinaAux.fil <= 0 || ban==1) break;
		
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
					
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.fil += 1;
						reinaAux.col -= 1;
		
						if (reinaAux.col <= 0 || reinaAux.fil > tamañoTablero || ban==1) break;
		
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
					
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.fil += 1;
		
						if (reinaAux.col > tamañoTablero || reinaAux.fil > tamañoTablero || ban==1) break;
		
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
					
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.fil -= 1;
		
						if (reinaAux.col > tamañoTablero || reinaAux.fil <= 0 || ban==1) break;
		
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
					
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.col += 1;
		
						if (reinaAux.col > tamañoTablero || reinaAux.fil > tamañoTablero || ban==1) break;
		
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
					
					reinaAux.col = col;
					reinaAux.fil = fil;
		
					for (int i = 0,ban=0; i < cantidadReinas; i++, pos = -1) {
		
						reinaAux.col -= 1;
		
						if (reinaAux.col <= 0 || reinaAux.fil > tamañoTablero || ban==1) break;
			
						pos = buscarPosEnLista(reinaAux);
						if (pos >= 0) {
							listaReinas.get(j).conflictos[0] = ++cantidadConflictos;
							listaReinas.get(j).conflictos[cantidadConflictos] = (pos+1);
							ban=1;
						}
					}
		}
		for (Reina elemento : listaReinas) {
			System.out.println("Reina: " + elemento.posLlegada + " y su vector de conflictos:");
			for (int k = 0; k < elemento.conflictos.length; k++)
				System.out.print(elemento.conflictos[k] + "|");
			System.out.println("\n");
		}
	}

	private int buscarPosEnLista(Reina reinaAux) {
		
		int pos = -1;
		for (Reina reinaLista : listaReinas) {
			if(reinaAux.fil==reinaLista.fil && reinaAux.col==reinaLista.col)
				pos = reinaLista.posLlegada;
		}
		pos-=1;
		return pos;
	}

	public Tablero(ArrayList<Integer> array) {

		this.tamañoTablero = array.get(0);
		this.cantidadReinas = array.get(1);

		for (int i = 2, j = 1; i < (cantidadReinas * 2 + 2); i++, j++)
			listaReinas.add(new Reina(array.get(i), array.get(++i), j, cantidadReinas));
	}

	public void ordenarConflictosEntreReinas(){
		
		for (Reina reinaLista : listaReinas) {
			Arrays.sort(reinaLista.conflictos, 1,(reinaLista.conflictos[0]+1));
		}
		
		System.out.println("ORDENANDO:");
		for (Reina elemento : listaReinas) {
			System.out.println("Reina: " + elemento.posLlegada + " y su vector de conflictos:");
			for (int k = 0; k < elemento.conflictos.length; k++)
				System.out.print(elemento.conflictos[k] + "|");
			System.out.println("\n");
		}
	}
	
	public LinkedList<Reina> getListaReinas() {
		return listaReinas;
	}
}