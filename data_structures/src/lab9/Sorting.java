package lab9;

public class Sorting {
	public static int [] InsertSort(int[] arrayToSort) throws Exception{
		int[] sortedArray = arrayToSort.clone();
		
		for (int j = 1; j < sortedArray.length; j ++) {
			int nextItem = sortedArray[j];
			int i = j-1;
			while (i >= 0 && sortedArray[i] > nextItem) {
				sortedArray[i + 1] = sortedArray[i];
				i --;
				
			}
			sortedArray[i+1] = nextItem;
		}
		return sortedArray; 
	}
	
	public static int [] heapSort(int[] arrayToSort) throws Exception{
		PQMaxHeap heap = new PQMaxHeap(arrayToSort.clone());
		int[] sortedArray = new int[arrayToSort.length];
		
		for(int i = (sortedArray.length - 1); i >= 0; i -- ) {
			sortedArray[i] = heap.dequeue();
		}
		
		return sortedArray;
		
	}
	
}
