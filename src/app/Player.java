package app;

public class Player {
	private String name;
	private int score = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	@Override
	public String toString() {
		return "Player's name : " + name + ". Player's score : " + score + " pts.";
	}
	
	public void updateScore(int n) {
		this.score += n;
	}
}
