public class Point{
    private int xcor, ycor;
    private Point prev;

    public Point(int x, int y){
	xcor = x;
	ycor = y;
	prev = null;
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
	
}
