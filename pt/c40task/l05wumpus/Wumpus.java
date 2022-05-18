package pt.c40task.l05wumpus;

public class Wumpus extends Componente {
	
	public Wumpus(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		
		super(linhaCaverna, colunaCaverna, caverna, 3);
		caverna.incluirSalaComponente(this, linhaCaverna, colunaCaverna);
		if (linhaCaverna < 3) {
			new Fedor(linhaCaverna+1, colunaCaverna, caverna);
		}
		if (linhaCaverna > 0) {
			new Fedor(linhaCaverna-1, colunaCaverna, caverna);
		}
		if (colunaCaverna < 3) {
			new Fedor(linhaCaverna, colunaCaverna+1, caverna);
		}
		if (colunaCaverna > 0) {
			new Fedor(linhaCaverna, colunaCaverna-1, caverna);
		}
	}
	
	public char getTipo() {
		return 'W';
	}
}
