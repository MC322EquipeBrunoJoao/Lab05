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

				matrizSalas[i][j] = new Sala(i, j, new Componente[1], new Componente[2]);
			}

		}

		caverna = new Caverna(matrizSalas);

	}

	public void montarCaverna(String[][] caverna) {
		
		

		for (String[] stringComponente : caverna) {

			int linha = Character.getNumericValue(stringComponente[0].charAt(0)) - 1;
			int coluna = Character.getNumericValue(stringComponente[1].charAt(0)) - 1;
			char tipo = stringComponente[2].charAt(0);

			insereComponente(linha, coluna, tipo);

		}
		montada = true;

	}

	public Caverna getCaverna() {

		return caverna;
	}

	public boolean getCavernaMontada() {

		return montada;
	}

	public void insereComponente(int linhaCaverna, int colunaCaverna, char tipo) {

		

		if (tipo == 'P') {

			if (qtdHeroi < 1) {
				new Heroi(0, 0, caverna);
				qtdHeroi += 1;
			}
		}

		else if (tipo== 'W') {

			if (qtdWumpus < 1) {

				new Wumpus(linhaCaverna, colunaCaverna, caverna);
				qtdWumpus += 1;
			}
		}

		else if (tipo == 'B') {

			if (qtdBuracos < 3) {

				new Buraco(linhaCaverna, colunaCaverna, caverna);
				qtdBuracos += 1;
			}
		}

		else if (tipo == 'O') {
			

			new Ouro(linhaCaverna, colunaCaverna, caverna);

		}
		

	}

}
