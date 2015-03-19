public class LList{
    private Node dummy;
    private Node l;
    private int len;

    public LList(){
	dummy = new Node(0);
	l = null;
	dummy.setNext(l);
	len = 0;
    }

    /*----------------------------- Utilities ---------------------------------*/

    //Adds a Node with data i to the beginning of the list
    public void add(int i){
	Node tmp = new Node(i);
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

    public LLit getLLit(){
	LLit i = new LLit(l.getNext());
	return i;
    }
    
    /*------------------------------- Methods ---------------------------------*/

    //Returns the element at location n
    public int get(int n){
	int ans;
	Node tmp = l;
	while(n > 0){
	    tmp = tmp.getNext();
	    n--;
	}
	ans = tmp.getData();
	return ans;
    }

    //Inserts a Node with data i at location n
    public void add(int n, int i){
	Node ins = new Node(i);
	Node tmp = dummy;
	while(n > 0){
	    tmp = tmp.getNext();
	    n--;
	}
	ins.setNext(tmp.getNext());
	tmp.setNext(ins);
	len++;
    }

    //Removes the element at location n and returns it
    public int remove(int n){
	if(n < 0 || n > len){
	    //throw (NoSuchElementException e);
	}
	int ans;
	Node n1 = dummy;
        while(n > 0){
	    n1 = n1.getNext();
	    n--;
	}
        Node n2 = n1.getNext();
	Node n3 = n2.getNext();
	ans = n2.getData();
	n1.setNext(n3);
	return ans;
    }

    //Removes the first occurence of i in the list and returns true
    //if successful, false if i is not in the list
    public boolean removeFirstOccurence(int i){
	Node n1 = l;
	for(int j = 0 ; j < len - 1; j++){
	    if(n1.getData() == i){
		remove(j);
		return true;
	    }
	    else
	        n1 = n1.getNext();
	}
	return false;		
    }

    //Very much slow, has to go from first element each time it does get
    public int sumAll(){
	int sum = 0;
	for(int i = 0 ; i < len - 1; i++){
	    sum = sum + get(i);
	}
	return sum;
    }
    
}
    
