import java.util.*;

public class Sorting{

    /*--------------------- Variables & Constructors ----------------------*/
    
    private int listlength;
    private ArrayList<Integer> nums;
    private Random rnd = new Random();
    private boolean finished;

    public Sorting(){
	this(10);
    }

    public Sorting(int l){
	listlength = l;
	nums = new ArrayList<Integer>();
	for(int i = 0 ; i < listlength ; i++){
	    nums.add(rnd.nextInt(listlength));
	}
    }

    public ArrayList<Integer> getList(){
	return nums;
    }

    /*------------------------- Merge Method ---------------------------*/
    /*
      Instead of using arraylist's remove method (because that requires 
      extra looping) I decided to just keep counter variables to keep track
      of what element of the arraylist we were up to.
      placeA and B are the current arraylist indexes 
      valueA and B are the values at indexes A and B in their respective arraylists
    */
    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	ArrayList<Integer> mergedlist = new ArrayList<Integer>();
	int placeA = 0;
	int placeB = 0;
	for(int i = 0 ; i < a.size() + b.size() ; i++){
	    //Instantiate both as -1, so that if the array index is out
	    //of bounds, we know to only pick from the other pile
	    int valueA = -1;
	    int valueB = -1;
	    
	    //To avoid errors, only get the number if its location is within
	    //the arraylist length, so we have a check here
	    if(placeA < a.size())
	        valueA = a.get(placeA);
	    if(placeB < b.size())
	        valueB = b.get(placeB);

	    //Choose the lower value to add to the final list first
	    //Make sure you don't add the -1 of course
	    if((valueA < valueB && valueA != -1) || valueB == -1){
		mergedlist.add(valueA);
		placeA++;
	    }
	    else{
		mergedlist.add(valueB);
		placeB++;
	    }
	}
	
	return mergedlist;     
    }

    /*----------------------- MergeSort Method -------------------------*/

    public ArrayList<Integer> msort(ArrayList<Integer> L){
	if(L.size() > 1){
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    ArrayList<Integer> b = new ArrayList<Integer>();
	    for(int i = 0 ; i < L.size()/2 ; i++)
		a.add(L.get(i));
	    for(int j = L.size()/2 ; j < L.size() ; j++)
		b.add(L.get(j));

	    ArrayList<Integer> r1 = new ArrayList<Integer>();
	    r1 = msort(a);
	    ArrayList<Integer> r2 = new ArrayList<Integer>();
	    r2 = msort(b);
	    return merge(r1,r2);
	}
	else{
	    return L;
	}
    }
    
    /*----------------------------- Main -------------------------------*/

    public static void main(String[] args){
	/*
	  Time for 1000000 = 2.046 sec
	  Time for 2000000 = 4.058 sec
	  Time for 4000000 = 8.078 sec
	  Time for 6000000 = 19.121 sec
	  Time for 8000000 = 23.179 sec
	  Time for 10000000 = 29.232 sec
	  Time for 20000000 = 1 min 13.177 sec
	  Appears to grow slightly above n^2 
	  But initial times are much lower than bsort, ssort, isor
	  Only starts taking long in the 10^8 range
	*/
	int length = 20000000;
	if(args.length > 0)
	    length = Integer.parseInt(args[0]);
	Sorting s = new Sorting(length);
	s.msort(s.getList());
	//System.out.println("Original List: "+"\n"+s.getList()+"\n");
	//System.out.println("Sorted List: "+"\n"+s.msort(s.getList())+"\n");
    }
}
