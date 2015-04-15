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

    private Frontier f;
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
	f = new Frontier();
	//f = new StackFront();
	Point start = new Point(x,y);
	f.add(start);
	System.out.println(f);
	while(!f.isEmpty()){
	    //Grab the first point from the frontier
	    current = f.remove();
	    int curx = current.getX();
	    int cury = current.getY();

	    //Check if it is the exit, if it is do path recovery
	    if(board[curx][cury] == exit){
	        Point p = current.getPrev();
		while(p != null){
		    board[p.getX()][p.getY()] = me;
		    p = p.getPrev();
		    System.out.println(this);
		    delay(40);
		}
		System.out.println(this);
		break;
	    }

	    //Else, mark your territory
	    board[curx][cury] = visited;
	    
	    //Then add the surrounding elements to the frontier only if
	    //they are valid points on the path
	    addToFront(curx+1,cury);
	    addToFront(curx-1,cury);
	    addToFront(curx,cury+1);
	    addToFront(curx,cury-1);
	    delay(40);
	    System.out.println(this);
	}
    }

    //Adds to the frontier only if the point is valid
    private void addToFront(int tx, int ty){
        Point tmp = null;
	if(board[tx][ty] == path || board[tx][ty] == exit){
	    tmp = new Point(tx,ty);
	    tmp.setPrev(current);
	    f.add(tmp);   
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

