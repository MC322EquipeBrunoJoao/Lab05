package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	
	private Random randomGenerator = new Random();
	private int numFlechas = 1;
	private boolean flechaEquipada = false;
	private boolean carregandoOuro = false;
	private boolean matouWumpus = false;
	private int score = 0;
	
	public Heroi(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna);
	}
	
	public void moverAbaixo() {
		if (linhaCaverna < 3) {
			linhaCaverna++;
		}
	}
	
	public void moverAcima() {
		if (linhaCaverna > 0) {
			linhaCaverna--;
		}
	}
	
	public void moverEsquerda() {
		if (colunaCaverna > 0) {
			colunaCaverna--;
		}
	}
	
	public void moverDireita() {
		if (colunaCaverna < 3) {
			colunaCaverna++;
		}
	}
	
	public void addScore(int value) {
		score += value;
	}
	
	public int getScore() {
		return score;
	}
	
	public void capturarOuro() {
		if (caverna.getSala(linhaCaverna, colunaCaverna).temOuro()) {
			carregandoOuro = true;
			caverna.getSala(linhaCaverna, colunaCaverna).desconectaComponente('O'); //desconecta o componente de tipo "O" da sala
		}
	}
	
	public void equiparFlecha() {
		if (numFlechas == 1) {
			flechaEquipada = !flechaEquipada;
		}
	}
	
	/**
	 * Retorna true se foi poss�vel matar o Wumpus com o estado atual do her�i. Caso contr�rio, retorna false.
	 */
	public void atirarFlecha() {
		if (flechaEquipada && randomGenerator.nextBoolean()) { 
			matouWumpus = true;
		}
		else {
			matouWumpus = false;
		}
	}
	
	public void perderFlecha() {
		numFlechas = 0;
	}
	
	public char getTipo() {
		return 'P';
	}
	
	public boolean getCarregandoOuro() {
		return carregandoOuro;
	}
	
	public boolean getMatouWumpus() {
		return matouWumpus;
	}
	
 }
