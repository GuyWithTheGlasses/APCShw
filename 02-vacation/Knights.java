import java.util.Random;

public class Knights{

    /*--------------------- Variables & Constructors ----------------------*/
    
    private int[][] board;
    private int knightmoves;
    private int squares;
    private int[] startloc;
    private Random rnd = new Random();
    private boolean solved;

    public Knights(){
	this(9,9);
    }

    public Knights(int x, int y){
	board = new int[x][y];
	setup();
    }

    /*
      In setup we fill the border of the board with -1's and place the knight
      in a random location in the 5x5.
      We also record the starting location of the knight so we know where to
      start calling knightsTour from.
    */
    private void setup(){
	squares = (board.length - 4)*(board.length - 4);
	for(int i = 0 ; i < board.length ; i++){
	    for(int j = 0 ; j < board[i].length ; j++){
		if(i <= 1 ||
		   j <= 1 ||
		   i >= board.length-2 ||
		   j >= board.length-2){
		    board[i][j] = -1;
		}
	    }
	}
	startloc = new int[2];
        startloc[0] = rnd.nextInt(5) + 2;
        startloc[1] = rnd.nextInt(5) + 2;
	knightmoves = 0;
	solved = false;
    }

    /*-------------------------- Methods -------------------------------*/

    public void delay(int time){
	try{
	    Thread.sleep(time);
	}catch (Exception e) {}
    }

    public void print(){
	System.out.println(knightmoves + "\n");
	for(int x = 2 ; x < board.length - 2; x++){
	    for(int y = 2 ; y < board[x].length - 2; y++){
	        int i = board[x][y];
		String s = String.format("%4d",i);
		System.out.printf(s);
	    }
	    System.out.println("\n");
	}
    }

    public void solve(){
	knightsTour(startloc[0],startloc[1]);
    }

    public void knightsTour(int x, int y){
	//If the knight would move out of bounds or to a previously
	//visited square, that's a no-no. That branch is invalid.
	//Also if it's finished then we're finished.
	if(solved)
	    return;
	if(knightmoves >= squares){
	    solved = true;
	    print();
	    return;
	}
	if(board[x][y] != 0)
	    return;
	
	//delay(100); //it's taking too long
	knightmoves++;
	board[x][y] = knightmoves;
        //print(); //I just wanna solve it
	
	//Now we test this branch in all 8 directions.
	knightsTour(x+2,y+1);
	knightsTour(x+2,y-1);
	knightsTour(x-2,y+1);
	knightsTour(x-2,y-1);
	knightsTour(x+1,y+2);
	knightsTour(x+1,y-2);
	knightsTour(x-1,y+2);
	knightsTour(x-1,y-2);
	
	/*
	  The reset - if this branch fails, we have to set all the squares
	  that we changed in the process of trying this branch back to 0.
	  And since knightmoves was being increased by 1 each time we tried
	  a new part, we have to decrease knightmoves by 1 for each time 
	  we increased it before.
	 */
	board[x][y] = 0;
	knightmoves--;
	return;
	//Writing return here is unnecessary because it's a void method, 
	//but stylistically, this is the final return case.
    }

    /*---------------------------- Main --------------------------------*/

    public static void main(String[] args){
	Knights k = new Knights(); //creates 5x5 board with 2-wide border
	k.solve();
    }

}
