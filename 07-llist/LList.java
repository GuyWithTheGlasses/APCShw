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

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
	len++;
    }
		
    public String toString(){
	String s = "";
	Node tmp;
	for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

    /*------------------------------- Methods ---------------------------------*/
		
    public Node get(int n){
	Node ans = null;
	//The only way there is no element at index n is if the index
	//is too big or negative
	Node tmp;
	int count = 0;
	//Keep moving through the llist while keeping a counter of which element
	//we are up to; when we reach the proper element, we stop
	for(tmp = dummy ; count < len ; tmp = tmp.getNext() ){
	    if(n == count){
		ans = tmp;
		break;
            }
	    else
		count++;
        }
        return ans;
    }
    /*
    public void add(int n, String s){
	Node ins = new Node(s);
	Node tmp;
	int count = 0;
	//Otherwise, we use the same algorithm from find to get to the 
	//nth element of the llist. Then we switch the nodes. 
	for(tmp = l ; tmp != null ; tmp = tmp.getNext() ){
	    if(n == count+1){
		ins.setNext(tmp.getNext());
	        tmp.setNext(ins);
		break;
	    }
	    else
		count++;
	}
    }

    */
    public void add(int n, String s){
	Node ins = new Node(s);
	Node tmp = get(n-1);
	ins.setNext(tmp.getNext());
	tmp.setNext(ins);
	len++;
    }

}
    
