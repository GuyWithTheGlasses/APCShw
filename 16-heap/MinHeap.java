import java.util.Arrays;

public class MinHeap{
    private int[] heap;

    /*------------------- Constructors and Utilities --------------------*/

    public MinHeap(){
	heaplist = new int[0];
    }

    public String toString(){
	return Arrays.toString(heap);
    }	

    private int getLeft(int i){
	//Returns index of left child of node at index i
	if(i = 0)
	    return 1;
	//Because 2*0-1 is -1, which won't work
        int lindex = 2*i - 1;
	if(lindex < heap.length)
	    return lindex;
	else
	    return null;
    }

    private int getRight(int i){
	//Returns index of right child of node at index i
	if(i = 0)
	    return 2;
	//Because 2*0 is 0, which also won't work
	int rindex = 2*i;
	if(rindex < heap.length)
	    return rindex;
	else
	    return null;
    }

    private int getParent(int i){
	//Returns index of parent of node at index i
	if(i = 0)
	    return null;
	//Orphan root QQ
	return i/2 - 1;
    }

    /*---------------------------- Methods -----------------------------*/

    public int findMin(){
	//returns minimum value in heap
	return heap[0];
    }



    public void removeMin(){
	//removes minimum value from heap
       
	int[] a = new int[heap.length - 1];
	//Create a new array 1 shorter than the original heap's array
	
	a[0] = heap[heap.length - 1];
	for(int i = 1 ; i < heap.length - 1; i++)
	    a[i] = heap[i];
	//Copy over all the elements from the original heap
	//Except swap the first and last elements
	
	pushDown(0, a);
	//Pushdown the new root to re-establish heap structure
	heap = a;
    }

    private void pushDown(int i, int[] h){
	//pushes down the value at index i in heap h
	int tmp = i;

	//While the node at tmp is greater than at least one of its children
        while(h[tmp] > getLeft(tmp)|| h[tmp] > getRight(tmp)){
	    int node = h[tmp];
	    int left = getLeft(tmp); //Indexes of the nodes 
	    int right = getRight(tmp); //left and right of tmp

	    if(h[left] <= h[right]){
		//Swap the node at tmp with the node at left
		h[tmp] = h[left];
		h[left] = node;
		//Point tmp to left
		tmp = left;
	    }
	    else{
		//Swap the node at tmp with the node at rightt
		h[tmp] = h[right];
		h[right] = node;
		//Point tmp to right
		tmp = right;
	    }
	}
    }



    public void insert(int i){
	//inserts a new value into the heap
	
	int[] b = new int[heap.length + 1];
	//create a new array 1 larger than the original heap array
	
	for(int i = 0 ; i < heap.length ; i++)
	    b[i] = heap[i];
	//copy over all the elements from the heap into the new array
	//this leaves the last entry blank

	b[b.length - 1] = i;
	//set the last element to the value being inserted
	
	siftUp(b.length - 1, b);
	//sift up the last element to re-establish heap structure
	heap = b;
    }

    private void siftUp(int i, int[] h){
	//sifts up the value at index i in heap h
	int tmp = i;
	
	//While the node at tmp is less than its parent
	while(h[tmp] < getParent(tmp)){
	    int node = h[tmp];
	    int parent = getParent(tmp);
	    
	    //Swap the node at tmp with the node at parent
	    h[tmp] = h[parent];
	    h[parent] = node;
	    //Point tmp to parent
	    tmp = parent;
	}
    }
   
}
