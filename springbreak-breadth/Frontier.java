public class Frontier{

    private myQueue<Integer> xcoords = new myQueue<Integer>();
    private myQueue<Integer> ycoords = new myQueue<Integer>();

    public void add(int x, int y){
	xcoords.enqueue(x);
	ycoords.enqueue(y);
    }

    public int[] remove(){
	int[] a = new int[2];
	a[0] = xcoords.dequeue();
	a[1] = ycoords.dequeue();
	return a;
    }
   
}
