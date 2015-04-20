import java.util.*;

public class PFrontier{

    public LinkedList<Point> f = new LinkedList<Point>();
    //f is for frontier creative I know
    //This frontier is a priority list

    public void add(Point p){
	int i = 0;
	while(i < f.size()){
	    if(p.getPri() < f.get(i).getPri()){
		f.add(i,p);
		return;
	    }
	    i++;
	}
	f.add(i,p);
    }

    public Point remove(){
	return f.remove();
    }

    public boolean isEmpty(){
	return f.isEmpty();
    }

    public String toString(){
        String s = "";
        for(int i = 0 ; i < f.size() ; i++)
	    s = s + "["+f.get(i).getX()+","+f.get(i).getY()+"] --> ";
	s = s + " null ";
	return s;	    
    }

    
    public static void main(String[] args){
	PFrontier pf = new PFrontier();
	Point p1 = new Point(1,1);
	p1.setPri(1);
	pf.add(p1);
	System.out.println(pf);
	Point p2 = new Point(2,2);
	p2.setPri(3);
	pf.add(p2);
	System.out.println(pf);
	Point p3 = new Point(3,3);
	p3.setPri(2);
	pf.add(p3);
	System.out.println(pf);
	Point p4 = new Point(4,4);
	p4.setPri(4);
	pf.add(p4);
	System.out.println(pf);
	Point p5 = new Point(5,5);
	p5.setPri(0);
	pf.add(p5);
	System.out.println(pf);
	System.out.println(pf.remove());
	System.out.println(pf);
    }
    
    
}

