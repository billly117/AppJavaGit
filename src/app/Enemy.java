package app;
import java.util.Random;
public class Enemy extends Character{
	
	private static int counter = 0;
	private Random rand;
	
	public Enemy(int x, int y, int life) {
		super("Enemy" + (counter +1), x,y,life);
		this.rand = new Random();
	}
	
	@Override
	public void move(Level level) {
		Direction[] directions = Direction.values();
		int attempts = 0;
		
		while(attempts < directions.length) {
			Direction dir = directions[rand.nextInt(directions.length)];
			int newX = this.posX;
			int newY = this.posY;
			
			switch(dir) {
			case UP:
				newX -= 1;
				break;
			case DOWN:
				newX += 1;
				break;
			case LEFT:
				newY -= 1;
				break;
			case RIGHT: 
				newY += 1;
				break;
			}
			
			newX = (newX + level.getGrid().length) % level.getGrid().length;
			newY = (newY + level.getGrid()[0].length) % level.getGrid()[0].length;
			
			if(level.validPosition(newX, newY) && level.getGrid()[newX][newY].getType() != CellType.TRAPPED) {
				posX = newX;
				posY = newY;
				break;
			}
			attempts ++ ;
		}
	}

}
