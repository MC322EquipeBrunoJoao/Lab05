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
			  
			  while (controle.jogoEmAndamento()) {
				  controle.acaoHeroi(keyboard.nextLine());
			      System.out.println("=====");
			      tk.writeBoard(caverna.apresenta(), heroi.getScore(), 'x');
				  caverna.imprime();
				  System.out.println(controle);
			  }
			  
			  keyboard.close();
			  
		  }
		  else {
			  
			  controle.setPlayer("Alcebiades");
		      System.out.println("=====");
		      caverna.imprime();
			  System.out.println(controle);
		      
			  
			  for (int i = 0; i < movements.length(); i++) {
				  if (controle.jogoEmAndamento()) {
				      System.out.println("=====");
					  controle.acaoHeroi(movements.charAt(i));
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
		  tk.writeBoard(caverna.apresenta(), heroi.getScore(), 'x');
		
      }
      else {
    	  System.out.println("Nao foi possivel iniciar o jogo com a caverna fornecida");
      }
      
/*      System.out.println("=== Caverna");
      for (int l = 0; l < cave.length; l++) {
         for (int c = 0; c < cave[l].length; c++)
            System.out.print(cave[l][c] + ((c < cave[l].length-1) ? ", " : ""));
         System.out.println();
      }
      
      System.out.println("=== Movimentos");
      System.out.println(movements);
      
      System.out.println("=== Caverna Intermediaria");
      char partialCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '-', '-'},
         {'b', '-', '-', '-'},
         {'p', '-', '-', '-'}
      };
      int score = -120;
      char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(partialCave, score, status);

      System.out.println("=== Última Caverna");
      char finalCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '#', 'f'},
         {'b', '-', '-', 'w'},
         {'#', '-', '-', '-'}
      };
      score = -1210;
      status = 'n'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(finalCave, score, status);
*/      
      //teste
      tk.stop();
   }

}
