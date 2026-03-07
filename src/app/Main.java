package app;

import java.io.IOException;

/**
 * Classe principale de l'application.
 * Contient le point d'entrée de l'application. * 
 * @author bilal
 * @version 1.0
 */

public class Main {
	
	 /**
     * Constructeur par défaut de la classe Main.
     */
	
	public Main() {
		
	}
	
	/**
     * Point d'entrée de l'application.
     * @param args arguments passés à l'application (non utilisés ici)
     */
	public static void main(String[] args){
		
		System.out.println("World 1 tests : \n");
		
		System.out.println("Created players : " + Player.getCounter());
		
		Player p1 = new Player();
		Player p2 = new Player("Alice");
		Player p3 = new Player("Bob");
		Player p4 = new Player("BOB");
		//Player p5 = p3;
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println();
		
		System.out.println("Player 1's informations:");
		System.out.println("Name : " + p1.getName());
		System.out.println("Score : " + p1.getScore());
		
		System.out.println();
		
		System.out.println("Player 2's informations:");
		System.out.println("Name : " + p2.getName());
		System.out.println("Score : " + p2.getScore());
		
		System.out.println();
		
		p1.updateScore(10);
		p2.updateScore(-5);
		
		System.out.println("Score updates \n");
		
		System.out.println("Player 1's informations:");
		System.out.println("Name : " + p1.getName());
		System.out.println("Score : " + p1.getScore());
		
		System.out.println();
		
		System.out.println("Player 2's informations:");
		System.out.println("Name : " + p2.getName());
		System.out.println("Score : " + p2.getScore());
		
		System.out.println();
		
		System.out.println("Equals's tests:");
		System.out.println("Player Alice equal to the String \"Alice\" : " + p1.equals("Alice"));
		System.out.println("Player Alice equal to player Bob : " + p1.equals(p2));
		System.out.println("Player Bob equal to player BOB : " + p2.equals(p3));
		System.out.println("Player Bob == BOB : " + (p2 == p3));
		System.out.println("Player Bob == reference to Bob : " + (p2 == p4));
		
		System.out.println();
		System.out.println("Created players : " + Player.getCounter());
		p4 = null;
		System.out.println("Created players : " + Player.getCounter());
		
		System.out.println();
		
		System.out.println("World 2 tests : \n");
		
		char[][] grid1 = {
			    {'#','#','#','#','#','#','#','#','#','#'},
			    {'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			    {'#',' ','#','#',' ','#','#',' ',' ','#'},
			    {'#',' ',' ','#',' ',' ','#',' ',' ','#'},
			    {'#','#',' ','#','#',' ','#','#',' ','#'},
			    {'#',' ',' ',' ',' ',' ',' ','#',' ','#'},
			    {'#',' ','#','#','#','#',' ','#',' ','#'},
			    {'#',' ',' ',' ',' ','#',' ',' ',' ','#'},
			    {'#',' ','#','#',' ',' ',' ','#',' ','#'},
			    {'#','#','#','#','#','#','#','#','#','#'}
			};
		
		char[][] grid2 = {
			    {'#','#','#','#','#','#','#','#','#','#'},
			    {'#',' ',' ',' ','#',' ',' ',' ',' ','#'},
			    {'#',' ','#',' ','#',' ','#','#',' ','#'},
			    {'#',' ','#',' ',' ',' ','#',' ',' ','#'},
			    {'#',' ','#','#','#',' ','#',' ','#','#'},
			    {'#',' ',' ',' ','#',' ',' ',' ',' ','#'},
			    {'#','#','#',' ','#','#','#',' ',' ','#'},
			    {'#',' ',' ',' ',' ',' ','#',' ',' ','#'},
			    {'#',' ','#','#','#',' ',' ',' ','#','#'},
			    {'#','#','#','#','#','#','#','#','#','#'}
			};
		
		char[][] grid3 = {
			    {'#','#','#','#','#','#','#','#','#','#'},
			    {'#',' ',' ',' ',' ','#',' ',' ',' ','#'},
			    {'#',' ','#','#',' ','#',' ','#',' ','#'},
			    {'#',' ',' ','#',' ',' ',' ','#',' ','#'},
			    {'#','#',' ','#','#','#',' ','#',' ','#'},
			    {'#',' ',' ',' ',' ','#',' ',' ',' ','#'},
			    {'#',' ','#','#',' ','#','#','#',' ','#'},
			    {'#',' ',' ','#',' ',' ',' ',' ',' ','#'},
			    {'#',' ','#',' ','#','#','#',' ','#','#'},
			    {'#','#','#','#','#','#','#','#','#','#'}
			};
		
		Level level1 = new Level(grid1,p1,1,1);
		Level level2 = new Level(grid2,p2,1,1);
		Level level3 = new Level(grid3,p3,1,1);
		
		System.out.println("Level 1 :");
		level1.display();
		
		System.out.println();
		
		System.out.println("Level 2 :");
		level2.display();
		
		System.out.println();
		
		System.out.println("Level 3 :");
		level3.display();
		
		//Game game1 = new Game(level1);
		//game1.gameLoop();
		
		/*try {
	        Level level4 = new Level("levels/grid1.txt", p1, 1, 1);
	        Game game2 = new Game(level4);
			game2.gameLoop();
	    } catch (IOException e) {
	        System.out.println("Error : file not found");
	        e.printStackTrace();
	    }*/
		
		if(args.length == 0) {
			System.out.println("Usage : java -jar game.jar <fichier_niveau>");
	        return;
		}
		
		String filename = args[0];
		
		Player p6 = new Player("JUL");
		
		try {
	        Level level5 = new Level(filename, p6, 1, 1);
	        Game game3 = new Game(level5);
			game3.gameLoop();
	    } catch (IOException e) {
	        System.out.println("Error : file not found");
	        e.printStackTrace();
	    }
		
	}
}
