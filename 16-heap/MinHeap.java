import java.util.Arrays;

public class MinHeap{
    private int[] heaplist;

    /*------------------- Constructors and Utilities --------------------*/

    public MinHeap(){
	heaplist = new int[0];
    }

    public String toString(){
	return Arrays.toString(heaplist);
    }	

    private int getLeft(int i){
	//Returns index of left child of node at index i
	if(i = 0)
	    return 1;
	//Because 2*0-1 is -1, which won't work
        int lindex = 2*i - 1;
	if(lindex < heaplist.length)
	    return lindex;
	else
	    return null;
    }
    private int getRight(int i){
	//Returns index of right child of node at index i
	if(i = 0)
	    return 2;
	//Because 2*0 is 0, which also won't work
	int rindex = 2*i;
	if(rindex < heaplist.length)
	    return rindex;
	else
	    return null;
    }
    private int getParent(int i){
	//Returns index of parent of node at index i
	if(i = 0)
	    return null;
	//Orphan root QQ
	return i/2 - 1;
    }

    /*---------------------------- Methods -----------------------------*/

    public int findMin(){
	//returns minimum value in heap
	return heaplist[0];
    }
 
    public void removeMin(){
	
    }
   
}
