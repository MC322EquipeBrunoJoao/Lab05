package pt.c40task.l05wumpus;

public class Sala {

	private int x;
	private int y;
	private Componente componentePrimaria;
	private Componente componentesSecundarias[];
	private boolean visitada;
	private Heroi heroi;
	
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
	
	public Heroi getHeroi() {
		
		return heroi;
		
	}
	
	public void visitar() {
		
		visitada = true;
	}
	
	public boolean jaVisitada() {
		
		return visitada;
				
	}
	
	public boolean temOuro() {
		
		if(componentePrimaria.getTipo() == 'O')
			return true;
		
		return false;
			
	}
	
	public void desconectaComponente(char tipo) {
		
		if(tipo == 'H') {
			if(heroi == null) {
				
				System.out.println("N�o h� heroi nessa sala!");
				return;
			}
			
			heroi = null;
			return;
			
		}
		
		if(tipo == 'O' || tipo == 'W' || tipo == 'B') {
			
			if(componentePrimaria.getTipo() != tipo) {
				
				System.out.println("N�o h� esta componente nesta sala!");
				return;
				
			}
			
			componentePrimaria = null;
			return;
			
		}
			
		
			
		for(int i = 0; i < 2; i++) {
			
			if(componentesSecundarias[i].getTipo() == tipo) {
				
				componentesSecundarias[i] = null;
				return;
			}
			
			System.out.println("N�o h� esta componente nesta sala!");
		
		}
			
	}

}
