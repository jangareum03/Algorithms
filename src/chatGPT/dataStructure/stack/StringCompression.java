package chatGPT.dataStructure.stack;

import java.util.Stack;

/**
 * 스택 - 문자열 압축 해제
 */
public class StringCompression {
	public static void main(String[] args) {
		String input1 = "3[a2[b]]";
		String input2 = "2[xy3[z]]";

		System.out.println(decode(input1));
		System.out.println(decode(input2));
	}

	private static String decode(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();

		StringBuilder stringBuilder = new StringBuilder();
		int num = 0;

		for( char ch : s.toCharArray() ) {
			if( Character.isDigit(ch) ) {
				num = num * 10 + ch - '0';
			}else if( ch == '[' ) {
				countStack.push(num);
				stringStack.push(stringBuilder);

				stringBuilder = new StringBuilder();
				num = 0;
			}else if( ch == ']' ) {
				int count = countStack.pop();
				StringBuilder sb = stringStack.pop();

				sb.append( String.valueOf(stringBuilder).repeat(count) );
				stringBuilder = sb;
			}else {
				stringBuilder.append(ch);
			}
		}

		return stringBuilder.toString();
	}
}
