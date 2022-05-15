package pt.c40task.l05wumpus;

public class Sala {

	private int linha;
	private int coluna;
	private Componente componentePrimaria;
	private Componente componentesSecundarias[];
	private boolean visitada;
	private Heroi heroi;

	
	
	public Sala(int x, int y) {
		
		this.linha = x;
		this.coluna = y;
		this.visitada = false;
		componentesSecundarias = new Componente[2];
		
	}
	
	public void conectaHeroi(Heroi heroi) {
		this.heroi = heroi;
		
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
	
	
	public int getLinha() {
		
		return linha;	
	}
	
	
	public int getColuna() {
		
		return coluna;	
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
				
				System.out.println("Não há heroi nessa sala!");
				return;
			}
			
			heroi = null;
			return;
			
		}
		
		if(tipo == 'O' || tipo == 'W' || tipo == 'B') {
			
			if(componentePrimaria.getTipo() != tipo) {
				
				System.out.println("Não há esta componente nesta sala!");
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
			
			System.out.println("Não há esta componente nesta sala!");
		
		}
			
	}
	
	public void Verifica() {
		
		boolean flechaEquipada = heroi.getFlechaEquipada();
		
		switch(this.componentePrimaria.getTipo()) {
		
		case 'B':
			if(flechaEquipada)
				heroi.perderFlecha();
			
			heroi.cairNoBuraco();
			return;
		
		case 'O':
			if(flechaEquipada)
				heroi.perderFlecha();
			
			heroi.capturarOuro();
			return;
			
		case 'W':
			heroi.atirarFlecha();			
			return;
		
		default:
			if(flechaEquipada)
				heroi.perderFlecha();
			
			
		}
		
		
	}

}
