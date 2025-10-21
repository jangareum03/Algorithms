package chatGPT.dataStructure.stack;

import java.util.Stack;

/**
 * 스택 - 괄호 짝 맞추기
 */
public class ParenthesesSearch {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();

		String text1 = "((())";

		for( Character c : text1.toCharArray() ) {
			if( '(' == c ) stack.push(c);
			else if(')' == c) {
				if( stack.isEmpty() ) {
					System.out.println("올바르지 않은 괄호입니다.");
					return;
				}

				stack.pop();
			}
		}

		if( stack.isEmpty() ) System.out.println("올바른 괄호입니다.");
		else System.out.println("올바르지 않은 괄호입니다.");
	}
}