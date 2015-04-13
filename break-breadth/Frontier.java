public class Frontier{

    private myQueue<Point> f;
    //f is for frontier creative I know

    public Frontier(){
	f = new myQueue<Point>();
    }

    public void add(Point p){
	//adds to back of queue
	f.enqueue(p);
    }

    public Point remove(){
	//removes from front of queue
        return f.dequeue();
    }

    public int getX(){
	return f.head().getX();
    }

    public int getY(){
	return f.head().getY();
    }

    public int[] getCoords(){
	//returns x and y of the first element in the frontier
	return f.head().getXY();
    }

    public String toString(){
	return f.toString();
    }
   
}
