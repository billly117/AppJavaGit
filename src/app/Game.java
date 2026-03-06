package app;

import java.util.Scanner;

public class Game {

	private Level level;
	
	public Game(Level level) {
		this.level = level;
	}
	
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
	
	public void gameLoop() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("\n Moving (ZQSD)");
			String input = sc.nextLine().toUpperCase();
			Direction dir = directionCast(input);
			
			if(dir == null) {
				System.out.println("Invalid Input. Use Z Q S D");
			}else {
				level.playerMove(dir);
			}
		}
		
	}
}
