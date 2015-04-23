public class Node<E>{

    private E data;
    private Node<E> left, right;

    public Node(E i){
	data = i;
	left = null;
	right = null;
    }

    public Node getLeft(){
	return left;
    }
    public void setLeft(Node<E> l){
	left = l;
    }

    public Node getRight(){
	return right;
    }
    public void setRight(Node<E> r){
        right = r;
    }

    public E getData(){
	return data;
    }
    public void setData(E d){
	data = d;
    }
    
}

