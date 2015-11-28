package test;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

import src.PlutoRover;
import static org.hamcrest.core.Is.is;


public class PlutoRoverTest {
	
	private PlutoRover rover = new PlutoRover();
	
	@Test
	public void RoverMovesForward() {
		int initialXPos = rover.getXCoords();
		int initialYPos = rover.getYCoords();
		char initialOrientation = rover.getDirection();
		
		rover.interpret("F");
		
		//Y coordinate is one more
		assertThat(initialYPos, is(rover.getYCoords() +1));
		
		//X coordinate and direction remains unchanged
		assertThat(initialXPos, is(rover.getXCoords()));
		assertThat(initialOrientation, is(rover.getDirection()));
		}
	
	@Test
	public void RoverMovesBackward() {
		int initialXPos = rover.getXCoords();
		int initialYPos = rover.getYCoords();
		char initialOrientation = rover.getDirection();
		
		rover.interpret("B");
		
		//Y coordinate is one less
		assertThat(initialYPos, is(rover.getYCoords() -1));
			
		//X coordinate and direction remains unchanged
		assertThat(initialXPos, is(rover.getXCoords()));
		assertThat(initialOrientation, is(rover.getDirection()));
			
	}

}
