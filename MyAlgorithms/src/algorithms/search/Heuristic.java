/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

/**
 * The Interface Heuristic.
 *
 * @param <T> the generic type
 */
public interface Heuristic<T> {
	
	/**
	 * h. the heuristic function.
	 *
	 * @param current the state to calculate.
	 * @param goul the goal state.
	 * @return the function result (double).
	 */
	public double h(State<T> current, State<T> goal);
	
}
