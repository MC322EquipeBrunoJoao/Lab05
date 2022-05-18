package pt.c40task.l05wumpus;

public class Sala {

	private int linha;
	private int coluna;
	private Componente componentesPrimarias[];
	private int qtdComponentesPrimarias;
	private Componente componentesSecundarias[];
	private int qtdComponentesSecundarias;
	private boolean visitada;
	private Heroi heroi;

	public Sala(int x, int y, Componente componentesPrimarias[], Componente componentesSecundarias[]) {

		this.linha = x;
		this.coluna = y;
		this.visitada = false;
		this.componentesPrimarias = componentesPrimarias;
		this.componentesSecundarias = componentesSecundarias;
		qtdComponentesSecundarias = 0;

	}

	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
		visitada = true;

	}

	public boolean conectaComponente(Componente componente) {

		if (componente.getPrioridade() > 2 && qtdComponentesPrimarias < 1) {

			this.componentesPrimarias[qtdComponentesPrimarias] = componente;
			qtdComponentesPrimarias += 1;
			return true;

		}

		else if (qtdComponentesSecundarias < 2) {

			componentesSecundarias[qtdComponentesSecundarias] = componente;
			qtdComponentesSecundarias += 1;
			return true;
		}

		return false;

	}

	public Componente getComponenteMaiorPrioridade() {

		Componente resultado = null;
		int prioridadeMax = -1;
		if (this.heroi != null) {

			resultado = heroi;
			prioridadeMax = heroi.getPrioridade();

		}

		for (int i = 0; i < componentesPrimarias.length; i++) {

			if (componentesPrimarias[i] != null && componentesPrimarias[i].getPrioridade() > prioridadeMax) {

				prioridadeMax = componentesPrimarias[i].getPrioridade();
				resultado = componentesPrimarias[i];
			}

		}

		for (int i = 0; i < componentesSecundarias.length; i++) {

			if (componentesSecundarias[i] != null && componentesSecundarias[i].getPrioridade() > prioridadeMax) {

				prioridadeMax = componentesSecundarias[i].getPrioridade();
				resultado = componentesSecundarias[i];
			}

		}

		return resultado;

	}

	public int getLinha() {

		return linha;
	}

	public int getColuna() {

		return coluna;
	}

	public Componente getComponentePrimaria() {

		return componentesPrimarias[0];
	}

	public Componente[] getComponentesSecundarias() {

		return componentesSecundarias;
	}

	public Heroi getHeroi() {

		return heroi;

	}

	public void visitar() {

		visitada = true;
	}

	public boolean jaVisitada() {

		return visitada;

	}

	public boolean temOuro() {


		if (this.getComponenteMaiorPrioridade().getTipo() == 'O')
			return true;

		return false;

	}

	public void desconectaComponente(char tipo) {

		if (tipo == 'H') {
			if (heroi == null) {

				System.out.println("N�o h� heroi nessa sala!");
				return;
			}

			heroi = null;
			return;

		}

		for (int i = 0; i < qtdComponentesPrimarias; i++) {
			if (tipo == 'O' || tipo == 'W' || tipo == 'B') {

				if (componentesPrimarias[i].getTipo() == tipo) {

					componentesPrimarias[i] = null;
					return;

				}
			}
		}	
				
		for (int i = 0; i < qtdComponentesSecundarias; i++) {

			if (componentesSecundarias[i] != null &&  componentesSecundarias[i].getTipo() == tipo) {

				componentesSecundarias[i] = null;
				return;
			}

			System.out.println("N�o h� esta componente nesta sala!");

		}

	}

	public void Verifica() {

		boolean flechaEquipada = heroi.getFlechaEquipada();

		if (this.componentesPrimarias[0] != null) {
			switch (this.componentesPrimarias[0].getTipo()) {

			case 'B':
				if (flechaEquipada)
					heroi.perderFlecha();

				heroi.cairNoBuraco();
				return;

			//case 'O':
			//	if (flechaEquipada)
			//		heroi.perderFlecha();
//
//				heroi.capturarOuro();
				//return;

			case 'W':
				heroi.atirarFlecha();
				return;

			default:
				if (flechaEquipada)
					heroi.perderFlecha();

			}

		}
	}

}
