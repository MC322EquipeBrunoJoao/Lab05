package pt.c40task.l05wumpus;

public class Controle {
	
	private String player;
	private Heroi heroi;
	private boolean jogoAcabou = false;
	private char status;
	
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
				break;
			case "d":
				heroi.moverDireita();
				break;
			case "s":
				heroi.moverAbaixo();
				break;
			case "a":
				heroi.moverEsquerda();
				break;
			case "k":
				heroi.equiparFlecha();
				break;
			case "c":
				heroi.capturarOuro();
				break;
			case "q":
				status = 'q';
				jogoAcabou = true;
			default:
				System.out.println("Comando de ação inválido, tente novamente");
		}
		if (heroi.getLinha() == 0 && heroi.getColuna() == 0 && heroi.getCarregandoOuro()) {
			jogoAcabou = true;
			heroi.addScore(1000);
			status = 'W';
		}
		if (!heroi.getHeroiAtivo()) {
			status = 'L';
			jogoAcabou = true;
		}
	}
	
	public void acaoHeroi(char acao) {
		switch(acao) {
			case 'w':
				heroi.moverAcima();
				break;
			case 'd':
				heroi.moverDireita();
				break;
			case 's':
				heroi.moverAbaixo();
				break;
			case 'a':
				heroi.moverEsquerda();
				break;
			case 'k':
				heroi.equiparFlecha();
				break;
			case 'c':
				heroi.capturarOuro();
				break;
			case 'q':
				status = 'q';
				jogoAcabou = true;
			default:
				System.out.println("Comando de ação inválido, tente novamente");
		}
		if (heroi.getLinha() == 0 && heroi.getColuna() == 0 && heroi.getCarregandoOuro()) {
			jogoAcabou = true;
			heroi.addScore(1000);
			status = 'W';
		}
		if (!heroi.getHeroiAtivo()) {
			status = 'L';
			jogoAcabou = true;
		}
	}
	
	public boolean jogoEmAndamento() {
		return !jogoAcabou;
	}
	
	public void acabarJogo() {
		jogoAcabou = true;
	}
	
	public char getStatus() {
		return status;
	}
	
	public String toString() {
		return "Player: " + player + "\nScore: " + heroi.getScore();
	}
}
