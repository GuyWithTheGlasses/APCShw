import java.util.*;

public class Tree{

    private Node root;

    public Tree(){
	root = null;
    }

    /*--------------------- Insert and Search Methods ------------------------*/
    /*
    public void insert(Node groot, int i){
	//Inserts a node with data i in the proper location on the tree
	//with root pointing to groot
	Node n = new Node(i);
	//Base case where our tree is empty
	if(groot == null){
	    groot = n;
	    return;
	}
	//Otherwise, we have to search through the tree
	Node t = groot;
	Node t2 = null; //piggybacking
	while(t != null){
	    t2 = t;
	    //int c = t.getData().compareTo(i);
	    //"int cannot be dereferenced in java" ...what?
	    if(i == t.getData())
		return;
	    else if(i > t.getData())
		t = t.getRight();
	    else if(i < t.getData())
		t = t.getLeft();
	    else
		return;
	}
	//Insert new node on left or right depending on the value of i
	if(i > t2.getData())
	    t2.setRight(n);
	else
	    t2.setLeft(n);
    }
    */

    public void insert(int i){
	Node n = new Node(i);
	Node t2 = null;
	Node t = root;
	if (root == null){
	    root = n;
	    return;
	}						
	while (t!=null){
	    t2 = t;
	    if (t.getData() == i)
		return;
	    else if (t.getData() < i)
		t = t.getRight();
	    else if (t.getData() > i)
		t = t.getLeft();
	    else
		return;
	}				
	if (i > t2.getData())
	    t2.setRight(n);
	else
	    t2.setLeft(n);
    }

    public Node rsearch(Node groot, int i){
	//Recursive form of the search
	if(groot == null || groot.getData() == i)
	    return groot;
	else if(i > groot.getData())
	    return rsearch(groot.getRight(), i);
	else
	    return rsearch(groot.getLeft(), i);	    
    }

    public String search(int i){
        Node retval = rsearch(root,i);
	if(retval == null)
	    return "not found";
	else
	    return ""+retval;
    }

    public String traverse(Node groot){
	String s = "";
	if(groot == null)
	    return s;
	else{
	    s = s + traverse(groot.getLeft())+" ";
	    s = s + groot.getData()+" ";
	    s = s + traverse(groot.getRight())+" ";
	    return s;
	}	
    }
    
    public String toString(){
	return traverse(root);
    }

    /*-------------------------------- Main --------------------------------*/
    
    public static void main(String[] args){
	Tree t = new Tree();
	Random rnd = new Random();
	for(int i = 0 ; i < 20; i++)
	    t.insert(rnd.nextInt(20));
	System.out.println(t.search(5));
	System.out.println(t);
    }
    
}
