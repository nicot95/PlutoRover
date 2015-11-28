package src;

public class Location {
	
	private Direction dir;
	private int xCoord, yCoord;
	private static final int GRID_LIMIT = 100;
	
	public Location() {
		dir = Direction.N;
		xCoord = 0;
		yCoord = 0;
	}
	
	public void move(int d) {
		switch(dir) {
		case N: yCoord = (yCoord + d) % GRID_LIMIT; break;
		case S: yCoord -= d; if(yCoord < 0) yCoord = GRID_LIMIT-1; break;
		case E: xCoord = (xCoord + d) % GRID_LIMIT; break;
		case W: xCoord -= d; if(xCoord < 0) xCoord = GRID_LIMIT-1; break;
		}
	}
	
	public Direction getDir() {
		return dir;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}
	
	public void rotate(int d) {
		dir = dir.rotate(d);
	}

}
