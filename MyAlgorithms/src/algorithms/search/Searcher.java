/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

/**
 * The Interface Searcher.
 *
 * @param <T> the generic type
 */
public interface Searcher<T> {
	
	/**
	 * the Search method. 
	 *
	 * @param s the Searchable problem to solve.
	 * @return the solution.
	 */
	public Solution<T> search(Searchable<T> s);
	
	/**
	 * Gets the number of nodes evaluated.
	 *
	 * @return the number of nodes evaluated.
	 */
	public int getNumberOfNodesEvaluated();

}
