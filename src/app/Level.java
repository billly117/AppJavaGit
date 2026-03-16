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
	
	private char[][] grid;
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
		
		grid = new char[rows.size()][rows.get(0).length()];
		
		for(int i = 0; i<rows.size(); i++) {
			for(int j = 0; j<rows.get(i).length(); j++) {
				grid[i][j] = rows.get(i).charAt(j);
				if(grid[i][j] == '.') {
					nbCoins ++;
				}
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

	/**
	 * Initialise un niveau à partir d'une matrice de caractère pour la gille, un joueur et sa position initiale
	 * @param grid matrice de caractère pour la grille
	 * @param player joueur
	 * @param x position x initiale du joueur
	 * @param y position y initiale du joueur
	 */
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
	
	/**
	 * Retourne le nombre de pièce dans le niveau
	 * @return lle nombre de pièce dans le niveau
	 */
	public int getNbCoins(){
		return this.nbCoins;
	}
	
	/**
	 * Retourne la grille du niveau
	 * @return la grille du niveau
	 */
	public char[][] getGrid(){
		return this.grid;
	}
	
	/**
	 * Retourne un booléen si la position est valide (dans la grille et espace vide)
	 * @param x position x
	 * @param y position y
	 * @return un booléen si la position est valide (dans la grille et espace vide)
	 */
	public boolean validPosition(int x,int y) {
		return (!(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y] == '#'));
	}
	
	/**
	 * Affiche la grille dans la console
	 */
	public void display() {
		System.out.println("Player : " + player.getName()+ ". Position : (" + player.getPosX()  + "," + player.getposY() +"). Score : " + player.getScore() + ". Reamining coins : " + nbCoins);
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
			
			if(grid[player.getPosX()][player.getposY()] == '.') {
				player.updateScore(10);
				grid[player.getPosX()][player.getposY()] = ' ';
				nbCoins -= 1;
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Level && this.grid == ((Level) obj).getGrid()) {
			return true;
		}return false;
	}
	

}
