package pt.c40task.l05wumpus;

public class Sala {

	private int linha;
	private int coluna;
	private Componente componentes[];
	private int qtdComponentes;
	private boolean visitada;
	private Heroi heroi;

	public Sala(int x, int y, Componente componentes[]) {

		this.linha = x;
		this.coluna = y;
		this.visitada = false;
		this.componentes = componentes;
			
	}
	
	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
		visitada = true;

	}

	public boolean conectaComponente(Componente componente) {

		if (qtdComponentes < componentes.length) {

			this.componentes[qtdComponentes] = componente;
			qtdComponentes += 1;
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

		for (int i = 0; i < componentes.length; i++) {

			if (componentes[i] != null && componentes[i].getPrioridade() > prioridadeMax) {

				prioridadeMax = componentes[i].getPrioridade();
				resultado = componentes[i];
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

		return componentes[0];
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

		for (int i = 0; i < qtdComponentes; i++) {
			if (tipo == 'O' || tipo == 'W' || tipo == 'B') {

				if (componentes[i].getTipo() == tipo) {

					componentes[i] = null;
					return;

				}
			}
		}	

	}

	public void Verifica() {

		boolean flechaEquipada = heroi.getFlechaEquipada();

		if (this.componentes[0] != null) {
			switch (this.componentes[0].getTipo()) {

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
