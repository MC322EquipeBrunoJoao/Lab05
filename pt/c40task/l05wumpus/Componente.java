package pt.c40task.l05wumpus;

public abstract class Componente {
	
	protected int linhaCaverna, colunaCaverna;
	private Caverna caverna;
	
	public Componente (int linhaCaverna, int colunaCaverna, Caverna caverna) {
		this.linhaCaverna = linhaCaverna;
		this.colunaCaverna = colunaCaverna;
		this.caverna = caverna;
		caverna.incluirSala(this, linhaCaverna, colunaCaverna);
	}
	
	public int getLinha() {
		return linhaCaverna;
	}
	
	public int getColuna() {
		return colunaCaverna;
	}
	
	public abstract char getTipo();
}