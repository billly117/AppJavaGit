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
	/**Nombre de joueurs créés*/
	private static int counter = 0;
	/**Position X du joueur	 */
	private int posX = -1;
	/**Position Y du joueur	 */
	private int posY = -1;
	
	
	/**
	 * Initialise un joueur dont le score est nul.
	 * @param name nom du joueur
	 */
	public Player(String name) {
		this.name = name;
		counter ++;
	}
	
	/**
	 * Initialise un joueur dont le score est nul avec un nom générique.
	 * @param name nom du joueur
	 */
	public Player() {
		counter ++;
		this.name = "Joueur" + counter;
	}
	
	
	
	/**
	 * Retourne le nombre de joueurs créés
	 * @return  le nombre de joueurs créés
	 */
	
	public static int getCounter() {
		return counter;
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
	 * Retourne la position X du joueur
	 * @return  la position X du joueur
	 */
	public int getPosX() {
		return this.posX;
	}
	
	/**
	 * Retourne la position Y du joueur
	 * @return  la position Y du joueur
	 */
	public int getposY() {
		return this.posY;
	}
	
	/**
	 * Met à jour la position X du joueur
	 */
	public void setPosX(int x) {
		this.posX = x;
	}
	
	/**
	 * Met à jour la position Y du joueur
	 */
	public void setPosY(int y) {
		this.posY = y;
	}
	
	/**
	 * Representation textuelle de l'objet Player
	 * @return une chaîne de caractères contenant le nom et le score du joueur
	 */	
	@Override
	public String toString() {
		if(this.score>1) {
			return name + " : " + score + " pts. Position : (" + posX + "," + posY + ").";
		}
		return name + " : " + score + " pt. Position : (" + posX + "," + posY + ").";
		
	}
	/**
	 * Teste l'égalité entre deux objets
	 * @param obj est l'objet avec lequel on teste l'égalité
	 * @return un booléen vrai si deux joueurs avec le même nom faux sinon
	 */	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Player && this.getName().equalsIgnoreCase(((Player) obj).getName())) {
			return true;
		}return false;
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
