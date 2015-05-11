import java.util.*;

public class Tree{
    private Node root;

    public Tree(){
	root = null;
    }

    /*------------------- Insert and Search Methods ----------------------*/

    public void insert(int i){
	Node n = new Node(i);
	Node t2 = null; //Piggyback nodes
	Node t = root;
	//If root is null, well we just insert the node there
	if (root == null){
	    root = n;
	    return;
	}
	//If it's not null, we move left/right depending on the value of i
	//to find the proper location to insert the nodex
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
	//By now, t should point the location the node should go
	//And t2 should point at the node right before it
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
	//For convieniece's sake
        Node retval = rsearch(root,i);
	if(retval == null)
	    return "not found";
	else
	    return ""+retval;
    }

    /*------------------------ How to toString ---------------------------*/

    public String traverse(Node groot){
	String s = "";
	if(groot != null)
	    s = s + traverse(groot.getLeft()) +
		groot.getData() +", " +
		traverse(groot.getRight());
	//Intuitively, this always prints in order
	//Because we do the left first always, which is smaller
	//This is known as an in-order traversal
	return s;
    }

    public String toString(){
	return traverse(root);
    }

    /*------------------------- Finally, Delete --------------------------*/
    /*
      Three cases:
      1. Remove a leaf
       - point the previous node to null
      2. Node has one child
       - point the previous node to the current node's child
      1 and 2 can basically be combined into one algorithm.

      3. Node has two children 
       - find largest node on left subtree / smallest on right subtree
         *Go as far to the right as you can on the left
         *This node always has, at most, 1 child
       - copy that node's data into the space left by the deleted node
       - set the previous node to null
     */
    public void delete(int i){
	Node i = new Node(i);
	Node t2 = null;
	Node t = root;
	while(t != null){
	    if(t.getData() == i)
	        break;
	    t2 = t;
	    else if(t.getData() < i)
		t = t.getRight();
	    else if(t.getData() > i)
		t = t.getLeft();
	    else
		return;
	}
	//Same algorithm as insert, t2 points at the node before our target
	if(t.getLeft() == null)
	    t2.setRight(t.getRight());
	else if(t.getRight() == null)
	    t2.setLeft(t.getLeft());
	else{
	    t = t2.getLeft();
	    while(t.getRight() != null)
		t = t.getRight();
	    
	    

	/*------------------------------ Main --------------------------------*/
    
    public static void main(String[] args){
	Tree t = new Tree();
	Random rnd = new Random();
	for(int i = 0 ; i < 20; i++)
	    t.insert(rnd.nextInt(20));
	System.out.println(t.search(5));
	System.out.println(t);
    }
    
}
