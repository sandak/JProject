/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/
package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Astar;
import algorithms.search.BFS;
import algorithms.search.CommonSearcher;
import algorithms.search.MazeAirDistance;
import algorithms.search.MazeManhattanDistance;
import algorithms.search.Solution;

/**
 * The Class Demo.
 */
public class Demo {

	
	/**
	 * Run.
	 */
	public void run()
	{

		Maze3dGenerator generator = new MyMaze3dGenerator();
		Maze3d maze=generator.generate(15,15,15); 
		System.out.println(maze);
		System.out.println("****BFS******\n");	
		CommonSearcher<Position> search = new BFS<Position>();	
		Solution<Position> trace =search.search(new Maze3dSearchable(maze));  
		//System.out.println(trace);
		System.out.println(search.getNumberOfNodesEvaluated());
		System.out.println("****Astar -AIR ******\n");	
		search = new Astar<Position>(new MazeAirDistance());
		trace = search.search(new Maze3dSearchable(maze)); 
    	//System.out.println(trace);
		System.out.println(search.getNumberOfNodesEvaluated());
		System.out.println("****Astar -Manhattan ******\n");	
		search = new Astar<Position>(new MazeManhattanDistance());
		trace = search.search(new Maze3dSearchable(maze)); 
		System.out.println(search.getNumberOfNodesEvaluated());
		System.out.println("******  Solution  ******\n");
		 	System.out.println(trace);
	}
}
