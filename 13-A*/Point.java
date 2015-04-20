public class Point{
    private int xcor, ycor;
    private Point prev;
    private int priority;
    private int steps;

    public Point(int x, int y){
	xcor = x;
	ycor = y;
	prev = null;
    }
    public Point(int x, int y, int pri){
	xcor = x;
	ycor = y;
	priority = pri;
    }

    public int getX(){
	return xcor;
    }
    public int getY(){
	return ycor;
    }

    public Point getPrev(){
	return prev;
    }
    public void setPrev(Point p){
	prev = p;
    }

    public int getPri(){
	return priority;
    }
    public void setPri(int p){
	priority = p;
    }
    
    public int getSteps(){
	return steps;
    }
    public void setSteps(int s){
	steps = s;
    }

}
