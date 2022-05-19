package pt.c40task.l05wumpus;

public class Fedor extends Componente {
	
	public Fedor(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna, 1);
		caverna.incluirSalaComponente(this, linhaCaverna, colunaCaverna);
	}
	
	public char getTipo() {
		return 'f';
	}
}
