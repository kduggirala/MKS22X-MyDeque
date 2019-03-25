
public class Calculator{
	/*Evaluate a postfix expression stored in s.
	 *Assume valid postfix notation, separated by spaces.
	 */
	public static double eval(String s){
		String[] string = s.split(" ");
		MyDeque<Double> stack = new MyDeque<Double>();
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
				stack.addLast(first + second);
				break;
			case "*":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first + second);
				break;
			case "/":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first + second);
				break;
			case "%":
				second = stack.removeLast();
				first = stack.removeLast();
				stack.addLast(first + second);
				break;
			default:
				stack.addLast(Double.parseDouble(string[i]));
				break;
			}
		}
		return stack.getLast();
	}
}

