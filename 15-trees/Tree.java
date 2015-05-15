import java.util.*;

public class Tree{    
    private Node root;

    /*---------------------- Copied from the BST -----------------------*/
    
    public Tree(){
	root = null;
    }

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

    /*---------------------- Cool Routines -------------------------*/

    public int numNodes(Node t){
	if(t == null)
	    return 0;
	else
	    return 1 + numNodes(t.getLeft()) + numNodes(t.getRight());
	//If we want to get the sum of all the nodes
	//we replace 1 with t.getValue()
    }

    public int maxValue(Node t){
	//Largest value in tree
	if(t == null)
	    return Integer.MIN_VALUE;
	else{
	    int maxr = maxVal(t.getRight());
	    int maxl = maxVal(t.getLeft());
	    return Math.max(maxr, Math.max(maxl, t.getValue()) );
	}
    }

    public int height(Node t){
	//Longest root to leaf path
	if(t == null)
	    return 0;
	else
	    return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
    }

    public int diameter(Node t){
	//Longest leaf to leaf path
	int plen1 = height(t.getLeft()) + height(t.getRight()) + 2;
	int plen2 = diameter(t.getLeft());
	int plen3 = diameter(t.getRight());
	return Math.max(plen1, Math.max(plen2, plen3));
    }
    
}
