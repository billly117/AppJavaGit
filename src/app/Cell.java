package app;

public class Cell {
	
	private int row;
	private int col;
	private boolean hasCoin;
	private boolean throughable;
	private CellType type;
	
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
	
	public int getRow(){
		return this.row;
	}

	public int getCol() {
		return this.col;
	}
	
	public boolean getHasCoin() {
		return this.hasCoin;
	}
	
	public CellType getType() {
		return this.type;
	}
	
	public boolean getThroughable() {
		return this.throughable;
	}
	
	public void setThroughable(boolean throughable) {
		this.throughable = throughable;
	}
	
	public void setHasCoin(boolean hasCoin) {
		this.hasCoin = hasCoin;
	}
	
	public void setType(CellType type) {
		this.type = type;
	}
}
