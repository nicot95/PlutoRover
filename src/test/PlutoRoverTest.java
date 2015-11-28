package test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import javax.naming.InitialContext;

import org.junit.Test;

import src.Direction;
import src.PlutoRover;
import static org.hamcrest.core.Is.is;



public class PlutoRoverTest {
	
	private PlutoRover rover = new PlutoRover();
	private static final int GRID_LIMIT = 100;
	
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
		rover.resetLocation();
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
		rover.resetLocation();
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
	
	@Test
	public void wrappingHorizontalEdge() {
		// face south edge
		rover.resetLocation();
		rover.interpret("RR");
		int initialXCoord = rover.getXCoord();
		Direction initialDir = rover.getDir();
		
		rover.interpret("F");
		
		// south edge wrapped to north edge
		assertThat(rover.getYCoord(), is(GRID_LIMIT-1));
		
		//X coordinate and direction remains unchanged
		assertThat(rover.getDir(), is(initialDir));
		assertThat(rover.getXCoord(), is(initialXCoord));
	}
	
	@Test
	public void wrappingVerticalEdge() {
		// face west edge
		rover.resetLocation();
		rover.interpret("L");
		int initialYCoord = rover.getYCoord();
		Direction initialDir = rover.getDir();
		
		rover.interpret("F");
		
		// west edge wrapped to east edge
		assertThat(rover.getXCoord(), is(GRID_LIMIT-1));
		
		//X coordinate and direction remains unchanged
		assertThat(rover.getDir(), is(initialDir));
		assertThat(rover.getYCoord(), is(initialYCoord));
	}
	
	@Test
	public void collisionDetection() {
		rover.resetLocation();
		int[][] grid = new int[100][100];
		Arrays.fill(grid, 0);
		grid[1][0] = 1;
		rover.setGrid(grid);
		
		int initalYCoord = rover.getYCoord();
		
		rover.interpret("FFFF");
		
		//obstacle detected
		assertThat(rover.getYCoord(), is(initalYCoord));
	}
	
}
