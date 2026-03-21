package app;

public abstract class Character {
	
	protected final String name;
	protected int posX;
	protected int posY;
	protected int nbLives;
	
	public Character(String name, int x, int y, int nbLives) {
		this.name = name;
		this.posX = x;
		this.posY = y;
		this.nbLives = nbLives;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getNbLives() {
		return nbLives;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setNbLives(int n) {
		this.nbLives = n;
	}
	
	public void looseLife(int n) {
		this.nbLives -= n ;
		if(this.nbLives<0) {
			this.nbLives = 0;
		}
	}
	
	public abstract void move(Level level);

}
