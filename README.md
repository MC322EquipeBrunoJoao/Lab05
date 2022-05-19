# Lab05
## Destaques

O polimorfismo é utilizado na classe sala, visto que seu construtor recebe um vetor de objetos Componente - cujos elementos podem ser instanciados em qualquer herdeira da classe Componente. É pertinente citar que a adição de novas componentes no jogo se torna mais fácil dessa maneira, pois o comportamento da sala se torna independente do tipo da componente presente no vetor. Contudo, cabe citar que optamos por não incluir instâncias de Heroi no vetor supramencionado, uma vez que o caráter excepcional dessa classe no código (devido ao papel central do herói no jogo) requer a chamada de métodos específicos, que não estão contidos em Componente.  

	public Sala(int x, int y, Componente componentes[]) {

		this.linha = x;
		this.coluna = y;
		this.visitada = false;
		this.componentes = componentes;		
	}

Exploramos o encapsulamento tornando private os atributos das classes utilizadas, além da escrita de métodos de consulta e alteração para todos aqueles cujos valores deveriam ser alterados ou consultados por fora de sua respectiva classe. Dessa maneira, tomamos cuidado para que o comportamento interno de cada classe fosse o mais isolado e independente possível do restante do código. Abaixo, temos alguns dos métodos escritos para a classe Herói que explicitam o uso de encapsulamento.

	public int getScore() {
		return score;
	}
	
	public void addScore(int value) {
		score += value;
	}
	
	public char getTipo() {
		return 'P';
	}
	
	public boolean getCarregandoOuro() {
		return carregandoOuro;
	}
