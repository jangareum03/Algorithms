package chatGPT.DesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴 - 사내 메신저
 */
public class Messenger {
	public static void main(String[] args) {
		ChatRoom room = new ChatRoom();

		room.enter(new User("Kim"));
		room.enter(new User("Lee"));
		room.enter(new User("Park"));

		room.send("안녕하세요!");
		room.send("오늘 회의는 3시에 시작합니다.");
	}
}

class ChatRoom {
	private final List<User> userList = new ArrayList<>();

	public void enter(User user) {
		userList.add(user);
	}

	public void send(String message) {
		for( User u : userList ) {
			u.display(message);
		}
	}
}

class User {
	private final String name;

	public User(String name) {
		this.name = name;
	}

	public void display(String message) {
		System.out.printf("[User: %s] 새 메시지 도착 -> %s%n", name, message);
	}
}