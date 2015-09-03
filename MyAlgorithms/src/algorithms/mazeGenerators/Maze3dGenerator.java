/**************************
written by: Amit Sandak.
id - 302819677
updated:	12/08/15
**************************/

package algorithms.mazeGenerators;

//General interface for  maze generators algorithms
public interface Maze3dGenerator {
	
	public Maze3d generate( int x, int y, int z);
public String measureAlgorithmTime( int x, int y, int z);
}
