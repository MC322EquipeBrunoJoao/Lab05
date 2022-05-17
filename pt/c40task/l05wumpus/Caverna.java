package pt.c40task.l05wumpus;

public class Caverna {

	private Sala[][] matrizSalas;

	public Caverna(Sala[][] matrizSalas) {

		this.matrizSalas = matrizSalas;
	}
	
	public void incluirSalaHeroi(Heroi heroi, int x, int y) {
		
		matrizSalas[x][y].conectaHeroi(heroi);
		
		
	}

	public void incluirSalaComponente(Componente componente, int x, int y) {

		if (matrizSalas[x][y].conectaComponente(componente))
			return;

		// Considerar o que acontece se o Componente não conseguir se conectar
		System.out.println("O componente nao pode se conectar!"
				+ "x: " + x + "y: " + y + "Tipo: " + componente.getTipo());
		

	}

	public void moverJogador(Sala salaSaida, Sala salaChegada) {

	}

	public char[][] apresenta() {

		char[][] resultado = new char[4][4];

		for (int i = 0; i < 4; i++) {

			resultado[i] = new char[4];

			for (int j = 0; j < 4; j++) {

				Sala sala = matrizSalas[i][j];
				Heroi heroi  = sala.getHeroi();
				Componente componenteP = sala.getComponentePrimaria();
				Componente componentesS[] = sala.getComponentesSecundarias();

				if (sala.jaVisitada()) {
					
					if(heroi != null) {
						resultado[i][j] = 'P';
					}

					else if (componenteP != null)
						resultado[i][j] = componenteP.getTipo();

					else if (componentesS.length > 0) {

						for (Componente c : componentesS) {

							resultado[i][j] = c.getTipo();

							if (c.getTipo() == 'F') {
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

	public char[][] apresentaTudo() { // para testes

		char[][] resultado = new char[4][4];

		for (int i = 0; i < 4; i++) {

			resultado[i] = new char[4];

			for (int j = 0; j < 4; j++) {

				Sala sala = matrizSalas[i][j];
				Componente componente = sala.getComponentePrimaria();

				if (componente != null)
					resultado[i][j] = componente.getTipo();

				else
					resultado[i][j] = '-';

			}

		}

		return resultado;

	}

	public Sala getSala(int linha, int coluna) {

		return matrizSalas[linha - 1][coluna - 1];

	}

	public void moverHeroi(Heroi heroi, int linhaSaida, int colunaSaida, int linhaChegada, int colunaChegada) {

		matrizSalas[linhaSaida][colunaSaida].desconectaComponente('H');

		matrizSalas[linhaChegada][colunaChegada].conectaHeroi(heroi);

		matrizSalas[linhaChegada][colunaChegada].Verifica();

	}
	
	public void imprime() {
		char apresentacao[][] = this.apresenta();
		
		for(int i=0; i < 4; i++) {
	    	  
	    	  for(int j=0; j < 4; j++) {
	    		  System.out.print(apresentacao[i][j]);
	    	  }
	    	  System.out.print("\n");
	    	  
	    	  
	      }
		
		
	}

}
