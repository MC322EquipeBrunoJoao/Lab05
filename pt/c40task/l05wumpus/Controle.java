package pt.c40task.l05wumpus;

public class Controle {
	private Heroi heroi;

	public Controle(Heroi heroi) {
		
		this.heroi = heroi;
		
	}
	
	public void proximoMovimento(char movimento) {
		
		switch(movimento) {
			
			case 'w': 	heroi.moverAcima();
						break;
				
			case 'a':	heroi.moverEsquerda();
						break;
						
			case 's':	heroi.moverAbaixo();
						break;
			
			case 'd':	heroi.moverDireita();
						break;
						
			case 'k':	heroi.equiparFlecha();
						break;
						
			case 'c':	heroi.capturaOuro();
						break;
			
			default:	return;
			
	}

}
