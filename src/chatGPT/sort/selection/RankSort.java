package chatGPT.sort.selection;

import java.util.Arrays;

/**
 * 선택 정렬 - 게임 상위 랭킹
 */
public class RankSort {
	public static void main(String[] args) {
		int[] topScores = descTopNByScores(3, new int[] {87, 92, 75, 100, 64, 89, 93});

		System.out.println(Arrays.toString(topScores));
	}

	private static int[] descTopNByScores(int n, int[] scores) {
		int[] copyArr = Arrays.copyOf(scores, scores.length);
		int[] top = new int[n];

		for( int i=0; i<n; i++ ) {
			int  maxIndex = i;

			for( int j=i; j<copyArr.length; j++ ) {
				if( copyArr[maxIndex] < copyArr[j] ) {
					maxIndex = j;
				}
			}

			int temp = copyArr[maxIndex];
			copyArr[maxIndex] = copyArr[i];
			top[i] = temp;
		}


		return top;
	}
}