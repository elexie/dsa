package Random;

public class BinarySearch {

	public static void main(String[] args) 
	{
	BinarySearch bSearch=new BinarySearch();
	int[] array={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
	
	int x=0;
	while(x<array.length)
	{
		System.out.println(x+" is at index "+bSearch.binarySearch(x,array));
	x++;	
	}
	}

	public int binarySearch(int item, int[] array)
	{
		int low=0;
		int high=(array.length)-1;
		int mid;
		while(low<=high)
		{
		mid=(low+high)/2;	
			if(array[mid]>item)// middle position is greater than item
			{
			high=mid-1;//decrease bounds to the previous item
			}
			else if(array[mid]<item)// middle position is less than the item
			{
			low=mid+1;//increase bounds to the next item	
			}
			else 
			{
			return mid;
			}
		}
	return -1;
	}
}
