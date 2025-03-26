package lab8;



public class Ar_UListCC {
	//Use private variables to preserve Encapsulation 
	public static final int MAXSIZE = 1000000;	
	private CCFraudRecord[] ListItems;
	private int length;
	private int currentPos = 0;
	
	public Ar_UListCC() {
		length = 0; //a newly constructed list has 0 elements
		ListItems = new CCFraudRecord[MAXSIZE];
	}
	boolean isFull()  {
		return (length == MAXSIZE); //Useful to check that we don't add too many elements		
	}
	
	int getLength() {
	  return length;
	}

	CCFraudRecord getItem(int gitem) {
		int searchiter;
		for (searchiter = length-1; searchiter>=0; searchiter--) { //main loop decrements from the final index in the list down to -1 
			
			if (ListItems[searchiter].time == gitem) //if this condition is met, we have a match
				return ListItems[searchiter];
		} 
		return null;
				
		
	}
	
	void makeEmpty() {
		length = 0; //as with the constructor, we need do nothing to the actual array, as it now "junk" data
	}
	
	void putItem(CCFraudRecord pitem) throws Exception {
		if (this.isFull()) {
			throw new Exception("List is full -- unable to add new item.");
		}
		 ListItems[length] = pitem; //Reminder that Java uses 0-indexing.
		 length++;
	}
		
	void deleteItem(int ditem) throws Exception { //This is the more efficient version of what we discussed ("Swap") that is a little bit easier and faster		
		  boolean indexfound=false;
		  for (int loc=0; loc<length; loc++) {
			  if (ListItems[loc].time == ditem) { 
				  indexfound=true;
				  ListItems[loc] = ListItems[length-1];
			  }
		  }
		  if (!indexfound)
			  throw new Exception("Value not present in list -- unable to delete.");
		  length--;
	}
	
	void resetList() {
		currentPos = 0;
	}

	
	CCFraudRecord getNextItem() throws Exception {
		if (currentPos == length)
			throw new Exception("End of list has been reached.");
		//Possibly counter-intuitive, but we want to return the item at the current index AND increment it
		currentPos++;
		return ListItems[currentPos-1];   
	}

	void printList() { //simple function to print a list's items in stored order
		
		for (int loc=0; loc<length; loc++) {
		  	System.out.print(ListItems[loc].time + ", " + ListItems[loc].amount + ", " + ListItems[loc].fraudclass + ";\n");
		}
	}
}

