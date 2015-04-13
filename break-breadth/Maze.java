import java.io.*;
import java.util.*;

public class Maze {
    /*--------------------------- Variables ------------------------*/
    
    private char[][] board;
    private int maxX;
    private int maxY;

    private char path='#';
    private char wall=' ';
    private char me='z';
    private char exit='$';
    private char visited = '.';
    private boolean solved = false;

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

    /*------------------------ Solve Routines --------------------------*/
    
    public void DFsolve(int x, int y){
	if (board[x][y]==wall ||
	    board[x][y]==me ||
	    board[x][y]==visited ||
	    solved){
	    return;
	}
	if (board[x][y]==exit){
	    System.out.println(this);
	    solved = true;
	}
	delay(100);
	System.out.println(this);
	board[x][y]=me;
	DFsolve(x+1,y);
	DFsolve(x-1,y);
	DFsolve(x,y+1);
	DFsolve(x,y-1);
	if (!solved){
	    board[x][y]=visited;
	}
    }

    public void BFsolve(int x, int y){
	Frontier f = new Frontier();
	Point start = new Point(x,y);
	f.add(start);
	System.out.println(f);
	while(!solved){
	    //Grab the first point from the frontier
	    Point current = f.remove();
	    int curx = current.getX();
	    int cury = current.getY();

	    //Check if it is the exit, if it is do path recovery
	    if(board[curx][cury] == exit){
		while(current != start){
		    board[current.getX()][current.getY()] = me;
		    current = current.getPrev();
		}
		System.out.println(this);
		solved = true;
	    }
	    //If not, continue and mark it 
	    board[curx][cury] = visited;
	    System.out.println(this);

	    //Add the surrounding elements to the frontier  only if they
	    //are valid points on the path
	    if(board[curx+1][cury] == path){
		Point p1 = new Point(curx+1,cury);
		p1.setPrev(current);
		f.add(p1);
		//System.out.println(f);
	    }
	    if(board[curx-1][cury] == path){
		Point p2 = new Point(curx-1,cury);
		p2.setPrev(current);
		f.add(p2);
		//System.out.println(f);
	    }
	    if(board[curx][cury+1] == path){
		Point p3 = new Point(curx,cury+1);
		p3.setPrev(current);
		f.add(p3);
		//System.out.println(f);
	    }
	    if(board[curx][cury-1] == path){
		Point p4 = new Point(curx,cury-1);
		p4.setPrev(current);
		f.add(p4);
		//System.out.println(f);
	    }
	}
    }

    /*---------------------------- Main -------------------------------*/
		
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	//m.DFsolve(1,1);
	m.BFsolve(1,1);
	System.out.println(m);
    }
    
}

