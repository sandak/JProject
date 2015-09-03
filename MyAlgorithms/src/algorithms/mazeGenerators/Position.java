/**************************
written by: Amit Sandak.
id - 302819677
updated:	12/08/15
**************************/

package algorithms.mazeGenerators;

//this class represent a position in the maze
public class Position {
	private int [] position;

	//C'tor
	public Position(int x,int y, int z) {
		super();
		this.position =new int [] {x,y,z};
	}

//get methods:
	public int[] getPosition() {
		return position;
	}
	
	public int getX() {
		return position[0];
	}
	
	public int getY() {
		return position[1];
	}
	public int getZ() {
		return position[2];
	}

	//this method update the position
	public void setPosition(int x,int y, int z) {
		this.position[0] = x;
		this.position[1] = y;
		this.position[2] = z;
	}
	
	// forms a meaningful representation
	@Override
	public String toString() {
		return  "{"+getX() + "," + getY() + "," + getZ()+"}";
	}

	//Relevant execution to clone method
	@Override
	public Position clone(){
		Position copy = new Position(this.getX(),this.getY(),this.getZ());
					return copy;
	}
	
	//Relevant execution to equals method
	@Override
	  public boolean equals (Object o) {
		Position obj = ((Position)o);
		if (((obj.getY() == this.getY())&&(obj.getZ() == this.getZ())&&(obj.getX() == this.getX())))
			return true;
	return false;
		
		    }
	
	//move methods - updating the position according to the matched shift.
	public Position UP() {
		 position[0]++;
		 return this;
	}
	
	public Position DOWN() {
		 position[0]--;
		 return this;
	}
	
	public Position RIGHT() {
		 position[1]++;
		 return this;
	}
	
	public Position LEFT() {
		 position[1]--;
		 return this;
	}
	
	public Position FORWORD() {
		 position[2]++;
		 return this;
	}
	
	public Position BACKWORD() {
		 position[2]--;
		 return this;
	}
	
	
}
