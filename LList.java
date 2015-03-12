public class LList{
		private Node l=null;

		public void add(String s){
				Node tmp = new Node(s);
				tmp.setNext(l);
				l = tmp;
		}
		
		public String toString(){
				String s = "";
				Node tmp;
				for (tmp=l ; tmp!=null ; tmp=tmp.getNext()){
						s = s + tmp + " --> ";
				}
				s = s + "null";
				return s;
		}
		
		public String find(int n){
		    String ans;
		    Node tmp;
		    int count = 0;
		    for(tmp = l ; tmp != null ; tmp = tmp.getNext() ){
		        if(n == count){
		            ans = tmp.getData();
		            break;
            }
		        else
		            count++;
        }
        return ans;
    }
    
		            
}