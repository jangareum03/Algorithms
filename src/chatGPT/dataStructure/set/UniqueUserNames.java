package chatGPT.dataStructure.set;

import java.util.*;

/**
 * 셋 - 중복 제거된 사용자이름
 */
public class UniqueUserNames {
	public static void main(String[] args) {
		List<String> users =  Arrays.asList("mike", "anna", "mike", "john", "anna");

		Set<String> names = new HashSet<>(users);

		System.out.println("고유 사용자 수: " + names.size());
		System.out.println("사용자 목록: " + names);
	}
}
