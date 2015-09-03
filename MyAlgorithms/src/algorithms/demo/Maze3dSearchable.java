/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/
package algorithms.demo;

import java.util.ArrayList;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Searchable;
import algorithms.search.State;

/**
 * The Class Maze3dSearchable.
 */
public class Maze3dSearchable implements Searchable<Position> 
{

	/** The maze. */
	protected Maze3d maze;
	
	/**
	 * Instantiates a new maze3d searchable.
	 *
	 * @param amaze the maze
	 */
	Maze3dSearchable(Maze3d amaze)
	{
		maze = amaze;
	}
	
	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getStartState()
	 */
	@Override
	public State<Position> getStartState() {
		return new State<Position>(maze.getStartPosition(),0);
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getGoalState()
	 */
	@Override
	public State<Position> getGoalState() {
		return new State<Position>(maze.getGoalPosition(),0);
	}

	/* (non-Javadoc)
	 * @see algorithms.search.Searchable#getAllPossibleStates(algorithms.search.State)
	 */
	@Override
	public ArrayList<State<Position>> getAllPossibleStates(State<Position> s) {
		
		String[] tmp = maze.getPossibleMoves(s.getState());
		ArrayList<State<Position>> arr = new ArrayList<State<Position>>();
		
		for (String str: tmp)
			switch (str)
			{
			case "UP":
				arr.add(new State<Position>(s.getState().clone().UP(),1));
				//System.out.println(" UP " + s.getState().clone().UP() +" "); //for tests
				break;
			case "DOWN":
				arr.add(new State<Position>(s.getState().clone().DOWN(),1));
				//System.out.println(" DOWN " + s.getState().clone().DOWN() +" ");//for tests
				break;
			case "LEFT":
				arr.add(new State<Position>(s.getState().clone().LEFT(),1));
				//System.out.println(" LEFT " + s.getState().clone().LEFT() +" ");//for tests
				break;
			case "RIGHT":
				arr.add(new State<Position>(s.getState().clone().RIGHT(),1));
				//System.out.println(" RIGHT " + s.getState().clone().RIGHT() +" ");//for tests
				break;
			case "FORWORD":
				arr.add(new State<Position>(s.getState().clone().FORWORD(),1));
				//System.out.println(" FORWORD " + s.getState().clone().FORWORD() +" ");//for tests
				break;
			case "BACKWORD":
				arr.add(new State<Position>(s.getState().clone().BACKWORD(),1));
				//System.out.println(" BACKWORD " + s.getState().clone().BACKWORD() +" ");//for tests
				break;
			}
		
		return arr;
	}

}
