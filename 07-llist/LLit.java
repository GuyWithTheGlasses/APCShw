public class LLit{
    //Linked list iterator
    private Node t;
    
    public LLit(Node n){
	t = n;
    }

    public boolean hasNext(){
	return t != null;
    }

    public int next(){
	int retval = t.getData();
	t = t.getNext();
	return retval;
    }
    
}
