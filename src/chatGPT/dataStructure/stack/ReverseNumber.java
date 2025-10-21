package chatGPT.dataStructure.stack;

import java.util.Stack;

/**
 * 스택 - 숫자 뒤집기
 */
public class ReverseNumber {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		int number = 12345;
		String numStr = Integer.toString(number);

		for( Character c : numStr.toCharArray() ) {
			stack.push( c - '0' );
		}

		while ( !stack.isEmpty() ) {
			System.out.print(stack.pop());
		}
	}
}