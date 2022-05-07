package pt.c40task.l05wumpus;

import java.util.Iterator;

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
	
	public void moverJogador(Sala salaSaida, Sala salaChegada) {
		
		
		
		
		
		
	}
	
	public char[][] apresenta(){
		
		char[][] resultado = new char[4][4];
		
		for (int i = 0; i < 4; i++) {
			
			resultado[i] = new char[4];
			
			for (int j = 0; j < 4; j++) {
				
				Sala sala = matrizSalas[i][j];
				Componente componenteP = sala.getComponentePrimaria();
				Componente componentesS[] = sala.getComponentesSecundarias();
				
				
				
				if(sala.jaVisitada()) {
					
					if(componenteP != null) 
						resultado[i][j] = componenteP.getTipo();
					
					else if(componentesS.length > 0) {
						
						for(Componente c : componentesS) {
							
							resultado[i][j] = c.getTipo();
							
							if(c.getTipo() == 'F') {
								resultado[i][j] = 'F';
								break;
							}	
						}	
					}
					
					else
						resultado[i][j] = '#';	
				}
				
				else
					resultado[i][j] = '-';
								
			}
			
		}
		
		return resultado;
			
	}
	
public char[][] apresentaTudo(){ //para testes 
		
		char[][] resultado = new char[4][4];
		
		for (int i = 0; i < 4; i++) {
			
			resultado[i] = new char[4];
			
			for (int j = 0; j < 4; j++) {
				
				Sala sala = matrizSalas[i][j];
				Componente componente = sala.getComponentePrimaria();
					
				if(componente != null) 
						resultado[i][j] = componente.getTipo();
						
				else
					resultado[i][j] = '-';
								
			}
			
		}
		
		return resultado;
			
	}
	
}
