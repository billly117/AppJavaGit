package app;

import java.util.Scanner;

public class Game {

	private Level level;
	
	/**
	 * Initialise une partie avec un niveau
	 * @param level niveau de la partie
	 */
	public Game(Level level) {
		this.level = level;
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
	 * Boucle de jeu
	 */
	public void gameLoop() {
		Scanner sc = new Scanner(System.in);
		
		while(level.getNbCoins() > 0) {
			
			System.out.println("\n Moving (ZQSD)");
			String input = sc.nextLine().toUpperCase();
			Direction dir = directionCast(input);
			
			if(dir == null) {
				System.out.println("Invalid Input. Use Z Q S D");
			}else {
				level.playerMove(dir);
			}
		}
		
		System.out.println("LEVEL COMPLETED");
		
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
	
	
}
