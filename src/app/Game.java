package app;

import java.util.Scanner;

public class Game {

	/*Niveau de la partie*/
	private Level level;
	/*Nom du fichier associé au niveau*/
	private String filename;
	/*Position X de départ*/
	private int startX;
	/*Position Y de départ*/
	private int startY;
	
	/**
	 * Initialise une partie avec un niveau
	 * @param level niveau de la partie
	 */
	public Game(Level level, String filename, int startX, int startY) {
		this.level = level;
		this.filename = filename;
		this.startX = startX;
		this.startY = startY;
	}
	
	/**
	 * Retourne une direction en fonction du caractère entré
	 * @param s caractère à convertir en direction
	 * @return une direction en fonction du caractère entré
	 */
	public Direction directionCast(String s) {
		
		switch(s) {
			case "Z":
				return Direction.UP;
			case "Q":
				return Direction.LEFT;
			case "S":
				return Direction.DOWN;
			case "D":
				return Direction.RIGHT;
			default:
				return null;
				
		}
	}
	
	/**
	 * Fonction pour relancer une partie après un GAME OVER
	 */
	public void reset() {
		try {
	        Player newPlayer = new Player(level.getPlayer().getName());
	        this.level = new Level(this.filename, newPlayer, this.startX, this.startY);
	    } catch (Exception e) {
	        System.err.println("Reboot Error");
	    }
	}
	
	/**
	 * Boucle de jeu
	 */
	public void gameLoop() {
		Scanner sc = new Scanner(System.in);
		level.display();
		
		while(level.getNbCoins() > 0 && level.getPlayer().getNbLives() > 0) {
			
			System.out.println("\n Moving (ZQSD)");
			String input = sc.nextLine().toUpperCase();
			Direction dir = directionCast(input);
			
			if(dir == null) {
				System.out.println("Invalid Input. Use Z Q S D");
			}else {
				level.playerMove(dir);
			}
		}
		
		if(!(level.getNbCoins() > 0)) {
			System.out.println("LEVEL COMPLETED");
		}
		
		if(level.getPlayer().getNbLives() <= 0) {
		    System.out.println("GAME OVER");
		    System.out.println("Restart level ? (Y/N)");

		    String choice = sc.nextLine().toUpperCase();

		    if(choice.equals("Y")) {
		        reset();
		        gameLoop();
		    } else {
		        System.out.println("Goodbye");
		    }
		}
		
	}
	
	/**
	 * Representation textuelle de l'objet Game
	 * @return une chaîne de caractères contenant le niveau de la partie
	 */
	
	@Override
	public String toString() {
		return "Game's level : " + level.toString();
	}
	
	/**
	 * Teste l'égalité entre deux objets
	 * @param obj est l'objet avec lequel on teste l'égalité
	 * @return un booléen vrai si deux parties ont le même niveau faux sinon
	 */
	@Override	
	public boolean equals(Object obj) {
		if(obj instanceof Game && this.level.equals(((Game) obj).level)) {
			return true;
		}return false;
	}
	
	/**
	 * Fonction pour déterminer si il y a GAME OVER
	 * @return true si le nombre de vies du joueur est négatif
	 */
	public boolean isGameOver() {
		return level.getPlayer().getNbLives() <= 0;
	}
	
	
}
