package chatGPT.sort.Insertion;

/**
 * 삽입 정렬 - 배열
 */
public class AscSort {
	public static void main(String[] args) {
		int[] scores = {75, 90, 82, 60, 95};

		for( int i=1; i<scores.length; i++ ) {
			int point = scores[i];
			int j = i-1;

			while ( j >= 0 && scores[j] > point ) {
				scores[j+1] = scores[j];
				j--;
			}

			scores[j+1] = point;
		}

		for(int s : scores) System.out.print(s + " ");
	}
}

