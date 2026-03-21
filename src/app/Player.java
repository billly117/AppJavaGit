package app;

/**
 * Représente un joueur possédant un nom et un score.
 * Le score ne peut jamais être négatif.
 *
 * @author bilal
 * @version 1.0
 */

public class Player extends Character{
	/**Score initalement nul*/
	private int score = 0;
	/**Position X initale du joueur	 */
	private int posXinit;
	/**Position Y initale du joueur	 */
	private int posYinit;
	/**Nombre de joueurs créés*/
	private static int counter = 0;
	
	/**
	 * Initialise un joueur dont le score est nul.
	 * @param name nom du joueur
	 */
	public Player(String name) {
		super(name,-1,-1,5);
		counter ++;
	}
	
	/**
	 * Initialise un joueur dont le score est nul avec un nom générique.
	 * @param name nom du joueur
	 */
	public Player() {
		super("Player " + (counter + 1),-1,-1,5);
	}
	
	/**
	 * Retourne la position X initale du joueur
	 * @return  la position X initiale du joueur
	 */ 
	public int getPosXInit() {
		return this.posXinit;
	}
	
	/**
	 * Retourne la position Y initale du joueur
	 * @return  la position Y initiale du joueur
	 */ 
	public int getPosYInit() {
		return this.posYinit;
	}

	
	/**
	 * Retourne le nombre de joueurs créés
	 * @return  le nombre de joueurs créés
	 */
	
	public static int getCounter() {
		return counter;
	}
	
	/**
	 * Retourne le score du joueur
	 * @return  le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Met à jour la position X initiale du joueur
	 * @param x position X initiale
	 */
	public void setPosXInit(int x) {
		this.posXinit = x;
	}
	
	/**
	 * Met à jour la position Y initiale du joueur
	 * @param y position Y initiale
	 */
	public void setPosYInit(int y) {
		this.posYinit = y;
	}
	
	
	/**
	 * Met à jour le nombre de vies
	 * @param n Nouveau nombre de vies
	 */
	public void setNbLives(int n) {
		this.nbLives = n;
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
	
	/**
	 * Representation textuelle de l'objet Player
	 * @return une chaîne de caractères contenant le nom et le score du joueur
	 */	
	@Override
	public String toString() {
		String str = name + " : " + score + " pt";
		if(this.score>1) {
			return str + "s";

		}
		return str;
		
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
	
	@Override
	public void move(Level level) {
		
	}
	
	
	
	
}