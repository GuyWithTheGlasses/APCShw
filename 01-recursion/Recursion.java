public class Recursion{

    /*------------------- Basic Recursion Examples -----------------*/

    //Given an int n, return n factorial
    public int fact(int n){
	if(n <= 1)
	    return 1;
	else
	    return n*fact(n-1);
    }
    
    //Given an int n, return the nth fibonacci number
    //precondition: n is an int >= 1
    public int fib(int n){
	if(n == 0)
	    return 0;
	if(n == 1)
	    return 1;
	else
	    return fib(n-1) + fib(n-2);
    }

    //Given a String s, find the length of the string
    public int len(String s){
	if(s.equals(""))
	    return 0;
	else
	    return 1 + len(s.substring(1));
    }

    //Given a String s and a char c, find the number of times 
    //the char c occurs in the String s
    public int count(String s, char c){
	if(len(s) == 0)
	    return 0;
	else if(s.charAt(0) == c)
	    return 1 + count(s.substring(1),c);
	else
	    return 0 + count(s.substring(1),c);	   
    }

    /*---------------------- Coding Bat Problems -----------------------*/

    public int bunnyEars2(int bunnies) {
	if(bunnies == 0)
	    return 0;
	else if(bunnies % 2 == 1)
	    return 2 + bunnyEars2(bunnies - 1);
	else
	    return 3 + bunnyEars2(bunnies - 1);
    }

    public int sumDigits(int n) {
	if(n == n % 10)
	    return n;
	else
	    return n % 10 + sumDigits(n / 10);
    }

    public String allStar(String str) {
	if(str.equals(""))
	    return "";
	if(str.substring(0).equals(str.substring(0,1)))
	    return str.substring(0,1);
	else
	    return str.substring(0,1) + "*" + allStar(str.substring(1));
    }

    /*-------------------------- Main ----------------------------*/

    public static void main(String[] args){
	Recursion r = new Recursion();
	System.out.println(r.fact(5)); //should print 120
	System.out.println(r.fib(8)); //should print 21
	System.out.println(r.len("github")); //should print 6
	System.out.println(r.count("Mississippi",'i')); //should print 4
	System.out.println(r.bunnyEars2(3)); //should print 7
	System.out.println(r.sumDigits(4242)); //should print 12
	System.out.println(r.allStar("heynow")); //should print "h*e*y*n*o*w"
    }

}
