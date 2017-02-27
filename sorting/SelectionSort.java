package sorting;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] unsorted = { 8, 9, 6, 2, 12 };
		selectionSort(unsorted);

	}

	public static int[] selectionSort(int[] arr) {
		System.out.println("unsorted: "+Arrays.toString(arr)+"\n");
		int smallestIndex, smallerNumber;
		for (int i = 0; i < arr.length - 1; i++) {
			smallestIndex = i;
			for (int j = smallestIndex + 1; j < arr.length; j++) {
				if (arr[j] < arr[smallestIndex])
					smallestIndex = j;
			}

			smallerNumber = arr[smallestIndex];
			arr[smallestIndex] = arr[i];
			arr[i] = smallerNumber;
			System.out.println("iteration "+i+":"+Arrays.toString(arr));
		}
		System.out.println("\nsorted: "+Arrays.toString(arr));
		return arr;

	}
}
