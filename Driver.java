
public class Driver {
	public static void main(String[] args) {
		MyDeque<Integer> q = new MyDeque<Integer>();
		System.out.println(q);
		for (int i = 0; i < 10; i++) {
			q.addFirst(i);
			q.addLast(i);
		}
		System.out.println(q);
	}
}
