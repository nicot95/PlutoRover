package test;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import src.Direction;
import src.PlutoRover;
import static org.hamcrest.core.Is.is;


public class PlutoRoverTest {
	
	private PlutoRover rover = new PlutoRover();
	
	@Test
	public void roverMovesForward() {
		int initialXCoord = rover.getXCoord();
		int initialYCoord = rover.getYCoord();
		Direction initialDir = rover.getDir();
		
		rover.interpret("F");
		
		//Y coordinate is one more
		assertThat(rover.getYCoord(), is(initialYCoord +1));
		
		//X coordinate and direction remains unchanged
		assertThat(initialXCoord, is(rover.getXCoord()));
		assertThat(initialDir, is(rover.getDir()));
	}
	
	@Test
	public void roverMovesBackward() {
		int initialXCoord = rover.getXCoord();
		int initialYCoord = rover.getYCoord();
		Direction initialDir = rover.getDir();
		
		rover.interpret("B");
		
		//Y coordinate is one less
		assertThat(rover.getYCoord(), is(initialYCoord -1));
		
		//X coordinate and direction remains unchanged
		assertThat(initialXCoord, is(rover.getXCoord()));
		assertThat(initialDir, is(rover.getDir()));
	}
		
	
	@Test
	public void roverMovesForwardAndBackward() {
		int initialXCoord = rover.getXCoord();
		int initialYCoord = rover.getYCoord();
		Direction initialDir = rover.getDir();
		
		rover.interpret("FB");
				
		//X,Y coordinates and direction remains unchanged
		assertThat(initialXCoord, is(rover.getXCoord()));
		assertThat(initialYCoord, is(rover.getYCoord()));
		assertThat(initialDir, is(rover.getDir()));
		
	}
	
	@Test
	public void roverRotatesLeft() {
		int initialXCoord = rover.getXCoord();
		int initialYCoord = rover.getYCoord();
		
		rover.interpret("L");
		
		// New direction is 90 degrees to the left
		assertThat(rover.getDir(), is(Direction.W));
		
		//X,Y coordinates and direction remains unchanged
		assertThat(initialXCoord, is(rover.getXCoord()));
		assertThat(initialYCoord, is(rover.getYCoord()));
		
	}
	
	@Test
	public void roverRotatesRight() {
		int initialXCoord = rover.getXCoord();
		int initialYCoord = rover.getYCoord();
		
		rover.interpret("R");
		
		// New direction is 90 degrees to the right
		assertThat(rover.getDir(), is(Direction.E));
		
		//X,Y coordinates and direction remains unchanged
		assertThat(initialXCoord, is(rover.getXCoord()));
		assertThat(initialYCoord, is(rover.getYCoord()));
		
	}
	
	@Test 
	public void roverMovesForwardAndRotatesCorrectly() {
		int initialXCoord = rover.getXCoord();
		int initialYCoord = rover.getYCoord();
		Direction initialDir = rover.getDir();
		
		rover.interpret("FFBBFFRFFRFFRFFR");
		
		//X,Y coordinates and direction remains unchanged
		assertThat(initialXCoord, is(rover.getXCoord()));
		assertThat(initialYCoord, is(rover.getYCoord()));
		assertThat(initialDir, is(rover.getDir()));
	}	
}
