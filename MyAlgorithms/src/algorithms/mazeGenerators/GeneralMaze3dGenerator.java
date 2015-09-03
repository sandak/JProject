/**************************
written by: Amit Sandak.
id - 302819677
updated:	12/08/15
**************************/


package algorithms.mazeGenerators;

public abstract class GeneralMaze3dGenerator implements Maze3dGenerator {

	//this abstract method used to generate a maze
public abstract Maze3d generate(int x, int y, int z);


//this method used to measure the maze generate time
	@Override
	public String measureAlgorithmTime(int x, int y, int z)
	{
	long start = System.currentTimeMillis();
	this.generate(x, y, z);
	long end= System.currentTimeMillis();
	long result = ((end - start));
	String format = String.format("%02d:%02d:%02d", result / 60000, (result % 60000) / 1000, (result % 1000));
	//System.out.println(format); //test line
		return ("(M:S:MS) "+format);
	}

}
