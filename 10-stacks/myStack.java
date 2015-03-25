public class myStack<E>{

    /*--------------- Variables, Constructors, Utilities -----------------*/
    
    private Node<E> stacktop;
    
    public myStack(){
	stacktop = new Node<E>();
    }

    public String toString(){
	String s = "";
	Node<E> tmp;
	for(tmp = stacktop ; tmp.getNext() != null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    /*-------------------------Important Methods ---------------------------*/

    public void push(E data){
	Node<E> tmp = new Node<E>(data);
	tmp.setNext(stacktop);
	stacktop = tmp;
    }

    public E pop(){
	Node<E> tmp = stacktop;
	stacktop = tmp.getNext();
	return tmp.getData();
    }

    /*--------------------- Other Useful Methods --------------------------*/
    
    public boolean empty(){
	return stacktop == null;
    }

    public E top(){
        return stacktop.getData();
    }
    
}
