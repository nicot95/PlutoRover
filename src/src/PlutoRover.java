package src;


public class PlutoRover {
	
	private Location loc;
	private static final int GRID_LIMIT = 99;
	
	public PlutoRover() {
		loc = new Location();
	}
	
	
	public void interpret(String s) {
		for(int i = 0; i < s.length(); i++) {
			parse(s.charAt(i));
		}
	}
	
	private void parse(char c) {
		
		switch(c) {
		case 'F' : loc.move(1); break;
		case 'B' : loc.move(-1); break;
		case 'L' : loc.rotate(-1); break;
		case 'R' : loc.rotate(1); break;
		}
 	}
	
	public void resetLocation() {
		loc = new Location();
	}
	
	public int getXCoord() {
		return loc.getxCoord();
	}
	
	public int getYCoord() {
		return loc.getyCoord();
	}
	
	public Direction getDir() {
		return loc.getDir();
	}
	

}
