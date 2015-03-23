import java.io.*;
import java.util.*;

public class LLit<E> implements Iterator<E>{
    private Node<E> t;

    public LLit(Node<E> n){
	t=n;
    }

    public boolean hasNext(){
	return t != null;
    }

    public E next(){
	E retval = t.getData();
	t=t.getNext();
	return retval;
    }

    //This will remove the item after t 
    //However, next moves t down the line by 1, and returns the 
    //value t used to have. Not really sure how we can access 
    //that node anymore, we already passed it?

    //Okay, apparently this works. I don't know why. 
    public void remove(){
	t.setNext(t.getNext().getNext());
    }
}

