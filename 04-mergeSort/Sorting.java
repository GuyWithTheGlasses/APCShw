import java.util.*;

public class Sorting{

    /*--------------------- Variables & Constructors ----------------------*/
    
    private int listlength;
    private ArrayList<Integer> nums;
    private Random rnd = new Random();

    public Sorting(){
	listlength = 10;
	nums = new ArrayList<Integer>();
	for(int i = 0 ; i < listlength ; i++){
	    nums.add(rnd.nextInt(listlength));
	}
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

    public void msort(ArrayList<Integer> L){
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
	    
	    return merge(a,b);
	}
	else{
	    return L;
	}
    }
    
    /*----------------------------- Main -------------------------------*/

    public static void main(String[] args){
	Sorting s = new Sorting();
	/*
	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();
	for(int i = 0 ; i < 5 ; i++){
	    al1.add(i);
	    al2.add(i+1);
	}
	System.out.println(s.merge(al1,al2));
	*/
	
    }
}
