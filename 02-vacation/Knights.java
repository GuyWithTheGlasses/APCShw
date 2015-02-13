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
	this(7,7);
    }

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

    public void knightsTour(){
	
    }

    /*---------------------------- Main --------------------------------*/

    public static void main(String[] args){
	Knights k = new Knights();
	System.out.println(k);
    }

}
