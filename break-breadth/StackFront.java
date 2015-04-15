public class StackFront extends Frontier{

    public LinkedList<Point> f = new LinkedList<Point>();    

    public void add(Point p){
	f.add(0, p);
    }

}
