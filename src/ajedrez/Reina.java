package ajedrez;

public class Reina {

	public int fil;
	public int col;
	public int posLlegada;
	public int []conflictos;
	
	public Reina(int fil, int col)
	{
		this.fil=fil;
		this.col=col;
	}
	
	public Reina(int fil, int col,int posLlegada,int cantidadReinas) {
		this.fil = fil;
		this.col = col;
		this.posLlegada = posLlegada;
		inicializarConflictos(cantidadReinas);
	}	
	
	private void inicializarConflictos(int cantidadReinas){
		conflictos = new int[cantidadReinas+1];
		for (int i=0;i<cantidadReinas+1;i++)
			this.conflictos[i]=0;
	}
}