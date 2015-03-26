public class myQueue<E>{
    private Node<E> first;
    private Node<E> last;

    /*-------------------- Constructors, Utilities ---------------------*/

    public myQueue(){
	first = new Node<E>();
        last = first;
	first.setNext(last);
    }

    public String toString(){
	Node<E> tmp = first.getNext();
	String s = "";
	for( ; tmp != last ; tmp = tmp.getNext())
	    s = s + tmp.getData() + " <-- ";
	s = s + last.getData();
	return s;
    }

    /*----------------------- Fundamental Methods -----------------------*/

    public void enqueue(E data){
	Node<E> tmp = new Node<E>(data);
	last.setNext(tmp);
	last = tmp;
    }

    public E dequeue(){
	if(!empty()){
	    Node tmp = first.getNext();
	    first.setNext(tmp.getNext());
	    return (E)tmp.getData();
	}
	else
	    return null;
    }

    /*----------------------- Helpful Methods --------------------------*/

    public boolean empty(){
	return first == last;
    }

    public E head(){
	return first.getNext().getData();
    }

    /*---------------------------- Main -------------------------------*/

    public static void main(String[] args){
	myQueue<Integer> q = new myQueue<Integer>();
	System.out.println(q);

	for(int i = 0 ; i < 10 ; i++)
	    q.enqueue(i);
	System.out.println(q);

	for(int j = 0 ; j < 5 ; j++)
	    System.out.println("Removing "+q.dequeue());
	System.out.println(q);	
    }
   
}
