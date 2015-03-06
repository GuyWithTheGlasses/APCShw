import java.util.Random;

public class Select{

    private int[] numlist;
    private Random rnd;

    public Select(int size){
	numlist = new int[size];
	rnd = new Random();
	for(int i = 0 ; i < size ; i++){
	    numlist[i] = rnd.nextInt(i);
	}
    }

    public int[] getNumlist(){
	return numlist;
    }

    /*------------------------- Partition Method ------------------------*/

    public void partition(int[] L, int start, int end){
	int[] D = new int[L.length];
	for(int i = 0 ; i < L.length ; i++){
	    if(i < start && i > end){
		D[i] = L[i];
	    }
	}
	int pivot = L[start];
	for(int j = 0 ; j > start && j <= end ; j++){
	    if(L[j] < pivot){
		D[start] = L[j];
		start++;
	    }
	    if(L[j] > pivot){
		D[end] = L[j];
		end--;
	    }
	}
    }

    /*------------------------------- Main -------------------------------*/

    public static void main(String[] args){
	Select s = new Select(10);
	s.partition(s.getNumlist());
    }

}
