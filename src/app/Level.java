package app;

public class Level {
	
	private char[][] grid;
	
	public Level(char[][] grid) {
		this.grid = grid;
	}
	
	public void display() {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

}
