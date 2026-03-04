package app;

public class Main {
	public static void main(String[] args) {
		
		Player p1 = new Player("Alice");
		Player p2 = new Player("Bob");
		
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
	}
}
