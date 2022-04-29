package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	
	private Random randomGenerator = new Random();
	private int numFlechas = 1;
	private boolean flechaEquipada = false;
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
	
	public void equiparFlecha() {
		if (numFlechas == 1) {
			flechaEquipada = true;
		}
	}
	
	public void desequiparFlecha() {
		if (numFlechas == 1) {
			flechaEquipada = false;
		}
	}
	
	/**
	 * Retorna true se foi possível matar o Wumpus com o estado atual do herói. Caso contrário, retorna false.
	 */
	public boolean atirarFlecha() {
		if (flechaEquipada && randomGenerator.nextBoolean()) { 
			return true;
		}
		else {
			return false;
		}
	}
	
	public void perderFlecha() {
		numFlechas = 0;
	}
	
	public char getTipo() {
		return 'P';
	}
	
	public int getScore() {
		return score;
	}
	
 }
