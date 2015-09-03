/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;
import java.util.LinkedList;


/**
 * The Class Solution.
 *
 * @param <T> the generic type
 */
public class Solution<T> {

	/** The solution trace. */
	private LinkedList<State<T>> trace;
	
	/**
	 * Instantiates a new solution.
	 */
	Solution()
	{
		trace = new LinkedList<State<T>>();
	}
	
	/**
	 * Adds a state to solution trace.
	 *
	 * @param state the state to add.
	 */
	public void add(State<T> state) {
		trace.addFirst(state);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    String output = "";
	for (State<T> state : trace)
		output += state.getState() + " , ";
	    return output;
	}
	

}
