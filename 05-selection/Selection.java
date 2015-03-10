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
    /*
      Input: Array, start index, end index
      Output: Int which is sorted location of the first item from the array

      Partition takes that first element and puts it into its sorted location
      All elements before it are lower, all after it are higher
      This version creates a new array because initially I coded it to return
      the array after it got partitioned
    */

    public int partition(int[] L, int start, int end){
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
		    
		    start++;
		}
		if(L[j] >= pivot){
		    end--;
		}
	    }
	}
	//When start is no longer less than end, that means there is only 
	//one spot left in the array, which has to go to the pivot value
        return start;
    }

    /*-------------------------- Select Method ---------------------------*/
    /*
      Returns the kth smallest element in array A
      low and high serve as boundaries of the search 
      First call is Select(A,k,0,A.length - 1) to search the full array
    */

    public int select(int[] A, int k, int low, int high){
	//Sort the first element of the array A and find what it is
	int sortedIndex = partition(A, low, high);
	System.out.println(Arrays.toString(numlist));
	int sortedVal = A[sortedIndex];
	System.out.println("index: "+sortedIndex+" value: "+sortedVal);
	
	//If that element happens to be the kth term of the array  when 
	//sorted, that's your kth largest term
	if(sortedIndex == k)
	    return sortedVal;
	    
	//Else try 1 of 2 paths: if the element's index is less than k,
	//partition the lower portion of the array
	else if(sortedIndex < k){
	    int sortedIndex1 = partition(A, low, sortedIndex - 1);
	    return A[sortedIndex1];
	}
	//If the element's index is more than k, partition the upper portion
	else{
	    int sortedIndex2 = partition(A, sortedIndex + 1, high);
	    return A[sortedIndex2];
	}
    }


    /*------------------------------- Main -------------------------------*/

    public static void main(String[] args){
	Selection s = new Selection(10);
	int[] nums = s.getNumlist();
	System.out.println(Arrays.toString(nums));
	//System.out.println(s.partition(nums, 0, nums.length - 1));
	int kth = s.select(nums, 3, 0, nums.length-1);
	System.out.println(kth);
    }

}
