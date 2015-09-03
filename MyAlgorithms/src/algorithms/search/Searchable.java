/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

import java.util.ArrayList;

/**
 * The Interface Searchable.
 *
 * @param <T> the generic type
 */
public interface Searchable<T> {

		   /**
   		 * Gets the start state.
   		 *
   		 * @return the start state
   		 */
   		State<T> getStartState();
		   
   		/**
   		 * Gets the goal state.
   		 *
   		 * @return the goal state
   		 */
   		State<T> getGoalState();
		   
   		/**
   		 * Gets all the possible states from a given state.
   		 *
   		 * @param s the state.
   		 * @return the possible states.
   		 */
   		ArrayList<State<T>> getAllPossibleStates(State<T> s);
		
}
