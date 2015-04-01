public class Point{
    private int xcor, ycor;
    private Point prev;

    public Point(int x, int y){
	xcor = x;
	ycor = y;
    }

    public int getX(){
	return xcor;
    }
    public void setX(int x){
	xcor = x;
    }

    public int getY(){
	return ycor;
    }
    public void setY(int y){
	ycor = y;
    }
    
    public int[] getXY(){
        int[] a = new int[2];
	a[0] = xcor;
	a[1] = ycor;
	return a;
    }
    public void setXY(int x, int y){
	xcor = x;
	ycor = y;
    }

}
