
public class Calculator{
	public static void main(String[] args) {
		System.out.println(eval("10 2.0 +"));
		System.out.println(eval("11 3 - 4 + 2.5 *"));
		System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
		System.out.println(eval("1 2 3 4 5 + * - -"));
	}
	/*Evaluate a postfix expression stored in s.
	 *Assume valid postfix notation, separated by spaces.
	 */
	public static double eval(String s){
		String[] string = s.split(" ");
		MyDeque<Double> stack = new MyDeque<Double>((string.length / 2) + 1);
		double second, first;
		for (int i = 0; i < string.length; i++) {
			switch(string[i]) {
			case "+":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first + second);
				break;
			case "-":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first - second);
				break;
			case "*":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first * second);
				break;
			case "/":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first / second);
				break;
			case "%":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first % second);
				break;
			default:
				stack.addLast(Double.parseDouble(string[i]));
				break;
			}
		}
		return stack.getLast();
	}
}

