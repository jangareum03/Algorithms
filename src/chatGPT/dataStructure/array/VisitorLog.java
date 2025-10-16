package chatGPT.dataStructure.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 배열 - 중복 없는 방문 로그 정리
 */
public class VisitorLog {
	public static void main(String[] args) {
		String[] visitors = {"A123", "B456", "A123", "C789", "B456"};

		Set<String> s = new HashSet<>();
		List<String> stringList = new ArrayList<>();

		for( String v : visitors ) {
			if( !s.contains(v) ) {
				s.add(v);
				stringList.add(v);
			}
		}

		for( String v : stringList ) {
			System.out.print(v + " ");
		}
	}
}