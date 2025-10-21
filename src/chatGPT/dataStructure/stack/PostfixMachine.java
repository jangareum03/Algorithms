package chatGPT.dataStructure.stack;

import java.util.Stack;

/**
 * 스택 - 후위 계산기
 */
public class PostfixMachine {
	public static void main(String[] args) {
		String text = "3 4 + 2 * 7 /";

		Stack<Integer> stack = new Stack<>();
		for( String s : text.split(" ") ) {	//공백기준으로 문자 나누기
			if( s.matches("\\d") ) stack.push(Integer.parseInt(s));
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();

				switch ( s ) {
					case "+" : stack.push( num1 + num2 ); break;
					case "-" : stack.push(num1 - num2); break;
					case "*" : stack.push(num1 * num2); break;
					case "/" : stack.push(num1 / num2); break;
				}
			}
		}

		System.out.println(stack.pop());
	}
}
