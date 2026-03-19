package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Représente un niveau
 *
 * @author bilal
 * @version 1.0
 */

public class Level {
	
	private Cell[][] grid;
	private final Player player;
	private int nbCoins = 0;
	
	/**
	 * Initialise un niveau à partir d'un fichier texte pour la gille, un joueur et sa position initiale
	 * @param filename chemin du fichier de la grille
	 * @param player joueur
	 * @param x position x initiale du joueur
	 * @param y position y initiale du joueur
	 * @throws IOException exception
	 */
	public Level(String filename, Player player, int x, int y) throws IOException{
		List<String> rows;
		
		try {
			rows = Files.readAllLines(Paths.get(filename));
		}catch(Exception e) {
			System.err.println("Error : fichier \"" + filename + "\" not found.");
	        throw e;
		}
		
		grid = new Cell[rows.size()][rows.get(0).length()];
		
		for(int i = 0; i<rows.size(); i++) {
			for(int j = 0; j<rows.get(i).length(); j++){
				char c = rows.get(i).charAt(j);
				boolean hasCoin = false;
				CellType type = CellType.EMPTY;
				
				switch(c) {
				case '#':
					type = CellType.WALL;
					break;
					
				case '*':
					type = CellType.TRAPPED;
					break;
				case 'D':
					type = CellType.LOCKED;
					break;
				case '.':
					hasCoin = true;
					nbCoins ++;
				}
				
				grid[i][j] = new Cell(i,j,hasCoin,type);
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
			
			player.setPosXInit(x);
			player.setPosYInit(y);
		}
	}
	
	/**
	 * Retourne le nombre de pièce dans le niveau
	 * @return lle nombre de pièce dans le niveau
	 */
	public int getNbCoins(){
		return this.nbCoins;
	}
	
	
	/**
	 * Retourne le joueur du niveau
	 * @return le joueur du niveau
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Retourne un booléen si la position est valide (dans la grille et espace vide)
	 * @param x position x
	 * @param y position y
	 * @return un booléen si la position est valide (dans la grille et espace vide)
	 */
	public boolean validPosition(int x,int y) {
		return (!(x<0 || y<0 || x>=grid.length || y>=grid[0].length || !grid[x][y].getThroughable()));
	}
	
	/**
	 * Affiche la grille dans la console
	 */
	public void display() {
		System.out.println("Player : " + player.getName()+ ". Position : (" + player.getPosX()  + "," + player.getposY() +"). Score : " + player.getScore() + ". Reamining coins : " + nbCoins + ". Lives : " + player.getNbLives());
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length;j++) {				
				
				if(i == player.getPosX() && j == player.getposY()) {
		            System.out.print('1');
		        }
		        else {

		            Cell cell = grid[i][j];

		            if(cell.getType() == CellType.WALL) {
		                System.out.print('#');
		            }
		            else if(cell.getType() == CellType.TRAPPED) {
		                System.out.print('*');
		            }
		            else if(cell.getType() == CellType.LOCKED) {
		            	System.out.print('D');
		            }
		            else if(cell.getHasCoin()) {
		                System.out.print('.');
		            }
		            else {
		                System.out.print(' ');
		            }
		        }
			}
			System.out.println();
		}
	}
	
	/**
	 * Déplace le joueur dans la grille
	 * @param dir Direction du déplacement du joueur
	 */
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
			
			if(grid[player.getPosX()][player.getposY()].getHasCoin()) {
				player.updateScore(10);
				grid[player.getPosX()][player.getposY()].setHasCoin(false);;
				nbCoins -= 1;
			}
			
			if(grid[player.getPosX()][player.getposY()].getType() == CellType.TRAPPED) {
				player.looseLife(2);
				grid[player.getPosX()][player.getposY()].setType(CellType.EMPTY);
				player.setPosX(player.getPosXInit());
				player.setPosY(player.getPosYInit());
			}
		}
		
		display();
	}
	
	/**
	 * Representation textuelle de l'objet Level
	 * @return une chaîne de caractères contenant le nom du joueur associé
	 */
	
	@Override
	
	public String toString() {
		return "Level's player : " + player.getName();
	}
	
	/**
	 * Teste l'égalité entre deux objets
	 * @param obj est l'objet avec lequel on teste l'égalité
	 * @return un booléen vrai si deux niveaux avec la même grille faux sinon
	 */	
	
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Level && this.grid == ((Level) obj).getGrid()) {
			return true;
		}return false;
	}
	*/
	

}
