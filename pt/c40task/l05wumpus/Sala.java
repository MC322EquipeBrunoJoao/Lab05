package pt.c40task.l05wumpus;

public class Sala {

	private int linha;
	private int coluna;
	private Componente componentePrimaria;
	private Componente componentesSecundarias[];
	private int qtdComponentesSecundarias;
	private boolean visitada;
	private Heroi heroi;

	public Sala(int x, int y) {

		this.linha = x;
		this.coluna = y;
		this.visitada = false;
		componentesSecundarias = new Componente[2];
		qtdComponentesSecundarias = 0;

	}

	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
		visitada = true;

	}

	public boolean conectaComponente(Componente componente) {

		if (componente.getTipo() == 'W' || componente.getTipo() == 'B' || componente.getTipo() == 'O') {

			if (componentePrimaria == null) {

				this.componentePrimaria = componente;
				return true;

			}

			else {
				// erro
				return false;
			}

		}

		if (qtdComponentesSecundarias < 2) {

			componentesSecundarias[qtdComponentesSecundarias] = componente;
			qtdComponentesSecundarias += 1;
			return true;
		}

		return false;

	}

	public int getLinha() {

		return linha;
	}

	public int getColuna() {

		return coluna;
	}

	public Componente getComponentePrimaria() {

		return componentePrimaria;
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

		if (componentePrimaria != null && componentePrimaria.getTipo() == 'O')
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

		if (tipo == 'O' || tipo == 'W' || tipo == 'B') {

			if (componentePrimaria != null && componentePrimaria.getTipo() != tipo) {

				System.out.println("N�o h� esta componente nesta sala!");
				return;

			}

			componentePrimaria = null;
			return;

		}

		for (int i = 0; i < 2; i++) {

			if (componentesSecundarias[i] != null &&  componentesSecundarias[i].getTipo() == tipo) {

				componentesSecundarias[i] = null;
				return;
			}

			System.out.println("N�o h� esta componente nesta sala!");

		}

	}

	public void Verifica() {

		boolean flechaEquipada = heroi.getFlechaEquipada();

		if (this.componentePrimaria != null) {
			switch (this.componentePrimaria.getTipo()) {

			case 'B':
				if (flechaEquipada)
					heroi.perderFlecha();

				heroi.cairNoBuraco();
				return;

			case 'O':
				if (flechaEquipada)
					heroi.perderFlecha();

				heroi.capturarOuro();
				return;

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
