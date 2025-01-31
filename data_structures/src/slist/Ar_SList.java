package slist;

public class Ar_SList {
	public static final int MAX_SIZE = 10;
	private int[] ListItems;
	private int length;
	private int currentPos;
	
	public Ar_SList() {
		length = 0;
		currentPos = 0;
		ListItems = new int [MAX_SIZE];
	}
	public int getLength() { //Basic accessor
		return length;
	}

	public boolean isFull()  { //Verify whether there is more space
		return length == MAX_SIZE;
	}
	
	public void putItem(int item) throws Exception{
		
		int loc = 0;
		boolean itemFound = false;
		if(length == 0) {
			ListItems[loc] = item;
			length++;
		}
		else {
			
				for(int i = 0; i < length-1; i++) {
					if(ListItems[i] >= item) {
						itemFound = true;
						loc = i;
					}
					if(itemFound) 
						break;
				}
	
			
			for(int index = length; index > loc ; index--) {
				ListItems[index] = ListItems[index-1];
			}
			ListItems[loc] = item;
			length ++;

		}
		
		
//		int aloc = 0;
//		boolean moreToSearch = aloc < length;
//		while(moreToSearch) {
//			if(ListItems[aloc] >= item) {
//				moreToSearch = false;
//			}
//			else {
//				
//			}
//		}
		
	}
	
	public void deleteItemSwap(int item) {
		for(int loc = 0; loc < length; loc++) {
			if(ListItems[loc] == item) {
				ListItems[loc] = ListItems[length-1];
				length--;
				return;
			}
		}
	}
	
	public void deleteItemShift(int item) {
		boolean indexFound = false;
		for(int loc = 0; loc < length-1; loc++) {
			if(ListItems[loc] == item) {
				indexFound = true;
			}
			if(indexFound && loc < (MAX_SIZE - 1)) {
				ListItems[loc]=ListItems[loc + 1];	
			}
		}
		if(indexFound) {
			length--;
		}
	}
	
	public void deleteItem(int item) throws Exception{
		if(getItem(item) == -1)
			throw new Exception("Item not in list");
		deleteItemShift(item);
	}
	
	public void makeEmpty() {
		length = 0;
	}
	
	public void resetList() {
		currentPos = 0;
	}
	
	public int getNextItem() throws Exception{
		if(currentPos == length)
			throw new Exception("End of list has been reached");
		currentPos++;
		return ListItems[currentPos - 1];
	}
	
	public int getItem(int item) {
		int midpoint=0, first=0, last=length-1;
		boolean moreToSearch = first <= last; //falls through if list is empty
		
		while (moreToSearch) {
		    midpoint = (first + last) / 2;
		    if(item == ListItems[midpoint]) {
		    	return midpoint;
		    }
		    else if (item < ListItems[midpoint]) {
		    	last = midpoint-1;
		    }
		    else {
		    	first = midpoint + 1;
		    }
		    moreToSearch = first <= last;
		}
		
		
			
		return -1;
	}
	public void printList() { 
		System.out.print("(");
		for (int loc=0; loc<length; loc++) {
		  	System.out.print(ListItems[loc]);
			if (loc<length-1)
		             	  System.out.print(", ");
		}
		System.out.println(")");
	}



	
	
}

