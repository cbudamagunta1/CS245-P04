
public class ArrayQueue implements Queue {
	
///////////////////////////////////////////////////////////////	
	
	private int head;
	private int tail;
	private Object[] itemArray;
	
///////////////////////////////////////////////////////////////
	
	public ArrayQueue() {
		head = 0;
		tail = 0;
		itemArray = new Object[10];
	}
	
///////////////////////////////////////////////////////////////
	
	public Object dequeue() {
		
		if(empty()) {
			return null;
		}
		
		Object item = itemArray[head];
		head ++;
		
		if(head >= itemArray.length) {
			head = 0;
		}
		
		return item;
	}

///////////////////////////////////////////////////////////////
	
	public void enqueue(Object item) {
		
		if(full()) {
			growQueue();
		}
		
		itemArray[tail] = item;
		tail ++;
		
		if(tail >= itemArray.length) {
			tail = 0;
		}

	}

///////////////////////////////////////////////////////////////
	
	public boolean empty() {
		
		if(head == tail) {
			return true;
		}
		
		return false;
	}
	
///////////////////////////////////////////////////////////////
	
	public boolean full() {
		
		if((tail+1) % itemArray.length == head) {
			return true;
		}
		
		return false;
	}
	
///////////////////////////////////////////////////////////////
	
	private void growQueue() {

		Object[] newArr = new Object[(itemArray.length) * 2];		
		
		if(tail<head) {
			System.arraycopy(itemArray, 0, newArr, 0, tail+1);
			//System.arraycopy(itemArray, tail+1, newArr, tail+1, head-tail-1);
			System.arraycopy(itemArray, head, newArr, tail+1, (itemArray.length)-head-1);
		}
		
		if(tail>head) {
			System.arraycopy(itemArray, 0, newArr, 0, head+1);
			//System.arraycopy(itemArray, tail+1, newArr, tail+1, head-tail-1);
			System.arraycopy(itemArray, tail, newArr, head, (itemArray.length)-tail);
		}
		
		head = 0;
		tail = itemArray.length-1;
		itemArray = newArr;
		
	}
	
///////////////////////////////////////////////////////////////	

}
