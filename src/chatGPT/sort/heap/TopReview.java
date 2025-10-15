package chatGPT.sort.heap;


import java.util.Arrays;

/**
 * 퀵 정렬 - 상위 N개 리뷰
 */
public class TopReview {
	public static void main(String[] args) {
		double[] scores = {4.2, 3.9, 4.8, 4.6, 4.1, 3.5};
		heapSort(scores);

		double[] topN = Arrays.copyOf(scores, 3);
		System.out.println(Arrays.toString(topN));
	}

	private static void heapSort(double[] arr) {
		int length = arr.length;

		//최소힙 구하기
		for( int i=arr.length/2 - 1; i >= 0; i-- ) {
			heapify( arr, i, length );
		}

		for( int i=arr.length -1; i >= 0; i-- ) {
			double temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			heapify( arr, 0, i );
		}
	}

	private static void heapify(double[] arr, int root, int length) {
		int r = root;
		int left = root * 2 +1;
		int right = root * 2 + 2;

		//자식노드 인덱스가 배열 길이보다 작고 왼쪽 자식노드가 루트값보다 작으면 변경
		if( left < length && arr[r] > arr[left]) {
			r = left;
		}

		if( right < length && arr[r] > arr[right]) {
			r = right;
		}

		//루트가 변경된 경우
		if( root != r ) {
			double temp = arr[root];
			arr[root] = arr[r];
			arr[r] = temp;

			heapify(arr, r, length);
		}

	}
}

