import java.util.Random;

public class Knights{

    /*--------------------- Variables & Constructors ----------------------*/
    
    private int[][] board;
    private int knightmoves;
    private Random rnd = new Random();

    public Knights(int x, int y){
	board = new int[x][y];
	setup();
    }

    public Knights(){
	this(9,9);
    }

    /*
      In setup we fill the border of the board with -1's and place the knight
      in a random location in the 5x5.
      Thus the knight has already made its 1st move and knightmoves = 1.
    */
    private void setup(){
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
	board[rnd.nextInt(5)+2][rnd.nextInt(5)+2] = 1;
	knightmoves = 1;
    }

    /*-------------------------- Methods -------------------------------*/

    public void print(){
	for(int x = 0 ; x < board.length ; x++){
	    for(int y = 0 ; y < board[x].length ; y++){
	        int i = board[x][y];
		String s = String.format("%d",i);
		System.out.printf(s);
	    }
	    System.out.print("\n");
	}
    }

    public void knightsTour(){
	
    }

    /*---------------------------- Main --------------------------------*/

    public static void main(String[] args){
	Knights k = new Knights(); //creates 5x5 board with 2x2 border
        k.print();
    }

}
