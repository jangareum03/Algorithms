package chatGPT.dataStructure.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 셋 - 공통 요소 찾기
 */
public class CommonProducts {
	public static void main(String[] args) {
		Set<String> storeA = new HashSet<>(Arrays.asList("TV", "Laptop", "Phone", "Mouse"));
		Set<String> storeB = new HashSet<>(Arrays.asList("Tablet", "Phone", "TV", "Keyboard"));

		storeA.retainAll(storeB);
		System.out.println("공통 제품: " + storeA);
	}
}
