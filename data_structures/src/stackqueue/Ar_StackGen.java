6package stackqueue;

public class Ar_StackGen <T> {
	public static final int MAXSIZE = 10;
	private int top;
	private Object[] StackItems;
	
	public Ar_StackGen() {
		top = -1;
		StackItems = new Object[MAXSIZE];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == MAXSIZE -1;
	}

	
	void push(T item) throws Exception{ 
		if (isFull()) {
			throw new Exception("Stack is full -- unable to add new item.");
		}
		top++;
		StackItems[top] = item;
	}
	
	@SuppressWarnings("unchecked")
	T pop() throws Exception{ 
		if (isEmpty()) {
			throw new Exception("Stack is emplty -- unable to add remove item.");
		}
		T tmpitem = (T) StackItems[top];
		top--;
		return tmpitem;

	}
	
	@SuppressWarnings("unchecked")
	T peek() { 
		return (T)StackItems[top]; 
	}

	

}
