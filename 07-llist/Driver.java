import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args){
	Random rnd = new Random();
	LList l1 = new LList();
	for(int i = 0 ; i < 10 ; i++){
	    l1.add(rnd.nextInt(10));
	}
	/*
	System.out.println(l1);
	l1.add(0,13);
	System.out.println(l1);
	System.out.println(l1.remove(1));
	System.out.println(l1);
	System.out.println(l1.get(1));
	System.out.println(l1.removeFirstOccurence(7));
	System.out.println(l1);
	*/
	//System.out.println(l1.sumAll());

	LLit i = l1.getLLit();
	while(i.hasNext()){
	    int number = i.next();
	    System.out.print(number+" --> ");
	}
	System.out.println("null");
    }
}
