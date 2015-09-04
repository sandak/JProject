package algorithms.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class Tests {

	public static void main(String[] args) {
	 	
		Maze3dGenerator generator = new MyMaze3dGenerator();
		Maze3d maze = generator.generate(3,5, 5) ;
		//System.out.println(maze);
		try { 
 	 	// save it to a file 
 	 	OutputStream out=new MyCompressorOutputStream(new FileOutputStream("1.maz")); 
 	 	out.write(maze.toByteArray()); 
 	 	out.flush();
			out.close(); 
	 	 
	 	InputStream in = new MyDecompressorInputStream( new FileInputStream("1.maz")); 
 	 	byte b[]=new byte[maze.toByteArray().length]; 
	 	
			in.read(b);
			in.close(); 
	        
 	 	Maze3d loaded=new Maze3d(b);  	 
 	 	System.out.println(loaded.equals(maze)); 
	 	} catch (IOException e1) {
			System.out.println("error");
			e1.printStackTrace();
		}



	}

}
