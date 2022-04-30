package pt.c40task.l05wumpus;

public class Caverna {

	private Sala[][] matrizSalas;
	
	public Caverna(Sala[][] matrizSalas) {
		
		this.matrizSalas = matrizSalas;	
	}

	
	public void incluirSala(Componente componente, int x, int y) {
		
	if(matrizSalas[x][y].conectaComponente(componente)) 
		return;
	
	// Considerar o que acontece se o Componente não conseguir se conectar
		
		
	return;
	
	
	}
	
}
