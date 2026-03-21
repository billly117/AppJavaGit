package app;

/**
 * Représente les types de cellules possibles
 *
 * @author bilal
 * @version 1.0
 */

public enum CellType {
	/**Case vide ou avec une pièce*/
	EMPTY,
	/**Mur*/
	WALL,
	/**Case piégée*/
	TRAPPED,
	/**Porte verouillée*/
	LOCKED
}
