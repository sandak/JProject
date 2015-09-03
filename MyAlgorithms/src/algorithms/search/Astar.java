/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/
package algorithms.search;

/**
 * The Class Astar.
 * Implement a A* search algorithm.
 *
 * @param <T> the generic type
 */
public class Astar<T> extends BFS<T> {
	

	/** The Heuristic part of the algorithm */
	Heuristic<T> h;
	
	/**
	 * Instantiates a new Astar.
	 *
	 * @param ah - the Heuristic part of the search algorithm.
	 */
	public Astar(Heuristic<T> ah)  {this.h=ah;}

	/* (non-Javadoc)
	 * @see algorithms.search.BFS#calcCost(algorithms.search.State, algorithms.search.Searchable)
	 */
	@Override
	protected double calcCost(State<T> current, Searchable<T> problem) {
		return super.calcCost(current, problem)+h.h(current, problem.getGoalState());
	}


}
