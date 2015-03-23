public class Node<E>{
    Node<E> next;
    E data;

    public Node(E i){
	data = i;
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
