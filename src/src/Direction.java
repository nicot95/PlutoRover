package src;

public enum Direction {
	
	N, E, S, W;
	
	private static Direction[] directions = values();
	
	public Direction rotate(int d) {
		int newOrd = ordinal() +d;
		int index = newOrd < 0 ? directions.length-1 : (newOrd) % directions.length;
		
		return directions[index];
	}
	

}
