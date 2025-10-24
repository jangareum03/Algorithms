package chatGPT.dataStructure.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 맵 - 학생 점수 평균
 */
public class StudentScoreMap {
	public static void main(String[] args) {
		Map<String, Integer> scores = new HashMap<>();
		scores.put("민수", 75);
		scores.put("지영", 92);
		scores.put("철민", 88);
		scores.put("하늘", 64);

		int total = 0;
		for( int s : scores.values() ) total += s;
		double avg = (double) total / scores.size();
		System.out.println("전체 평균 점수: " + avg);

		System.out.println("80점 이상 학생: ");
		for(Map.Entry<String, Integer> s : scores.entrySet() ) {
			if( s.getValue() >= 80 ) {
				System.out.printf("%s (%d)%n", s.getKey() , s.getValue());
			}
		}

	}
}
