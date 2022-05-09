package pt.c40task.l05wumpus;

public class Montador {

	Caverna caverna;
	int qtdHeroi;
	int qtdWumpus;
	int qtdBuracos;

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
