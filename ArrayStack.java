
public class ArrayStack implements Stack {

///////////////////////////////////////////////////////////////	
	
	private int top;
	private Object[] itemArray;
	
///////////////////////////////////////////////////////////////	
	
	public ArrayStack() {
		top = 0;
		itemArray = new Object[10];
	}
	
///////////////////////////////////////////////////////////////	
	
	public void push(Object item) {
		
		if(top>=itemArray.length) {
			growStack();
		}
		
		itemArray[top++] = item;
	}

///////////////////////////////////////////////////////////////	
	
	public Object pop() {
		
		if(!empty()) {
			return itemArray[--top];
		}
		
		return null;
	}

///////////////////////////////////////////////////////////////	
	
	public Object peek() {
		
		if(!empty()) {
			return itemArray[top-1];
		}
		
		return null;
	}

///////////////////////////////////////////////////////////////	
	
	public boolean empty() {
		
		if(top==0) {
			return true;
		}
		
		return false;
	}

///////////////////////////////////////////////////////////////	
	
	private void growStack() {
		Object[] newArr = new Object[(itemArray.length) * 2];		
		System.arraycopy(itemArray, 0, newArr, 0, itemArray.length);
		itemArray = newArr;
	}
	
///////////////////////////////////////////////////////////////
	
}
