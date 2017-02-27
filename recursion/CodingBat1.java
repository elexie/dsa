package recursion;

/**
 * This class provides solutions for the Recursion 1 exercise on codingbat.com:
 * http://codingbat.com/java/Recursion-1
 * 
 * @author Elexie
 *
 */
public class CodingBat1 {

	public static void main(String[] args) {
		CodingBat1 c1 = new CodingBat1();

		System.out.println("Compute the factorial from 1 to 12");
		for(int x=0;x<13;x++){
			System.out.println(x+"!: "+c1.factorial(x));
		}

		System.out.println("\nFind the number of ears of bunnies from 1 to 6");
		for(int x=0;x<7;x++){
			System.out.println(x+": "+c1.bunnyEars(x)+" ears");
		}
		
		System.out.println("\nnth Fibonacci number from 0 to 9");
		for(int x=0;x<10;x++){
			System.out.println(x+"th: "+c1.fibonacci(x));
		}
		
		System.out.println("\nBunnyEars2 from 0 to 6");
		for(int x=0;x<7;x++){
			System.out.println(x+": "+c1.bunnyEars2(x)+" ears");
		}
		
		System.out.println("\nTriangle rows from 0 to 6");
		for(int x=0;x<6;x++){
			System.out.println("row: "+x+":"+c1.triangle(x));
		}

	}

	/**
	 * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
	 * (n-2) ... 1. Compute the result recursively (without loops).
	 * 
	 * @param n
	 * @return
	 */
	public int factorial(int n) {
		int ans = 0;
		if (n == 1 || n==0) {
			ans = 1;
		} else {
			ans = n * factorial(n - 1);
		}
		return ans;
	}

	/**
	 * 
	We have a number of bunnies
 	and each bunny has two big
  	floppy ears. We want to compute 
  	the total number of ears across 
  	all the bunnies recursively
   	(without loops or multiplication).
	  
	  @param bunnies
	  the number of bunnies
	 
	  @return
	 */
	public int bunnyEars(int bunnies){
		int ans=0;
			if(bunnies==0){
				ans=0;
			}
			else{
				ans=2+bunnyEars(bunnies-1);
			}
		return ans;
	}
	
	/**
	 * The fibonacci sequence is a famous bit of mathematics, 
	 * and it happens to have a recursive definition. The first two
	 * values in the sequence are 0 and 1 (essentially 2 base cases).
	 * Each subsequent value is the sum of the previous two values,
	 * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
	 * Define a recursive fibonacci(n) method that returns the nth 
	 * fibonacci number, with n=0 representing the start of the sequence.
	 * @param n
	 * @return
	 */
	public int fibonacci(int n){
		int ans=0;
		if(n<=2){
			if(n==0){
				ans=0;
			}
			else{
				ans=1;
			}
		}
		else{
			ans=fibonacci(n-2)+fibonacci(n-1);
		}
		return ans;
	}
	
	/**
	 We have bunnies standing in a line,
	 numbered 1, 2, ... The odd bunnies
	 (1, 3, ..) have the normal 2 ears. 
	 The even bunnies (2, 4, ..) we'll say 
	 have 3 ears, because they each have a 
	 raised foot. Recursively return the number 
	 of "ears" in the bunny line 1, 2, ... 
	 n (without loops or multiplication).
	 */
	public int bunnyEars2(int bunnies) {
	int ans=0;
	if(bunnies==0){
		ans=0;
	}else{
		ans=(bunnies%2)==0?3+bunnyEars2(bunnies-1): 2+bunnyEars2(bunnies-1);
	}
	return ans;	 
	}
	
	/**
	 * We have triangle made of blocks.
	 * The topmost row has 1 block, 
	 * the next row down has 2 blocks, 
	 * the next row has 3 blocks, and so on.
	 * Compute recursively (no loops or multiplication) 
	 * the total number of blocks in such a triangle 
	 * with the given number of rows.
	 */
	public int triangle(int rows) {
		int ans=0;
		if(rows<=3){
			if(rows==0)
				ans=0;
			if(rows==1)
				ans=1;
			if(rows==2)
				ans=3;
		}
		else{
			ans=0+triangle(rows-1);
		}
		return ans;
	}
	
	/**
	 * Given a non-negative int n,
	 * return the sum of its digits 
	 * recursively (no loops). Note 
	 * that mod (%) by 10 yields the 
	 * rightmost digit (126 % 10 is 6), 
	 * while divide (/) by 10 removes 
	 * the rightmost digit (126 / 10 is 12).
	 */
	 public int sumDigit(int n){
		 int ans=0;
		 return ans;
	 }
	
	
	
}
