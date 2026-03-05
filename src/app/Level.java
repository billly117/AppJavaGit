package app;

public class Level {
	
	private char[][] grid;
	private final Player player;
	
	public Level(char[][] grid, Player player, int x, int y) {
		
		if(player==null) {
			throw new IllegalArgumentException("A level must have a player");
		}
		this.grid = grid;
		this.player = player;
		
		if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == '#') {
			throw new IllegalArgumentException("Impossible placement");
		}else {
			player.setPosX(x);
			player.setPosY(y);
		}
		
	}
	
	public void display() {
		System.out.println("Player : " + player.getName()+ ". Position : (" + player.getPosX()  + "," + player.getposY() +").");
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length;j++) {
				if(i == player.getPosX() && j == player.getposY()) {
					System.out.print('1');
				}else {
					System.out.print(grid[i][j]);
				}				
			}
			System.out.println();
		}
	}

}
