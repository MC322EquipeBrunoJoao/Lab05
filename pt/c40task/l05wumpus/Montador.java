package pt.c40task.l05wumpus;

public class Montador {

	private Caverna caverna;
	private int qtdHeroi;
	private int qtdWumpus;
	private int qtdBuracos;
	private boolean montada = false;

	public Montador() {
		qtdHeroi = 0;
		qtdWumpus = 0;
		qtdBuracos = 0;

		Sala[][] matrizSalas = new Sala[4][4];

		for (int i = 0; i < 4; i++) {

			matrizSalas[i] = new Sala[4];

			for (int j = 0; j < 4; j++) {

				matrizSalas[i][j] = new Sala(i, j);
			}

		}

		caverna = new Caverna(matrizSalas);

	}
	
	public void montarCaverna(String[][] caverna) {
		
		for(String[] stringComponente : caverna) {
			
			int linha = stringComponente[0].charAt(0); 
			int coluna = stringComponente[1].charAt(0);
			
			switch(stringComponente[2].charAt(0)) {
			
				case 'B': Componente buraco = new Buraco(linha, coluna, this.caverna);
						  break;
				
				case 'O': Componente ouro = new Ouro(linha, coluna, this.caverna);
						  break;
						  
				case 'W': Componente wumpus = new Wumpus(linha, coluna, this.caverna);
						  break;
						  
				case 'H': Heroi heroi = new Heroi(linha, coluna, this.caverna);
						  break;
			  
				default: System.out.println("Componente inválida!");
			
		    
			
			
			}
			
			
		}
		
		
		
	}
	
	public Caverna getCaverna() {
		
		return caverna;
	}
	
	public boolean getCavernaMontada() {
		
		return montada;
	}
	
	

	public void insereComponente(String posicaoComponente) {

		int linhaCaverna = Character.getNumericValue(posicaoComponente.charAt(0));
		int colunaCaverna = Character.getNumericValue(posicaoComponente.charAt(1));
		
		
		

		if (posicaoComponente.charAt(2) == 'P') {

			if(qtdHeroi < 1) {
				Heroi heroi = new Heroi(1, 1, caverna);
				qtdHeroi += 1;
			}
		}
		

		if (posicaoComponente.charAt(2) == 'W') {
			
			if(qtdWumpus < 1) {
				
				Componente componente;
				componente = new Wumpus(linhaCaverna, colunaCaverna, caverna);
				qtdWumpus += 1;
			}
		}
		

		if (posicaoComponente.charAt(2) == 'B') {

			if(qtdBuracos < 3) {
				
				Componente componente;
				componente = new Buraco(linhaCaverna, colunaCaverna, caverna);
				qtdBuracos += 1;
			}
		}
		

		if (posicaoComponente.charAt(2) == 'O') {
			Componente componente;

			componente = new Ouro(linhaCaverna, colunaCaverna, caverna);

		}

	}

}
