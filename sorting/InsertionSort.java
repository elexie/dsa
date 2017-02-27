package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 22, 2, 13, 5, 6123232, 13434, 1223, 53234, 0, -1, 93,
				-5 };
		int[] standard={8,9,6,2,12};
		insertionSort(standard);
		
	}

	public static int[] insertionSort(int[] arr) {
		System.out.println("unsorted: "+Arrays.toString(arr)+"\n");
		int j, toMoveLeft;
		for (int i = 1; i < arr.length; i++) {
			toMoveLeft = arr[i];
			j = i;
			while (j > 0 && arr[j - 1] > toMoveLeft) {
				arr[j] = arr[j - 1];
				j--;
				System.out.println("iteration "+i+":"+Arrays.toString(arr));

			}
			arr[j] = toMoveLeft;
		}
		System.out.println("\nsorted: "+Arrays.toString(arr));
		return arr;
	}
}
