package chatGPT.dataStructure.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 덱 - 기본 연산
 */
public class BasicDeque {
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();

		deque.addFirst(10);
		deque.addLast(20);
		deque.addFirst(5);
		deque.removeLast();
		deque.addLast(15);

		System.out.println(deque);
	}
}
