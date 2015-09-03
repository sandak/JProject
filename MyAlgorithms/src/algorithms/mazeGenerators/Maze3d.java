/**************************
written by: Amit Sandak.
id - 302819677
updated:	12/08/15
**************************/

//

//

package algorithms.mazeGenerators;

//this class represent a 3D maze.
public class Maze3d {

int x; //Refers to the levels amount
int y; //Refers to the rows amount
int z; //Refers to columns amount
int[][][] maze; // [level][row][column]
Position startPoint; 
Position exitPoint;

//C'tor
public Maze3d(int x, int y, int z) {
	super();
	this.y = y;
	this.z = z;
	this.x = x;
	maze = new int[x][y][z];
}

//get methods:
public int getY() {
	return y;
}

public int getZ() {
	return z;
}

public int getX() {
	return x;
}

public int[][][] getmaze() {
	return maze.clone();
}

public Position getExitPoint() {
	return exitPoint;
}

public Position getGoalPosition()
{
	return getExitPoint();
}

public Position getStartPosition() {
	return startPoint;
}

//this method returns the type of a specific position. wall = 1 cell = 0.
//notice! this method can throw errors
public int getType(Position p)
{
	if (inRange(p))
	return maze[p.getX()][p.getY()][p.getZ()];
	else throw new IndexOutOfBoundsException("out Of Bounds");
}

//set methods//

//set a specific point to cell
public void setCell(int ax, int ay, int az)
{
	if (inRange(new Position(ax, ay,az)))
		this.maze[ax][ay][az] = 0;
}

//set a specific position to cell
// notice! this method can throw errors
public void setCell(Position p)
{
	if (!(inRange(p)))
		throw new IndexOutOfBoundsException("out Of Bounds");
	setCell(p.getX(),p.getY(),p.getZ());
}

//set a specific point to wall
public void setWall(int ax, int ay, int az)
{
	if ((ax<x)&&(ay<y)&&(az<z))
		this.maze[ax][ay][az] = 1;
}

//set a specific position to wall
//notice! this method can throw errors
public void setWall(Position p)
{
	if (!(inRange(p)))
		throw new IndexOutOfBoundsException("out Of Bounds");
	setWall(p.getX(),p.getY(),p.getZ());
}


//set the start point of the maze
public void setStartPoint(Position obj) {
	this.startPoint = obj.clone();
}

//set the end position in the maze 
public void setExitPoint(Position obj) {
	this.exitPoint =obj.clone();
	
}

//this method getting a position and returns if the method is in the range of the maze
public boolean inRange(Position p) {
	if ((p.getY() <0)||(p.getY() >=y) || (p.getZ() <0)||(p.getZ() >=z)  ||  (p.getX() <0)||(p.getX() >=x)  )
		return false;
	else
		return true;
}

//this method getting a position and returns the possible moves from this position in the maze
public String[] getPossibleMoves(Position p) {
	String [] tmoves = new String [6]; //temp array
	int i = 0;
	
	Position temp = p.clone(); //check if move UP/DOWN/RIGHT/... are legal
	if (inRange(temp.UP()))
		if (getType(temp)==0)
			tmoves[i++]="UP";
	
	temp = p.clone();
	if (inRange(temp.DOWN()))
		if (getType(temp)==0)
			tmoves[i++]="DOWN";
	
	temp = p.clone();
	if (inRange(temp.RIGHT()))
		if (getType(temp)==0)
			tmoves[i++]="RIGHT";

	temp = p.clone();
	if (inRange(temp.LEFT()))
		if (getType(temp)==0)
			tmoves[i++]="LEFT";
	
	temp = p.clone();
	if (inRange(temp.FORWORD()))
		if (getType(temp)==0)
			tmoves[i++]="FORWORD";

	temp = p.clone();
	if (inRange(temp.BACKWORD()))
		if (getType(temp)==0)
			tmoves[i++]="BACKWORD";
	
	String [] moves = new String [i]; //creating a matched new array to return
	for (int j=0;j<i;j++)
		moves[j]= tmoves[j];
	
	return moves;
}

//this method return the cross section by row
public int[][] getCrossSectionByY(int i) {
	if ((i<0)||(i>=y))
		throw new IndexOutOfBoundsException("out Of Bounds");
	int [][] cross = new int [x][z];
	for (int ax=0;ax<x;ax++)
		for(int az=0;az<z;az++)
			cross[ax][az]=maze[ax][i][az];

		return cross;
}

//this method return the cross section by column
public int[][] getCrossSectionByZ(int i) {
	if ((i<0)||(i>=z))
		throw new IndexOutOfBoundsException("out Of Bounds");
	int [][] cross = new int [x][y];
	for (int ax=0;ax<x;ax++)
		for(int ay=0;ay<y;ay++)
			cross[ax][ay]=maze[ax][ay][i];

		return cross;
}

//this method return the cross section by level
public int[][] getCrossSectionByX(int i)  {
if ((i<0)||(i>=x))
	throw new IndexOutOfBoundsException("out Of Bounds");
int [][] cross = new int [y][z];
for (int ay=0;ay<y;ay++)
	for(int az=0;az<z;az++)
		cross[ay][az]=maze[i][ay][az];

	return cross;
}

// forms a meaningful representation
@Override
public String toString() {
    String output = "";
    for(int i = 0; i<x;i++)
    {
    	for (int j = 0; j < z; j++)
    	{
    		for (int k = 0; k < y; k++)
    		{
    			output += maze[i][k][j];
    			output += " ";
    		}
        output += "\n";
         }
    	 output += "\n";
    }
    
    return output + "\nStart = " + startPoint+" \nExit = " + exitPoint;
}

}


