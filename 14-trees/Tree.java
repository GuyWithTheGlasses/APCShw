import java.util.*;

public class Tree{

    private Node root;

    public Tree(){
	root = null;
    }

    public Node getRoot(){
	return root;
    }

    public void insert(Node groot, int i){
	//Inserts a node with data i in the proper location on the tree
	//with root pointing to groot
	Node n = new Node(i);

	//Base case where our tree is empty
	if(groot == null)
	    groot = n;

	//Otherwise, we have to search through the tree
	else{
	    Node t = groot;
	    Node t2 = t; //piggybacking
	    
	    boolean onLeft = false;
	    //so we know whether we add on the left or right of t2
	    
	    while(t != null){
		t2 = t;
		//int c = t.getData().compareTo(i);
		//"int cannot be dereferenced in java" ...what?
		if(i > t.getData()){
		    t = t.getRight();
		    onLeft = false;
		}
		else if(i < t.getData()){
		    t = t.getLeft();
		    onLeft = true;
		}
	    }
	    if(onLeft)
		t2.setLeft(n);
	    else
		t2.setRight(n);
	}
    }

    public Node search(Node groot, int i){
	//Finds a node with data i and returns it
	//Else returns null
	Node tmp = groot;
	while(tmp != null){
	    int cur = tmp.getData();
	    System.out.println(tmp);
	    if(i == cur)
		return tmp;
	    else if(i > cur)
		tmp = tmp.getRight();
	    else
		tmp = tmp.getLeft();
	}
	return null;		    
    }

    public static void main(String[] args){
	Tree t = new Tree();
	for(int i = 0 ; i < 10; i--)
	    t.insert(t.getRoot(),i);
	t.insert(t.getRoot(),11);
	t.search(t.getRoot(),11);
    }
    
}
