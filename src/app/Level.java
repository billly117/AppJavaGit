package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Level {
	
	private char[][] grid;
	private final Player player;
	
	public Level(String filename, Player player, int x, int y) throws IOException{
		List<String> rows;
		
		try {
			rows = Files.readAllLines(Paths.get(filename));
		}catch(Exception e) {
			System.err.println("Error : fichier \"" + filename + "\" not found.");
	        throw e;
		}
		
		grid = new char[rows.size()][rows.get(0).length()];
		
		for(int i = 0; i<rows.size(); i++) {
			for(int j = 0; j<rows.get(i).length(); j++) {
				grid[i][j] = rows.get(i).charAt(j);
			}
		}
		
		if(player == null) {
			throw new IllegalArgumentException("A level must have a player");
		}
		this.player = player;
		
		if(!(validPosition(x,y))) {
			throw new IllegalArgumentException("Impossible placement");
		}else {
			player.setPosX(x);
			player.setPosY(y);
		}
	}

	
	public Level(char[][] grid, Player player, int x, int y) {
		
		if(player==null) {
			throw new IllegalArgumentException("A level must have a player");
		}
		this.grid = grid;
		this.player = player;
		
		if(!(validPosition(x,y))) {
			throw new IllegalArgumentException("Impossible placement");
		}else {
			player.setPosX(x);
			player.setPosY(y);
		}
		
	}
	
	public boolean validPosition(int x,int y) {
		return (!(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == '#'));
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
	
	public void playerMove(Direction dir) {
		int x = player.getPosX();
		int y = player.getposY();
		
		switch(dir) {
			case UP: 
				x -= 1;
				break;
			case LEFT:
				y -= 1;
				break;
			case DOWN:
				x += 1;
				break;
			case RIGHT:
				y += 1;
				break;
		}
		
		if(validPosition(x,y)) {
			player.setPosX(x);
			player.setPosY(y);
		}
		
		display();
	}
	
	

}
