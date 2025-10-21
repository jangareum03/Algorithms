package chatGPT.dataStructure.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐 - 은행 대기열
 */
public class Bank {
	public static void main(String[] args) {
		Queue<String> bank = new LinkedList<>();

		bank.add("홍길동");
		bank.add("김철수");
		bank.add("이영희");
		bank.add("박민수");
		bank.add("최수정");

		while ( !bank.isEmpty() ) {
			String value = bank.poll();
			System.out.println("고객 " + value + " 처리 완료");
		}
		System.out.println("대기열 없음");
	}
}
