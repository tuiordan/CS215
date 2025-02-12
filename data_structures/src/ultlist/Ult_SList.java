package ultlist;

public class Ult_SList {
	private class LNode
	{
		public int item;
	    public LNode next;
	    public LNode prev;

	    //--------------------------------------------------------------
	    //  Sets up the node
	    //--------------------------------------------------------------
	    public LNode(int newitem)
	    {
	    	item = newitem;
	    	next = null;
	    	prev = null;
	    }
	}
	private LNode ListEnd;
	
	public Ult_SList() {
		ListEnd = new LNode(Integer.MAX_VALUE);	
		ListEnd.next = ListEnd;
		ListEnd.prev = ListEnd;
	}
	
	
	boolean isFull()  {
		return false; //Assume the size of a linked-list based implementation is UNBOUNDED for simplicity		
	}
	
	boolean isEmpty() {
		return ListEnd.next == ListEnd;
	}
	
	public int getLength() {
		if (isEmpty())
			return 0;
		else {
			LNode iterPos = ListEnd.next;
			int length=0;
			while (iterPos != ListEnd) {
				iterPos = iterPos.next;
				length++;
			}
			return length;
		}
	}
	private LNode FindItemNode(int fitem, int[] position) {
		position[0]=0;
		
		LNode nodeIter=ListEnd.next;
		   while ((nodeIter !=ListEnd ) && (nodeIter.item < fitem)) {
		      nodeIter=nodeIter.next;
		      position[0]++;
		   }
		   if (nodeIter.item != fitem)
			   position[0] = -1;
		   return nodeIter;
	}

	public int getItem(int gitem) {
		int[] position = {0};
		FindItemNode(gitem,position);
		return position[0];
	}
	
	public void makeEmpty() {
		ListEnd.next = ListEnd; //Garbage collector will take care of the rest!
		ListEnd.prev = ListEnd;
	}
	
	public void putItem(int pitem) throws Exception {
		LNode newNode = new LNode(pitem);
		
		LNode nodeCur = FindItemNode(pitem, new int[1]);			
		newNode.prev = nodeCur.prev;
		newNode.next = nodeCur;
		nodeCur.prev.next = newNode;
		nodeCur.prev = newNode;
		
	}
	
	void deleteItem(int ditem) throws Exception { //Find the item in question, and "unlink" it		
	
		int testarr[] = new int[1];
		LNode curNode = FindItemNode(ditem,testarr);
	    if (testarr[0] == -1)
	        throw new Exception("Item not present in list.");
		curNode.next.prev = curNode.prev;
		curNode.prev.next = curNode.next;			
	}	

	void printList() { //simple function to print a list's items in stored order
		LNode iterPos = ListEnd.next;
		System.out.print("(" + iterPos.item);		
		while (iterPos != ListEnd) {
			iterPos = iterPos.next;
			System.out.print(", " + iterPos.item);			
		}				
		System.out.println(")");
	}
	
}
