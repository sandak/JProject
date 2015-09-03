/**************************
@author Amit Sandak. id - 302819677
@version 1.0
@since updated:	12/08/15
**************************/

package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

/**
 **************************************************************************************
 *  Randomized Prim's algorithm                                                       *
 **************************************************************************************
This algorithm is a randomized version of Prim's algorithm.

1.Start with a grid full of walls.
2.Pick a cell, mark it as part of the maze. 
3.Add the walls of the cell to the wall list.
3.While there are walls in the list:
 		3.1. Pick a random wall from the list. If the cell on the opposite side isn't in the maze yet:
 		 		3.1.1. Make the wall a passage and mark the cell on the opposite side as part of the maze.
				3.1.2. Add the neighboring walls of the cell to the wall list.
		3.2.Remove the wall from the list.

 ******************************************************************************************* 
 */

public class MyMaze3dGenerator extends GeneralMaze3dGenerator {

	private ArrayList<Position> members;
	private ArrayList<Position> walls;


		
		public MyMaze3dGenerator() {
		super();
		this.members = new ArrayList<Position>() ; //used to mark cells as a part of the maze.
		this.walls = new ArrayList<Position>(); //used as wall list.
	}

		@Override
		public Maze3d generate(int x, int y, int z) {
			this.members.clear();
			this.walls.clear();
			Maze3d maze = new Maze3d(x,y,z);
			//1.Start with a grid full of walls.
			initGrid(maze);
			//2.Pick a cell
			 Random rand = new Random();
			 Position current;
			 int randx, randy, randz;
			 do{
			  randx = rand.nextInt(maze.getX());
			  randy = rand.nextInt(maze.getY());
			  randz = rand.nextInt(maze.getZ());
			 current=new Position(randx, randy, randz);
			 }while(maze.getType(current)==1);
			 
			 members.add(current); //2.mark as part of the maze
			addWalls(maze,current); //3.Add the walls of the cell to the wall list.
			maze.setStartPoint(current.clone());
			
			//System.out.println(current);  //used for tests
			
			int index = 0;
			Position wall;
			Position neighbor = null;
			while (!(walls.isEmpty()))  //3.While there are walls in the list:
			{
				index = rand.nextInt(walls.size()); //3.1. Pick a random wall from the list.
				wall = walls.get(index);

				do
				{
					index = rand.nextInt(6);
					switch (index){
					case 0: 
						neighbor = wall.clone().UP();
						break;
					case 1:
						neighbor = wall.clone().DOWN();
						break;
					case 2:
						neighbor = wall.clone().RIGHT();
						break;
					case 3:
						neighbor = wall.clone().LEFT();
						break;
					case 4:
						neighbor = wall.clone().FORWORD();
						break;
					case 5:
						neighbor = wall.clone().BACKWORD();
						break;
						default:
							neighbor = wall.clone().UP();
					}
				} while ((!maze.inRange(neighbor))||(maze.getType(neighbor)==1));
				
						if (!members.contains(neighbor))  //If the cell on the opposite side isn't in the maze yet:
		 		 		{
								members.add(neighbor); //3.1.1. Make the wall a passage and mark the cell on the opposite side as part of the maze.
								maze.setCell(wall);
								//maze.setCell(neighbor);
								addWalls(maze, neighbor); //3.1.2. Add the neighboring walls of the cell to the wall list.
								//members.add(wall);
		 		 		}
					walls.remove(wall);  //3.2.Remove the wall from the list.
					//System.out.println(walls); //for tests
			}		
		
			do{   // Pick a random exit cell
				 randx = rand.nextInt(maze.getX());
				 randy = rand.nextInt(maze.getY());
				 randz = rand.nextInt(maze.getZ());
				current=new Position(randx, randy, randz);
			}while((!maze.inRange(current))||(maze.getType(current)==1));
		maze.setExitPoint(current);
			return maze;
		}

		
		// Initialize grid maze to walls
		private void initGrid(Maze3d maze){
			for (int ax = 0; ax<maze.getX();ax++)
				for (int ay = 0; ay<maze.getY();ay++)
					for (int az = 0; az<maze.getZ();az++)
						if (((ay)%2==0)||((az)%2==0)||((ax)%2==0))
							maze.setWall(ax, ay, az); 
		}

		 //this method getting a position and a maze and add the walls of the position to the wall list.
		private void addWalls(Maze3d maze, Position p) {
			
			Position temp = p.clone();
			if (maze.inRange(temp.UP()))
				if (maze.getType(temp)==1)
					walls.add(temp.clone());
			
			temp = p.clone();
			if (maze.inRange(temp.DOWN()))
				if (maze.getType(temp)==1)
					walls.add(temp.clone());
			
			temp = p.clone();
			if (maze.inRange(temp.RIGHT()))
				if (maze.getType(temp)==1)
					walls.add(temp.clone());

			temp = p.clone();
			if (maze.inRange(temp.LEFT()))
				if (maze.getType(temp)==1)
					walls.add(temp.clone());
			
			temp = p.clone();
			if (maze.inRange(temp.FORWORD()))
				if (maze.getType(temp)==1)
					walls.add(temp.clone());

			temp = p.clone();
			if (maze.inRange(temp.BACKWORD()))
				if (maze.getType(temp)==0)
					walls.add(temp.clone());
		}
			
		
	}
	
	
	


