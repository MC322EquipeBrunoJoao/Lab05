# Lab05
## Destaques

O polimorfismo é bastante utilizado dentro da sala, visto que a sala recebe no construtor um vetor de componentes, que, fora o heroi, que precisa utilizar métodos dentro da sala, podem ser quaisquer.

	public Sala(int x, int y, Componente componentes[]) {

		this.linha = x;
		this.coluna = y;
		this.visitada = false;
		this.componentes = componentes;		
	}



Neste trecho, pode ser visto que a adição de uma nova componente para a sala é bem fácil, basta chamar o construtor da classe Componente(superclasse), atribuir sua prioridade, e chamar o método para a incluir na posição desejada na caverna. Abaixo está como exemplo a classe Ouro.

	public Componente (int linhaCaverna, int colunaCaverna, Caverna caverna, int prioridade) {
		this.linhaCaverna = linhaCaverna;
		this.colunaCaverna = colunaCaverna;
		this.caverna = caverna;
		this.prioridade = prioridade;
	}
	
	public Ouro(int linhaCaverna, int colunaCaverna, Caverna caverna) {
		super(linhaCaverna, colunaCaverna, caverna, 3);
		caverna.incluirSalaComponente(this, linhaCaverna, colunaCaverna);
	}
