package pt.c40task.l05wumpus;

public class Ouro extends Componente {
	private int prioridade = 3;
	
	public Ouro(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna, 3);
	}
	
	public char getTipo() {
		return 'O';
	}

}
