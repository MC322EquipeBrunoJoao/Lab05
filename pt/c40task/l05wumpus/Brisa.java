package pt.c40task.l05wumpus;

public class Brisa extends Componente {
	
	public Brisa(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna, 0);
	}
	
	public char getTipo() {
		return 'b';
	}
}