public class LList{
    private Node l = null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
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
		
    public String find(int n){
	String ans = "Out of bounds";
	//The only way there is no element at index n is if the index
	//is too big or negative
	Node tmp;
	int count = 0;
	for(tmp = l ; tmp != null ; tmp = tmp.getNext() ){
	    if(n == count){
		ans = tmp.getData();
		break;
            }
	    else
		count++;
        }
        return ans;
    }

    public void insert(int n, String s){
	Node ins = new Node(s);
	Node tmp;
	int count = 0;
	//Edge case: when we want to change the start of the llist, we
	//take the new node, set its next as l, and reset l (the start).
	if(n == 0){
	    ins.setNext(l);
	    l = ins;
	    return;
	}
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

}
    
