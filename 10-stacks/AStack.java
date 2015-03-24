public class AStack<E> {

    private E[] Stack = new E[10];

    private int Top = -1;
    
    public void push(E data){
	Top++;
	if(Top >= Stack.length){
	    Stack[Top] = data;
	}
	else{
	    E[] temp = new E[Stack.length + 10];
	    for (int i = 0; i < Stack.length ; i++){
		temp[i] = Stack[i];
	    }
	    temp[Top] = data;
	    Stack = temp;
	}
    }

    public E pop(){
    }

}
