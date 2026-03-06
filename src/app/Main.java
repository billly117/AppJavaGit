package app;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("World 1 tests : \n");
		
		System.out.println("Created players : " + Player.getCounter());
		
		Player p1 = new Player();
		Player p2 = new Player("Alice");
		Player p3 = new Player("Bob");
		Player p4 = new Player("BOB");
		Player p5 = p3;
		
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
		level3.playerMove(Direction.UP);
		level3.playerMove(Direction.RIGHT);
		level3.playerMove(Direction.RIGHT);
		level3.playerMove(Direction.DOWN);
		level3.display();
	}
}
