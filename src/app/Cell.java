package app;

/**
 * Représente une cellule
 *
 * @author bilal
 * @version 1.0
 */

public class Cell {
	
	/*Indice ligne de la cellule*/
	private int row;
	/*Indice colonne de la cellule*/
	private int col;
	/*Présence de pièce sur la cellule*/
	private boolean hasCoin;
	/*Cellule qui peut être traversée ou non par le joueur*/
	private boolean throughable;
	/*Type de la cellule*/
	private CellType type;
	
	
	/**
	 * Initilaise une cellule
	 * @param row Indice ligne de la cellule
	 * @param col Indice colonne de la cellule*
	 * @param hasCoin Présence de pièce dans la cellule
	 * @param type Type de la cellule
	 */
	public Cell(int row, int col, boolean hasCoin, CellType type) {
		this.row = row;
		this.col = col;
		this.hasCoin = hasCoin;
		this.type = type;
		if(type == CellType.LOCKED || type == CellType.WALL) {
			this.throughable = false;
		}
		else {
			this.throughable = true;
		}
	}
	
	/**
	 * Retourne l'indice ligne de la cellule
	 * @return l'indice ligne de la cellule
	 */
	public int getRow(){
		return this.row;
	}

	/**
	 * Retourne l'indice colonne de la cellule
	 * @return l'indice colonne de la cellule
	 */
	public int getCol() {
		return this.col;
	}
	
	/**
	 * Retourne un booléen selon qui indique la présence ou non d'une pièce
	 * @return true si il y a une pièce false sinon
	 */
	public boolean getHasCoin() {
		return this.hasCoin;
	}
	
	/**
	 * Retourne le type de la cellule
	 * @return le type de la cellule
	 */
	public CellType getType() {
		return this.type;
	}
	
	/**
	 * Retourne un booléen selon si la cellule peut être traversée par le joueur
	 * @return true si le joueur peut traverser false sinon
	 */
	public boolean getThroughable() {
		return this.throughable;
	}
	
	/**
	 * Met à jour la traversabilité d'une cellule
	 * @param throughable true si la case devient traversable false si la case ne l'est plus
	 */
	public void setThroughable(boolean throughable) {
		this.throughable = throughable;
	}
	
	/**
	 * Met à jour la présence d'une pièce
	 * @param hasCoin false si le joueur passe sur une case avec une pièce true si on ajoute une pièce
	 */
	public void setHasCoin(boolean hasCoin) {
		this.hasCoin = hasCoin;
	}
	
	/**
	 * Met à jour le type de la cellule
	 * @param type nouveau type de la cellule
	 */
	public void setType(CellType type) {
		this.type = type;
	}
	
	/**
	 * Représentation textuelle d'une cellule
	 */
	@Override
	
	
	public String toString() {
		return "Cell(" + row + "," + col + ", type=" + type + ", coin=" + hasCoin + ")";
	}
	
	@Override
	
	/**
	 * Teste l'égalité entre deux objets
	 * @param obj est l'objet avec lequel on teste l'égalité
	 * @return un booléen vrai si deux cellules sont la même faux sinon
	 */	
	public boolean equals(Object obj) {
		if(this == obj) {
	        return true;
	    }

	    if(!(obj instanceof Cell)) {
	        return false;
	    }

	    Cell other = (Cell) obj;

	    return row == other.row &&
	           col == other.col &&
	           hasCoin == other.hasCoin &&
	           type == other.type;
	}
}
