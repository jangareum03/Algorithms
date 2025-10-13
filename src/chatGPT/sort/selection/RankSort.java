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

	/**
	 * 점수 높은 순으로 n번째까지만 배열로 담은 후 반환하는 메서드
	 *
	 * @param n			상위 n번째
	 * @param scores	점수 배열
	 * @return	상위 n번째 점수만 담은 배열
	 */
	private static int[] descTopNByScores(int n, int[] scores) {
		int[] copyArr = Arrays.copyOf(scores, scores.length);	//원본 배열 복사
		int[] top = new int[n];

		for( int i=0; i<n; i++ ) {		//상위 n번째만 필요하기에 반복문을 n까지만 진행
			int  maxIndex = i;

			for( int j=i; j<copyArr.length; j++ ) {
				if( copyArr[maxIndex] < copyArr[j] ) {
					maxIndex = j;	//최대값 인덱스를 큰값의 인덱스로 변경
				}
			}

			int temp = copyArr[maxIndex];
			copyArr[maxIndex] = copyArr[i];
			top[i] = temp;
		}


		return top;
	}
}