import java.util.*;

public class PFrontier{

    public LinkedList<Point> f = new LinkedList<Point>();
    //f is for frontier creative I know
    //This frontier is a priority list

    public void add(Point p){
	if(isEmpty())
	    f.add(0,p);
	else{
	    for(int i = 0 ; i < f.size() ; i++){
		if(p.getPri() > f.get(i).getPri())
		    f.add(i,p);
	    }
	}
    }

    public Point remove(){
        return f.remove();
    }

    public boolean isEmpty(){
	return f.isEmpty();
    }

    public String toString(){
	return f.toString();
    }

    public static void main(String[] args){
	PFrontier pf = new PFrontier();
	Point p1 = new Point(1,1);
	Point p2 = new Point(2,2);
	Point p3 = new Point(3,3);
	Point p4 = new Point(4,4);
	Point p5 = new Point(5,5);
	pf.add(p1);
	pf.add(p2);
	pf.add(p3);
	pf.add(p4);
	pf.add(p5);

	System.out.println(pf);
    }
    
}
