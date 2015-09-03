/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

	import algorithms.mazeGenerators.Position;

/**
	 * The Class MazeAirDistance.
	 */
	public class MazeAirDistance implements Heuristic<Position> {

		/**
		 * Instantiates a new maze air distance.
		 */
		public MazeAirDistance(){}
		
		/* (non-Javadoc)
		 * @see algorithms.search.Heuristic#h(algorithms.search.State, algorithms.search.State)
		 */
		@Override
		public double h(State<Position> current, State<Position> goal) {
			double tmp = Math.sqrt(Math.pow(goal.getState().getX()-current.getState().getX(),2)+Math.pow(goal.getState().getY()-current.getState().getY(),2)+Math.pow(goal.getState().getZ()-current.getState().getZ(),2));
			return tmp;
		}

	}

