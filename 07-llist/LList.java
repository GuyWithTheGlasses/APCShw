public class LList{
    private Node dummy;
    private Node l;
    private int len;

    public LList(){
	dummy = new Node("START");
	l = null;
	dummy.setNext(l);
	len = 0;
    }

    /*------------------------------ Utilities ---------------------------------*/

    //Adds a Node with data s to the beginning of the list
    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
	dummy.setNext(l);
	len++;
    }
		
    public String toString(){
	String s = "";
	Node tmp;
	for (tmp = dummy ; tmp != null ; tmp = tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    /*------------------------------- Methods ---------------------------------*/

    //Returns the element at location n
    public Node get(int n){
	Node tmp = dummy;
	while(n > 0){
	    tmp = tmp.getNext();
	    n--;
	}
	return tmp;
    }

    //Inserts a Node with data s at location n
    public void add(int n, String s){
	Node ins = new Node(s);
	Node tmp = get(n-1);
	ins.setNext(tmp.getNext());
	tmp.setNext(ins);
	len++;
    }

    //Removes the element at location n and returns it
    public Node remove(int n){
	Node n1 = l;
	while(n > 0){
	    n1 = n1.getNext();
	    n--;
	}
        Node n2 = n1.getNext();
	Node n3 = n2.getNext();
	n1.setNext(n3);
	return n2;
    }

}
    
