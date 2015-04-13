import java.util.*;

public class Frontier{

    public LinkedList<Point> f;
    //f is for frontier creative I know

    public Frontier(){
	f = new LinkedList<Point>();
    }

    public void add(Point p){
	//adds to back of queue
	f.add(p);
    }

    public Point remove(){
	//removes from front of queue
        return f.remove(0);
    }

    public boolean isEmpty(){
	return f.isEmpty();
    }
    
}
