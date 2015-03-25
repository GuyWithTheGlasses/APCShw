public class AStack<E> {
    private E[] stack;
    private int top;

    public AStack(){
	stack = new E[10];
	top = -1;
    }
    
    public void push(E data){
	top++;
	if(top <= stack.length){
	    stack[top] = data;
	}
	else{
	    E[] temp = new E[stack.length + 10];
	    for (int i = 0; i < stack.length ; i++){
		temp[i] = stack[i];
	    }
	    temp[top] = data;
	    stack = temp;
	}
    }

    public E pop(){
	E temp = stack[top];
	stack[top] = null;
	top--;
	return temp;
    }

}
