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

    private PFrontier pf = new PFrontier();
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
	Point start = new Point(x,y);
	start.setSteps(0);

	//start.setPri(euclidPri(start));
	//start.setPri(manhattanPri(start));
	start.setPri(astarPri(start));

	pf.add(start);
	System.out.println(pf);

        while(!pf.isEmpty()){
	    current = pf.remove();
	    int curx = current.getX();
	    int cury = current.getY();

	    if(board[curx][cury] == exit){
	        Point p = current.getPrev();
		while(p != null){
		    board[p.getX()][p.getY()] = me;
		    p = p.getPrev();
		}
		System.out.println(this);
		break;
	    }

	    board[curx][cury] = visited;
	    
	    addToFront(curx+1,cury);
	    addToFront(curx-1,cury);
	    addToFront(curx,cury+1);
	    addToFront(curx,cury-1);
	    delay(50);
	    System.out.println(this);
	}
    }

    private void addToFront(int tx, int ty){
	//Also records the priority of the point being added
	Point tmp = null;
	if(board[tx][ty] == path || board[tx][ty] == exit){
	    tmp = new Point(tx,ty);
	    tmp.setPrev(current);
	    tmp.setSteps(current.getSteps() + 1);
	    
	    //tmp.setPri(euclidPri(tmp));
	    //tmp.setPri(manhattanPri(tmp));
	    tmp.setPri(astarPri(tmp));

	    pf.add(tmp);   
	}
    }

    private Point findExit(){
	for(int i = 0 ; i < maxX ; i++){
	    for(int j = 0 ; j < maxY ;j++){
		if(board[i][j] == exit){
		    Point exit = new Point(i,j);
		    return exit;
		}
	    }
	}
	return null;
    }

    private int euclidPri(Point e){
        int xplusy = manhattanPri(e);
        double d = Math.sqrt(xplusy*xplusy - 2*xplusy);
        int ans = (int)d;
	return ans;
    }

    private int manhattanPri(Point m){
	Point exit = findExit();
	return (exit.getX() - m.getX()) + (exit.getY() - m.getY());
    }

    private int astarPri(Point a){
        return manhattanPri(a) + a.getSteps();
    }

    /*---------------------------- Main -------------------------------*/
		
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	m.bestSolve(1,1);
	System.out.println(m);
    }
    
}

