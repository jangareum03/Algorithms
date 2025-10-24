package chatGPT.dataStructure.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 셋 - 데이터 동기화
 */
public class DataSync {
	public static void main(String[] args) {
		Set<String> dbData = new HashSet<>(Arrays.asList("user1", "user2", "user3", "user4"));
		Set<String> cacheData = new HashSet<>(Arrays.asList("user2", "user3", "user5"));

		//추가 필요(db에만 존재하는 데이터)
		Set<String> addData = new HashSet<>(dbData);
		addData.removeAll(cacheData);

		//삭제 필요(db에 없는 데이터)
		Set<String> removeData = new HashSet<>(cacheData);
		removeData.removeAll(dbData);

		//캐시 동기화
		cacheData.removeAll(removeData);
		cacheData.addAll(addData);

		System.out.println("추가필요: " + addData);
		System.out.println("삭제필요: " + removeData);
		System.out.println("동기화 후 캐시: " + cacheData);
	}
}
