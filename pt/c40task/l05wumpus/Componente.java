package pt.c40task.l05wumpus;

public abstract class Componente {
	
	protected int linhaCaverna, colunaCaverna;
	protected Caverna caverna;
	protected int prioridade;
	
	public Componente() {}
	
	public Componente (int linhaCaverna, int colunaCaverna, Caverna caverna, int prioridade) {
		this.linhaCaverna = linhaCaverna;
		this.colunaCaverna = colunaCaverna;
		this.caverna = caverna;
		this.prioridade = prioridade;
	}
	
	public int getLinha() {
		return linhaCaverna;
	}
	
	public int getColuna() {
		return colunaCaverna;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	
	public abstract char getTipo();
}