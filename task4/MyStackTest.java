public class MyStackTest {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop() == 3);
		System.out.println(stack.pop() == 2);
		System.out.println(stack.pop() == 1);
		Integer res = null;
		try {
			res = stack.pop();
		} catch(RuntimeException ex) {
			ex.printStackTrace();
		}
		System.out.println(res == null);
	}
}