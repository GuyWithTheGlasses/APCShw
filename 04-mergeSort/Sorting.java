import java.util.*;

public class Sorting{

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

    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	ArrayList<Integer> mergedlist = new ArrayList<Integer>();
	int placeA = 0;
	int placeB = 0;
	for(int i = 0 ; i < a.size() + b.size() ; i++){
	    int valueA = a.get(placeA);
	    int valueB = b.get(placeB);
	    if(valueA < valueB){
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

    public String toString(ArrayList<Integer> al){
	String str = "{";
	for(int i = 0 ; i < al.size() ; i++){
	    str = str + al.get(i) + " ,";
	}
	str = str + "}";
	return str;
    }

    public static void main(String[] args){
	Sorting s = new Sorting();
	ArrayList<Integer> al1 = new ArrayList<Integer>();
	ArrayList<Integer> al2 = new ArrayList<Integer>();
	for(int i = 0 ; i < 5 ; i++){
	    al1.add(i);
	    al2.add(i+1);
	}
	System.out.println(s.merge(al1,al2));
	
    }
}
