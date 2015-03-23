public class myStack<E>{
    private Node<E> stacktop;
    
    //n0 --> stacktop --> n1 --> n2
    public myStack(){
	
    }

    public void push(E data){
	Node<E> tmp = new Node<E>(data);
	stacktop.setNext(stacktop.getNext());
	tmp.setNext(stacktop);
	stacktop = tmp;
    }

    public E pop(){

    }

    public boolean empty(){

    }

    public E top(){

    }
}
