import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Selection{

    /*--------------- Variables, Constructors, Utilities ----------------*/

    private int[] numlist;
    private Random rnd;

    public Selection(int len){
	numlist = new int[len];
	rnd = new Random();
	ArrayList<Integer> dupes = new ArrayList<Integer>();
	//The dupes arraylist keeps track of which ints have already been
	//put into the numlist array, so numlist has no repeats

        for(int i = 0; i < len ; ){
	    int k = rnd.nextInt(2*len);
	    boolean used = false;

	    //We have to run through the entirety of dupes each time to 
	    //check, which kind of sucks, but idk how else to do it
	    for(int j = 0 ; j < dupes.size() ; j++){
		if(k == dupes.get(j)){
		    used = true;
		    break;
		}
	    }
	    if(!used){	
		numlist[i] = k;
	        dupes.add(k);
		i++;
	    }
	}
    }

    public int[] getNumlist(){
	return numlist;
    }

    /*------------------------- Partition Method ------------------------*/

    public int[] partition(int[] L, int start, int end){
	int[] D = new int[L.length];
	for(int i = 0 ; i < L.length ; i++){
	    if(i < start || i > end)
		D[i] = L[i];
	}
	int pivot = L[start];
	int sublength = end - start;
	/*
	  Pivot is the value we choose to sort into the right location.
	  Sublength is the number of elements between start and end, which
	  we use in the following loop to keep track of what element we
	  have to copy next from the original array.
	*/
	while(start < end){
	    for(int j = start+1 ; j <= sublength ; j++){
		//We loop from start+1 because L[start] is the pivot value,
		//which we aren't interested in placing anywhere yet.
		if(L[j] < pivot){
		    D[start] = L[j];
		    start++;
		}
		if(L[j] >= pivot){
		    D[end] = L[j];
		    end--;
		}
	    }
	}
	//When start is no longer less than end, that means there is only 
	//one spot left in the array, which has to go to the pivot value.
	D[start] = pivot;
	return D;
    }

    /*-------------------------- Select Method ---------------------------*/
    /*
      Returns the kth smallest element in array A
      low and high serve as boundaries of the search 
      First call is Select(A,k,0,A.length - 1) to search the full array
    */

    public int Select(int[] A, int k, int low, int high){
	
    }

    /*------------------------------- Main -------------------------------*/

    public static void main(String[] args){
	Selection s = new Selection(10);
	//System.out.println(Arrays.toString(s.getNumlist()));
	//int[] result = s.partition(s.getNumlist(),0,s.getNumlist().length - 1);
	//System.out.println(Arrays.toString(result));
    }

}
