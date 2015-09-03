/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

import algorithms.mazeGenerators.Position;

/**
 * The Class MazeManhattanDistance.
 */
public class MazeManhattanDistance implements Heuristic<Position> {

/**
 * Instantiates a new maze Manhattan distance.
 */
public MazeManhattanDistance(){}

	/* (non-Javadoc)
	 * @see algorithms.search.Heuristic#h(algorithms.search.State, algorithms.search.State)
	 */
	@Override
	public double h(State<Position> current, State<Position> goal) {
		double tmp = Math.abs(goal.getState().getX()-current.getState().getX())+Math.abs(goal.getState().getY()-current.getState().getY())+Math.abs(goal.getState().getZ()-current.getState().getZ());
		return tmp;
	}

}
