package Random;

public class Recursion 
{

	public static void main(String[] args)
	{
	Recursion r=new Recursion();
	r.recursiveSum(10);
	}
	
	int recursiveSum(int n)
	{
	if(n==1)
		{
		System.out.println("n is now 1");
		return n;	
		}
	else
		{
		System.out.println("n is: "+n);
		return recursiveSum(n-1)+n;
		}
	}
	

}
