package pt.c40task.l05wumpus;

public class Sala {

	private int x;
	private int y;
	private Componente componentePrimaria;
	private Componente componentesSecundarias[];
	private boolean visitada;
	private Heroi heroi; // heroi nao podera usar polimorfismo
	
	public Sala(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.visitada = false;
		componentesSecundarias = new Componente[2];
		
	}
	
	
	public boolean conectaComponente(Componente componente) {
		
		if(componente.getTipo() == 'W' || componente.getTipo() == 'B') {
			
			if(componentePrimaria == null) {
				
				this.componentePrimaria = componente;
				return true;
			
			}

			else {
				// erro
				return false;
			}
				
		}
		
		if(componentesSecundarias.length < 2) {
			
			componentesSecundarias[componentesSecundarias
			                       .length] = componente; 
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
	
	public Componente getComponentePrimaria() {
		
		return componentePrimaria;
	}
	
	public Componente[] getComponentesSecundarias() {
		
		return componentesSecundarias;
	}
	
	public void visitar() {
		
		visitada = true;
	}
	
	public boolean jaVisitada() {
		
		return visitada;
				
	}

}
