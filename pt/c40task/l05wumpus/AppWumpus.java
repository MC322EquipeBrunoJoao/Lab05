package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida, String arquivoMovimentos) {
      
	  Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
	  String cave[][] = tk.retrieveCave();
      String movements = tk.retrieveMovements();
      
      Montador montador = new Montador();
      montador.montarCaverna(cave); //montarCaverna monta a caverna com base em cave
      
      if (montador.getCavernaMontada()) { //get caverna montada retorna um boolean dizendo se foi possivel montar a caverna ou nao
			
    	  Caverna caverna = montador.getCaverna(); //retonra o objeto caverna criado pelo montador
		  Heroi heroi = caverna.getSala(1,1).getHeroi(); //para pegar o heroi, buscamos a sala 1,1 da caverna e pegamos o componente dela	      
	      
	      Controle controle = new Controle(heroi);
		  tk.writeBoard(caverna.apresenta(), 0, 'x');
		  
		  if (movements == "") { //se nao ha o arquivo de controle de movimentos
			  
			  Scanner keyboard = new Scanner(System.in);
			  controle.setPlayer(keyboard.nextLine());
			  
		      System.out.println("=====");
		      caverna.imprime();
		      System.out.println(controle);
			  
			  while (true) {
				  controle.acaoHeroi(keyboard.nextLine());
				  if (controle.jogoEmAndamento()) {
				      System.out.println("=====");
				      tk.writeBoard(caverna.apresenta(), heroi.getScore(), 'x');
					  caverna.imprime();
					  System.out.println(controle);
				  }
				  else {
					  break;
				  }
			  }
			  
			  keyboard.close();
			  
		  }
		  else {
			  
			  controle.setPlayer("Alcebiades");
		      System.out.println("=====");
		      caverna.imprime();
			  System.out.println(controle);
			  
			  for (int i = 0; i < movements.length(); i++) {
				  controle.acaoHeroi(movements.charAt(i));
				  if (controle.jogoEmAndamento()) {
				      System.out.println("=====");
					  tk.writeBoard(caverna.apresenta(), heroi.getScore(), 'x');
					  caverna.imprime();
					  System.out.println(controle);
				  }
				  else {
					  break;
				  }
			  }
			  
		  }
	      System.out.println("=====");
	      caverna.imprime();
	      System.out.println(controle);
	      if (controle.getStatus() == 'w') {
	    	  System.out.println("Voce ganhou :D !!!");
			  tk.writeBoard(caverna.apresenta(), heroi.getScore(), 'w');
	      }
	      else if (controle.getStatus() == 'n') {
	    	  System.out.println("Voce perdeu :( ...");
	    	  tk.writeBoard(caverna.apresenta(), heroi.getScore(), 'n');
	      }
	      else {
	    	  System.out.println("Volte sempre !");
	      }
		
      }
      else {
    	  System.out.println("Nao foi possivel iniciar o jogo com a caverna fornecida");
      }
      
      tk.stop();
   }

}
