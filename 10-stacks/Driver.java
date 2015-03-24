public class Driver{
    public static void main(String[] args){

	/*-------------------- Linked List Stack ----------------------*/
	myStack<Integer> stk = new myStack();
	System.out.println(stk);
	for(int i = 0 ; i < 10 ; i++){
	    stk.push(i);
	}
	System.out.println(stk);
	for(int j = 0 ; j < 5 ; j++){
	    System.out.println("Removing "+stk.pop());
	}
	
	System.out.println(stk);
	System.out.println(stk.empty());
	System.out.println("Top: "+stk.top());

	/*----------------------- Array Stack ------------------------*/
    }
}
