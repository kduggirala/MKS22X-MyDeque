public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  
  @SuppressWarnings("unchecked") 
  public MyDeque(){  
	  size = 0;
	  data = (E[])new Object[10];
	  start = 0;
	  end = 0;
  }
  
  @SuppressWarnings("unchecked") 
  public MyDeque(int initialCapacity){  
	  if (initialCapacity > 0) 
	  	data = (E[])new Object[initialCapacity];
	  else
		  throw new IllegalArgumentException();
	  size = 0;
	  start = 0;
	  end = 0;
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
			 newData[c++] = data[i++];
		 }
	 }
	 start = 0;
	 end = c;
  }
  public String toString(){ }
  public void addFirst(E element){ 
	  if (start == 0) {
		  if (data[data.length - 1] != null) {
			  doubleSize();
		  }
		  start += data.length;
	  }
	  
	  size++;
  }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
}