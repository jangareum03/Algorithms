package chatGPT.dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐 - 최근 조회 기록
 */
public class ViewHistory {
	public static void main(String[] args) {
		Web web = new Web();

		web.visit("home");
		web.visit("about");
		web.visit("contact");
		web.visit("blog");
		web.visit("faq");
	}
}

class Web {
	private final int MAX_SIZE = 3;
	Queue<String> browser = new LinkedList<>();

	public void visit(String page) {
		if( browser.size() >= MAX_SIZE ) {
			browser.poll();
		}

		browser.offer(page);
		System.out.printf("방문: %s, 최근 기록: %s%n", page, browser);
	}

}