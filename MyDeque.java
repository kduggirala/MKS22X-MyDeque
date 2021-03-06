import java.util.NoSuchElementException;

public class MyDeque<E>{
	private E[] data;
	private int size, start, end;

	@SuppressWarnings("unchecked") 
	public MyDeque(){  
		size = 0;
		data = (E[])new Object[10];
		start = 0;
		end = 9;
	}

	@SuppressWarnings("unchecked") 
	public MyDeque(int initialCapacity){  
		if (initialCapacity > 0) 
			data = (E[])new Object[initialCapacity];
		else
			throw new IllegalArgumentException();
		size = 0;
		start = 0;
		end = data.length - 1;
	}

	public int size(){ 
		return size;
	}
	//When array runs out of space,
	@SuppressWarnings("unchecked")
	private void doubleSize() {
		E[] newData = (E[]) new Object[data.length * 2];
		int c = 0;
		if (start < end) { 
			for (int i = start; i <= end; i++) {
				newData[c++] = data[i];
			}
		}
		else {
			for (int i = start; i < data.length; i++) {
				newData[c++] = data[i];
			}
			for (int i = 0; i <= end; i++) {
				newData[c++] = data[i];
			}
		}
		data = newData;
		start = 0;
		end = c - 1;
	}
	public String toString(){ 
		StringBuffer arrayString = new StringBuffer();
		arrayString.append("{");
		if (size > 0) {
			if (start < end) {
				for (int i = start; i <= end; i++) {
					if (data[i] != null)
						arrayString.append(data[i].toString() + " ");
				}
			}
			else {
				for (int i = start; i < data.length; i++) {
					if (data[i] != null)
						arrayString.append(data[i].toString() + " ");
				}
				for (int i = 0; i <= end; i++) {
					if (data[i] != null) 
						arrayString.append(data[i].toString() + " ");
				}
			}
		}
		arrayString.append("}");
		return arrayString.toString();
	}
	public void addFirst(E element){ 
		if (element == null)
			throw new NullPointerException();
		if (start == 0) {
			start += data.length;
		}
		if (data[start - 1] != null) {
			doubleSize();
			start += data.length;
		}
		data[--start] = element;
		size++;
		if (size == 1) 
			end = start;
	}
	public void addLast(E element){ 
		if (element == null)
			throw new NullPointerException();
		if (end == data.length - 1) {
			end -= data.length;
		}
		if (data[end + 1] != null) {
			doubleSize();
		}
		data[++end] = element;
		size++;
	}
	public E removeFirst(){ 
		if (size > 0) {	
			E temp = data[start];
			data[start++] = null;
			if (start == data.length) {
				start -= data.length;
			}
			size--;
			return temp;
		}
		throw new NoSuchElementException();
	}
	public E removeLast(){ 
		if (size > 0) {
			E temp = data[end];
			data[end--] = null;
			if (end == -1) {
				end += data.length;
			}
			size--;
			return temp;
		}
		throw new NoSuchElementException();
	}
	public E getFirst(){ 
		if (size == 0) 
			throw new NoSuchElementException();
		return data[start];
	}
	public E getLast(){ 
		if (size == 0) 
			throw new NoSuchElementException();
		return data[end];
	}
}