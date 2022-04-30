package pt.c40task.l05wumpus;

public class Montador {
	
	Caverna caverna;
	

	public Montador() {
		
		Sala[][] matrizSalas = new Sala[4][4];
		
		for(int i=0; i < 4; i++) {
			
			matrizSalas[i] = new Sala[4];
			
			for(int j=0; j < 4; j++) {
				
				matrizSalas[i][j] = new Sala(i, j);
			}
						
		}
		
		
		caverna = new Caverna(matrizSalas);
		
		
	}
	
	public void insereComponente(String posicaoComponente) {
		
		int linhaCaverna = Character.getNumericValue(posicaoComponente.charAt(0));
		int colunaCaverna = Character.getNumericValue(posicaoComponente.charAt(1));
		Componente componente;
		
		if(posicaoComponente.charAt(2) == 'P') {
				
			componente = new Heroi(linhaCaverna, colunaCaverna, caverna);
			return;
			
		}
		
		if(posicaoComponente.charAt(2) == 'W') {
			
			componente = new Wumpus(linhaCaverna, colunaCaverna, caverna);
			return;
			
		}
		
		if(posicaoComponente.charAt(2) == 'B') {
			
			componente = new Buraco(linhaCaverna, colunaCaverna, caverna);
			return;
			
		}
		
		if(posicaoComponente.charAt(2) == 'O') {
			
			componente = new Ouro(linhaCaverna, colunaCaverna, caverna);
			return;
			
		}
		
		
		
		
	}
	
	

}
