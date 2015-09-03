/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.search;

/**
 * The Class State.
 *
 * @param <T> the generic type
 */
public class State <T> implements Comparable<State <T>> {

	    /** The current state. */
    	private T state; 
	    
    	/** The cost of this state. */
    	private double cost;  
	    
    	/** The state we came from to this state. */
    	private State<T> cameFrom;  // 

	    /**
    	 * Instantiates a new state.
    	 *
    	 * @param state the current state
    	 */
    	public State(T state){      
	        this.state = state;
	        this.cost = 0;
	    }
	    
	    /**
    	 * Instantiates a new state.
    	 *
    	 * @param state the current state
    	 * @param aCost the cost of the state
    	 */
    	public State(T state, double aCost){     
	        this.state = state;
	        this.cost = aCost;
	    }

	    /* (non-Javadoc)
    	 * @see java.lang.Object#equals(java.lang.Object)
    	 */
    	@SuppressWarnings("unchecked")
		@Override
	    public boolean equals(Object obj){ 
	        return state.equals(((State<T>)obj).state);
	    }

		/**
		 * Gets the current state.
		 *
		 * @return the current state
		 */
		public T getState() {
			return state;
		}

		/**
		 * Sets the current state.
		 *
		 * @param state the new state
		 */
		public void setState(T state) {
			this.state = state;
		}

		/**
		 * Gets the cost.
		 *
		 * @return the cost
		 */
		public double getCost() {
			return cost;
		}

		/**
		 * Sets the cost.
		 *
		 * @param cost the new cost
		 */
		public void setCost(double cost) {
			this.cost = cost;
		}

		/**
		 * Gets the came from state.
		 *
		 * @return the came from state
		 */
		public State<T> getCameFrom() {
			return cameFrom;
		}

		/**
		 * Sets the came from state.
		 *
		 * @param cameFrom the new came from
		 */
		public void setCameFrom(State<T> cameFrom) {
			this.cameFrom = cameFrom;
		}


	
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		// forms a meaningful representation
		@Override
		public String toString() {
			return " < "+ state  + " , "  + cost + " , "+cameFrom.getState()+" > " ;
		}


		/* (non-Javadoc)
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(State<T> o) {
			return (int)(this.cost-o.getCost());
		}
	
}
