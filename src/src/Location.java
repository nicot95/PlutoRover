package src;

public class Location {
	
	private Direction dir;
	private int xCoord, yCoord;
	
	public Location() {
		dir = Direction.N;
		xCoord = 0;
		yCoord = 0;
	}
	
	public void move(int d) {
		switch(dir) {
		case N: yCoord += d; break;
		case S: yCoord -= d; break;
		case E: xCoord += d; break;
		case W: xCoord -= d; break;
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
