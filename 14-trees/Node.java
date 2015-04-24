public class Node{

    private int data;
    private Node left, right;

    public Node(int i){
	data = i;
	left = null;
	right = null;
    }

    public Node getLeft(){
	return left;
    }
    public void setLeft(Node l){
	left = l;
    }

    public Node getRight(){
	return right;
    }
    public void setRight(Node r){
        right = r;
    }

    public int getData(){
	return data;
    }
    public void setData(int d){
	data = d;
    }
    
}

