package app;

/**
 * Représente un joueur possédant un nom et un score.
 * Le score ne peut jamais être négatif.
 *
 * @author bilal
 * @version 1.0
 */

public class Player {
	/**Nom du joueur (non modifiable)*/
	private final String name;
	/**Score du joueur (initialement nul et toujours positif)*/
	private int score = 0;
	
	
	/**
	 * Initialise un joueur dont le score est nul.
	 * @param name nom du joueur
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Retourne le nom du joueur
	 * @return  le nom du joueur
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Retourne le score du joueur
	 * @return  le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Representation textuelle de l'objet Player
	 * @return une chaîne de caractères contenant le nom et le score du joueur
	 */	
	@Override
	public String toString() {
		return "Player's name : " + name + ". Player's score : " + score + " pts.";
	}
	
	/**
	 * Ajoute ou retire des points au score du  joueur.
	 * Si le score devient négatif, il est ramené à 0
	 * @param n nombre de points à ajouter (peut être négatif)
	 */
	public void updateScore(int n) {
		if(this.score + n >= 0) {
			this.score += n;
		}else {
			this.score = 0;
		}
		
	}
}
