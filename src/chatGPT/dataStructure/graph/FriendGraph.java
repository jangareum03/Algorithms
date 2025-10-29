package chatGPT.dataStructure.graph;

import java.util.*;

/**
 * 그래프 - 친구 네트워크 연결
 */
public class FriendGraph {
	Map<String, Set<String>> network = new HashMap<>();

	//두 사용자 사이에 친구 관계 추가
	public void addFriend(String userA, String userB) {
		//맵의 키는 사용자 이름으로 진행 => 사용자(키)별로 친구 리스트 관리 가능
		network.putIfAbsent(userA, new HashSet<>());
		network.putIfAbsent(userB, new HashSet<>());

		network.get(userA).add(userB);
		network.get(userB).add(userA);
	}

	public boolean isFriend(String userA, String userB) {
		if( !network.containsKey(userA) ) {
			System.out.println("서비스를 사용하지 않은 사용자입니다: " + userA);
			return false;
		}

		return network.get(userA).contains(userB);
	}

	public static void main(String[] args) {
		FriendGraph graph = new FriendGraph();
		graph.addFriend("Alice", "Bob");
		graph.addFriend("Bob", "Charlie");

		System.out.println(graph.isFriend("Alice", "Bob"));
		System.out.println(graph.isFriend("Alice", "Charlie"));
	}
}