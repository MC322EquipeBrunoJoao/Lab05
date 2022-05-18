package pt.c40task.l05wumpus;

public class Buraco extends Componente {
	
	public Buraco (int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna, 3);
		if (linhaCaverna < 3) {
			new Brisa(linhaCaverna+1, colunaCaverna, caverna);
		}
		if (linhaCaverna > 0) {
			new Brisa(linhaCaverna-1, colunaCaverna, caverna);
		}
		if (colunaCaverna < 3) {
			new Brisa(linhaCaverna, colunaCaverna+1, caverna);
		}
		if (colunaCaverna > 0) {
			new Brisa(linhaCaverna, colunaCaverna-1, caverna);
		}
	}
	
	public char getTipo() {
		return 'B';
	}

}
