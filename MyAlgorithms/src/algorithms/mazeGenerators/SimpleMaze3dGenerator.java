/**************************
written by: Amit Sandak.
id - 302819677
updated:	12/08/15
**************************/

package algorithms.mazeGenerators;
import java.util.Random;

//This algorithm is a simple version of maze generator.
public class SimpleMaze3dGenerator extends GeneralMaze3dGenerator {

	@Override
	public Maze3d generate(int x, int y, int z)
	{
		Maze3d maze = new Maze3d(x, y, z);
		Random rand = new Random();
		//generate random walls
		 int result;
				for (int ax = 0; ax<maze.getX();ax++)
					for (int ay = 0; ay<maze.getY();ay++)
						for (int az = 0; az<maze.getZ();az++)

						{ 
						result = rand.nextInt(2);
						if (result == 1)
							maze.setWall(ax, ay, az); 
						}
		
		//generate random start point
	
		 int randz = rand.nextInt(maze.getZ());
		 int randx = rand.nextInt(maze.getX());
		 int randy = rand.nextInt(maze.getY());
		 maze.setStartPoint(new Position(randx, randy, randz));
		 maze.setCell(randx, randy,randz);
		// System.out.println("start "+randx+" "+randy+" "+randz+" ");  //for tests
		 
for(int i=0;i<25;i++)
	rand.nextInt(i+5);
		 
		 //random exit point
		  randz = rand.nextInt(maze.getZ());
		  randx = rand.nextInt(maze.getX());
		  randy = rand.nextInt(maze.getY());
		 maze.setExitPoint(new Position(randx, randy,randz));
		 maze.setCell(randx, randy, randz);
		 //System.out.println("exit "+randx+" "+randy+" "+randz+" "); //for tests
		
		 
		//Creating a certain route from the start to the end points
		 Position step= maze.getStartPosition().clone();  
		 int course;
		 while (!step.equals(maze.getExitPoint()))
		 {
			 course = (rand.nextInt(3));
			 if (course == 0)
				 if (maze.getExitPoint().getX()>step.getX())
					 step.UP();
				 else if (maze.getExitPoint().getX()<step.getX())
					 step.DOWN();;
			 if (course == 1)
				 if (maze.getExitPoint().getY()>step.getY())
					 step.RIGHT();
				 else if (maze.getExitPoint().getY()<step.getY())
					 step.LEFT();
			 if (course == 2)
				 if (maze.getExitPoint().getZ()>step.getZ())
					 step.FORWORD();
				 else if (maze.getExitPoint().getZ()<step.getZ())
					 step.BACKWORD();
			 maze.setCell(step.getX(), step.getY(), step.getZ());
					 
		 }	 
		 
		return maze;
	}

}
