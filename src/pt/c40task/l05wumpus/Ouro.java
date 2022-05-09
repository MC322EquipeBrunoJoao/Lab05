package pt.c40task.l05wumpus;

public class Ouro extends Componente {
	
	public Ouro(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna);
	}
	
	public char getTipo() {
		return 'O';
	}

}
