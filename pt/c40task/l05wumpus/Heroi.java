package pt.c40task.l05wumpus;
import java.util.Random;

public class Heroi extends Componente {
	
	private Random randomGenerator = new Random();
	private int numFlechas = 1;
	private boolean flechaEquipada = false;
	private boolean carregandoOuro = false;
	private boolean heroiAtivo = true; //true se o Heroi esta vivo ou livre para se mover
	private boolean matouWumpus = false;
	private int score = 0;
	
	public Heroi(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna);
	}
	
	public void moverAbaixo() {
		if (linhaCaverna < 3) {
			score -= 15;
			linhaCaverna++;
			caverna.moverHeroi(this, linhaCaverna-1, colunaCaverna, linhaCaverna, colunaCaverna);
		}
	}
	
	public void moverAcima() {
		if (linhaCaverna > 0) {
			score -= 15;
			linhaCaverna--;
			caverna.moverHeroi(this, linhaCaverna+1, colunaCaverna, linhaCaverna, colunaCaverna);
		}
	}
	
	public void moverEsquerda() {
		if (colunaCaverna > 0) {
			score -= 15;
			colunaCaverna--;
			caverna.moverHeroi(this, linhaCaverna, colunaCaverna+1, linhaCaverna, colunaCaverna);
		}
	}
	
	public void moverDireita() {
		if (colunaCaverna < 3) {
			score -= 15;
			colunaCaverna++;
			caverna.moverHeroi(this, linhaCaverna, colunaCaverna-1, linhaCaverna, colunaCaverna);
		}
	}
	
	public void addScore(int value) {
		score += value;
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
	 * Retorna true se foi possivel matar o Wumpus com o estado atual do heroi. Caso contrario, retorna false.
	 */
	public void atirarFlecha() {
		if (flechaEquipada && randomGenerator.nextBoolean()) {
			score += 500;
			matouWumpus = true;
		}
		else {
			score -= 1000;
			heroiAtivo = false;
		}
	}
	
	public void perderFlecha() {
		if (numFlechas == 1) {
			score -= 100;
			numFlechas = 0;
		}
	}
	
	public void cairNoBuraco() {
		score -= 1000;
		heroiAtivo = false;
	}
	
	public int getScore() {
		return score;
	}
	
	public char getTipo() {
		return 'P';
	}
	
	public boolean getCarregandoOuro() {
		return carregandoOuro;
	}
	
	public boolean getHeroiAtivo() {
		return heroiAtivo;
	}
	
	public boolean getFlechaEquipada() {
		return flechaEquipada;
	}
	
	public boolean getMatouWumpus() {
		return matouWumpus;
	}
	
 }
