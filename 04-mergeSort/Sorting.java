import java.util.*

public class Sorting{

    private int listlength;
    private ArrayList<Integer> nums;
    private Random rnd = new Random();

    public Sorting(int l){
	listlength = l;
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
	    if(valueA > valueB){

	    }
	}
	return mergedlist;     
    }

}
