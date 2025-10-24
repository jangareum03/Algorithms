package chatGPT.dataStructure.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 셋 - 금지어 필터링
 */
public class BannedWordFilter {
	public static void main(String[] args) {
		Set<String> banned = new HashSet<>(Arrays.asList("광고", "도박", "불법") );
		List<String> posts = Arrays.asList(
				"오늘 날씨 좋다.",
				"불법 도박 사이트 링크 공유",
				"건강한 광고입니다.",
				"공부 모임 같이 할 사람?"
		);

		Set<String> blockedPosts = new HashSet<>();	//차단된 게시물 저장
		for( String post : posts ) {
			for( String word : banned ) {
				if( post.contains(word) ) {
					blockedPosts.add(post);
					break;
				}
			}
		}

		System.out.println("차단된 게시글: " + blockedPosts);
	}
}
