package pt.c40task.l05wumpus;

public class Fedor extends Componente {
	
	public Fedor(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna);
	}
	
	public char getTipo() {
		return 'f';
	}
}
