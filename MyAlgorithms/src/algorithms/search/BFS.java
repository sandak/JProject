/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/*   (non-Javadoc)
 * 
 **************************************************************************************
 *  Best First Search algorithm                                                       *
 **************************************************************************************
pseudo code Best First Search:
OPEN = [initial state]	// a priority queue of states to be evaluated
CLOSED = []	// a set of states already evaluated
while OPEN is not empty
do
   1. n <-- dequeue(OPEN) // Remove the best node from OPEN
   2. add(n,CLOSED)	      // so we won’t check n again
   3. If n is the goal state, 
          backtrace path to n (through recorded parents) and return path.
   4. Create n's successors.
   5. For each successor s do:
   	a. If s is not in CLOSED and s is not in OPEN: 
		i.  update that we came to s from n
		ii. add(s,OPEN) 
	b. Otherwise, if this new path is better than previous one
          		i.  If it is not in OPEN add it to OPEN. 
		ii. Otherwise, adjust its priority in OPEN
done

 * 
 */


/**
 * The Class BFS.
 * Implement a BFS search algorithm.
 *
 * @param <T> the generic type
 */
public class BFS<T> extends CommonSearcher<T> 
{
	
	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#search(algorithms.search.Searchable)
	 */
	@Override
	public Solution<T> search(Searchable<T> s) 
	{
		  addToOpenList(s.getStartState());
		  HashSet<State<T>> closedSet=new HashSet<State<T>>();
		  State<T> n;
		  
		  while(openList.size()>0)
		  {
		    n=popOpenList(); // dequeue
		    //System.out.println(n); //for tests
		    closedSet.add(n);

		    if(n.equals(s.getGoalState()))
		      return backTrace(n); 

		    ArrayList<State<T>> successors=s.getAllPossibleStates(n);  
		    for(State<T> state : successors)
		    {
		    	state.setCameFrom(n);
		    	state.setCost(calcCost(state, s));
		    	//System.out.println(state); //for tests
		    	if(!closedSet.contains(state) && !openList.contains(state))
		      {
		    		addToOpenList(state);
		        //System.out.println("open list added"); //for tests
		      }
		      else
		      {
		    	 if (state.getCost()<openList.peek().getCost())
		    	  if  (!openList.contains(state))
		    	  	addToOpenList(state);
		        	else
		        		adjustPriority(state);
		      }
		    }
		  }
		  return null;
	}

	/* (non-Javadoc)
	 * @see algorithms.search.CommonSearcher#calcCost(algorithms.search.State, algorithms.search.Searchable)
	 */
	@Override
	protected double  calcCost(State<T> current, Searchable<T> problem) {
		double tCost = 0;
		if (current == null)
			return 0;
		State<T> temp = current;
		while (temp!=null)
		{
			tCost+=temp.getCost();
			temp=temp.getCameFrom();
		}
		return tCost;
	}

	/**
	 * Adjust priority.
	 * this method gets a state and updates the queue with the best state.
	 *
	 * @param state the state
	 */
	protected void adjustPriority(State<T> state)
	{
	Iterator<State<T>> iterator = openList.iterator();
	State<T> temp = null;
 if (openList.contains(state))
	while(iterator.hasNext())
	{
	//	System.out.println("iterator"); //for tests
		temp = iterator.next();
	//	System.out.println("next =" + temp.getState()); //for tests
		if(temp.getState().equals(state.getState()))
		{
			if (temp.getCost()>state.getCost())
			{
				openList.remove(temp);
        		openList.add(state);
			}
			return;
		}
		
		}
	return;
	}

	


	}
