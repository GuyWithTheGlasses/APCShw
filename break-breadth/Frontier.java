public class Frontier{

    private myQueue<Point> f;
    //f is for frontier #creativity

    public Frontier(){
	f = new myQueue<Point>();
    }

    public void add(Point p){
	f.enqueue(p);
    }

    public Point remove(){
        return f.dequeue();
    }

    public int[] getCoords(){
	//returns x and y of the first element in the frontier
	return f.top().getXY();
    }
   
}
