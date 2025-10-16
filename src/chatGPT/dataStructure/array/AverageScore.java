package chatGPT.dataStructure.array;

/**
 * 배열 - 평균 이상 점수찾기
 */
public class AverageScore {
	public static void main(String[] args) {
		int[] scores = new int[] {70, 80, 90, 60, 50};

		double avg = averageScore(scores);
		printAverage(scores, avg);
	}

	private static double averageScore(int[] arr) {
		int sum = 0;

		for( int a : arr ) {
			sum += a;
		}

		return (double) sum / arr.length;
	}

	private static void printAverage(int[] scores, double avg) {
		System.out.print(avg + "보다 높은 점수: ");

		for(int s : scores ) {
			if( s >= avg ) {
				System.out.print(s + "  ");
			}
		}
	}
}
