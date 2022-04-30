package pt.c40task.l05wumpus;

public class Sala {

	private int x;
	private int y;
	private Componente componente;
	
	public Sala(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	
	public boolean conectaComponente(Componente componente) {
		
		if(componente == null) {
			
			this.componente = componente;
			return true;
		}
		
		return false;	
		
	}
	
	
	public int getX() {
		
		return x;	
	}
	
	
	public int getY() {
		
		return y;	
	}
	
	public Componente getComponente() {
		
		return componente;
	}

}
