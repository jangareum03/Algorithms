package chatGPT.dataStructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 스택 - 웹 브라우저 뒤로/앞으로
 */
public class WebBrowser {
	public static void main(String[] args) {
		Stack<String> backStack = new Stack<>();
		Stack<String> forwardStack = new Stack<>();

		String currentPage = "google.com";
		Scanner sc = new Scanner(System.in);
		String command;

		System.out.println("현재 페이지: " + currentPage);
		System.out.println("명령어: visit [url], back, forward, exit");

		while (true) {
			System.out.print("입력 > ");
			command = sc.nextLine();

			if (command.startsWith("visit ")) {
				String newPage = command.substring(6);
				backStack.push(currentPage);
				currentPage = newPage;
				forwardStack.clear(); // 새로운 방문 시 앞으로 가기 초기화
				System.out.println("이동: " + currentPage);

			} else if (command.equals("back")) {
				if (!backStack.isEmpty()) {
					forwardStack.push(currentPage);
					currentPage = backStack.pop();
					System.out.println("뒤로가기 → " + currentPage);
				} else {
					System.out.println("더 이상 뒤로 갈 수 없습니다.");
				}

			} else if (command.equals("forward")) {
				if (!forwardStack.isEmpty()) {
					backStack.push(currentPage);
					currentPage = forwardStack.pop();
					System.out.println("앞으로가기 → " + currentPage);
				} else {
					System.out.println("더 이상 앞으로 갈 수 없습니다.");
				}

			} else if (command.equals("exit")) {
				System.out.println("브라우저 종료");
				break;

			} else {
				System.out.println("잘못된 명령입니다.");
			}
		}

		sc.close();
	}
}

class Browser {
	Stack<String> backStack = new Stack<>();
	Stack<String> forwardStack = new Stack<>();


	public void visitedFirst(String page) {
		backStack.push(page);
		forwardStack.empty();

		System.out.println("방문" + page);
	}

	public void goBack() {
		String page = backStack.pop();
		forwardStack.push(page);
	}

	public void goForward() {
		String page = forwardStack.pop();
		backStack.push(page);
	}
}