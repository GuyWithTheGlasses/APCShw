import java.io.*;
import java.util.*;

public class Maze {
    /*--------------------------- Variables ----------------------------*/
    
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

    private PFrontier pf;
    private Point current;

    /*--------------------- Constructors & Utilities ---------------------*/
		
    public void delay(int n){
	try {
	    Thread.sleep(n);
	} catch (Exception e) {}
    }
		
    public Maze() {
	maxX=40;
	maxY=20;
	board = new char[maxX][maxY];		
	try {						
	    Scanner sc = new Scanner(new File("maze.dat"));
	    int j=0;
	    while (sc.hasNext()){
		String line = sc.nextLine();
		for (int i=0;i<maxX;i++){
		    board[i][j] = line.charAt(i);
		}
		j++;
	    }
	}
	catch (Exception e){}				
    }
		
    public String toString(){
	String s = "[2J\n";
	for (int y=0;y<maxY;y++){
	    for (int x=0;x<maxX;x++)
		s = s +board[x][y];
	    s=s+"\n";
	}
	return s;
    }
    
    /*---------------------- BEST-first Search ------------------------*/

    public void bestSolve(int x, int y){
	
    }

    /*---------------------------- Main -------------------------------*/
		
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);

	System.out.println(m);
    }
    
}

