import java.util.Random;

public class Driver{
    public static void main(String[] args){
	Random rnd = new Random();
	
	LList l1 = new LList();
	for(int i = 0 ; i < 10 ; i++){
	    l1.add(""+rnd.nextInt(10));
	}
	System.out.println(l1);
	l1.add(0, ""+13);
	System.out.println(l1);
	l1.remove(0);
	System.out.println(l1);
    }
}
