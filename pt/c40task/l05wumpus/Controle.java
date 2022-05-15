package pt.c40task.l05wumpus;

public class Controle {
	
	private String player;
	private Heroi heroi;
	private boolean jogoAcabou = false;
	
	public Controle(Heroi heroi) {
		this.heroi = heroi;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public void acaoHeroi(String acao) {
		switch(acao) {
			case "w":
				heroi.moverAcima();
			case "d":
				heroi.moverDireita();
			case "s":
				heroi.moverAbaixo();
			case "a":
				heroi.moverEsquerda();
			case "k":
				heroi.equiparFlecha();
			case "c":
				heroi.capturarOuro();
			case "q":
				if (heroi.getLinha() == 1 && heroi.getColuna() == 1) {
					jogoAcabou = true;
				}
		}
	}
	
	public void acaoHeroi(char acao) {
		switch(acao) {
			case 'w':
				heroi.moverAcima();
			case 'd':
				heroi.moverDireita();
			case 's':
				heroi.moverAbaixo();
			case 'a':
				heroi.moverEsquerda();
			case 'k':
				heroi.equiparFlecha();
			case 'c':
				heroi.capturarOuro();
			case 'q':
				if (heroi.getLinha() == 1 && heroi.getColuna() == 1 && heroi.getMatouWumpus()) {
					jogoAcabou = true;
					if (heroi.getCarregandoOuro()) {
						heroi.addScore(1000);
					}
				}
		}
	}
	
	public boolean jogoEmAndamento() {
		return !jogoAcabou;
	}
	
	public void acabarJogo() {
		jogoAcabou = true;
	}
	
	public String toString() {
		return "Player: " + player + "\nScore: " + heroi.getScore() + "\n";
	}
}
