public class Node<E>{
    private Node<E> next;
    private E data;

    public Node(){
	data = null;
	next = null;
    }
    public Node(E i){
	data = i;
	next = null;
    }

    public void setData(E i){
	data = i;
    }

    public E getData(){
	return data;
    }

    public void setNext(Node<E> n){
	next = n;
    }

    public Node<E> getNext(){
	return next;
    }

    public String toString(){
	return ""+data;
    }
    
}
