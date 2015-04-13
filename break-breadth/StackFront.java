public class StackFront extends Frontier{

    public StackFront(){
	f = new LinkedList<Point>();
    }

    public void add(Point p){
	f.add(0, p);
    }

}
