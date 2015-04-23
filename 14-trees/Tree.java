import java.util.*;

public class Tree<E>{

    private Node<E> root;

    public Tree(){
	root = null;
    }

    public void insert(int i){
	Node t = root;
	Node t2 = t;
	while(t != null){
	    t2 = t;
	    int c = t.getData().compareTo(i);
	    if(c > 0)
	}
    }
    
}
