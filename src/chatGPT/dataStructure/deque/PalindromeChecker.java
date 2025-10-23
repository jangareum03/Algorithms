package chatGPT.dataStructure.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 덱 - 회문 검사기
 */
public class PalindromeChecker {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Deque<Character> deque = new ArrayDeque<>();

		//문장 입력
		System.out.print("입력받은 문장: ");
		String text = scan.nextLine().replaceAll("\\s+", "");

		for( Character c : text.toLowerCase().toCharArray() ) {
			deque.addFirst(c);
		}

		//확인
		while ( !deque.isEmpty() ) {
			if( deque.pollFirst() != deque.pollLast() ) {
				System.out.println("회문이 아닙니다.");
				return;
			}
		}

		System.out.println("회문입니다.");
	}
}