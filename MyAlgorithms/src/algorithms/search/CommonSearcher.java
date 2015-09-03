/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

import java.util.PriorityQueue;

/**
 * The Class CommonSearcher.
 *
 * @param <T> the generic type
 */
public abstract class CommonSearcher<T> implements Searcher<T> {

	 /** a priority queue of states to be evaluated. */
 	protected PriorityQueue<State<T>> openList;
	 
 	/** The number of evaluated nodes. */
 	private int evaluatedNodes;

	 /**
 	 * Instantiates a new common searcher.
 	 */
 	public CommonSearcher() {
	  openList=new PriorityQueue<State<T>>();
	  evaluatedNodes=0;
	 }

	 /**
 	 *Retrieves and removes the head of this queue, or returns null if this queue is empty.
 	 *
 	 * @return the head of this queue, or null if this queue is empty
 	 */
 	protected State<T> popOpenList() {
	  evaluatedNodes++;
	  return openList.poll();	
	 }
	 
	 /* (non-Javadoc)
 	 * @see algorithms.search.Searcher#search(algorithms.search.Searchable)
 	 */
 	@Override
	 public abstract Solution<T> search(Searchable<T> s);

	 /* (non-Javadoc)
 	 * @see algorithms.search.Searcher#getNumberOfNodesEvaluated()
 	 */
 	@Override
	 public int getNumberOfNodesEvaluated() {
	  return evaluatedNodes;
	 }
	 
	 /**
 	 * Inserts the specified element into this priority queue.
 	 *
 	 * @param the state to add
 	 */
 	protected void addToOpenList(State<T> state) {
			openList.add(state);
			
		}
	 
	 /**
 	 * Backtrack path from the given state to start state through recorded parents. 
 	 *
 	 * @param the  state to backtrace.
 	 * @return  solution that present the path.
 	 */
		protected Solution<T> backTrace(State<T> current) {
			Solution<T> trace = new Solution<T>();
			State<T> temp = current;
			while (temp!=null)
			{
				trace.add(temp);
				temp=temp.getCameFrom();
			}
			return trace;
		}
		
		/**
		 * Calculate the cost of the path to the given state.
		 *
		 * @param current the state to calculate
		 * @param problem the problem that contains the state.
		 * @return the cost (double)
		 */
		abstract protected double calcCost(State<T> current, Searchable<T> problem);
}
